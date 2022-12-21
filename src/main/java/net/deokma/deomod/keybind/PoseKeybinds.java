package net.deokma.deomod.keybind;

import net.deokma.deomod.DeoMod;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.deokma.deomod.entity.Pose;
import net.deokma.deomod.network.PoseRequestC2SPacket;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public abstract class PoseKeybinds {
    // translation keys for controls screen
    private static final String KEY = "key." + DeoMod.MOD_ID + ".";
    private static final String CATEGORY = "key." + DeoMod.MOD_ID + ".category";

    // sit and lay hotkeys
    private static final KeyBinding sitKey = emptyKey("sit");
    private static final KeyBinding layKey = emptyKey("lay");

    private static KeyBinding emptyKey(String base) {
        return KeyBindingHelper.registerKeyBinding(
                new KeyBinding(KEY + base, InputUtil.Type.KEYSYM,InputUtil.UNKNOWN_KEY.getCode(), CATEGORY)
        );
    }

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while(sitKey.wasPressed()) {
                ClientPlayNetworking.send(DeoMod.REQUEST_CHANNEL, new PoseRequestC2SPacket(Pose.SITTING).buf());
            }

            while(layKey.wasPressed()) {
                ClientPlayNetworking.send(DeoMod.REQUEST_CHANNEL, new PoseRequestC2SPacket(Pose.LAYING).buf());
            }
        });
    }
}
