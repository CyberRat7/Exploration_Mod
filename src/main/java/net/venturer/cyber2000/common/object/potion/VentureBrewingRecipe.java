package net.venturer.cyber2000.common.object.potion;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import org.jetbrains.annotations.NotNull;

public class VentureBrewingRecipe implements IBrewingRecipe {
    private final Potion input;
    private final Item ingredient;
    private final Potion output;

    public VentureBrewingRecipe(Potion input, Item ingredient, Potion output) {
        this.input = input;
        this.ingredient = ingredient;
        this.output = output;
    }

    @Override
    public @NotNull ItemStack getOutput(@NotNull ItemStack input, @NotNull ItemStack ingredient) {
        if(isRecipeEmpty(input, ingredient)) return ItemStack.EMPTY;
        return getImprovedRecipeOutput(input);
    }

    private ItemStack getImprovedRecipeOutput(@NotNull ItemStack input) {
        ItemStack itemStack = new ItemStack(input.getItem());
        itemStack.setTag(new CompoundTag());
        PotionUtils.setPotion(itemStack, this.output);
        return itemStack;
    }

    private boolean isRecipeEmpty(@NotNull ItemStack input, @NotNull ItemStack ingredient) {
        return !this.isInput(input) || !this.isIngredient(ingredient);
    }

    @Override
    public boolean isInput(@NotNull ItemStack input) {
        return PotionUtils.getPotion(input) == this.input;
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        return ingredient.getItem() == this.ingredient;
    }
}