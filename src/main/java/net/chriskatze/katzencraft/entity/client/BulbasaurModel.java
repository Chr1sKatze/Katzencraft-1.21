package net.chriskatze.katzencraft.entity.client;

import net.chriskatze.katzencraft.entity.client.animation.BulbasaurAnimations;
import net.chriskatze.katzencraft.entity.custom.BulbasaurEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class BulbasaurModel extends SinglePartEntityModel<BulbasaurEntity> {
    private final ModelPart bulbasaur;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart torso;

    public BulbasaurModel(ModelPart root) {
        this.bulbasaur = root.getChild("bulbasaur");
        this.body = this.bulbasaur.getChild("body");
        this.torso = this.body.getChild("torso");
        this.head = this.torso.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bulbasaur = modelPartData.addChild("bulbasaur", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = bulbasaur.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -5.0F, 1.0F));

        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.5F, -0.5F));

        ModelPartData torso_r1 = torso.addChild("torso_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -3.5F, -4.5F, 8.0F, 6.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

        ModelPartData bulb = torso.addChild("bulb", ModelPartBuilder.create().uv(0, 17).cuboid(-4.0F, -5.0F, -4.25F, 8.0F, 5.0F, 9.0F, new Dilation(0.1F))
                .uv(26, 0).cuboid(-2.5F, -7.0F, -2.25F, 5.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 1.75F, -0.2618F, 0.0F, 0.0F));

        ModelPartData bulb_r1 = bulb.addChild("bulb_r1", ModelPartBuilder.create().uv(25, 49).cuboid(-0.5F, -1.017F, -1.3794F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.483F, 0.1294F, 0.0F, -0.7854F, 0.0F));

        ModelPartData bulb_r2 = bulb.addChild("bulb_r2", ModelPartBuilder.create().uv(25, 54).cuboid(-0.5F, -1.017F, -1.3794F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.483F, 0.1294F, 0.0F, 0.7854F, 0.0F));

        ModelPartData head = torso.addChild("head", ModelPartBuilder.create().uv(27, 24).cuboid(-4.5F, -3.0F, -5.75F, 9.0F, 6.0F, 7.0F, new Dilation(0.0F))
                .uv(25, 22).cuboid(-3.5F, 2.0F, -6.25F, 7.0F, 1.0F, 1.0F, new Dilation(0.01F))
                .uv(25, 17).cuboid(-4.5F, 3.0F, -2.75F, 9.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, -3.5F));

        ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(0, 2).cuboid(-0.6F, -0.6F, 0.25F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.75F, 3.0F, -5.25F, 0.5236F, -0.4363F, -0.8727F));

        ModelPartData head_r2 = head.addChild("head_r2", ModelPartBuilder.create().uv(7, 2).cuboid(-0.4F, -0.6F, 0.25F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.75F, 3.0F, -5.25F, 0.5236F, 0.4363F, 0.8727F));

        ModelPartData pattern = head.addChild("pattern", ModelPartBuilder.create().uv(34, 51).cuboid(-4.0F, -10.5F, -8.25F, 8.0F, 6.0F, 7.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F, 7.5F, 2.5F));

        ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(0, 31).cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.0F, -2.75F));

        ModelPartData eyes = head.addChild("eyes", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.5F, -4.95F));

        ModelPartData eye_right = eyes.addChild("eye_right", ModelPartBuilder.create().uv(34, 45).cuboid(-0.985F, -1.5F, -0.985F, 2.0F, 3.0F, 3.0F, new Dilation(0.01F)), ModelTransform.pivot(-3.515F, 0.0F, 0.185F));

        ModelPartData pupil_right = eye_right.addChild("pupil_right", ModelPartBuilder.create().uv(7, 0).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.02F)), ModelTransform.pivot(0.015F, 0.25F, -0.985F));

        ModelPartData eyelid_right = eye_right.addChild("eyelid_right", ModelPartBuilder.create().uv(45, 10).cuboid(-0.985F, -1.5F, -0.985F, 2.0F, 3.0F, 3.0F, new Dilation(0.03F)), ModelTransform.pivot(0.1F, 0.0F, 0.1F));

        ModelPartData eye_left = eyes.addChild("eye_left", ModelPartBuilder.create().uv(24, 43).cuboid(-1.015F, -1.5F, -0.985F, 2.0F, 3.0F, 3.0F, new Dilation(0.01F)), ModelTransform.pivot(3.515F, 0.0F, 0.185F));

        ModelPartData pupil_left = eye_left.addChild("pupil_left", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.02F)), ModelTransform.pivot(-0.015F, 0.25F, -0.985F));

        ModelPartData eyelid_left = eye_left.addChild("eyelid_left", ModelPartBuilder.create().uv(0, 0).cuboid(-1.015F, -1.5F, -0.985F, 2.0F, 3.0F, 3.0F, new Dilation(0.03F)), ModelTransform.pivot(-0.1F, 0.0F, 0.1F));

        ModelPartData ears = head.addChild("ears", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.0F, -2.25F));

        ModelPartData ear_right = ears.addChild("ear_right", ModelPartBuilder.create().uv(13, 52).cuboid(-2.0F, -2.875F, 0.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 0.875F, 0.75F, 0.0F, 0.2182F, -0.3054F));

        ModelPartData ear_left = ears.addChild("ear_left", ModelPartBuilder.create().uv(13, 48).cuboid(-2.0F, -2.875F, 0.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 0.875F, 0.75F, 0.0F, -0.2182F, 0.3054F));

        ModelPartData leg_front_right = body.addChild("leg_front_right", ModelPartBuilder.create().uv(28, 37).cuboid(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.75F, 1.5F, -3.0F));

        ModelPartData knee_front_right = leg_front_right.addChild("knee_front_right", ModelPartBuilder.create().uv(12, 42).cuboid(0.0F, 0.0F, -3.0F, 3.0F, 2.0F, 3.0F, new Dilation(0.01F))
                .uv(62, 0).cuboid(1.5F, 1.0F, -3.75F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, 1.5F, 1.5F));

        ModelPartData leg_front_right_r1 = knee_front_right.addChild("leg_front_right_r1", ModelPartBuilder.create().uv(62, -1).mirrored().cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.75F, 1.5F, -3.0F, 0.0F, -0.2618F, 0.0F));

        ModelPartData leg_front_right_r2 = knee_front_right.addChild("leg_front_right_r2", ModelPartBuilder.create().uv(62, 1).cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, 1.5F, -3.0F, 0.0F, 0.2618F, 0.0F));

        ModelPartData leg_front_left = body.addChild("leg_front_left", ModelPartBuilder.create().uv(36, 7).cuboid(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(3.75F, 1.5F, -3.0F));

        ModelPartData knee_front_left = leg_front_left.addChild("knee_front_left", ModelPartBuilder.create().uv(37, 40).cuboid(-3.0F, 0.0F, -3.0F, 3.0F, 2.0F, 3.0F, new Dilation(0.01F))
                .uv(62, 3).mirrored().cuboid(-1.5F, 1.0F, -3.75F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.5F, 1.5F, 1.5F));

        ModelPartData leg_front_left_r1 = knee_front_left.addChild("leg_front_left_r1", ModelPartBuilder.create().uv(62, 4).mirrored().cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.25F, 1.5F, -3.0F, 0.0F, -0.2618F, 0.0F));

        ModelPartData leg_front_left_r2 = knee_front_left.addChild("leg_front_left_r2", ModelPartBuilder.create().uv(62, 2).cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.75F, 1.5F, -3.0F, 0.0F, 0.2618F, 0.0F));

        ModelPartData leg_back_right = body.addChild("leg_back_right", ModelPartBuilder.create().uv(14, 35).cuboid(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.75F, 1.5F, 3.5F));

        ModelPartData knee_back_right = leg_back_right.addChild("knee_back_right", ModelPartBuilder.create().uv(0, 42).cuboid(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, new Dilation(0.01F))
                .uv(62, 6).cuboid(1.5F, 1.0F, -0.75F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, 1.5F, -2.5F));

        ModelPartData leg_front_right_r3 = knee_back_right.addChild("leg_front_right_r3", ModelPartBuilder.create().uv(62, 7).cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, 1.5F, 0.0F, 0.0F, 0.2618F, 0.0F));

        ModelPartData leg_front_right_r4 = knee_back_right.addChild("leg_front_right_r4", ModelPartBuilder.create().uv(62, 5).mirrored().cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.75F, 1.5F, 0.0F, 0.0F, -0.2618F, 0.0F));

        ModelPartData leg_back_left = body.addChild("leg_back_left", ModelPartBuilder.create().uv(0, 35).cuboid(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(3.75F, 1.5F, 3.5F));

        ModelPartData knee_back_left = leg_back_left.addChild("knee_back_left", ModelPartBuilder.create().uv(41, 0).cuboid(-3.0F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, new Dilation(0.01F))
                .uv(62, 9).mirrored().cuboid(-1.5F, 1.0F, -0.75F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.5F, 1.5F, -2.5F));

        ModelPartData leg_front_left_r3 = knee_back_left.addChild("leg_front_left_r3", ModelPartBuilder.create().uv(62, 8).cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.75F, 1.5F, 0.0F, 0.0F, 0.2618F, 0.0F));

        ModelPartData leg_front_left_r4 = knee_back_left.addChild("leg_front_left_r4", ModelPartBuilder.create().uv(62, 10).mirrored().cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.25F, 1.5F, 0.0F, 0.0F, -0.2618F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(BulbasaurEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(BulbasaurAnimations.BULBASAUR_GROUND_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, BulbasaurAnimations.BULBASAUR_GROUND_IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
        headPitch = MathHelper.clamp(headPitch, -25f, 45);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        bulbasaur.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return bulbasaur;
    }
}