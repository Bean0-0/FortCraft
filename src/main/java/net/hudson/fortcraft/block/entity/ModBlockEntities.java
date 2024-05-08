package net.hudson.fortcraft.block.entity;

import net.hudson.fortcraft.FortCraft;
import net.hudson.fortcraft.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FortCraft.MOD_ID);

    public static final RegistryObject<BlockEntityType<BuildingGhostBlockEntity>> BUILDING_GHOST_BE =
            BLOCK_ENTITIES.register("building_ghost_be", () ->
                    BlockEntityType.Builder.of(BuildingGhostBlockEntity::new,
                            ModBlocks.BUILDING_GHOST.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}