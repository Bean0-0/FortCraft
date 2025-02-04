package net.hudson.fortcraft.potion;

import net.hudson.fortcraft.FortCraft;
import net.hudson.fortcraft.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, FortCraft.MOD_ID);

    public static final RegistryObject<Potion> BOUNCE_POTION = POTIONS.register("bounce_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.BOUNCE.get(),1,0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

}
