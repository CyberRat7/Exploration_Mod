package net.venturer.temporal.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.venturer.temporal.Venturer;
import net.venturer.temporal.common.object.entity.Coyote;

public class CoyoteModel<T extends Coyote> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Venturer.MOD_ID, "coyote"), "main");
	private final ModelPart coyote;

	public CoyoteModel(ModelPart root) {
		this.coyote = root.getChild("coyote");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();
		PartDefinition coyote = partDefinition.addOrReplaceChild("coyote", CubeListBuilder.create(), PartPose.offset(-1.0F, 14.5F, -7.0F));

		PartDefinition tail = coyote.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(22, 0).addBox(0.0F, 1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(22, 9).addBox(0.0F, 4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.offset(0.0F, -2.5F, 17.0F));
		PartDefinition leg4 = coyote.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(12, 23).addBox(0.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 1.5F, 4.0F));
		PartDefinition leg3 = coyote.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(12, 23).mirror().addBox(0.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 1.5F, 4.0F));
		PartDefinition leg2 = coyote.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(12, 23).addBox(0.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 1.5F, 14.0F));
		PartDefinition leg1 = coyote.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(12, 23).mirror().addBox(0.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 1.5F, 14.0F));
		PartDefinition body = coyote.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(1.0F, -0.5F, 9.0F));
		PartDefinition bodyRotation = body.addOrReplaceChild("bodyRotation", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition head = coyote.addOrReplaceChild("head", CubeListBuilder.create().texOffs(18, 15).addBox(-2.0F, -2.0F, -2.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(10, 19).addBox(2.0F, -5.0F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 19).mirror().addBox(-2.0F, -5.0F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 19).addBox(-0.5F, 0.98F, -5.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		ModelPart head = this.coyote.getChild("head");
		head.xRot = headPitch * ((float)Math.PI / 180F);
		head.yRot = netHeadYaw * ((float)Math.PI / 180F);

		ModelPart leg1 = this.coyote.getChild("leg1");
		ModelPart leg2 = this.coyote.getChild("leg2");
		ModelPart leg3 = this.coyote.getChild("leg3");
		ModelPart leg4 = this.coyote.getChild("leg4");
		leg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		leg2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		leg3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		leg4.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		coyote.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}