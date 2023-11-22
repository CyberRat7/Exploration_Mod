package net.venturer.cyber2000.client.renderer;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.venturer.cyber2000.Venturer;
import net.venturer.cyber2000.common.object.projectile.AncientArrow;

public class AncientArrowRenderer extends ArrowRenderer<AncientArrow> {
    public AncientArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(AncientArrow ancientArrow) {
        return new ResourceLocation(Venturer.MOD_ID, "textures/entity/projectiles/ancient_arrow.png");
    }
}