package net.deokma.deomod;

import io.netty.buffer.Unpooled;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.deokma.deomod.registry.screenRegistry;
import net.deokma.deomod.sitOnStuff.Sit;
import net.deokma.deomod.sitOnStuff.SitEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientLoginNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientLoginNetworkHandler;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
@Environment(EnvType.CLIENT)
public class DeoModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // handler for if the server pings us with a loaded check
        ClientLoginNetworking.registerGlobalReceiver(DeoMod.LOADED_CHANNEL, DeoModClient::checkPacketReply);


        //ScreenRegistry.register(screenRegistry.WORKBENCH_SCREENHANDLER, workBenchScreen::new);

        EntityRendererRegistry.register(Sit.SIT_ENTITY_TYPE, EmptyRendererr::new);

        ClientLoginNetworking.registerGlobalReceiver(Sit.VERSION_CHECK, this::onServerRequest);

    }

    private static CompletableFuture<PacketByteBuf> checkPacketReply(MinecraftClient client, ClientLoginNetworkHandler handler, PacketByteBuf buf, Consumer<GenericFutureListener<? extends Future<? super Void>>> listener) {
        // respond to loaded check
        return CompletableFuture.completedFuture(PacketByteBufs.empty());
    }

    // empty renderer - will never render as shouldRender is always false
    private static class EmptyRenderer extends EntityRenderer<Entity> {
        protected EmptyRenderer(EntityRendererFactory.Context ctx) { super(ctx); }

        @Override
        public boolean shouldRender(Entity entity, Frustum frustum, double x, double y, double z) { return false; }

        @Override
        public Identifier getTexture(Entity entity) { return null; }
    }
    /**
     * VERSION_CHECK request received from server, send back own version
     * */
    private CompletableFuture<PacketByteBuf> onServerRequest(MinecraftClient minecraft, ClientLoginNetworkHandler listener, PacketByteBuf inBuf, Consumer<GenericFutureListener<? extends Future<? super Void>>> consumer)
    {
        //VERSION_CHECK request received from server, send back own version
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());

        buf.writeFloat(DeoMod.getModVersion());
        return CompletableFuture.completedFuture(buf);
    }

    private static class EmptyRendererr extends EntityRenderer<SitEntity> {
        protected EmptyRendererr(EntityRendererFactory.Context ctx) {
            super(ctx);
        }

        @Override
        public boolean shouldRender(SitEntity entity, Frustum frustum, double d, double e, double f) {
            return false;
        }

        @Override
        public Identifier getTexture(SitEntity entity) {
            return null;
        }
    }
}
