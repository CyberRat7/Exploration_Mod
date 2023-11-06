package net.venture.cyber2000.core.gen.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.venture.cyber2000.core.util.ModPlacedFeatureUtils;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> STINGING_NETTLE_PLACED = ModPlacedFeatureUtils.createKey("stinging_nettle_placed");

    public static final ResourceKey<PlacedFeature> YELLOW_MARIGOLD_PLACED = ModPlacedFeatureUtils.createKey("yellow_marigold_placed");

    public static final ResourceKey<PlacedFeature> ORANGE_MARIGOLD_PLACED = ModPlacedFeatureUtils.createKey("orange_marigold_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        ModPlacedFeatureUtils.register(context, STINGING_NETTLE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.STINGING_NETTLE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(12),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        ModPlacedFeatureUtils.register(context, ORANGE_MARIGOLD_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORANGE_MARIGOLD_KEY),
                List.of(RarityFilter.onAverageOnceEvery(8),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        ModPlacedFeatureUtils.register(context, YELLOW_MARIGOLD_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.YELLOW_MARIGOLD_KEY),
                List.of(RarityFilter.onAverageOnceEvery(8),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    }
}