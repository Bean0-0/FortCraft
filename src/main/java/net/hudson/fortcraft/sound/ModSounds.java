package net.hudson.fortcraft.sound;

import net.hudson.fortcraft.FortCraft;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FortCraft.MOD_ID);

    //Music Discs
    public static final RegistryObject<SoundEvent> CHUGWU = registerSoundEvents("chugwu");
    public static final RegistryObject<SoundEvent> AR_SHOT = registerSoundEvents("ar_shot");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name){
        return SOUND_EVENTS.register(name,() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(FortCraft.MOD_ID,name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
