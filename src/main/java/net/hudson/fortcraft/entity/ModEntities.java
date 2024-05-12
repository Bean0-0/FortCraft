package net.hudson.fortcraft.entity;

import net.hudson.fortcraft.FortCraft;
import net.hudson.fortcraft.entity.custom.BlockRiftProjectileEntity;
import net.hudson.fortcraft.entity.custom.BlockRiftProjectileKillEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FortCraft.MOD_ID);

    public static final RegistryObject<EntityType<BlockRiftProjectileEntity>> BLOCK_RIFT_PROJECTILE =
            ENTITY_TYPES.register("block_rift_projectile",() -> EntityType.Builder.<BlockRiftProjectileEntity>of(BlockRiftProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("block_rift_projectile"));

    public static final RegistryObject<EntityType<BlockRiftProjectileKillEntity>> BLOCK_RIFT_KILL_PROJECTILE =
            ENTITY_TYPES.register("block_rift_kill_projectile",() -> EntityType.Builder.<BlockRiftProjectileKillEntity>of(BlockRiftProjectileKillEntity::new, MobCategory.MISC)
                    .sized(1f,1f).build("block_rift_kill_projectile"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
