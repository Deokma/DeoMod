package net.deokma.deomod.registry;

import net.deokma.deomod.recipes.workBenchRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class recipeRegistry {

    public static RecipeSerializer<workBenchRecipe> WORKBENCH_SERIALIZER;
    public static RecipeType<workBenchRecipe> WORKBENCH_TYPE;

    public static void registerRecipes() {

        WORKBENCH_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, new Identifier("deomod", "workbench"), workBenchRecipe.Serializer.INSTANCE);
        WORKBENCH_TYPE = Registry.register(Registry.RECIPE_TYPE, new Identifier("deomod", "workbench"), workBenchRecipe.Type.INSTANCE);

    }
}
