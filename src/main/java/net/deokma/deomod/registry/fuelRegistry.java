package net.deokma.deomod.registry;

import net.fabricmc.fabric.impl.content.registry.FuelRegistryImpl;

import static net.deokma.deomod.registry.blockRegistry.*;

public class fuelRegistry {
    public static void registerFuel()
    {
        FuelRegistryImpl.INSTANCE.add(OAK_LOG_SMALL_STOOL, 300);
    }
}
