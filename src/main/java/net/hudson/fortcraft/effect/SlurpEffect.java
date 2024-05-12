package net.hudson.fortcraft.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.fml.common.Mod;

public class SlurpEffect extends MobEffect {
    private int time = 30;
    private int amount ;

    protected SlurpEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
        amount = 0;
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(!pLivingEntity.level().isClientSide) {
            if(amount == 80){
                if (pLivingEntity.getHealth() < pLivingEntity.getMaxHealth()) {
                    pLivingEntity.heal(4.0F);
                }
                pLivingEntity.addEffect(new MobEffectInstance(ModEffects.SHIELD.get(),1 , 0, false, false,false));
                amount=0;
            }
            else{
                amount++;
            }
            super.applyEffectTick(pLivingEntity,pAmplifier);
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier){
        return true;
    }


}
