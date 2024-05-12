package net.hudson.fortcraft.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class RiftEffect extends MobEffect {

    protected RiftEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide) {
            System.out.println("Yay");
            pLivingEntity.moveTo(pLivingEntity.getX(), 220, pLivingEntity.getZ(), pLivingEntity.getYRot(), pLivingEntity.getXRot());
           super.applyEffectTick(pLivingEntity,pAmplifier);
        }
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
