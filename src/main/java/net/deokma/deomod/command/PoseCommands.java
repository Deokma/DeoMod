package net.deokma.deomod.command;

import net.deokma.deomod.entity.Pose;

import java.util.stream.Stream;

// possible pose commands
public enum PoseCommands {
    SIT(Pose.SITTING, "sit", true),
    LAY(Pose.LAYING, "lay", true);

    // Pose to use
    public final Pose pose;
    // name of command - used for command and permission
    public final String name;
    // whether to enable by default
    public final boolean enable;

    PoseCommands(Pose pose, String name, boolean enable) {
        this.pose = pose;
        this.name = name;
        this.enable = enable;
    }

    public static Stream<PoseCommands> stream() {
        return Stream.of(PoseCommands.values());
    }
}
