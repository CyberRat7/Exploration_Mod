package net.temporal.venturer.core.gen.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.temporal.venturer.Venturer;
import net.temporal.venturer.core.gen.worldgen.VenturerBiomeModifiers;
import net.temporal.venturer.core.gen.worldgen.VenturerConfiguredFeatures;
import net.temporal.venturer.core.gen.worldgen.VenturerPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class VenturerWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, VenturerConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, VenturerPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, VenturerBiomeModifiers::bootstrap);

    public VenturerWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Venturer.MOD_ID));
    }
}