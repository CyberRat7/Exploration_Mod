package net.venture.cyber2000.core.tag;

import net.venture.cyber2000.Venture;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class VentureBiomeTags {
    public static final TagKey<Biome> ACACIA_CART_BIOMES = create("has_structure/abandoned_acacia_cart");
    public static final TagKey<Biome> DARK_OAK_CART_BIOMES = create("has_structure/abandoned_dark_oak_cart");
    public static final TagKey<Biome> SPRUCE_CART_BIOMES = create("has_structure/abandoned_spruce_cart");

    private static TagKey<Biome> create(String name) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(Venture.MOD_ID, name));
    }
}
