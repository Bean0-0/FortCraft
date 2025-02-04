package net.hudson.fortcraft;

import com.mojang.logging.LogUtils;
import net.hudson.fortcraft.block.ModBlocks;
import net.hudson.fortcraft.block.entity.ModBlockEntities;
import net.hudson.fortcraft.effect.ModEffects;
import net.hudson.fortcraft.entity.ModEntities;
import net.hudson.fortcraft.item.ModCreativeModeTabs;
import net.hudson.fortcraft.item.ModItems;
import net.hudson.fortcraft.sound.ModSounds;
import net.hudson.fortcraft.util.ModData;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.hudson.fortcraft.effect.ModEffects;
import net.hudson.fortcraft.item.ModCreativeModeTabs;
import net.hudson.fortcraft.item.ModItems;
import net.hudson.fortcraft.sound.ModSounds;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FortCraft.MOD_ID)
public class FortCraft {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "fortcraft";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public FortCraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);

        ModEntities.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BUILDING_GHOST.get(), RenderType.translucent());
            EntityRenderers.register(ModEntities.BLOCK_RIFT_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.BLOCK_RIFT_KILL_PROJECTILE.get(), ThrownItemRenderer::new);
        }
    }
}
