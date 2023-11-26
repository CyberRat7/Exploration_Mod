package net.venturer.temporal.core.util.creative;

import net.minecraft.world.level.ItemLike;
import net.venturer.temporal.Venturer;
import net.venturer.temporal.core.util.log.InfoLoggable;

import java.util.List;
import java.util.function.Supplier;

public class CreativeTabBuilder {
    private CreativeTabAdder creativeTabAdder;

    public CreativeTabBuilder(CreativeTabAdder creativeTabAdder) {
        this.creativeTabAdder = creativeTabAdder;
    }

    @SafeVarargs
    public final CreativeTabBuilder processIngredients(Supplier<? extends ItemLike>... items) {
        creativeTabAdder.addAllToIngredients(List.of(items));
        return this;
    }

    @SafeVarargs
    public final CreativeTabBuilder processCombat(Supplier<? extends ItemLike>... items) {
        creativeTabAdder.addAllToCombat(List.of(items));
        return this;
    }

    @SafeVarargs
    public final CreativeTabBuilder processTools(Supplier<? extends ItemLike>... items) {
        creativeTabAdder.addAllToTools(List.of(items));
        return this;
    }

    @SafeVarargs
    public final CreativeTabBuilder processFood(Supplier<? extends ItemLike>... items) {
        creativeTabAdder.addAllToFood(List.of(items));
        return this;
    }

    @SafeVarargs
    public final CreativeTabBuilder processBuildingBlocks(Supplier<? extends ItemLike>... items) {
        creativeTabAdder.addAllToBuildingBlocks(List.of(items));
        return this;
    }

    @SafeVarargs
    public final CreativeTabBuilder processNaturalBlocks(Supplier<? extends ItemLike>... items) {
        creativeTabAdder.addAllToNaturalBlocks(List.of(items));
        return this;
    }

    @SafeVarargs
    public final CreativeTabBuilder processColoredBlocks(Supplier<? extends ItemLike>... items) {
        creativeTabAdder.addAllToColoredBlocks(List.of(items));
        return this;
    }

    @SafeVarargs
    public final CreativeTabBuilder processFunctionalBlocks(Supplier<? extends ItemLike>... items) {
        creativeTabAdder.addAllToFunctionalBlocks(List.of(items));
        return this;
    }

    @SafeVarargs
    public final CreativeTabBuilder processRedstoneBlocks(Supplier<? extends ItemLike>... items) {
        creativeTabAdder.addAllToRedstoneBlocks(List.of(items));
        return this;
    }

    public static CreativeTabBuilder create(CreativeTabAdder creativeTabAdder) {
        return new CreativeTabBuilder(creativeTabAdder);
    }

    public void build() {
        new InfoLoggable("Creative Tabs").log();
    }

    public CreativeTabAdder getCreativeTabAdder() {
        return creativeTabAdder;
    }

    public void setCreativeTabAdder(CreativeTabAdder creativeTabAdder) {
        this.creativeTabAdder = creativeTabAdder;
    }
}
