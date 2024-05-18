package net.hudson.fortcraft.effect;

import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.lwjgl.system.macosx.LibC;

import javax.annotation.Nullable;

public class BounceEffect extends MobEffect {
    private int time = 30;

    protected BounceEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(!pLivingEntity.level().isClientSide) {
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP,20*20 , pAmplifier + 1, false, false,false));
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 20*20, pAmplifier, false, false, false));
            super.applyEffectTick(pLivingEntity,pAmplifier);
        }
    }

    public boolean isDurationEffectTick(int pDuration, int pAmplifier){
        return true;
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }

}
