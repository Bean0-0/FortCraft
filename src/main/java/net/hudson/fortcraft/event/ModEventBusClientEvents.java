package net.hudson.fortcraft.event;

import net.hudson.fortcraft.FortCraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FortCraft.MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        //event.registerLayerDefinition(ModModelLayers."entity"::createBodyLayer);
    }
}
