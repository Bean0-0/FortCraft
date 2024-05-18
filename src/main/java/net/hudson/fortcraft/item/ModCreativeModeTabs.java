package net.hudson.fortcraft.item;

import net.hudson.fortcraft.FortCraft;
import net.hudson.fortcraft.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FortCraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FORTCRAFT_TAB =CREATIVE_MODE_TABS.register("fortcraft_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RIFT_DEVICE.get()))
                    .title(Component.translatable("creativetab.fortcraft_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        //Regular Items
                        pOutput.accept(ModItems.RIFT_DEVICE.get());


                        //Blocks
                        pOutput.accept(ModBlocks.RIFT_BLOCK.get());
                        pOutput.accept(ModBlocks.BUILDING_GHOST.get());

                        //Food
                        pOutput.accept(ModItems.MEAT.get());
                        pOutput.accept(ModItems.BANDAGE.get());
                        pOutput.accept(ModItems.MEDKIT.get());

                        pOutput.accept(ModItems.CHUGWU_MUSIC_DISC.get());

                        // Buildings
                        pOutput.accept(ModItems.BUILDING_WALL.get());
                        pOutput.accept(ModItems.BUILDING_FLOOR.get());
                        pOutput.accept(ModItems.BUILDING_STAIRS.get());
                        pOutput.accept(ModItems.BUILDING_PYRAMID.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
