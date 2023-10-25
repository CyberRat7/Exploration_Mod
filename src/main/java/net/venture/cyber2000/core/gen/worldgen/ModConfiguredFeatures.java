package net.venture.cyber2000.core.gen.worldgen;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.venture.cyber2000.core.registry.object.VentureBlocks;
import net.venture.cyber2000.core.util.ModConfiguredFeatureUtils;


public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> STINGING_NETTLE_KEY = ModConfiguredFeatureUtils.createKey("stinging_nettle");


    //Tries means how many of the flowers will spawn in a patch together, xzSpread and ySpread are how spread out the flowers in the patch are
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        ModConfiguredFeatureUtils.register(context, STINGING_NETTLE_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(8, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(VentureBlocks.STINGING_NETTLE.get())))));
    }
}