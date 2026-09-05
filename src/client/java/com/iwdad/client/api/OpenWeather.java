package com.iwdad.client.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;

public class OpenWeather {

    private static final Path KEY_FILE = Path.of("diaodiao.txt");
    private static final int MAX_ATTEMPTS = 5;

    private static final HttpClient CLIENT = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private OpenWeather() {
    }

    public static String fetchWeather(double lon, double lat) throws IOException, InterruptedException {
        String apiKey = readKeyFile();
        if (apiKey == null || apiKey.isBlank()) {
            return "未找到有效的 API 密钥，请检查 diaodiao.txt 文件";
        }

        HttpRequest request = HttpRequest.newBuilder(URI.create(buildUrl(lon, lat, apiKey)))
                .timeout(Duration.ofSeconds(30))
                .GET()
                .build();

        IOException lastError = null;
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            try {
                HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() != 200) {
                    return "OpenWeather API 错误: HTTP " + response.statusCode();
                }
                return formatWeather(response.body());
            } catch (IOException e) {
                lastError = e;
                try {
                    Thread.sleep(500L * attempt);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new IOException("重试等待被中断", ie);
                }
            }
        }
        throw lastError;
    }

    private static String buildUrl(double lon, double lat, String apiKey) {
        return "https://api.openweathermap.org/data/2.5/weather"
                + "?lat=" + lat + "&lon=" + lon
                + "&appid=" + apiKey + "&units=metric&lang=zh_cn";
    }

    private static String formatWeather(String body) {
        try {
            JsonObject json = JsonParser.parseString(body).getAsJsonObject();

            String city = json.has("name") ? json.get("name").getAsString() : "未知城市";

            String weather = "未知";
            if (json.has("weather") && json.getAsJsonArray("weather").size() > 0) {
                weather = json.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
            }

            double temp = 0.0;
            int humidity = 0;
            if (json.has("main")) {
                JsonObject main = json.getAsJsonObject("main");
                if (main.has("temp")) temp = main.get("temp").getAsDouble();
                if (main.has("humidity")) humidity = main.get("humidity").getAsInt();
            }

            return String.format("城市: %s | 天气: %s | 温度: %.1f °C | 湿度: %d%%", city, weather, temp, humidity);
        } catch (Exception e) {
            return "天气数据解析失败: " + e.getMessage();
        }
    }

    private static String readKeyFile() {
        try {
            if (!Files.exists(KEY_FILE)) {
                return null;
            }
            List<String> lines = Files.readAllLines(KEY_FILE, StandardCharsets.UTF_8);
            for (String line : lines) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                int separatorIndex = line.indexOf('=');
                if (separatorIndex > 0) {
                    String key = line.substring(separatorIndex + 1).trim();
                    if (!key.isBlank()) {
                        return key;
                    }
                }
            }
        } catch (IOException ignored) {
        }
        return null;
    }
}