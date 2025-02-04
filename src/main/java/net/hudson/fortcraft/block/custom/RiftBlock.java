package net.hudson.fortcraft.block.custom;

import net.hudson.fortcraft.worldgen.dimension.ModDimensions;
import net.hudson.fortcraft.worldgen.portal.ModTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class RiftBlock extends Block {
    public RiftBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.canChangeDimensions()) {
            handleHudsonPortal(pPlayer, pPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }

    private void handleHudsonPortal(Entity player, BlockPos pPos) {
        if (player.level() instanceof ServerLevel serverlevel) {
            System.out.println("a");
            MinecraftServer minecraftserver = serverlevel.getServer();
            ResourceKey<Level> resourcekey = player.level().dimension() == ModDimensions.FORTCRAFT_LEVEL_KEY ?
                    Level.OVERWORLD : ModDimensions.FORTCRAFT_LEVEL_KEY;

            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
            System.out.println(portalDimension);
            if (portalDimension != null && !player.isPassenger()) {
                System.out.println("b");
                if(resourcekey == ModDimensions.FORTCRAFT_LEVEL_KEY) {
                    System.out.println("c");
                    player.changeDimension(portalDimension, new ModTeleporter(pPos, true));
                } else {
                    System.out.println("d");
                    player.changeDimension(portalDimension, new ModTeleporter(pPos, false));
                }
            }
        }
    }
}