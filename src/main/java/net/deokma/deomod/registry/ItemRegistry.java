package net.deokma.deomod.registry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
public class ItemRegistry {
    public static final String MOD_ID = "deomod";
    /* |------|
       |-FOOD-|
       |------|*/
    public static final FoodComponent BACONF = new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build();
    public static final FoodComponent CHOCOLATE_PIEF = new FoodComponent.Builder().hunger(10).saturationModifier(0.3f).build();
    public static final FoodComponent COOKED_BACONF = new FoodComponent.Builder().hunger(7).saturationModifier(0.1f).build();
    public static final FoodComponent GREEN_APPLEF = new FoodComponent.Builder().hunger(8).saturationModifier(0.3f).build();
    public static final FoodComponent GRILLED_SALMONF = new FoodComponent.Builder().hunger(16).saturationModifier(0.3f).build();
    public static final FoodComponent STRANGE_PLANTF = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build();
//     /*|-------|
//       |-ITEMS-|
//       |-------|*/
    public static final Item RUBY = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item ARTEFACT = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bacon"), new Item(new FabricItemSettings().food(BACONF).group(ItemGroup.FOOD)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cooked_bacon"), new Item(new FabricItemSettings().food(COOKED_BACONF).group(ItemGroup.FOOD)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chocolate_pie"), new Item(new FabricItemSettings().food(CHOCOLATE_PIEF).group(ItemGroup.FOOD)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "green_apple"), new Item(new FabricItemSettings().food(GREEN_APPLEF).group(ItemGroup.FOOD)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "grilled_salmon"), new Item(new FabricItemSettings().food(GRILLED_SALMONF).group(ItemGroup.FOOD)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "strange_plant"), new Item(new FabricItemSettings().food(STRANGE_PLANTF).group(ItemGroup.FOOD)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "ruby"), RUBY);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "artefact"), ARTEFACT);
    }
}