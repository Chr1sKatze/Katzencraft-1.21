package net.chriskatze.katzencraft.entity.client;

import net.chriskatze.katzencraft.entity.client.animation.IvysaurAnimations;
import net.chriskatze.katzencraft.entity.custom.IvysaurEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class IvysaurModel extends SinglePartEntityModel<IvysaurEntity> {
    private final ModelPart ivysaur;
    private final ModelPart body;
    private final ModelPart torso;
    private final ModelPart head;

    public IvysaurModel(ModelPart root) {
        this.ivysaur = root.getChild("ivysaur");
        this.body = this.ivysaur.getChild("body");
        this.torso = this.body.getChild("torso");
        this.head = this.torso.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData ivysaur = modelPartData.addChild("ivysaur", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = ivysaur.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -6.0F, 2.0F));

        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 1.0F, 0.0F));

        ModelPartData torso_r1 = torso.addChild("torso_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -6.5F, -4.5F, 10.0F, 8.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 1.0F, -1.5F, -0.0873F, 0.0F, 0.0F));

        ModelPartData bulb_master = torso.addChild("bulb_master", ModelPartBuilder.create(), ModelTransform.of(0.0F, -5.5F, -0.25F, -0.0873F, 0.0F, 0.0F));

        ModelPartData bulb = bulb_master.addChild("bulb", ModelPartBuilder.create().uv(48, 56).cuboid(-2.0F, -2.75F, -2.25F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 46).cuboid(-3.0F, -2.75F, -3.25F, 6.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(30, 25).cuboid(-4.0F, -9.75F, -4.25F, 8.0F, 7.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.25F));

        ModelPartData bulb_r1 = bulb.addChild("bulb_r1", ModelPartBuilder.create().uv(63, 72).cuboid(-0.5F, -2.0F, -4.0F, 1.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -10.25F, -0.25F, 0.0F, 0.7854F, 0.0F));

        ModelPartData bulb_r2 = bulb.addChild("bulb_r2", ModelPartBuilder.create().uv(63, 61).cuboid(-0.5F, -2.0F, -4.0F, 1.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -10.25F, -0.25F, 0.0F, -0.7854F, 0.0F));

        ModelPartData leaf_front = bulb_master.addChild("leaf_front", ModelPartBuilder.create().uv(83, 27).cuboid(-3.5F, -1.0F, -4.0F, 7.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -1.75F, -0.3491F, 0.0F, 0.0F));

        ModelPartData leaf_front2 = leaf_front.addChild("leaf_front2", ModelPartBuilder.create().uv(82, 21).cuboid(-3.5F, -1.0F, -5.0F, 7.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -4.0F));

        ModelPartData leaf_front3 = leaf_front2.addChild("leaf_front3", ModelPartBuilder.create().uv(83, 16).cuboid(-3.5F, -1.0F, -4.0F, 7.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -5.0F));

        ModelPartData leaf_right = bulb_master.addChild("leaf_right", ModelPartBuilder.create().uv(83, 56).cuboid(-4.0F, -1.0F, -3.5F, 4.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, 0.15F, 0.0F, 0.0F, 0.1745F));

        ModelPartData leaf_right2 = leaf_right.addChild("leaf_right2", ModelPartBuilder.create().uv(82, 64).cuboid(-5.0F, -1.0F, -3.25F, 5.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 0.0F, -0.25F));

        ModelPartData leaf_right3 = leaf_right2.addChild("leaf_right3", ModelPartBuilder.create().uv(83, 72).cuboid(-4.0F, -1.0F, -3.5F, 4.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, 0.0F, 0.25F));

        ModelPartData leaf_left = bulb_master.addChild("leaf_left", ModelPartBuilder.create().uv(83, 48).cuboid(0.0F, -1.0F, -3.5F, 4.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.0F, 0.15F, 0.0F, 0.0F, -0.1745F));

        ModelPartData leaf_left2 = leaf_left.addChild("leaf_left2", ModelPartBuilder.create().uv(82, 40).cuboid(0.0F, -1.0F, -3.5F, 5.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 0.0F, 0.0F));

        ModelPartData leaf_left3 = leaf_left2.addChild("leaf_left3", ModelPartBuilder.create().uv(83, 32).cuboid(0.0F, -1.0F, -3.5F, 4.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 0.0F, 0.0F));

        ModelPartData leaf_back = bulb_master.addChild("leaf_back", ModelPartBuilder.create().uv(83, 11).cuboid(-3.5F, -1.0F, 0.0F, 7.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.25F, 2.0F, 0.0873F, 0.0F, 0.0F));

        ModelPartData leaf_back2 = leaf_back.addChild("leaf_back2", ModelPartBuilder.create().uv(82, 5).cuboid(-3.5F, -1.0F, 0.0F, 7.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 4.0F));

        ModelPartData leaf_back3 = leaf_back2.addChild("leaf_back3", ModelPartBuilder.create().uv(83, 0).cuboid(-3.5F, -1.0F, 0.0F, 7.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 5.0F));

        ModelPartData head = torso.addChild("head", ModelPartBuilder.create().uv(0, 19).cuboid(-5.5F, -3.5F, -6.75F, 11.0F, 6.0F, 8.0F, new Dilation(0.0F))
                .uv(56, 46).cuboid(-3.5F, 1.5F, -7.25F, 7.0F, 1.0F, 1.0F, new Dilation(0.01F))
                .uv(11, 24).cuboid(-1.5F, 2.0F, -7.25F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(30, 19).cuboid(-5.5F, 2.0F, -2.75F, 11.0F, 2.0F, 4.0F, new Dilation(-0.01F)), ModelTransform.pivot(0.0F, -3.0F, -6.0F));

        ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(8, -1).cuboid(-0.6F, -0.6F, 0.25F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.5F, 2.5F, -7.0F, -0.0309F, -0.0308F, -0.7849F));

        ModelPartData head_r2 = head.addChild("head_r2", ModelPartBuilder.create().uv(8, -1).cuboid(-0.4F, -0.6F, 0.25F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, 2.5F, -7.0F, -0.0309F, 0.0308F, 0.7849F));

        ModelPartData pattern = head.addChild("pattern", ModelPartBuilder.create().uv(0, 33).cuboid(-3.0F, -10.5F, -8.25F, 6.0F, 6.0F, 7.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F, 7.0F, 1.5F));

        ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(26, 40).cuboid(-5.0F, -0.5F, -4.0F, 10.0F, 2.0F, 4.0F, new Dilation(-0.01F)), ModelTransform.pivot(0.0F, 2.5F, -2.75F));

        ModelPartData eyes = head.addChild("eyes", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -5.95F));

        ModelPartData eye_right = eyes.addChild("eye_right", ModelPartBuilder.create().uv(0, 61).cuboid(-0.985F, -1.5F, -0.985F, 3.0F, 3.0F, 2.0F, new Dilation(0.01F)), ModelTransform.pivot(-4.515F, 0.0F, 0.185F));

        ModelPartData pupil_right = eye_right.addChild("pupil_right", ModelPartBuilder.create().uv(0, 1).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.02F)), ModelTransform.pivot(1.015F, 0.25F, -0.985F));

        ModelPartData eyelid_right = eye_right.addChild("eyelid_right", ModelPartBuilder.create().uv(31, 67).cuboid(-0.985F, -1.5F, -0.985F, 3.0F, 3.0F, 2.0F, new Dilation(0.03F)), ModelTransform.pivot(0.1F, 0.0F, 0.1F));

        ModelPartData eye_left = eyes.addChild("eye_left", ModelPartBuilder.create().uv(10, 61).cuboid(-2.015F, -1.5F, -0.985F, 3.0F, 3.0F, 2.0F, new Dilation(0.01F)), ModelTransform.pivot(4.515F, 0.0F, 0.185F));

        ModelPartData pupil_left = eye_left.addChild("pupil_left", ModelPartBuilder.create().uv(0, 3).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.02F)), ModelTransform.pivot(-1.015F, 0.25F, -0.985F));

        ModelPartData eyelid_left = eye_left.addChild("eyelid_left", ModelPartBuilder.create().uv(31, 72).cuboid(-2.015F, -1.5F, -0.985F, 3.0F, 3.0F, 2.0F, new Dilation(0.03F)), ModelTransform.pivot(-0.1F, 0.0F, 0.1F));

        ModelPartData ears = head.addChild("ears", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.5F, -3.25F));

        ModelPartData ear_right = ears.addChild("ear_right", ModelPartBuilder.create().uv(12, 71).cuboid(-2.75F, -2.875F, -1.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 0.875F, 0.75F, 0.0F, 0.2182F, -0.3054F));

        ModelPartData ear_left = ears.addChild("ear_left", ModelPartBuilder.create().uv(12, 67).cuboid(-1.25F, -2.875F, -1.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 0.875F, 0.75F, 0.0F, -0.2182F, 0.3054F));

        ModelPartData leg_front_right = body.addChild("leg_front_right", ModelPartBuilder.create().uv(16, 53).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.25F, 1.0F, -3.5F));

        ModelPartData knee_front_right = leg_front_right.addChild("knee_front_right", ModelPartBuilder.create().uv(64, 39).cuboid(0.0F, 0.0F, -4.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.01F))
                .uv(8, 9).cuboid(2.0F, 2.0F, -4.75F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 2.0F, 2.0F));

        ModelPartData leg_front_right_r1 = knee_front_right.addChild("leg_front_right_r1", ModelPartBuilder.create().uv(9, 3).cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.25F, 2.5F, -4.0F, 0.0F, -0.2618F, 0.0F));

        ModelPartData leg_front_right_r2 = knee_front_right.addChild("leg_front_right_r2", ModelPartBuilder.create().uv(30, 18).cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.75F, 2.5F, -4.0F, 0.0F, 0.2618F, 0.0F));

        ModelPartData leg_front_left = body.addChild("leg_front_left", ModelPartBuilder.create().uv(0, 53).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.25F, 1.0F, -3.5F));

        ModelPartData knee_front_left = leg_front_left.addChild("knee_front_left", ModelPartBuilder.create().uv(28, 60).cuboid(-4.0F, 0.0F, -4.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.01F))
                .uv(8, 6).cuboid(-2.0F, 2.0F, -4.75F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 2.0F, 2.0F));

        ModelPartData leg_front_left_r1 = knee_front_left.addChild("leg_front_left_r1", ModelPartBuilder.create().uv(8, 7).cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.75F, 2.5F, -4.0F, 0.0F, -0.2618F, 0.0F));

        ModelPartData leg_front_left_r2 = knee_front_left.addChild("leg_front_left_r2", ModelPartBuilder.create().uv(8, 8).cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.25F, 2.5F, -4.0F, 0.0F, 0.2618F, 0.0F));

        ModelPartData leg_back_right = body.addChild("leg_back_right", ModelPartBuilder.create().uv(52, 48).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.25F, 1.0F, 3.5F));

        ModelPartData knee_back_right = leg_back_right.addChild("knee_back_right", ModelPartBuilder.create().uv(58, 8).cuboid(0.0F, 0.0F, 0.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.01F))
                .uv(8, 4).cuboid(2.0F, 2.0F, -0.75F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 2.0F, -2.0F));

        ModelPartData leg_front_right_r3 = knee_back_right.addChild("leg_front_right_r3", ModelPartBuilder.create().uv(8, 2).cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.75F, 2.5F, 0.0F, 0.0F, 0.2618F, 0.0F));

        ModelPartData leg_front_right_r4 = knee_back_right.addChild("leg_front_right_r4", ModelPartBuilder.create().uv(8, 5).cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.25F, 2.5F, 0.0F, 0.0F, -0.2618F, 0.0F));

        ModelPartData leg_back_left = body.addChild("leg_back_left", ModelPartBuilder.create().uv(36, 52).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.25F, 1.0F, 3.5F));

        ModelPartData knee_back_left = leg_back_left.addChild("knee_back_left", ModelPartBuilder.create().uv(59, 0).cuboid(-4.0F, 0.0F, 0.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.01F))
                .uv(8, 0).cuboid(-2.0F, 2.0F, -0.75F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 2.0F, -2.0F));

        ModelPartData leg_front_left_r3 = knee_back_left.addChild("leg_front_left_r3", ModelPartBuilder.create().uv(7, 3).cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.25F, 2.5F, 0.0F, 0.0F, 0.2618F, 0.0F));

        ModelPartData leg_front_left_r4 = knee_back_left.addChild("leg_front_left_r4", ModelPartBuilder.create().uv(8, 1).cuboid(0.0F, -0.5F, -0.65F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.75F, 2.5F, 0.0F, 0.0F, -0.2618F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(IvysaurEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(IvysaurAnimations.IVYSAUR_GROUND_WALK, limbSwing, limbSwingAmount, 4f, 8f);
        this.updateAnimation(entity.idleAnimationState, IvysaurAnimations.IVYSAUR_GROUND_IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0f, 10.0f);
        headPitch = MathHelper.clamp(headPitch, -25f, 25);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        ivysaur.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return ivysaur;
    }
}