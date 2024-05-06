package net.hudson.fortcraft.block.entity;

import net.hudson.fortcraft.block.entity.util.TickableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GemPolishingStationBlockEntity extends BlockEntity implements TickableBlockEntity {
    private int ticks;

    public GemPolishingStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GEM_POLISHING_BE.get(), pos, state);
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
