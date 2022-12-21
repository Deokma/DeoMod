package net.deokma.deomod.entity;

/*
Possible poses
 */
public enum Pose {
    SITTING("sitting"),
    LAYING("laying");

    public final String pose;

    Pose(String pose) {
        this.pose = pose;
    }

    @Override
    public String toString() {
        return this.pose;
    }
}
