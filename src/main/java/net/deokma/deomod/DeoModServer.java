package net.deokma.deomod;

import net.deokma.deomod.sitOnStuff.Sit;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.networking.v1.*;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerLoginNetworkHandler;

import static net.deokma.deomod.DeoMod.getModVersion;

public class DeoModServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        // on player joins, ping them with a fabsit check packet to see if they have the mod loaded
        ServerLoginConnectionEvents.QUERY_START.register(DeoModServer::checkLoaded);

        ServerLoginNetworking.registerGlobalReceiver(Sit.VERSION_CHECK, this::onClientResponse);
        ServerLoginConnectionEvents.QUERY_START.register(this::onLoginStart);

    }


    private static void checkLoaded(ServerLoginNetworkHandler handler, MinecraftServer server, PacketSender sender, ServerLoginNetworking.LoginSynchronizer synchronizer) {
        sender.sendPacket(DeoMod.LOADED_CHANNEL, PacketByteBufs.empty());
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
