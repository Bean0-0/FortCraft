package net.hudson.fortcraft.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.lwjgl.system.macosx.LibC;

public class BounceEffect extends MobEffect {
    protected BounceEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier){

        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP,1,1,false,false));
        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING,1,1,false,false));
        super.applyEffectTick(pLivingEntity,pAmplifier);

    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier){
        return true;
    }


}
