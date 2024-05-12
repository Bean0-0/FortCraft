package net.hudson.fortcraft.entity.custom;

import net.hudson.fortcraft.entity.ModEntities;
import net.hudson.fortcraft.item.ModItems;
import net.hudson.fortcraft.item.custom.BlockRiftItem;
import net.hudson.fortcraft.util.ModData;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import java.util.Random;

public class BlockRiftProjectileEntity extends ThrowableItemProjectile {
    public BlockRiftProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public BlockRiftProjectileEntity(Level pLevel) {
        super(ModEntities.BLOCK_RIFT_PROJECTILE.get(), pLevel);
    }

    public BlockRiftProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.BLOCK_RIFT_PROJECTILE.get(),livingEntity,pLevel);
    }

    @Override
    protected Item getDefaultItem(){
        return ModItems.BLOCK_RIFT.get();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {

        if(!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, ((byte) 3));
            Random rand = new Random();
            int typeOfBlock = rand.nextInt(0,3);
            randomRift(typeOfBlock,pResult);
        }
        this.discard();
        super.onHitBlock(pResult);
    }

    private void randomRift(int num, BlockHitResult pResult) {
        if (num == 0) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 3; j++) {
                    for (int k = -1; k < 2; k++) {
                        this.level().setBlock(new BlockPos(blockPosition().getX() + i, blockPosition().getY() + 50 + j, blockPosition().getZ() + k), (Blocks.DAMAGED_ANVIL).defaultBlockState(), 3);
                    }

                }
            }
        } else if (num == 1) {
                killBox(3,3,47);
                FallingBlockEntity fallingBlockEntity = new FallingBlockEntity(EntityType.FALLING_BLOCK,this.level());
                for(int i =-1;i<2;i++){
                    fallingBlockEntity.fall(this.level(),new BlockPos(blockPosition().getX()+i,blockPosition().getY()+50,blockPosition().getZ()-1),Blocks.RED_CONCRETE.defaultBlockState());
                    fallingBlockEntity.fall(this.level(),new BlockPos(blockPosition().getX()+i,blockPosition().getY()+50,blockPosition().getZ()),Blocks.RED_TERRACOTTA.defaultBlockState());
                    fallingBlockEntity.fall(this.level(),new BlockPos(blockPosition().getX()+i,blockPosition().getY()+50,blockPosition().getZ()+1),Blocks.RED_CONCRETE.defaultBlockState());
                }
            for(int i =-1;i<2;i++) {
                for(int j = -1;j<2;j++){
                    if(i ==0 & j ==0){
                        fallingBlockEntity.fall(this.level(),new BlockPos(blockPosition().getX()+i,blockPosition().getY()+51,blockPosition().getZ()+j),Blocks.TNT.defaultBlockState());
                    }else {
                        fallingBlockEntity.fall(this.level(), new BlockPos(blockPosition().getX() + i, blockPosition().getY() + 51, blockPosition().getZ() + j), Blocks.WHITE_CONCRETE.defaultBlockState());
                    }
                }
            }
            for(int i =-1;i<2;i++){
                fallingBlockEntity.fall(this.level(),new BlockPos(blockPosition().getX()+i,blockPosition().getY()+52,blockPosition().getZ()-1),Blocks.RED_CONCRETE.defaultBlockState());
                fallingBlockEntity.fall(this.level(),new BlockPos(blockPosition().getX()+i,blockPosition().getY()+52,blockPosition().getZ()),Blocks.RED_TERRACOTTA.defaultBlockState());
                fallingBlockEntity.fall(this.level(),new BlockPos(blockPosition().getX()+i,blockPosition().getY()+52,blockPosition().getZ()+1),Blocks.RED_CONCRETE.defaultBlockState());
            }
            fallingBlockEntity.fall(this.level(),new BlockPos(blockPosition().getX(),blockPosition().getY()+53,blockPosition().getZ()),Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE.defaultBlockState());
            }
        else if (num == 2) {
            killBox(3,3,47);
            FallingBlockEntity fallingBlockEntity = new FallingBlockEntity(EntityType.FALLING_BLOCK,this.level());
            for(int i =-1;i<2;i++) {
                for(int j = -1;j<2;j++){
                    if(i ==-1 & j ==0){
                        fallingBlockEntity.fall(this.level(),new BlockPos(blockPosition().getX()+i,blockPosition().getY()+50,blockPosition().getZ()+j),Blocks.GREEN_CONCRETE.defaultBlockState());
                    }else {
                        fallingBlockEntity.fall(this.level(), new BlockPos(blockPosition().getX() + i, blockPosition().getY() + 50, blockPosition().getZ() + j), Blocks.LIME_TERRACOTTA.defaultBlockState());
                    }
                }
            }
            for(int i =-1;i<2;i++) {
                for(int j = -1;j<2;j++){
                    if((i ==-1 & j ==-1)||(i ==-1 & j ==1)){
                        fallingBlockEntity.fall(this.level(),new BlockPos(blockPosition().getX()+i,blockPosition().getY()+51,blockPosition().getZ()+j),Blocks.BLACK_CONCRETE.defaultBlockState());
                    } else if(i==1) {
                        fallingBlockEntity.fall(this.level(),new BlockPos(blockPosition().getX()+i,blockPosition().getY()+51,blockPosition().getZ()+j),Blocks.GREEN_CONCRETE.defaultBlockState());
                    }
                    else {
                        fallingBlockEntity.fall(this.level(), new BlockPos(blockPosition().getX() + i, blockPosition().getY() + 51, blockPosition().getZ() + j), Blocks.LIME_TERRACOTTA.defaultBlockState());
                    }
                }
            }
            for(int i =-1;i<2;i++){
                fallingBlockEntity.fall(this.level(),new BlockPos(blockPosition().getX()+i,blockPosition().getY()+52,blockPosition().getZ()-1),Blocks.GREEN_CONCRETE.defaultBlockState());
                fallingBlockEntity.fall(this.level(),new BlockPos(blockPosition().getX()+i,blockPosition().getY()+52,blockPosition().getZ()),Blocks.GREEN_CONCRETE.defaultBlockState());
                fallingBlockEntity.fall(this.level(),new BlockPos(blockPosition().getX()+i,blockPosition().getY()+52,blockPosition().getZ()+1),Blocks.GREEN_CONCRETE.defaultBlockState());
            }
        }
        }

    private void  killBox(int l, int w,int h){
        for (int i = -1; i < l-1; i++) {
                for (int k = -1; k < w-1; k++) {
                    Entity kill_zone = ModEntities.BLOCK_RIFT_KILL_PROJECTILE.get().spawn((ServerLevel) this.level(), new BlockPos(blockPosition().getX() + i, blockPosition().getY() + h, blockPosition().getZ() + k), MobSpawnType.MOB_SUMMONED);
                    kill_zone.push(0,-0.30D,0);

                }

        }
    }

   /* @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if(!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, ((byte) 3));

            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    for (int k = -1; k < 2; k++) {
                        this.level().setBlock(new BlockPos(blockPosition().getX()+i,blockPosition().getY()+50+j,blockPosition().getZ()+k), (Blocks.ANVIL).defaultBlockState(), 3);
                    }

                }
            }

        }
        this.discard();
        super.onHitEntity(pResult);
    }

    */
}
