package net.hudson.fortcraft.item;


import net.hudson.fortcraft.effect.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties MEAT = new FoodProperties.Builder().meat().nutrition(0).saturationMod(0f).effect(() -> new MobEffectInstance(MobEffects.HEAL,1), 1f).alwaysEat().build();
    public static final FoodProperties BANDAGE = new FoodProperties.Builder().nutrition(0).saturationMod(0f).effect(() -> new MobEffectInstance(MobEffects.HEAL,1), 1f).alwaysEat().fast().build();
    public static final FoodProperties MEDKIT = new FoodProperties.Builder().nutrition(4).saturationMod(0f).effect(() -> new MobEffectInstance(MobEffects.HEAL,1,10), 1f).alwaysEat().build();

    public static final FoodProperties MINI = new FoodProperties.Builder().nutrition(0).saturationMod(0f).effect(() -> new MobEffectInstance(ModEffects.SHIELD.get(),1), 1f).alwaysEat().fast().build();
    public static final FoodProperties BIGPOT = new FoodProperties.Builder().nutrition(0).saturationMod(0f).effect(() -> new MobEffectInstance(ModEffects.SHIELD.get(),1,1), 1f).alwaysEat().build();
    public static final FoodProperties CHUG_JUG = new FoodProperties.Builder().nutrition(0).saturationMod(0f).effect(() -> new MobEffectInstance(ModEffects.SLURP.get(),20*20), 1f).alwaysEat().build();

    public static final FoodProperties SLURP_JUICE = new FoodProperties.Builder().nutrition(0).saturationMod(0f).effect(() -> new MobEffectInstance(ModEffects.SLURP.get(),30*20,0), 1f).alwaysEat().build();

    public static final FoodProperties HOP_ROCK = new FoodProperties.Builder().nutrition(0).saturationMod(0f).effect(() -> new MobEffectInstance(ModEffects.BOUNCE.get(),1), 1f).alwaysEat().fast().build();

    public static final FoodProperties RIFT_TO_GO = new FoodProperties.Builder().nutrition(0).saturationMod(0f).alwaysEat().build();

}
