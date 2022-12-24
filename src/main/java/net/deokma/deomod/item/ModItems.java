package net.deokma.deomod.item;

import net.deokma.deomod.DeoMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //Food
    public static final Item GREEN_APPLE = registerItem("green_apple",
            new Item(new FabricItemSettings().food(Food.GREEN_APPLE).group(ItemGroup.FOOD)));
    public static final Item STRANGE_PLANT = registerItem("strange_plant",
            new Item(new FabricItemSettings().food(Food.STRANGE_PLANT).group(ItemGroup.FOOD)));
    public static final Item BACON = registerItem("bacon",
            new Item(new FabricItemSettings().food(Food.BACON).group(ItemGroup.FOOD)));
    public static final Item COOKED_BACON = registerItem("cooked_bacon",
            new Item(new FabricItemSettings().food(Food.COOKED_BACON).group(ItemGroup.FOOD)));
    public static final Item CHOCOLATE_PIE = registerItem("chocolate_pie",
            new Item(new FabricItemSettings().food(Food.CHOCOLATE_PIE).group(ItemGroup.FOOD)));
    public static final Item GRILLED_SALMON = registerItem("grilled_salmon",
            new Item(new FabricItemSettings().food(Food.GRILLED_SALMON).group(ItemGroup.FOOD)));

    //Items
    public static final Item RUBY = registerItem("ruby",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item ARTEFACT = registerItem("artefact",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(DeoMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DeoMod.LOGGER.debug("Registering Mod Items for " + DeoMod.MOD_ID);
    }
}
