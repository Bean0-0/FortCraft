package net.hudson.fortcraft.entity.custom;

import net.hudson.fortcraft.entity.ModEntities;
import net.hudson.fortcraft.item.ModItems;
import net.hudson.fortcraft.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.apache.commons.logging.Log;

import java.util.ArrayList;

public class BlockRiftProjectileKillEntity extends ThrowableItemProjectile{
    //BlockState[] canbeDestoryed = {Blocks.OAK_WOOD.defaultBlockState(), Blocks.OAK_LOG., Blocks.OAK_LEAVES.};

    public BlockRiftProjectileKillEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BLOCK_RIFT_KILL.get();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if (!this.level().isClientSide()) {

            this.level().broadcastEntityEvent(this, ((byte) 3));
                AABB aabb = this.getBoundingBox().inflate(1D);
                this.isInvisible();
                for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                    BlockState blockstate = this.level().getBlockState(blockpos);
                    Block block = blockstate.getBlock();
                    System.out.println(block.getDescriptionId());
                    if (block instanceof LeavesBlock) {
                        destoryingBlock(blockpos);
                    }

                    else if (block instanceof FlowerBlock) {
                        destoryingBlock(blockpos);
                    }
                    else if (block instanceof FlowerPotBlock) {
                        destoryingBlock(blockpos);
                    }
                    else if (block instanceof TorchBlock) {
                        destoryingBlock(blockpos);
                    }
                    else if (block instanceof LanternBlock) {
                        destoryingBlock(blockpos);
                    }
                    else if (block instanceof DoorBlock) {
                        destoryingBlock(blockpos);
                    }
                    else if (block.getDescriptionId().equals("block.minecraft.oak_stairs")) {
                        destoryingBlock(blockpos);
                    }
                    else if (block.getDescriptionId().equals("block.minecraft.oak_slab")) {
                        destoryingBlock(blockpos);
                    }
                    else if (block instanceof LadderBlock) {
                        destoryingBlock(blockpos);
                    }

                    else if (block.getDescriptionId().equals("block.minecraft.oak_log")) {
                        System.out.println("true");
                        destoryingBlock(blockpos);
                    }
                    else if (block.getDescriptionId().equals("block.minecraft.oak_planks")) {
                        destoryingBlock(blockpos);
                    }

                }

            }

                /* }
                else if (this.level().getBlockState(new BlockPos(blockPosition().getX(), blockPosition().getY() + 1, blockPosition().getZ())).equals(block.defaultBlockState())) {
                    this.level().destroyBlock(new BlockPos(blockPosition().getX(), blockPosition().getY() + 1, blockPosition().getZ()), false);
                    Entity entity = ModEntities.BLOCK_RIFT_KILL_PROJECTILE.get().spawn((ServerLevel) this.level(), blockPosition(), MobSpawnType.MOB_SUMMONED);

                    check = false;
                    break;

                }
                if (this.level().getBlockState(new BlockPos(blockPosition().getX(), blockPosition().getY() , blockPosition().getZ())).equals(block)) {
                    this.level().destroyBlock(new BlockPos(blockPosition().getX(), blockPosition().getY(), blockPosition().getZ()), false);
                    Entity entity = ModEntities.BLOCK_RIFT_KILL_PROJECTILE.get().spawn((ServerLevel) this.level(), blockPosition(), MobSpawnType.MOB_SUMMONED);


                    check = false;
                    break;

                }

                 */


        this.discard();
        super.onHitBlock(pResult);
    }


    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (!(pResult.getEntity() instanceof FallingBlockEntity)) {
            pResult.getEntity().kill();
            super.onHitEntity(pResult);
        }
    }

    private  void destoryingBlock(BlockPos blockpos){
        BlockState blockstate = this.level().getBlockState(new BlockPos(blockpos.getX(),blockpos.getY()-1,blockpos.getZ()));
        Block block = blockstate.getBlock();
        this.level().destroyBlock(blockpos, false, this);
        Entity entity = ModEntities.BLOCK_RIFT_KILL_PROJECTILE.get().spawn((ServerLevel) this.level(), new BlockPos(getBlockX(),getBlockY()-1,getBlockZ()), MobSpawnType.MOB_SUMMONED);
        entity.push(0,-0.45D,0);
        this.discard();
    }

}

