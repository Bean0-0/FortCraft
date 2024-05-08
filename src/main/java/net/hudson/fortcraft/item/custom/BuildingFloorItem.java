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

public class BuildingFloorItem extends Item {
    public BuildingFloorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int itemSlot, boolean isSelected) {
        if(isSelected && entity instanceof Player player) {
            if(!level.isClientSide()) {
                if(player.getXRot() < 20) {
                    placeBlocks(level, player.blockPosition().relative(player.getDirection(), 2), ModBlocks.BUILDING_GHOST.get(), player.getDirection());
                }
                else {
                    placeBlocks(level, player.blockPosition().relative(player.getDirection(), 1), ModBlocks.BUILDING_GHOST.get(), player.getDirection());
                }
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide()) {
            if (player.getXRot() < 20) {
                placeBlocks(level, player.blockPosition().relative(player.getDirection(), 2), Blocks.OAK_SLAB, player.getDirection());
            } else {
                placeBlocks(level, player.blockPosition().relative(player.getDirection(), 1), Blocks.OAK_SLAB, player.getDirection());
            }
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

        BlockPos pos1 = startBlockPos.below();
        BlockPos pos2 = startBlockPos.below().north();
        BlockPos pos3 = startBlockPos.below().north().east();
        BlockPos pos4 = startBlockPos.below().east();
        BlockPos pos5 = startBlockPos.below().south().east();
        BlockPos pos6 = startBlockPos.below().south();
        BlockPos pos7 = startBlockPos.below().south().west();
        BlockPos pos8 = startBlockPos.below().west();
        BlockPos pos9 = startBlockPos.below().north().west();
        BlockPos[] posArr = {pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8, pos9};

        for(BlockPos pos:posArr) {
            if(level.getBlockState(pos) == Blocks.AIR.defaultBlockState() ||
                    level.getBlockState(pos) == ModBlocks.BUILDING_GHOST.get().defaultBlockState()) {
                level.setBlock(pos, block.defaultBlockState(), 3);
            }
        }
    }
}