package net.temporal.venturer.client.renderer;

import com.temporal.api.core.engine.io.EnginedResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.temporal.venturer.client.model.CoyoteModel;
import net.temporal.venturer.common.object.entity.Coyote;

public class CoyoteRenderer extends MobRenderer<Coyote, CoyoteModel<Coyote>> {
    public CoyoteRenderer(EntityRendererProvider.Context context) {
        super(context, new CoyoteModel<>(context.bakeLayer(CoyoteModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(Coyote entity) {
        return new EnginedResourceLocation("textures/entity/coyote/coyote.png");
    }
}