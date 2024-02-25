package net.temporal.venturer.core.gen.worldgen;

import com.temporal.api.core.util.feature.PlacedFeatureUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class VenturerPlacedFeatures {
    protected static final PlacedFeatureUtils PLACED_FEATURE_UTILS = PlacedFeatureUtils.getInstance();
    public static final ResourceKey<PlacedFeature> STINGING_NETTLE_PLACED = PLACED_FEATURE_UTILS.createKey("stinging_nettle_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        PLACED_FEATURE_UTILS.register(context, STINGING_NETTLE_PLACED, configuredFeatures.getOrThrow(VenturerConfiguredFeatures.STINGING_NETTLE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(8),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    }
}