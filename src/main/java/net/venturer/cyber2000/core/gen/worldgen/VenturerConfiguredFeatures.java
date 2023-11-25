package net.venturer.cyber2000.core.gen.worldgen;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.venturer.cyber2000.core.registry.object.VenturerBlocks;
import net.venturer.cyber2000.core.util.VenturerConfiguredFeatureUtils;

public class VenturerConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> STINGING_NETTLE_KEY = VenturerConfiguredFeatureUtils.createKey("stinging_nettle");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_MARIGOLD_KEY = VenturerConfiguredFeatureUtils.createKey("orange_marigold");

    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_MARIGOLD_KEY = VenturerConfiguredFeatureUtils.createKey("yellow_marigold");

    //Tries means how many of the flowers will spawn in a patch together, xzSpread and ySpread are how spread out the flowers in the patch are
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        VenturerConfiguredFeatureUtils.register(context, STINGING_NETTLE_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(8, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(VenturerBlocks.STINGING_NETTLE.get())))));

//        VenturerConfiguredFeatureUtils.register(context, YELLOW_MARIGOLD_KEY, Feature.FLOWER,
//                new RandomPatchConfiguration(16, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
//                        new SimpleBlockConfiguration(BlockStateProvider.simple(VenturerBlocks.YELLOW_MARIGOLD.get())))));
//
//        VenturerConfiguredFeatureUtils.register(context, ORANGE_MARIGOLD_KEY, Feature.FLOWER,
//                new RandomPatchConfiguration(16, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
//                        new SimpleBlockConfiguration(BlockStateProvider.simple(VenturerBlocks.ORANGE_MARIGOLD.get())))));

    }
}