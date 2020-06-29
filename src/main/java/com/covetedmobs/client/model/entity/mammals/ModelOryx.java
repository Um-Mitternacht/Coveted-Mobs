package com.covetedmobs.client.model.entity.mammals;

import com.covetedmobs.common.entity.living.mammals.EntityOryx;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * Oryx - The_Indominator
 * Created using Tabula 7.0.1
 */
public class ModelOryx extends ModelBase {
    public double[] modelScale = new double[]{2.0D, 2.0D, 2.0D};
    public ModelRenderer Torso;
    public ModelRenderer Shoulder;
    public ModelRenderer Bum;
    public ModelRenderer TorsoBaby;
    public ModelRenderer Neck;
    public ModelRenderer LeftLegFront01;
    public ModelRenderer RightLegFront01;
    public ModelRenderer ShoulderBaby;
    public ModelRenderer DewlapAdult;
    public ModelRenderer Head;
    public ModelRenderer LeftFlapper;
    public ModelRenderer Snout01;
    public ModelRenderer RightFlapper;
    public ModelRenderer LeftScimitar01;
    public ModelRenderer RightScimitar01;
    public ModelRenderer Snout02;
    public ModelRenderer Mouth;
    public ModelRenderer LeftScimitar02;
    public ModelRenderer LeftScimitar03;
    public ModelRenderer RightScimitar02;
    public ModelRenderer RightScimitar03;
    public ModelRenderer LeftLegFront02;
    public ModelRenderer LeftLegFront03;
    public ModelRenderer LeftFootFront;
    public ModelRenderer RightLegFront02;
    public ModelRenderer RightLegFront03;
    public ModelRenderer RightFootFront;
    public ModelRenderer LeftLegBack01;
    public ModelRenderer RightLegBack01;
    public ModelRenderer Tail01;
    public ModelRenderer BumBaby;
    public ModelRenderer LeftLegBack02;
    public ModelRenderer LeftLegBack03;
    public ModelRenderer LeftFootBack;
    public ModelRenderer RightLegBack02;
    public ModelRenderer RightLegBack03;
    public ModelRenderer RightFootBack;
    public ModelRenderer Tail02;
    public ModelRenderer Tail03;
    public ModelRenderer Tail04;

    public ModelOryx() {
        this.textureWidth = 100;
        this.textureHeight = 75;
        this.RightFootFront = new ModelRenderer(this, 70, 16);
        this.RightFootFront.mirror = true;
        this.RightFootFront.setRotationPoint(0.0F, 5.0F, 1.0F);
        this.RightFootFront.addBox(-1.1F, -1.0F, -1.7F, 2, 2, 2, 0.0F);
        this.RightLegFront01 = new ModelRenderer(this, 0, 20);
        this.RightLegFront01.mirror = true;
        this.RightLegFront01.setRotationPoint(-2.5F, 3.2F, -3.8F);
        this.RightLegFront01.addBox(-1.5F, -1.0F, -2.0F, 3, 7, 4, 0.0F);
        this.setRotateAngle(RightLegFront01, -0.17453292519943295F, 0.0F, 0.0F);
        this.TorsoBaby = new ModelRenderer(this, 29, 41);
        this.TorsoBaby.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.TorsoBaby.addBox(-2.5F, -4.5F, -4.5F, 5, 7, 10, 0.0F);
        this.LeftScimitar01 = new ModelRenderer(this, 65, 42);
        this.LeftScimitar01.setRotationPoint(1.5F, -1.9F, 2.0F);
        this.LeftScimitar01.addBox(-1.0F, -2.0F, -1.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(LeftScimitar01, -1.1838568316277536F, 0.091106186954104F, 0.0F);
        this.LeftFootFront = new ModelRenderer(this, 70, 16);
        this.LeftFootFront.setRotationPoint(0.0F, 5.0F, 1.0F);
        this.LeftFootFront.addBox(-0.9F, -1.0F, -1.7F, 2, 2, 2, 0.0F);
        this.RightLegBack02 = new ModelRenderer(this, 47, 32);
        this.RightLegBack02.mirror = true;
        this.RightLegBack02.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.RightLegBack02.addBox(-1.4F, -1.0F, -1.5F, 3, 6, 3, 0.0F);
        this.setRotateAngle(RightLegBack02, 0.5410520681182421F, 0.0F, 0.0F);
        this.BumBaby = new ModelRenderer(this, 59, 47);
        this.BumBaby.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BumBaby.addBox(-3.0F, -0.5F, 0.0F, 6, 7, 7, 0.0F);
        this.DewlapAdult = new ModelRenderer(this, 34, 58);
        this.DewlapAdult.setRotationPoint(0.0F, 1.0F, -5.5F);
        this.DewlapAdult.addBox(-1.0F, -1.0F, -6.5F, 2, 3, 14, 0.0F);
        this.setRotateAngle(DewlapAdult, -0.27314402793711257F, 0.0F, 0.0F);
        this.LeftLegFront02 = new ModelRenderer(this, 0, 31);
        this.LeftLegFront02.setRotationPoint(0.2F, 6.0F, 0.0F);
        this.LeftLegFront02.addBox(-0.99F, -1.0F, -1.5F, 2, 6, 3, 0.0F);
        this.setRotateAngle(LeftLegFront02, -0.05235987755982988F, 0.0F, 0.0F);
        this.RightLegFront03 = new ModelRenderer(this, 0, 40);
        this.RightLegFront03.mirror = true;
        this.RightLegFront03.setRotationPoint(0.0F, 5.0F, -1.0F);
        this.RightLegFront03.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(RightLegFront03, 0.08726646259971647F, 0.0F, 0.0F);
        this.Shoulder = new ModelRenderer(this, 30, 0);
        this.Shoulder.setRotationPoint(0.0F, -4.5F, -3.5F);
        this.Shoulder.addBox(-3.0F, -0.5F, -7.0F, 6, 10, 8, 0.0F);
        this.setRotateAngle(Shoulder, 0.22759093446006054F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 84, 16);
        this.Head.setRotationPoint(0.01F, -2.0F, -12.0F);
        this.Head.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(Head, 1.0927506446736497F, 0.0F, 0.0F);
        this.Torso = new ModelRenderer(this, 0, 0);
        this.Torso.setRotationPoint(0.0F, 16.5F, 0.0F);
        this.Torso.addBox(-2.5F, -4.5F, -4.5F, 5, 9, 10, 0.0F);
        this.setRotateAngle(Torso, -0.091106186954104F, 0.0F, 0.0F);
        this.RightFootBack = new ModelRenderer(this, 70, 16);
        this.RightFootBack.mirror = true;
        this.RightFootBack.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.RightFootBack.addBox(-1.1F, -1.0F, -1.7F, 2, 2, 2, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 57);
        this.Neck.setRotationPoint(0.0F, 4.0F, -4.0F);
        this.Neck.addBox(-2.0F, -4.0F, -12.0F, 4, 5, 13, 0.0F);
        this.setRotateAngle(Neck, -0.36425021489121656F, -0.004014257279586958F, 0.0F);
        this.ShoulderBaby = new ModelRenderer(this, 1, 41);
        this.ShoulderBaby.setRotationPoint(0.0F, 0.3F, 0.0F);
        this.ShoulderBaby.addBox(-3.0F, -0.5F, -7.0F, 6, 8, 8, 0.0F);
        this.setRotateAngle(ShoulderBaby, -0.27314402793711257F, 0.0F, 0.0F);
        this.Tail04 = new ModelRenderer(this, 30, 40);
        this.Tail04.setRotationPoint(0.0F, 2.5F, 0.0F);
        this.Tail04.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.Bum = new ModelRenderer(this, 23, 18);
        this.Bum.setRotationPoint(0.0F, -4.5F, 4.0F);
        this.Bum.addBox(-3.0F, -0.5F, 0.0F, 6, 8, 7, 0.0F);
        this.setRotateAngle(Bum, -0.22759093446006054F, 0.0F, 0.0F);
        this.Tail03 = new ModelRenderer(this, 34, 34);
        this.Tail03.setRotationPoint(0.0F, 2.5F, 0.0F);
        this.Tail03.addBox(-1.5F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
        this.Snout01 = new ModelRenderer(this, 84, 26);
        this.Snout01.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.Snout01.addBox(-1.5F, -1.0F, -4.0F, 3, 2, 5, 0.0F);
        this.setRotateAngle(Snout01, -0.18203784098300857F, 0.0F, 0.0F);
        this.RightScimitar02 = new ModelRenderer(this, 61, 41);
        this.RightScimitar02.mirror = true;
        this.RightScimitar02.setRotationPoint(0.5F, -2.0F, -1.0F);
        this.RightScimitar02.addBox(-0.5F, -5.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(RightScimitar02, -0.27314402793711257F, -0.045553093477052F, -0.045553093477052F);
        this.RightScimitar01 = new ModelRenderer(this, 65, 42);
        this.RightScimitar01.mirror = true;
        this.RightScimitar01.setRotationPoint(-1.5F, -1.9F, 2.0F);
        this.RightScimitar01.addBox(0.0F, -2.0F, -1.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(RightScimitar01, -1.1838568316277536F, -0.091106186954104F, 0.0F);
        this.LeftFootBack = new ModelRenderer(this, 70, 16);
        this.LeftFootBack.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.LeftFootBack.addBox(-0.9F, -1.0F, -1.7F, 2, 2, 2, 0.0F);
        this.RightLegBack03 = new ModelRenderer(this, 59, 32);
        this.RightLegBack03.mirror = true;
        this.RightLegBack03.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.RightLegBack03.addBox(-1.0F, -1.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(RightLegBack03, -0.3141592653589793F, 0.0F, 0.0F);
        this.Tail01 = new ModelRenderer(this, 14, 36);
        this.Tail01.setRotationPoint(0.0F, 1.8F, 7.0F);
        this.Tail01.addBox(-1.0F, -1.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(Tail01, 0.7330382858376184F, 0.0F, 0.0F);
        this.Tail02 = new ModelRenderer(this, 22, 34);
        this.Tail02.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Tail02.addBox(-1.5F, -0.5F, -1.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(Tail02, -0.36425021489121656F, 0.0F, 0.0F);
        this.LeftLegFront01 = new ModelRenderer(this, 0, 20);
        this.LeftLegFront01.setRotationPoint(2.5F, 3.2F, -3.8F);
        this.LeftLegFront01.addBox(-1.5F, -1.0F, -2.0F, 3, 7, 4, 0.0F);
        this.setRotateAngle(LeftLegFront01, -0.17453292519943295F, 0.0F, 0.0F);
        this.LeftScimitar02 = new ModelRenderer(this, 61, 47);
        this.LeftScimitar02.setRotationPoint(-0.5F, -2.0F, -1.0F);
        this.LeftScimitar02.addBox(-0.5F, -5.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(LeftScimitar02, -0.27314402793711257F, 0.045553093477052F, 0.045553093477052F);
        this.LeftLegBack01 = new ModelRenderer(this, 50, 19);
        this.LeftLegBack01.setRotationPoint(2.5F, 1.5F, 3.3F);
        this.LeftLegBack01.addBox(-1.5F, -1.0F, -2.0F, 3, 8, 5, 0.0F);
        this.setRotateAngle(LeftLegBack01, 0.08726646259971647F, 0.0F, 0.0F);
        this.RightFlapper = new ModelRenderer(this, 90, 24);
        this.RightFlapper.mirror = true;
        this.RightFlapper.setRotationPoint(-1.7F, -1.7F, 1.5F);
        this.RightFlapper.addBox(-1.5F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(RightFlapper, 0.27314402793711257F, 1.0016444577195458F, 0.40980330836826856F);
        this.RightLegFront02 = new ModelRenderer(this, 0, 31);
        this.RightLegFront02.mirror = true;
        this.RightLegFront02.setRotationPoint(-0.2F, 6.0F, 0.0F);
        this.RightLegFront02.addBox(-1.01F, -1.0F, -1.5F, 2, 6, 3, 0.0F);
        this.setRotateAngle(RightLegFront02, -0.05235987755982988F, 0.0F, 0.0F);
        this.LeftFlapper = new ModelRenderer(this, 90, 24);
        this.LeftFlapper.setRotationPoint(1.7F, -1.7F, 1.5F);
        this.LeftFlapper.addBox(-0.5F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(LeftFlapper, 0.27314402793711257F, -1.0016444577195458F, -0.40980330836826856F);
        this.LeftScimitar03 = new ModelRenderer(this, 57, 41);
        this.LeftScimitar03.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.LeftScimitar03.addBox(-0.5F, -6.0F, 0.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(LeftScimitar03, -0.36425021489121656F, 0.045553093477052F, 0.045553093477052F);
        this.Mouth = new ModelRenderer(this, 70, 37);
        this.Mouth.setRotationPoint(0.0F, 0.7F, -1.5F);
        this.Mouth.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 6, 0.0F);
        this.setRotateAngle(Mouth, -0.091106186954104F, 0.0F, 0.0F);
        this.RightLegBack01 = new ModelRenderer(this, 50, 19);
        this.RightLegBack01.mirror = true;
        this.RightLegBack01.setRotationPoint(-2.5F, 1.5F, 3.3F);
        this.RightLegBack01.addBox(-1.5F, -1.0F, -2.0F, 3, 8, 5, 0.0F);
        this.setRotateAngle(RightLegBack01, 0.08726646259971647F, 0.0F, 0.0F);
        this.RightScimitar03 = new ModelRenderer(this, 57, 41);
        this.RightScimitar03.mirror = true;
        this.RightScimitar03.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.RightScimitar03.addBox(-0.5F, -6.0F, 0.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(RightScimitar03, -0.36425021489121656F, -0.045553093477052F, -0.045553093477052F);
        this.LeftLegBack02 = new ModelRenderer(this, 47, 32);
        this.LeftLegBack02.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.LeftLegBack02.addBox(-1.6F, -1.0F, -1.5F, 3, 6, 3, 0.0F);
        this.setRotateAngle(LeftLegBack02, 0.5410520681182421F, 0.0F, 0.0F);
        this.LeftLegBack03 = new ModelRenderer(this, 59, 32);
        this.LeftLegBack03.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.LeftLegBack03.addBox(-1.0F, -1.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(LeftLegBack03, -0.3141592653589793F, 0.0F, 0.0F);
        this.LeftLegFront03 = new ModelRenderer(this, 0, 40);
        this.LeftLegFront03.setRotationPoint(0.0F, 5.0F, -1.0F);
        this.LeftLegFront03.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(LeftLegFront03, 0.08726646259971647F, 0.0F, 0.0F);
        this.Snout02 = new ModelRenderer(this, 80, 33);
        this.Snout02.setRotationPoint(0.0F, -1.0F, -4.0F);
        this.Snout02.addBox(-1.0F, -0.5F, -0.5F, 2, 2, 8, 0.0F);
        this.setRotateAngle(Snout02, 0.136659280431156F, 0.0F, 0.0F);
        this.RightLegFront03.addChild(this.RightFootFront);
        this.Shoulder.addChild(this.RightLegFront01);
        this.Torso.addChild(this.TorsoBaby);
        this.Head.addChild(this.LeftScimitar01);
        this.LeftLegFront03.addChild(this.LeftFootFront);
        this.RightLegBack01.addChild(this.RightLegBack02);
        this.Bum.addChild(this.BumBaby);
        this.Neck.addChild(this.DewlapAdult);
        this.LeftLegFront01.addChild(this.LeftLegFront02);
        this.RightLegFront02.addChild(this.RightLegFront03);
        this.Torso.addChild(this.Shoulder);
        this.Neck.addChild(this.Head);
        this.RightLegBack03.addChild(this.RightFootBack);
        this.Shoulder.addChild(this.Neck);
        this.Shoulder.addChild(this.ShoulderBaby);
        this.Tail02.addChild(this.Tail04);
        this.Torso.addChild(this.Bum);
        this.Tail02.addChild(this.Tail03);
        this.Head.addChild(this.Snout01);
        this.RightScimitar01.addChild(this.RightScimitar02);
        this.Head.addChild(this.RightScimitar01);
        this.LeftLegBack03.addChild(this.LeftFootBack);
        this.RightLegBack02.addChild(this.RightLegBack03);
        this.Bum.addChild(this.Tail01);
        this.Tail01.addChild(this.Tail02);
        this.Shoulder.addChild(this.LeftLegFront01);
        this.LeftScimitar01.addChild(this.LeftScimitar02);
        this.Bum.addChild(this.LeftLegBack01);
        this.Head.addChild(this.RightFlapper);
        this.RightLegFront01.addChild(this.RightLegFront02);
        this.Head.addChild(this.LeftFlapper);
        this.LeftScimitar02.addChild(this.LeftScimitar03);
        this.Snout01.addChild(this.Mouth);
        this.Bum.addChild(this.RightLegBack01);
        this.RightScimitar02.addChild(this.RightScimitar03);
        this.LeftLegBack01.addChild(this.LeftLegBack02);
        this.LeftLegBack02.addChild(this.LeftLegBack03);
        this.LeftLegFront02.addChild(this.LeftLegFront03);
        this.Snout01.addChild(this.Snout02);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(1D / modelScale[0], 1D / modelScale[1], 1D / modelScale[2]);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Torso.offsetX, this.Torso.offsetY, this.Torso.offsetZ);
        GlStateManager.translate(this.Torso.rotationPointX * f5, this.Torso.rotationPointY * f5, this.Torso.rotationPointZ * f5);
        GlStateManager.scale(2.0D, 2.0D, 2.0D);
        GlStateManager.translate(-this.Torso.offsetX, -this.Torso.offsetY, -this.Torso.offsetZ);
        GlStateManager.translate(-this.Torso.rotationPointX * f5, -this.Torso.rotationPointY * f5, -this.Torso.rotationPointZ * f5);
        this.Torso.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.popMatrix();
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        boolean flag = entity instanceof EntityLivingBase && ((EntityLivingBase) entity).getTicksElytraFlying() > 4;
        float swingModifier = 0.3f;
        float add = entity.getUniqueID().hashCode() * 0.003F;
        this.Bum.offsetY = 0f;
        this.LeftLegFront01.rotateAngleZ = 0f;
        this.RightLegFront01.rotateAngleZ = 0f;
        this.RightLegBack01.rotateAngleZ = 0f;
        this.LeftLegBack01.rotateAngleZ = 0f;
        this.LeftLegFront01.rotateAngleX = MathHelper.sin(limbSwing * 0.8665F + (float) Math.PI) * swingModifier * limbSwingAmount + -0.17453292519943295F;
        this.RightLegFront01.rotateAngleX = MathHelper.cos(limbSwing * 0.8665F) * swingModifier * limbSwingAmount + -0.17453292519943295F;
        this.RightLegBack01.rotateAngleX = MathHelper.sin(limbSwing * 0.8665F) * swingModifier * limbSwingAmount + 0.08726646259971647F;
        this.LeftLegBack01.rotateAngleX = MathHelper.cos(limbSwing * 0.8665F + (float) Math.PI) * swingModifier * limbSwingAmount + 0.08726646259971647F;

        this.Neck.rotateAngleY = netHeadYaw * 0.015453292F;
        if (flag) {
            this.Neck.rotateAngleX = -((float) Math.PI / 4F);
        } else {
            this.Neck.rotateAngleX = headPitch * 0.015453292F;
        }

        if (entity instanceof EntityOryx) {
            EntityOryx oryx = (EntityOryx) entity;
            {
                float mul = 0.1F;
                float div = 40F;
                this.Tail01.rotateAngleZ = (float) Math.cos(ageInTicks * (mul + 0.06F) + add) / div + 0F;
            }
            if (oryx.isAttackingFromServer()) {
                this.Neck.rotateAngleX = - -0.41869712141416456F;
            }
            if (!oryx.isAttackingFromServer()) {
                float grazeTime = oryx.getGrazeTime();
                if (grazeTime <= 80) {
                    this.Neck.rotateAngleX = - -0.91869712141416456F;
                    this.Head.rotateAngleX = - -0.25869712141416456F;
                } else {
                    this.Neck.rotateAngleX = -0.36425021489121656F;
                    this.Head.rotateAngleX = 1.0927506446736497F;
                }
            }
        }
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