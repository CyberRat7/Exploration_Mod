package net.venturer.cyber2000.core.gen.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.venturer.cyber2000.core.util.VenturerPlacedFeatureUtils;

import java.util.List;

public class VenturerPlacedFeatures {
    public static final ResourceKey<PlacedFeature> STINGING_NETTLE_PLACED = VenturerPlacedFeatureUtils.createKey("stinging_nettle_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        VenturerPlacedFeatureUtils.register(context, STINGING_NETTLE_PLACED, configuredFeatures.getOrThrow(VenturerConfiguredFeatures.STINGING_NETTLE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(12),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));


    }
}