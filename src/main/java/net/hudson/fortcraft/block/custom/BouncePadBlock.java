package net.hudson.fortcraft.block.custom;

import net.hudson.fortcraft.effect.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;

public class BouncePadBlock extends SlabBlock {
    public BouncePadBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity.isAlive()){
            LivingEntity pLivingEntity = (LivingEntity)(pEntity);
            pLivingEntity.addEffect(new MobEffectInstance(ModEffects.BOUNCE.get(),1 , 0, false, false,false));
        }
        pEntity.lerpMotion(0,1.2f,0);
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
   @Override
    public boolean canPlaceLiquid(BlockGetter pLevel, BlockPos pPos, BlockState pState, Fluid pFluid) {
        return false;
    }

    @Override
    public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
        return false;
    }

}
