package net.venturer.temporal.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.venturer.temporal.Venturer;
import net.venturer.temporal.client.model.CoyoteModel;
import net.venturer.temporal.common.object.entity.Coyote;

public class CoyoteRenderer extends MobRenderer<Coyote, CoyoteModel<Coyote>> {
    public CoyoteRenderer(EntityRendererProvider.Context context) {
        super(context, new CoyoteModel<>(context.bakeLayer(CoyoteModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(Coyote entity) {
        return new ResourceLocation(Venturer.MOD_ID, "textures/entity/coyote/coyote.png");
    }
}