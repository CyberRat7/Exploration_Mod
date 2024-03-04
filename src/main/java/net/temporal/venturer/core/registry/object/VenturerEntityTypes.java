package net.temporal.venturer.core.registry.object;

import com.temporal.api.core.registry.factory.common.EntityTypeFactory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.temporal.venturer.Venturer;
import net.temporal.venturer.common.object.entity.Coyote;
import net.temporal.venturer.common.object.projectile.AncientArrow;

public class VenturerEntityTypes {
    public static final EntityTypeFactory ENTITY_TYPE_FACTORY = EntityTypeFactory.getInstance();

    public static final RegistryObject<EntityType<AncientArrow>> ANCIENT_ARROW = EntityTypeFactory.ENTITY_TYPES.register("ancient_arrow",
            () -> EntityType.Builder.<AncientArrow>of(AncientArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(Venturer.MOD_ID, "ancient_arrow").toString()));

    public static final RegistryObject<EntityType<Coyote>> COYOTE = EntityTypeFactory.ENTITY_TYPES.register("coyote",
            () -> EntityType.Builder.of(Coyote::new, MobCategory.CREATURE)
                    .sized(0.6F, 0.85F).clientTrackingRange(10)
                    .build(new ResourceLocation(Venturer.MOD_ID, "coyote").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPE_FACTORY.register(eventBus);
    }
}