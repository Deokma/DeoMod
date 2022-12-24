package net.deokma.deomod.item;

import net.minecraft.item.FoodComponent;

public class Food {
    public static final FoodComponent BACON = new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build();
    public static final FoodComponent CHOCOLATE_PIE = new FoodComponent.Builder().hunger(10).saturationModifier(0.3f).build();
    public static final FoodComponent COOKED_BACON = new FoodComponent.Builder().hunger(7).saturationModifier(0.1f).build();
    public static final FoodComponent GREEN_APPLE = new FoodComponent.Builder().hunger(8).saturationModifier(0.3f).build();
    public static final FoodComponent GRILLED_SALMON = new FoodComponent.Builder().hunger(16).saturationModifier(0.3f).build();
    public static final FoodComponent STRANGE_PLANT = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build();

}
