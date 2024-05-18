package net.hudson.fortcraft.item.custom;

import net.hudson.fortcraft.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BuildingPyramidItem extends Item {
    public BuildingPyramidItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int itemSlot, boolean isSelected) {
        if(isSelected && entity instanceof Player player) {
            if(!level.isClientSide()) {
                placeBlocks(level, player.blockPosition().relative(player.getDirection()), ModBlocks.BUILDING_GHOST.get(), player.getDirection());
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide()) {
            placeBlocks(level, player.blockPosition().relative(player.getDirection()), Blocks.OAK_PLANKS, player.getDirection());
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    private void placeBlocks(Level level, BlockPos startBlockPos, Block block, Direction playerFacing) {
        int x = startBlockPos.getX();
        int y = startBlockPos.getY();
        int z = startBlockPos.getZ();

        if(x % 3 == 1 || x % 3 == -2) {
            startBlockPos = startBlockPos.west();
        }
        else if(x % 3 == 2 || x % 3 == -1) {
            startBlockPos = startBlockPos.east();
        }

        if(y % 3 == 1 || y % 3 == -2) {
            startBlockPos = startBlockPos.below();
        }
        else if(y % 3 == 2 || y % 3 == -1) {
            startBlockPos = startBlockPos.above();
        }

        if(z % 3 == 1 || z % 3 == -2) {
            startBlockPos = startBlockPos.north();
        }
        else if(z % 3 == 2 || z % 3 == -1) {
            startBlockPos = startBlockPos.south();
        }

        BlockPos pos1 = startBlockPos.relative(playerFacing, 2);
        BlockPos pos2 = startBlockPos.relative(playerFacing,2).above();
        BlockPos pos3 = startBlockPos.relative(playerFacing,2).above(2);
        BlockPos pos4 = startBlockPos.relative(playerFacing,2).relative(playerFacing.getClockWise());
        BlockPos pos5 = startBlockPos.relative(playerFacing,2).relative(playerFacing.getClockWise()).above();
        BlockPos pos6 = startBlockPos.relative(playerFacing,2).relative(playerFacing.getClockWise()).above(2);
        BlockPos pos7 = startBlockPos.relative(playerFacing,2).relative(playerFacing.getCounterClockWise());
        BlockPos pos8 = startBlockPos.relative(playerFacing,2).relative(playerFacing.getCounterClockWise()).above();
        BlockPos pos9 = startBlockPos.relative(playerFacing,2).relative(playerFacing.getCounterClockWise()).above(2);

        if(level.getBlockState(pos1) == Blocks.AIR.defaultBlockState() ||
                level.getBlockState(pos1) == ModBlocks.BUILDING_GHOST.get().defaultBlockState()) {
            level.setBlock(pos1, block.defaultBlockState(), 3);
        }
        if(level.getBlockState(pos2) == Blocks.AIR.defaultBlockState() ||
                level.getBlockState(pos2) == ModBlocks.BUILDING_GHOST.get().defaultBlockState()) {
            level.setBlock(pos2, block.defaultBlockState(), 3);
        }
        if(level.getBlockState(pos3) == Blocks.AIR.defaultBlockState() ||
                level.getBlockState(pos3) == ModBlocks.BUILDING_GHOST.get().defaultBlockState()) {
            level.setBlock(pos3, block.defaultBlockState(), 3);
        }
        if(level.getBlockState(pos4) == Blocks.AIR.defaultBlockState() ||
                level.getBlockState(pos4) == ModBlocks.BUILDING_GHOST.get().defaultBlockState()) {
            level.setBlock(pos4, block.defaultBlockState(), 3);
        }
        if(level.getBlockState(pos5) == Blocks.AIR.defaultBlockState() ||
                level.getBlockState(pos5) == ModBlocks.BUILDING_GHOST.get().defaultBlockState()) {
            level.setBlock(pos5, block.defaultBlockState(), 3);
        }
        if(level.getBlockState(pos6) == Blocks.AIR.defaultBlockState() ||
                level.getBlockState(pos6) == ModBlocks.BUILDING_GHOST.get().defaultBlockState()) {
            level.setBlock(pos6, block.defaultBlockState(), 3);
        }
        if(level.getBlockState(pos7) == Blocks.AIR.defaultBlockState() ||
                level.getBlockState(pos7) == ModBlocks.BUILDING_GHOST.get().defaultBlockState()) {
            level.setBlock(pos7, block.defaultBlockState(), 3);
        }
        if(level.getBlockState(pos8) == Blocks.AIR.defaultBlockState() ||
                level.getBlockState(pos8) == ModBlocks.BUILDING_GHOST.get().defaultBlockState()) {
            level.setBlock(pos8, block.defaultBlockState(), 3);
        }
        if(level.getBlockState(pos9) == Blocks.AIR.defaultBlockState() ||
                level.getBlockState(pos9) == ModBlocks.BUILDING_GHOST.get().defaultBlockState()) {
            level.setBlock(pos9, block.defaultBlockState(), 3);
        }
    }
}
