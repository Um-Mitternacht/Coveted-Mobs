package com.covetedmobs.client.model.entity.mammals;

import com.covetedmobs.common.entity.living.mammals.EntityElephant;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * Elephant - Batman
 * Created using Tabula 7.0.1
 */
public class ModelElephant extends ModelBase {
	public ModelRenderer butt;
	public ModelRenderer front;
	public ModelRenderer lLeg1;
	public ModelRenderer rLeg1;
	public ModelRenderer tail;
	public ModelRenderer neck;
	public ModelRenderer lArm1;
	public ModelRenderer rArm1;
	public ModelRenderer howdahStraps;
	public ModelRenderer head;
	public ModelRenderer topJaw;
	public ModelRenderer lowerJaw;
	public ModelRenderer earLeft1_01;
	public ModelRenderer earRight_01;
	public ModelRenderer trunk00;
	public ModelRenderer africanTuskL_01;
	public ModelRenderer africanTuskR_01;
	public ModelRenderer trunk01;
	public ModelRenderer trunk02;
	public ModelRenderer trunk03;
	public ModelRenderer trunk04;
	public ModelRenderer trunk05;
	public ModelRenderer africanTuskL_02;
	public ModelRenderer africanTuskL_03;
	public ModelRenderer africanTuskR_02;
	public ModelRenderer africanTuskR_03;
	public ModelRenderer earLeft_flap;
	public ModelRenderer earLeft_02;
	public ModelRenderer earRight_flap;
	public ModelRenderer earRight_02;
	public ModelRenderer lArm2;
	public ModelRenderer lArm3;
	public ModelRenderer lHand;
	public ModelRenderer rArm2;
	public ModelRenderer rArm3;
	public ModelRenderer rHand;
	public ModelRenderer howdahPlatform;
	public ModelRenderer chestLeft;
	public ModelRenderer chestRight;
	public ModelRenderer howdahLegs;
	public ModelRenderer howdahCushion1;
	public ModelRenderer howdahCushion2;
	public ModelRenderer howdahTop;
	public ModelRenderer howdahTopSides;
	public ModelRenderer lLeg2;
	public ModelRenderer lLeg3;
	public ModelRenderer lFoot;
	public ModelRenderer rLeg2;
	public ModelRenderer rLeg3;
	public ModelRenderer rFoot;
	public ModelRenderer tail2;
	public ModelRenderer tail3;
	public ModelRenderer tailFloof;
	
	public ModelElephant() {
		this.textureWidth = 160;
		this.textureHeight = 200;
		this.rLeg1 = new ModelRenderer(this, 0, 134);
		this.rLeg1.setRotationPoint(-4.1F, 3.0F, 6.0F);
		this.rLeg1.addBox(-2.5F, 0.0F, 0.0F, 5, 9, 5, 0.0F);
		this.setRotateAngle(rLeg1, -0.045553093477052F, 0.0F, 0.0F);
		this.lLeg1 = new ModelRenderer(this, 0, 134);
		this.lLeg1.setRotationPoint(4.1F, 3.0F, 6.0F);
		this.lLeg1.addBox(-2.5F, 0.0F, 0.0F, 5, 9, 5, 0.0F);
		this.setRotateAngle(lLeg1, -0.045553093477052F, 0.0F, 0.0F);
		this.africanTuskL_02 = new ModelRenderer(this, 12, 107);
		this.africanTuskL_02.setRotationPoint(0.0F, 4.7F, 0.0F);
		this.africanTuskL_02.addBox(-0.5F, 0.0F, -1.0F, 1, 4, 2, 0.0F);
		this.setRotateAngle(africanTuskL_02, 0.0F, 0.0F, 0.27314402793711257F);
		this.rFoot = new ModelRenderer(this, 22, 146);
		this.rFoot.setRotationPoint(0.0F, 3.1F, -1.3F);
		this.rFoot.addBox(-2.0F, 0.0F, -3.0F, 4, 2, 4, 0.0F);
		this.setRotateAngle(rFoot, 0.045553093477052F, 0.0F, 0.0F);
		this.lHand = new ModelRenderer(this, 40, 111);
		this.lHand.setRotationPoint(0.0F, 3.5F, 2.7F);
		this.lHand.addBox(-2.0F, 0.0F, -3.0F, 4, 2, 4, 0.0F);
		this.earLeft1_01 = new ModelRenderer(this, 0, 95);
		this.earLeft1_01.setRotationPoint(3.3F, -1.5F, -1.0F);
		this.earLeft1_01.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 7, 0.0F);
		this.setRotateAngle(earLeft1_01, -1.0471975511965976F, 0.0F, -0.6373942428283291F);
		this.africanTuskL_01 = new ModelRenderer(this, 0, 107);
		this.africanTuskL_01.setRotationPoint(3.0F, 0.0F, 0.0F);
		this.africanTuskL_01.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
		this.setRotateAngle(africanTuskL_01, -1.5481070465189704F, -0.27314402793711257F, 0.0F);
		this.lLeg2 = new ModelRenderer(this, 21, 134);
		this.lLeg2.setRotationPoint(0.0F, 9.0F, 0.0F);
		this.lLeg2.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 4, 0.0F);
		this.setRotateAngle(lLeg2, 0.27314402793711257F, 0.0F, 0.0F);
		this.lArm1 = new ModelRenderer(this, 0, 120);
		this.lArm1.setRotationPoint(4.0F, 5.3F, -10.0F);
		this.lArm1.addBox(-2.5F, 0.0F, -1.5F, 5, 7, 5, 0.0F);
		this.setRotateAngle(lArm1, 0.18203784098300857F, 0.0F, 0.0F);
		this.topJaw = new ModelRenderer(this, 0, 69);
		this.topJaw.setRotationPoint(0.0F, 1.0F, -4.8F);
		this.topJaw.addBox(-3.5F, -2.5F, -4.0F, 7, 4, 4, 0.0F);
		this.setRotateAngle(topJaw, -0.091106186954104F, 0.0F, 0.0F);
		this.earRight_01 = new ModelRenderer(this, 0, 95);
		this.earRight_01.setRotationPoint(-3.3F, -1.5F, -1.0F);
		this.earRight_01.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 7, 0.0F);
		this.setRotateAngle(earRight_01, -1.0471975511965976F, 0.0F, 0.6373942428283291F);
		this.africanTuskR_03 = new ModelRenderer(this, 21, 109);
		this.africanTuskR_03.setRotationPoint(0.0F, 3.5F, 0.0F);
		this.africanTuskR_03.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1, 0.0F);
		this.setRotateAngle(africanTuskR_03, -0.36425021489121656F, 0.0F, -0.18203784098300857F);
		this.rArm2 = new ModelRenderer(this, 22, 120);
		this.rArm2.setRotationPoint(0.0F, 7.0F, 3.5F);
		this.rArm2.addBox(-2.0F, 0.0F, -4.0F, 4, 6, 4, 0.0F);
		this.setRotateAngle(rArm2, -0.36425021489121656F, 0.0F, 0.0F);
		this.tail3 = new ModelRenderer(this, 46, 17);
		this.tail3.setRotationPoint(0.0F, 0.0F, 5.0F);
		this.tail3.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
		this.setRotateAngle(tail3, -0.091106186954104F, 0.0F, 0.0F);
		this.lowerJaw = new ModelRenderer(this, 26, 89);
		this.lowerJaw.setRotationPoint(0.0F, 3.0F, -4.8F);
		this.lowerJaw.addBox(-3.0F, -1.0F, -4.0F, 6, 2, 4, 0.0F);
		this.setRotateAngle(lowerJaw, -0.18203784098300857F, 0.0F, 0.0F);
		this.trunk02 = new ModelRenderer(this, 17, 80);
		this.trunk02.setRotationPoint(0.0F, -0.5F, -3.7F);
		this.trunk02.addBox(-1.5F, -1.5F, -5.0F, 3, 3, 5, 0.0F);
		this.setRotateAngle(trunk02, -0.18203784098300857F, 0.0F, 0.0F);
		this.howdahCushion1 = new ModelRenderer(this, 0, 189);
		this.howdahCushion1.setRotationPoint(-5.1F, -0.2F, -6.9F);
		this.howdahCushion1.addBox(-3.0F, -2.0F, 0.0F, 6, 2, 5, 0.0F);
		this.africanTuskR_01 = new ModelRenderer(this, 0, 107);
		this.africanTuskR_01.setRotationPoint(-3.0F, 0.0F, 0.0F);
		this.africanTuskR_01.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
		this.setRotateAngle(africanTuskR_01, -1.5481070465189704F, 0.27314402793711257F, 0.0F);
		this.africanTuskL_03 = new ModelRenderer(this, 21, 109);
		this.africanTuskL_03.setRotationPoint(0.0F, 3.5F, 0.0F);
		this.africanTuskL_03.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1, 0.0F);
		this.setRotateAngle(africanTuskL_03, -0.36425021489121656F, 0.0F, 0.18203784098300857F);
		this.lFoot = new ModelRenderer(this, 22, 146);
		this.lFoot.setRotationPoint(0.0F, 3.1F, -1.3F);
		this.lFoot.addBox(-2.0F, 0.0F, -3.0F, 4, 2, 4, 0.0F);
		this.setRotateAngle(lFoot, 0.045553093477052F, 0.0F, 0.0F);
		this.butt = new ModelRenderer(this, 0, 0);
		this.butt.setRotationPoint(0.0F, 2.5F, 0.0F);
		this.butt.addBox(-5.0F, -4.0F, 0.0F, 10, 15, 12, 0.0F);
		this.setRotateAngle(butt, -0.045553093477052F, 0.0F, 0.0F);
		this.neck = new ModelRenderer(this, 0, 55);
		this.neck.setRotationPoint(0.0F, 0.0F, -11.5F);
		this.neck.addBox(-3.5F, -2.0F, -5.0F, 7, 8, 5, 0.0F);
		this.setRotateAngle(neck, 0.22759093446006054F, 0.0F, 0.0F);
		this.tail = new ModelRenderer(this, 46, 0);
		this.tail.setRotationPoint(0.0F, -2.0F, 11.5F);
		this.tail.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
		this.setRotateAngle(tail, -1.2292353921796064F, 0.0F, 0.0F);
		this.rArm3 = new ModelRenderer(this, 40, 120);
		this.rArm3.setRotationPoint(0.0F, 5.8F, -4.0F);
		this.rArm3.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
		this.setRotateAngle(rArm3, 0.136659280431156F, 0.0F, 0.0F);
		this.lLeg3 = new ModelRenderer(this, 39, 134);
		this.lLeg3.setRotationPoint(0.0F, 5.0F, 4.0F);
		this.lLeg3.addBox(-1.5F, 0.0F, -4.0F, 3, 4, 4, 0.0F);
		this.setRotateAngle(lLeg3, -0.22759093446006054F, 0.0F, 0.0F);
		this.tailFloof = new ModelRenderer(this, 46, 25);
		this.tailFloof.setRotationPoint(0.0F, 0.5F, 4.7F);
		this.tailFloof.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 4, 0.0F);
		this.front = new ModelRenderer(this, 0, 29);
		this.front.setRotationPoint(0.0F, -1.0F, 0.4F);
		this.front.addBox(-5.5F, -2.0F, -12.0F, 11, 13, 12, 0.0F);
		this.setRotateAngle(front, 0.091106186954104F, 0.0F, 0.0F);
		this.lArm2 = new ModelRenderer(this, 22, 120);
		this.lArm2.setRotationPoint(0.0F, 7.0F, 3.5F);
		this.lArm2.addBox(-2.0F, 0.0F, -4.0F, 4, 6, 4, 0.0F);
		this.setRotateAngle(lArm2, -0.36425021489121656F, 0.0F, 0.0F);
		this.trunk01 = new ModelRenderer(this, 0, 78);
		this.trunk01.setRotationPoint(0.0F, 0.0F, -4.0F);
		this.trunk01.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 4, 0.0F);
		this.setRotateAngle(trunk01, 0.36425021489121656F, 0.0F, 0.0F);
		this.trunk05 = new ModelRenderer(this, 12, 89);
		this.trunk05.setRotationPoint(0.0F, 0.0F, -3.5F);
		this.trunk05.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
		this.setRotateAngle(trunk05, -0.40980330836826856F, 0.0F, 0.0F);
		this.rArm1 = new ModelRenderer(this, 0, 120);
		this.rArm1.setRotationPoint(-4.0F, 5.3F, -10.0F);
		this.rArm1.addBox(-2.5F, 0.0F, -1.5F, 5, 7, 5, 0.0F);
		this.setRotateAngle(rArm1, 0.18203784098300857F, 0.0F, 0.0F);
		this.africanTuskR_02 = new ModelRenderer(this, 12, 107);
		this.africanTuskR_02.setRotationPoint(0.0F, 4.7F, 0.0F);
		this.africanTuskR_02.addBox(-0.5F, 0.0F, -1.0F, 1, 4, 2, 0.0F);
		this.setRotateAngle(africanTuskR_02, 0.0F, 0.0F, -0.27314402793711257F);
		this.earRight_02 = new ModelRenderer(this, 11, 96);
		this.earRight_02.setRotationPoint(0.0F, 0.0F, 7.0F);
		this.earRight_02.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 3, 0.0F);
		this.howdahPlatform = new ModelRenderer(this, 0, 172);
		this.howdahPlatform.setRotationPoint(0.0F, 0.6F, 1.7F);
		this.howdahPlatform.addBox(-12.0F, -1.0F, -7.0F, 14, 2, 12, 0.0F);
		this.howdahCushion2 = new ModelRenderer(this, 0, 189);
		this.howdahCushion2.setRotationPoint(-4.9F, -0.2F, -0.3F);
		this.howdahCushion2.addBox(-3.0F, -2.0F, 0.0F, 6, 2, 5, 0.0F);
		this.rLeg2 = new ModelRenderer(this, 21, 134);
		this.rLeg2.setRotationPoint(0.0F, 9.0F, 0.0F);
		this.rLeg2.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 4, 0.0F);
		this.setRotateAngle(rLeg2, 0.27314402793711257F, 0.0F, 0.0F);
		this.trunk00 = new ModelRenderer(this, 24, 69);
		this.trunk00.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.trunk00.addBox(-2.5F, -2.0F, -5.0F, 5, 5, 5, 0.0F);
		this.setRotateAngle(trunk00, 0.22759093446006054F, 0.0F, 0.0F);
		this.howdahTop = new ModelRenderer(this, 92, 177);
		this.howdahTop.setRotationPoint(0.0F, -10.0F, 0.0F);
		this.howdahTop.addBox(-13.5F, -1.0F, -8.5F, 17, 1, 15, 0.0F);
		this.rHand = new ModelRenderer(this, 40, 111);
		this.rHand.setRotationPoint(0.0F, 3.5F, 2.7F);
		this.rHand.addBox(-2.0F, 0.0F, -3.0F, 4, 2, 4, 0.0F);
		this.tail2 = new ModelRenderer(this, 46, 9);
		this.tail2.setRotationPoint(0.0F, -0.5F, 5.0F);
		this.tail2.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
		this.setRotateAngle(tail2, -0.22759093446006054F, 0.0F, 0.0F);
		this.lArm3 = new ModelRenderer(this, 40, 120);
		this.lArm3.setRotationPoint(0.0F, 5.8F, -4.0F);
		this.lArm3.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
		this.setRotateAngle(lArm3, 0.136659280431156F, 0.0F, 0.0F);
		this.chestLeft = new ModelRenderer(this, 49, 35);
		this.chestLeft.setRotationPoint(0.5F, 7.0F, 1.0F);
		this.chestLeft.addBox(0.0F, 0.0F, -2.5F, 3, 5, 5, 0.0F);
		this.setRotateAngle(chestLeft, 0.0F, 0.0F, 0.18203784098300857F);
		this.trunk04 = new ModelRenderer(this, 0, 87);
		this.trunk04.setRotationPoint(0.0F, 0.0F, -3.5F);
		this.trunk04.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
		this.setRotateAngle(trunk04, -0.40980330836826856F, 0.0F, 0.0F);
		this.howdahTopSides = new ModelRenderer(this, 41, 183);
		this.howdahTopSides.setRotationPoint(0.0F, 0.0F, -7.5F);
		this.howdahTopSides.addBox(-13.0F, 0.0F, -0.5F, 16, 2, 14, 0.0F);
		this.trunk03 = new ModelRenderer(this, 34, 80);
		this.trunk03.setRotationPoint(0.0F, -0.5F, -4.6F);
		this.trunk03.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
		this.setRotateAngle(trunk03, -0.27314402793711257F, 0.0F, 0.0F);
		this.chestRight = new ModelRenderer(this, 49, 35);
		this.chestRight.mirror = true;
		this.chestRight.setRotationPoint(-10.5F, 7.0F, 1.0F);
		this.chestRight.addBox(-3.0F, 0.0F, -2.5F, 3, 5, 5, 0.0F);
		this.setRotateAngle(chestRight, 0.0F, 0.0F, -0.18203784098300857F);
		this.howdahLegs = new ModelRenderer(this, 45, 160);
		this.howdahLegs.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.howdahLegs.addBox(-12.0F, -10.0F, -7.0F, 14, 10, 12, 0.0F);
		this.earLeft_02 = new ModelRenderer(this, 11, 96);
		this.earLeft_02.setRotationPoint(0.0F, 0.0F, 7.0F);
		this.earLeft_02.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 3, 0.0F);
		this.earRight_flap = new ModelRenderer(this, 21, 86);
		this.earRight_flap.setRotationPoint(0.0F, 0.9F, 0.0F);
		this.earRight_flap.addBox(0.0F, 0.0F, 0.0F, 0, 10, 11, 0.0F);
		this.howdahStraps = new ModelRenderer(this, 0, 154);
		this.howdahStraps.setRotationPoint(5.0F, -3.5F, -2.1F);
		this.howdahStraps.addBox(-11.0F, 0.0F, 0.0F, 12, 15, 2, 0.0F);
		this.setRotateAngle(howdahStraps, -0.045553093477052F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 25, 55);
		this.head.setRotationPoint(0.0F, 0.5F, -2.5F);
		this.head.addBox(-4.0F, -4.0F, -5.0F, 8, 8, 5, 0.0F);
		this.setRotateAngle(head, 0.7285004297824331F, 0.0F, 0.0F);
		this.rLeg3 = new ModelRenderer(this, 39, 134);
		this.rLeg3.setRotationPoint(0.0F, 5.0F, 4.0F);
		this.rLeg3.addBox(-1.5F, 0.0F, -4.0F, 3, 4, 4, 0.0F);
		this.setRotateAngle(rLeg3, -0.22759093446006054F, 0.0F, 0.0F);
		this.earLeft_flap = new ModelRenderer(this, 21, 86);
		this.earLeft_flap.setRotationPoint(0.0F, 0.9F, 0.0F);
		this.earLeft_flap.addBox(0.0F, 0.0F, 0.0F, 0, 10, 11, 0.0F);
		this.butt.addChild(this.rLeg1);
		this.butt.addChild(this.lLeg1);
		this.africanTuskL_01.addChild(this.africanTuskL_02);
		this.rLeg3.addChild(this.rFoot);
		this.lArm3.addChild(this.lHand);
		this.head.addChild(this.earLeft1_01);
		this.topJaw.addChild(this.africanTuskL_01);
		this.lLeg1.addChild(this.lLeg2);
		this.front.addChild(this.lArm1);
		this.head.addChild(this.topJaw);
		this.head.addChild(this.earRight_01);
		this.africanTuskR_02.addChild(this.africanTuskR_03);
		this.rArm1.addChild(this.rArm2);
		this.tail2.addChild(this.tail3);
		this.head.addChild(this.lowerJaw);
		this.trunk01.addChild(this.trunk02);
		this.howdahPlatform.addChild(this.howdahCushion1);
		this.topJaw.addChild(this.africanTuskR_01);
		this.africanTuskL_02.addChild(this.africanTuskL_03);
		this.lLeg3.addChild(this.lFoot);
		this.front.addChild(this.neck);
		this.butt.addChild(this.tail);
		this.rArm2.addChild(this.rArm3);
		this.lLeg2.addChild(this.lLeg3);
		this.tail3.addChild(this.tailFloof);
		this.butt.addChild(this.front);
		this.lArm1.addChild(this.lArm2);
		this.trunk00.addChild(this.trunk01);
		this.trunk04.addChild(this.trunk05);
		this.front.addChild(this.rArm1);
		this.africanTuskR_01.addChild(this.africanTuskR_02);
		this.earRight_01.addChild(this.earRight_02);
		this.howdahStraps.addChild(this.howdahPlatform);
		this.howdahPlatform.addChild(this.howdahCushion2);
		this.rLeg1.addChild(this.rLeg2);
		this.topJaw.addChild(this.trunk00);
		this.howdahLegs.addChild(this.howdahTop);
		this.rArm3.addChild(this.rHand);
		this.tail.addChild(this.tail2);
		this.lArm2.addChild(this.lArm3);
		this.howdahStraps.addChild(this.chestLeft);
		this.trunk03.addChild(this.trunk04);
		this.howdahTop.addChild(this.howdahTopSides);
		this.trunk02.addChild(this.trunk03);
		this.howdahStraps.addChild(this.chestRight);
		this.howdahPlatform.addChild(this.howdahLegs);
		this.earLeft1_01.addChild(this.earLeft_02);
		this.earRight_01.addChild(this.earRight_flap);
		this.front.addChild(this.howdahStraps);
		this.neck.addChild(this.head);
		this.rLeg2.addChild(this.rLeg3);
		this.earLeft1_01.addChild(this.earLeft_flap);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.butt.render(f5);
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		boolean flag = entity instanceof EntityLivingBase && ((EntityLivingBase) entity).getTicksElytraFlying() > 4;
		float swingModifier = 0.6f;
		float add = entity.getUniqueID().hashCode() * 0.003F;
		boolean sit = false;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		
		if (flag) {
			this.neck.rotateAngleX = -((float) Math.PI / 4F);
		}
		else {
			this.neck.rotateAngleX = headPitch * 0.017453292F;
		}
		
		if (entity instanceof EntityElephant) {
			EntityElephant elephant = (EntityElephant) entity;
			{
				float mul = 0.1F;
				float div = 40F;
				this.tail.rotateAngleZ = (float) Math.cos(ageInTicks * (mul + 0.06F) + add) / div + 0F;
				this.earLeft1_01.rotateAngleY = (float) Math.cos(ageInTicks * (mul + 0.06F) + add) / div + 0F;
				this.earRight_01.rotateAngleY = -(float) Math.cos(ageInTicks * (mul + 0.06F) + add) / div + 0F;
			}
			
			float grazeTime = elephant.getGrazeTime();
			if (grazeTime <= 80 && !elephant.isSitting()) {
				this.neck.rotateAngleX = (float) Math.toRadians(60F) - 0.31869712141416456F;
			}
			else {
				this.trunk00.rotateAngleX = headPitch * 0.017453292F;
			}
			
			if (elephant.isSitting()) {
				sit = true;
				this.butt.offsetY = 0.60f;
				this.setRotateAngle(lArm1, -1f, 0f, 0f);
				this.setRotateAngle(rArm1, -1f, 0f, 0f);
				this.setRotateAngle(lLeg1, 0.3f, 0f, -1.1f);
				this.setRotateAngle(rLeg1, 0.3f, 0f, -1.1f);
			}
			else {
				this.butt.offsetY = 0f;
				this.lArm1.rotateAngleZ = 0f;
				this.rArm1.rotateAngleZ = 0f;
				this.rLeg1.rotateAngleZ = 0f;
				this.lLeg1.rotateAngleZ = 0f;
				this.lArm1.rotateAngleX = MathHelper.sin(limbSwing * 0.18203784098300857F + (float) Math.PI) * swingModifier * limbSwingAmount - -0.20F;
				this.rArm1.rotateAngleX = MathHelper.cos(limbSwing * 0.18203784098300857F) * swingModifier * limbSwingAmount - -0.20f;
				this.lLeg1.rotateAngleX = MathHelper.sin(limbSwing * 0.18203784098300857F) * swingModifier * limbSwingAmount + 0f;
				this.rLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.18203784098300857F + (float) Math.PI) * swingModifier * limbSwingAmount + 0f;
			}
		}
		if (!sit) {
			this.butt.offsetY = 0f;
			this.lArm1.rotateAngleZ = 0f;
			this.rArm1.rotateAngleZ = 0f;
			this.rLeg1.rotateAngleZ = 0f;
			this.lLeg1.rotateAngleZ = 0f;
			this.lArm1.rotateAngleX = MathHelper.sin(limbSwing * 0.18203784098300857F + (float) Math.PI) * swingModifier * limbSwingAmount - -0.20F;
			this.rArm1.rotateAngleX = MathHelper.cos(limbSwing * 0.18203784098300857F) * swingModifier * limbSwingAmount - -0.20f;
			this.lLeg1.rotateAngleX = MathHelper.sin(limbSwing * 0.18203784098300857F) * swingModifier * limbSwingAmount + 0f;
			this.rLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.18203784098300857F + (float) Math.PI) * swingModifier * limbSwingAmount + 0f;
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
