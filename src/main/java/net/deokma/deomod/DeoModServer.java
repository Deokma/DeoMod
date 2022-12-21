package net.deokma.deomod;

import net.deokma.deomod.sitOnStuff.Sit;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.networking.v1.*;
import net.deokma.deomod.command.GenericSitBasedCommand;
import net.deokma.deomod.config.ConfigManager;
import net.deokma.deomod.event.UseStairCallback;
import net.deokma.deomod.network.PoseRequestC2SPacket;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerLoginNetworkHandler;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

import static net.deokma.deomod.DeoMod.getModVersion;

public class DeoModServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        // on player joins, ping them with a fabsit check packet to see if they have the mod loaded
        ServerLoginConnectionEvents.QUERY_START.register(DeoModServer::checkLoaded);
        ServerLoginNetworking.registerGlobalReceiver(DeoMod.LOADED_CHANNEL, DeoModServer::handleCheckResponse);

        // keybind receiver
        ServerPlayNetworking.registerGlobalReceiver(DeoMod.REQUEST_CHANNEL, DeoModServer::handlePoseRequest);
        ServerLoginNetworking.registerGlobalReceiver(Sit.VERSION_CHECK, this::onClientResponse);
        ServerLoginConnectionEvents.QUERY_START.register(this::onLoginStart);
        // use a stair to sit
        UseBlockCallback.EVENT.register(UseStairCallback::interact);
    }

    private static void handleCheckResponse(MinecraftServer server, ServerLoginNetworkHandler handler, boolean b, PacketByteBuf buf, ServerLoginNetworking.LoginSynchronizer synchronizer, PacketSender sender) {
        if(b) server.execute(() -> ConfigManager.loadedPlayers.add(handler.connection.getAddress()));
    }

    private static void checkLoaded(ServerLoginNetworkHandler handler, MinecraftServer server, PacketSender sender, ServerLoginNetworking.LoginSynchronizer synchronizer) {
        sender.sendPacket(DeoMod.LOADED_CHANNEL, PacketByteBufs.empty());
    }

    // attempt to pose when requested
    private static void handlePoseRequest(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler networkHandler, PacketByteBuf buf, PacketSender sender) {
        GenericSitBasedCommand.run(player, new PoseRequestC2SPacket(buf).getPose());
    }
    /**
     * On login start, send VERSION_CHECK request
     */
    private void onLoginStart(ServerLoginNetworkHandler serverLoginPacketListener, MinecraftServer server, PacketSender sender, ServerLoginNetworking.LoginSynchronizer sync)
    {
        //request the client to send its sit version number
        sender.sendPacket(Sit.VERSION_CHECK, PacketByteBufs.empty());
    }

    /**
     * Handle the VERSION_CHECK response
     */
    private void onClientResponse(MinecraftServer server, ServerLoginNetworkHandler listener, boolean understood, PacketByteBuf buf, ServerLoginNetworking.LoginSynchronizer loginSynchronizer, PacketSender packetSender)
    {
        float bufVersion = buf.readFloat();

        if(!understood || bufVersion != getModVersion())
        {
            listener.disconnect(Sit.INCORRECT_VERSION);
        }

    }
}
