package net.venturer.cyber2000.core.util.creative;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import java.util.List;
import java.util.function.Supplier;

public class CreativeTabAdder {
    private final BuildCreativeModeTabContentsEvent event;

    public CreativeTabAdder(BuildCreativeModeTabContentsEvent event) {
        this.event = event;
    }

    public void addAllToIngredients(List<Supplier<? extends ItemLike>> registries) {
        addAllToTab(CreativeModeTabs.INGREDIENTS, registries);
    }

    public void addAllToCombat(List<Supplier<? extends ItemLike>> registries) {
        addAllToTab(CreativeModeTabs.COMBAT, registries);
    }

    public void addAllToTools(List<Supplier<? extends ItemLike>> registries) {
        addAllToTab(CreativeModeTabs.TOOLS_AND_UTILITIES, registries);
    }

    public void addAllToFood(List<Supplier<? extends ItemLike>> registries) {
        addAllToTab(CreativeModeTabs.FOOD_AND_DRINKS, registries);
    }

    public void addAllToBuildingBlocks(List<Supplier<? extends ItemLike>> registries) {
        addAllToTab(CreativeModeTabs.BUILDING_BLOCKS, registries);
    }

    public void addAllToNaturalBlocks(List<Supplier<? extends ItemLike>> registries) {
        addAllToTab(CreativeModeTabs.NATURAL_BLOCKS, registries);
    }

    public void addAllToColoredBlocks(List<Supplier<? extends ItemLike>> registries) {
        addAllToTab(CreativeModeTabs.COLORED_BLOCKS, registries);
    }

    public void addAllToFunctionalBlocks(List<Supplier<? extends ItemLike>> registries) {
        addAllToTab(CreativeModeTabs.FUNCTIONAL_BLOCKS, registries);
    }

    public void addAllToRedstoneBlocks(List<Supplier<? extends ItemLike>> registries) {
        addAllToTab(CreativeModeTabs.REDSTONE_BLOCKS, registries);
    }

    public void addAllToTab(ResourceKey<CreativeModeTab> tab, List<Supplier<? extends ItemLike>> registries) {
        registries.forEach(registry -> addToCreativeTab(tab, registry));
    }

    private void addToCreativeTab(ResourceKey<CreativeModeTab> tab, Supplier<? extends ItemLike> registryObject) {
        if (event.getTabKey() == tab) event.accept(registryObject);
    }
}
