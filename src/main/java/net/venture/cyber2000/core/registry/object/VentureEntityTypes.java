package net.venture.cyber2000.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venture.cyber2000.Venture;
import net.venture.cyber2000.common.object.projectile.AncientArrow;
import net.venture.cyber2000.core.util.log.LoggingRegistry;

public class VentureEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, Venture.MOD_ID);

    public static final RegistryObject<EntityType<AncientArrow>> ANCIENT_ARROW = ENTITY_TYPES.register("ancient_arrow",
            () -> EntityType.Builder.<AncientArrow>of(AncientArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(Venture.MOD_ID, "ancient_arrow").toString()));

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(ENTITY_TYPES, "entities", eventBus);
    }
}
