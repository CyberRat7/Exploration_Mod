package net.temporal.venturer.core.gen.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.temporal.venturer.Venturer;
import net.temporal.venturer.core.registry.object.VenturerEntityTypes;

import java.util.List;

public class VenturerBiomeModifiers {
	
	public static final ResourceKey<BiomeModifier> SPAWN_COYOTE = registerKey("spawn_coyote");
	
	public static void bootstrap(BootstapContext<BiomeModifier> context) {
		var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
		var biomes = context.lookup(Registries.BIOME);
		
		context.register(SPAWN_COYOTE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
			biomes.getOrThrow(BiomeTags.IS_BADLANDS),
			List.of(new MobSpawnSettings.SpawnerData(VenturerEntityTypes.COYOTE.get(), 20, 3, 10))));
	}
	
	private static ResourceKey<BiomeModifier> registerKey(String name) {
		return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Venturer.MOD_ID, name));
	}
}
