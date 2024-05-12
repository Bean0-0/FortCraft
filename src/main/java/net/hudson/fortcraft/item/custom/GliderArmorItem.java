package net.hudson.fortcraft.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GliderArmorItem extends Item implements Equipable {
    public GliderArmorItem(Item.Properties pProperties) {
        super(pProperties);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    /**
     * Return whether this item is repairable in an anvil.
     */

    /**
     *
     */

    @Override
    public boolean canElytraFly(ItemStack stack, net.minecraft.world.entity.LivingEntity entity) {
        if (getDistanceFromGround(stack, entity) <=3) {
            removeElytra(stack,entity);
            return false;
        }
        return true;
    }
    public boolean removeElytra(ItemStack stack, net.minecraft.world.entity.LivingEntity entity){
        if (getDistanceFromGround(stack, entity) <= 1) {
            stack.shrink(1);
            return true;
        }
        return false;
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, net.minecraft.world.entity.LivingEntity entity, int flightTicks) {
        if (!entity.level().isClientSide) {
            int distFromGround = getDistanceFromGround(stack, entity);
            if (distFromGround <= 30) {
                entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 20, 5, false, false, false));
            }

            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
                if (nextFlightTick % 20 == 0) {
                    stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.CHEST));
                }
                entity.gameEvent(net.minecraft.world.level.gameevent.GameEvent.ELYTRA_GLIDE);
            }
        }
        return true;
    }


    public static boolean isFlyEnabled(ItemStack pElytraStack) {
        return pElytraStack.getDamageValue() < pElytraStack.getMaxDamage() - 1;
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(Items.PHANTOM_MEMBRANE);
    }

    /**
     * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
     */
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return this.swapWithEquipmentSlot(this, pLevel, pPlayer, pHand);
    }


    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_ELYTRA;
    }

    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.CHEST;
    }

    private int getDistanceFromGround(ItemStack stack, net.minecraft.world.entity.LivingEntity entity) {
        int distFromGround = 0;
        int i = 0;
        while (true) {
            BlockState blockstate = entity.level().getBlockState(new BlockPos(entity.getBlockX(), entity.getBlockY() + i, entity.getBlockZ()));
            Block block = blockstate.getBlock();
            if (block.getDescriptionId().equals("block.minecraft.air")) {
                i--;
            } else {
                distFromGround = entity.getBlockY() + i;
                break;
            }
        }
        return entity.getBlockY() - distFromGround;

    }
}