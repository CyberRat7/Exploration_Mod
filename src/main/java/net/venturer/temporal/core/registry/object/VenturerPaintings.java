package net.venturer.temporal.core.registry.object;

import net.venturer.temporal.Venturer;
import net.venturer.temporal.core.registry.factory.PaintingFactory;
import net.venturer.temporal.core.util.log.LoggingRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class VenturerPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(Registries.PAINTING_VARIANT, Venturer.MOD_ID);

    public static final RegistryObject<PaintingVariant> EARTH = PaintingFactory.create32x32("earth_planet");
    public static final RegistryObject<PaintingVariant> TURTLE = PaintingFactory.create32x16("turtle");
    public static final RegistryObject<PaintingVariant> BLACK_HEART = PaintingFactory.create16x16("black_heart");
    public static final RegistryObject<PaintingVariant> BLUE_HEART = PaintingFactory.create16x16("blue_heart");
    public static final RegistryObject<PaintingVariant> BROWN_HEART = PaintingFactory.create16x16("brown_heart");
    public static final RegistryObject<PaintingVariant> DARK_BLUE_HEART = PaintingFactory.create16x16("dark_blue_heart");
    public static final RegistryObject<PaintingVariant> GRAY_HEART = PaintingFactory.create16x16("gray_heart");
    public static final RegistryObject<PaintingVariant> GREEN_HEART = PaintingFactory.create16x16("green_heart");
    public static final RegistryObject<PaintingVariant> LIME_HEART = PaintingFactory.create16x16("lime_heart");
    public static final RegistryObject<PaintingVariant> ORANGE_HEART = PaintingFactory.create16x16("orange_heart");
    public static final RegistryObject<PaintingVariant> PINK_HEART = PaintingFactory.create16x16("pink_heart");
    public static final RegistryObject<PaintingVariant> PURPLE_HEART = PaintingFactory.create16x16("purple_heart");
    public static final RegistryObject<PaintingVariant> RED_HEART = PaintingFactory.create16x16("red_heart");
    public static final RegistryObject<PaintingVariant> WHITE_HEART = PaintingFactory.create16x16("white_heart");
    public static final RegistryObject<PaintingVariant> YELLOW_HEART = PaintingFactory.create16x16("yellow_heart");

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(PAINTING_VARIANTS, "paintings", eventBus);
    }
}
