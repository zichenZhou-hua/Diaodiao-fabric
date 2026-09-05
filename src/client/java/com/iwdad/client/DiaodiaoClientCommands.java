package com.iwdad.client;

import com.iwdad.client.api.OpenWeather;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.ClientCommands;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

import java.util.concurrent.CompletableFuture;

public class DiaodiaoClientCommands implements ClientModInitializer {

    private static final double DEFAULT_LAT = 39.90;
    private static final double DEFAULT_LON = 116.40;
    //diaodiao
    private static int executeDiaodiao(CommandContext<FabricClientCommandSource> context) {
        context.getSource().sendFeedback(Component.literal("hello"));
        return 1;
    }
    //diaodiao weather
    private static int executeWeather(CommandContext<FabricClientCommandSource> context) {
        return queryWeather(context, DEFAULT_LON,DEFAULT_LAT);
    }
    //* * <lat> <lon>
    private static int executeWeatherAt(CommandContext<FabricClientCommandSource> context) {
        return queryWeather(context,
                DoubleArgumentType.getDouble(context, "lon"),
                DoubleArgumentType.getDouble(context, "lat"));
    }

    private static int queryWeather(CommandContext<FabricClientCommandSource> context, double lon, double lat) {
        FabricClientCommandSource source = context.getSource();
        Minecraft client = source.getClient();

        source.sendFeedback(Component.literal("正在查询天气..."));

        CompletableFuture.supplyAsync(() -> {
            try {
                return OpenWeather.fetchWeather(lon, lat);
            } catch (Exception e) {
                return "获取天气失败: " + e.getMessage();
            }
        }).thenAccept(result -> client.execute(() ->
                source.sendFeedback(Component.literal(result))));

        return 1;
    }

    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommands.literal("diaodiao")
                    .executes(DiaodiaoClientCommands::executeDiaodiao)
                    .then(ClientCommands.literal("weather")
                            .executes(DiaodiaoClientCommands::executeWeather)
                            .then(ClientCommands.argument("lon", DoubleArgumentType.doubleArg(-180, 180))
                                    .then(ClientCommands.argument("lat", DoubleArgumentType.doubleArg(-90, 90))
                                            .executes(DiaodiaoClientCommands::executeWeatherAt))))
            );
        });
    }
}
