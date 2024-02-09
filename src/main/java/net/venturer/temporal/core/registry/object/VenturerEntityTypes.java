package net.venturer.temporal.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.temporal.Venturer;
import net.venturer.temporal.common.object.entity.Coyote;
import net.venturer.temporal.common.object.projectile.AncientArrow;

public class VenturerEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, Venturer.MOD_ID);

    public static final RegistryObject<EntityType<AncientArrow>> ANCIENT_ARROW = ENTITY_TYPES.register("ancient_arrow",
            () -> EntityType.Builder.<AncientArrow>of(AncientArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(Venturer.MOD_ID, "ancient_arrow").toString()));

    public static final RegistryObject<EntityType<Coyote>> COYOTE = ENTITY_TYPES.register("coyote",
            () -> EntityType.Builder.of(Coyote::new, MobCategory.CREATURE)
                    .sized(0.6F, 0.85F).clientTrackingRange(10)
                    .build(new ResourceLocation(Venturer.MOD_ID, "coyote").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}