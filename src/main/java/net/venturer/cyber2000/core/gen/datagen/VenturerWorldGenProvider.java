package net.venturer.cyber2000.core.gen.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.venturer.cyber2000.Venturer;
import net.venturer.cyber2000.core.gen.worldgen.VenturerConfiguredFeatures;
import net.venturer.cyber2000.core.gen.worldgen.VenturerPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class VenturerWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, VenturerConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, VenturerPlacedFeatures::bootstrap);

    public VenturerWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Venturer.MOD_ID));
    }
}