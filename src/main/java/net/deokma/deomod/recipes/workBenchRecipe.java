package net.deokma.deomod.recipes;

import com.google.gson.JsonObject;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.deokma.deomod.registry.blockRegistry;
import net.deokma.deomod.registry.recipeRegistry;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class workBenchRecipe extends CuttingRecipe {

    public workBenchRecipe(Identifier id, String group, Ingredient input, ItemStack output) {
        super(recipeRegistry.WORKBENCH_TYPE, recipeRegistry.WORKBENCH_SERIALIZER, id, group, input, output);
    }

    public boolean matches(Inventory inv, World world) {
        return this.input.test(inv.getStack(0));
    }

    @Environment(EnvType.CLIENT)
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(blockRegistry.WORKBENCH);
    }

    public static class Type implements RecipeType<workBenchRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "workbench";
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return recipeRegistry.WORKBENCH_SERIALIZER;
    }


    public static class Serializer implements RecipeSerializer<workBenchRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "workbench";

        // this is the name given in the json file
        @Override
        public workBenchRecipe read(Identifier id, JsonObject jsonObject) {
            String string = JsonHelper.getString(jsonObject, "group", "");
            Ingredient ingredient = JsonHelper.hasArray(jsonObject, "ingredient") ? Ingredient.fromJson(JsonHelper.getArray(jsonObject, "ingredient")) : Ingredient.fromJson(JsonHelper.getObject(jsonObject, "ingredient"));
            String string2 = JsonHelper.getString(jsonObject, "result");
            int i = JsonHelper.getInt(jsonObject, "count");
            ItemStack itemStack = new ItemStack(Registry.ITEM.get(new Identifier(string2)), i);

            return new workBenchRecipe(id, string, ingredient, itemStack);
        }

        @Override
        public workBenchRecipe read(Identifier id, PacketByteBuf buf) {
            String string = buf.readString();
            Ingredient ingredient = Ingredient.fromPacket(buf);
            ItemStack itemStack =buf.readItemStack();
            return new workBenchRecipe(id, string, ingredient, itemStack);
        }

        @Override
        public void write(PacketByteBuf buf, workBenchRecipe recipe) {
            buf.writeString(recipe.group);
            recipe.input.write(buf);
            buf.writeItemStack(recipe.output);
        }
    }
}
