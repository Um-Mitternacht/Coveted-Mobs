package com.covetedmobs.client.model.entity.herps;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * blindworm - cybercat5555
 * Created using Tabula 5.1.0
 */
public class ModelBlindworm extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer bodyB;
    public ModelRenderer neck00;
    public ModelRenderer tail00;
    public ModelRenderer neck01;
    public ModelRenderer head;
    public ModelRenderer snout;
    public ModelRenderer lowerJaw;
    public ModelRenderer leftEye;
    public ModelRenderer rightEye;
    public ModelRenderer headB;
    public ModelRenderer tail01;
    public ModelRenderer tail01b;
    public ModelRenderer tail02;
    public ModelRenderer tail03;

    public ModelBlindworm() {
        this.textureWidth = 64;
        this.textureHeight = 65;
        this.lowerJaw = new ModelRenderer(this, 15, 8);
        this.lowerJaw.setRotationPoint(0.0F, 0.9F, 1.0F);
        this.lowerJaw.addBox(-2.0F, -0.5F, -4.8F, 4, 1, 5, 0.0F);
        this.setRotateAngle(lowerJaw, -0.08726646259971647F, 0.0F, 0.0F);
        this.leftEye = new ModelRenderer(this, 32, 0);
        this.leftEye.setRotationPoint(1.4F, -0.2F, 0.0F);
        this.leftEye.addBox(-0.5F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(leftEye, 0.0F, 0.12217304763960307F, -0.19198621771937624F);
        this.body = new ModelRenderer(this, 25, 15);
        this.body.setRotationPoint(0.0F, 22.5F, 1.9F);
        this.body.addBox(-1.8F, -1.49F, -6.0F, 4, 3, 9, 0.0F);
        this.tail00 = new ModelRenderer(this, 0, 33);
        this.tail00.setRotationPoint(0.0F, 0.0F, 3.4F);
        this.tail00.addBox(-2.0F, -1.49F, -0.5F, 4, 3, 7, 0.0F);
        this.tail03 = new ModelRenderer(this, 43, 54);
        this.tail03.setRotationPoint(0.0F, 0.5F, 5.9F);
        this.tail03.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 6, 0.0F);
        this.tail01b = new ModelRenderer(this, 22, 55);
        this.tail01b.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.tail01b.addBox(-1.5F, 0.0F, -1.0F, 3, 1, 7, 0.0F);
        this.neck01 = new ModelRenderer(this, 0, 24);
        this.neck01.setRotationPoint(0.0F, 0.0F, -3.6F);
        this.neck01.addBox(-2.0F, -1.5F, -3.2F, 4, 3, 3, 0.0F);
        this.snout = new ModelRenderer(this, 0, 10);
        this.snout.setRotationPoint(0.0F, -0.8F, -1.9F);
        this.snout.addBox(-2.0F, -1.0F, -2.2F, 4, 2, 2, 0.0F);
        this.setRotateAngle(snout, 0.08726646259971647F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.3F, -3.9F);
        this.head.addBox(-1.6F, -2.0F, -2.5F, 4, 3, 5, 0.0F);
        this.setRotateAngle(head, 0.13962634015954636F, 0.0F, 0.0F);
        this.neck00 = new ModelRenderer(this, 0, 16);
        this.neck00.setRotationPoint(0.0F, 0.0F, -5.9F);
        this.neck00.addBox(-2.0F, -1.5F, -3.9F, 4, 3, 4, 0.0F);
        this.bodyB = new ModelRenderer(this, 25, 28);
        this.bodyB.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyB.addBox(-2.2F, -1.49F, -6.0F, 1, 3, 9, 0.0F);
        this.tail02 = new ModelRenderer(this, 41, 40);
        this.tail02.setRotationPoint(0.0F, 0.5F, 6.7F);
        this.tail02.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 7, 0.0F);
        this.tail01 = new ModelRenderer(this, 23, 45);
        this.tail01.setRotationPoint(0.0F, 0.0F, 5.9F);
        this.tail01.addBox(-1.5F, -1.1F, -1.0F, 3, 2, 7, 0.0F);
        this.rightEye = new ModelRenderer(this, 32, 0);
        this.rightEye.mirror = true;
        this.rightEye.setRotationPoint(-1.3F, -0.2F, 0.0F);
        this.rightEye.addBox(-1.5F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(rightEye, 0.0F, -0.12217304763960307F, 0.19198621771937624F);
        this.headB = new ModelRenderer(this, 19, 0);
        this.headB.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headB.addBox(-2.3F, -2.0F, -2.5F, 1, 3, 5, 0.0F);
        this.head.addChild(this.lowerJaw);
        this.head.addChild(this.leftEye);
        this.body.addChild(this.tail00);
        this.tail02.addChild(this.tail03);
        this.tail01.addChild(this.tail01b);
        this.neck00.addChild(this.neck01);
        this.head.addChild(this.snout);
        this.neck01.addChild(this.head);
        this.body.addChild(this.neck00);
        this.body.addChild(this.bodyB);
        this.tail01.addChild(this.tail02);
        this.tail00.addChild(this.tail01);
        this.head.addChild(this.rightEye);
        this.head.addChild(this.headB);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        EntityBlindworm blindworm = (EntityBlindworm) entity;
        
        float time = ((entity.ticksExisted + Minecraft.getMinecraft().getRenderPartialTicks()) * 0.4F);
        float angle = (float) (0.40F * ((blindworm.motionX + blindworm.motionZ) * 50));
        this.neck00.rotateAngleY = (float) (Math.toRadians(15) + angle * MathHelper.sin(time - 1));
        this.neck01.rotateAngleY = (float) (Math.toRadians(-15) + angle * MathHelper.sin(time + 1));
        this.neck00.rotateAngleX = (float) Math.toRadians(headPitch);
        this.neck01.rotateAngleX = 0F;
        this.body.rotateAngleY = (float) (angle * MathHelper.sin(time + 10) + Math.toRadians(netHeadYaw));
        this.tail00.rotateAngleY = (float) (Math.toRadians(15) + angle * MathHelper.sin(time + 0));
        this.tail01.rotateAngleY = (float) (Math.toRadians(15) + angle * MathHelper.sin(time + 2));
        this.tail02.rotateAngleY = (float) (Math.toRadians(-30) + angle * MathHelper.sin(time + 3));
        this.tail03.rotateAngleY = (float) (Math.toRadians(-15) + angle * MathHelper.sin(time + 1));
    }
    
    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
