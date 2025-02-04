package net.hudson.fortcraft.block;

import net.hudson.fortcraft.FortCraft;
import net.hudson.fortcraft.block.custom.BuildingGhostBlock;
import net.hudson.fortcraft.block.custom.RiftBlock;
import net.hudson.fortcraft.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FortCraft.MOD_ID);

    public static final RegistryObject<Block> RIFT_BLOCK = registerBlock("rift_block",
            () -> new RiftBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).noCollission().noOcclusion().noLootTable()));

    public static final RegistryObject<Block> BUILDING_GHOST = registerBlock("building_ghost",
            () -> new BuildingGhostBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().noCollission().replaceable()));

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        // Ensure that 'block.get()' is indeed a block before registering it as an item
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
