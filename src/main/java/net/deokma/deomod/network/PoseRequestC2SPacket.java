package net.deokma.deomod.network;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.deokma.deomod.entity.Pose;
import net.minecraft.network.PacketByteBuf;

/**
 * Pose request packet, client -> server
 */
public class PoseRequestC2SPacket {
    private final Pose pose;

    public PoseRequestC2SPacket(Pose pose) { this.pose = pose; }

    public PoseRequestC2SPacket(PacketByteBuf buf) { this.pose = buf.readEnumConstant(Pose.class); }

    public PacketByteBuf buf() {
        return PacketByteBufs.create().writeEnumConstant(this.pose);
    }

    public Pose getPose() { return pose; }
}
