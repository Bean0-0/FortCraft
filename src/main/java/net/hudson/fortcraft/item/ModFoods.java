package net.hudson.fortcraft.item;


import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties MEAT = new FoodProperties.Builder().meat().nutrition(0).saturationMod(0f).effect(() -> new MobEffectInstance(MobEffects.HEAL,1), 1f).alwaysEat().build();

    public static final FoodProperties BANDAGE = new FoodProperties.Builder().nutrition(0).saturationMod(0f).effect(() -> new MobEffectInstance(MobEffects.HEAL,1), 1f).alwaysEat().fast().build();

    public static final FoodProperties MEDKIT = new FoodProperties.Builder().nutrition(0).saturationMod(0f).effect(() -> new MobEffectInstance(MobEffects.HEAL,1,10), 1f).alwaysEat().build();

}
