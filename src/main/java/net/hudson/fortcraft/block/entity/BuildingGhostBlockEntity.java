package net.hudson.fortcraft.block.entity;

import net.hudson.fortcraft.block.entity.util.TickableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BuildingGhostBlockEntity extends BlockEntity implements TickableBlockEntity {
    private int ticks;

    public BuildingGhostBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BUILDING_GHOST_BE.get(), pos, state);
    }

    @Override
    public void tick() {
        if(this.level == null || this.level.isClientSide())
            return;

        if(this.ticks++ == 5) {
            this.level.removeBlock(this.getBlockPos(), false);
        }
    }
}
