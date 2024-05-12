package net.hudson.fortcraft.effect;

import net.hudson.fortcraft.FortCraft;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, FortCraft.MOD_ID);

    public static final RegistryObject<MobEffect> FREEZE = MOB_EFFECTS.register("freeze",
            () -> new FreezeEffect(MobEffectCategory.HARMFUL,3124687));

    public static final RegistryObject<MobEffect> BOUNCE = MOB_EFFECTS.register("bounce",
            () -> new BounceEffect(MobEffectCategory.BENEFICIAL,3124687));

    public static final RegistryObject<MobEffect> SHIELD = MOB_EFFECTS.register("shield",
            () -> new ShieldEffect(MobEffectCategory.BENEFICIAL,3124687));

    public static final RegistryObject<MobEffect> RIFTING = MOB_EFFECTS.register("rifting",
            () -> new RiftEffect(MobEffectCategory.BENEFICIAL,3124687));

    public static final RegistryObject<MobEffect> SLURP = MOB_EFFECTS.register("slurp",
            () -> new SlurpEffect(MobEffectCategory.BENEFICIAL,3124687));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}