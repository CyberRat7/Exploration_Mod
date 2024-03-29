package net.temporal.venturer.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.temporal.api.core.engine.io.EnginedResourceLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.temporal.venturer.client.model.CoyoteModel;
import net.temporal.venturer.common.object.entity.Coyote;
import org.jetbrains.annotations.NotNull;

public class CoyoteRenderer extends MobRenderer<Coyote, CoyoteModel<Coyote>> {
    public CoyoteRenderer(EntityRendererProvider.Context context) {
        super(context, new CoyoteModel<>(context.bakeLayer(CoyoteModel.LAYER_LOCATION)), 0.35F);
    }

    @Override
    public ResourceLocation getTextureLocation(@NotNull Coyote entity) {
        return new EnginedResourceLocation("textures/entity/coyote/coyote.png");
    }
    
    @Override
    public void render(Coyote pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.5F, 0.5F, 0.5F);
        }
        
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}