package net.deokma.deomod.item;

import net.deokma.deomod.DeoMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup ITEMSF = FabricItemGroupBuilder.create(new Identifier(DeoMod.MOD_ID, "itemsf"))
            .icon(() -> new ItemStack(ModItems.RUBY))
            .appendItems(stack -> {
                stack.add(new ItemStack(ModItems.RUBY));
                stack.add(new ItemStack(ModItems.ARTEFACT));
            })
            .build();

    public static final ItemGroup FOODF = FabricItemGroupBuilder.create(new Identifier(DeoMod.MOD_ID, "foodf"))
            .icon(() -> new ItemStack(ModItems.GREEN_APPLE))
            .appendItems(stack -> {
                stack.add(new ItemStack(ModItems.GREEN_APPLE));
                stack.add(new ItemStack(ModItems.STRANGE_PLANT));
                stack.add(new ItemStack(ModItems.BACON));
                stack.add(new ItemStack(ModItems.CHOCOLATE_PIE));
                stack.add(new ItemStack(ModItems.COOKED_BACON));
                stack.add(new ItemStack(ModItems.GRILLED_SALMON));
            })
            .build();
}
