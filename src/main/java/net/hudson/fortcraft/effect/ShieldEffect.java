package net.hudson.fortcraft.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.lwjgl.system.macosx.LibC;

import javax.annotation.Nullable;

public class ShieldEffect extends MobEffect {
    private int shield = 0;
    protected ShieldEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if ((int) pLivingEntity.getAbsorptionAmount() / 4 + pAmplifier < 5) {
            shield = (int) pLivingEntity.getAbsorptionAmount() / 4 + pAmplifier;
        }
        else{
            shield = 4;
        }
        System.out.println(shield);
        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, MobEffectInstance.INFINITE_DURATION, shield, false, false, false));
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier){

        return true;
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }
}
