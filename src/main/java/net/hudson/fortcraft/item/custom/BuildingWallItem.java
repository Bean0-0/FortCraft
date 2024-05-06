package net.hudson.fortcraft.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BuildingWallItem extends Item {
    public BuildingWallItem(Properties pProperties) {
        super(pProperties);
    }

    /*
    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int itemSlot, boolean isSelected) {
        if(isSelected && entity instanceof Player player) {
            BlockPos playerPos = player.blockPosition();
            Level level = player.getCommandSenderWorld();
            if(level != null && !world.isClientSide()) {
                // Place blocks relative to the player's position
                BlockPos placePos = playerPos.above(); // Example: Place blocks above the player
                placeBlocks(level, placePos, ModBlocks.BUILDING_GHOST.get(), player.getDirection());
            }
        }
    }

     */

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            // Get the player's facing direction
            Direction playerFacing = player.getDirection();

            // Get the block position in front of the player
            BlockPos startBlockPos = player.blockPosition().relative(playerFacing);

            // Place blocks relative to the player's facing direction
            placeBlocks(level, startBlockPos, Blocks.OAK_PLANKS, playerFacing);
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    private void placeBlocks(Level world, BlockPos startBlockPos, Block block, Direction playerFacing) {
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

        world.setBlock(startBlockPos.relative(playerFacing,2), block.defaultBlockState(), 3);
        world.setBlock(startBlockPos.relative(playerFacing,2).above(), block.defaultBlockState(), 3);
        world.setBlock(startBlockPos.relative(playerFacing,2).above(2), block.defaultBlockState(), 3);
        world.setBlock(startBlockPos.relative(playerFacing,2).relative(playerFacing.getClockWise()), block.defaultBlockState(), 3);
        world.setBlock(startBlockPos.relative(playerFacing,2).relative(playerFacing.getClockWise()).above(), block.defaultBlockState(), 3);
        world.setBlock(startBlockPos.relative(playerFacing,2).relative(playerFacing.getClockWise()).above(2), block.defaultBlockState(), 3);
        world.setBlock(startBlockPos.relative(playerFacing,2).relative(playerFacing.getCounterClockWise()), block.defaultBlockState(), 3);
        world.setBlock(startBlockPos.relative(playerFacing,2).relative(playerFacing.getCounterClockWise()).above(), block.defaultBlockState(), 3);
        world.setBlock(startBlockPos.relative(playerFacing,2).relative(playerFacing.getCounterClockWise()).above(2), block.defaultBlockState(), 3);
    }
}