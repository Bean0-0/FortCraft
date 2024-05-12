package net.hudson.fortcraft.item.custom;

import net.hudson.fortcraft.sound.ModSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.function.Predicate;

public class ArGunItem extends ProjectileWeaponItem implements Vanishable {

    public ArGunItem(Properties pProperties) {
        super(pProperties);
    }

    public static final int MAX_DRAW_DURATION = 5;
    public static final int DEFAULT_RANGE = 10;
    private int firing = 0;
    private final int fire_rate = 10;
    private boolean reset_firing =false;

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(pIsSelected && pEntity instanceof Player player) {
            if(!pLevel.isClientSide()) {
                System.out.println(firing);
                if(firing <fire_rate+1) {
                    firing++;
                }
                if(reset_firing){
                    firing = 0;
                    reset_firing = false;
                }
            }

        }
        else{
            firing =0;
            reset_firing = false;
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {

            ItemStack pStack = pPlayer.getItemInHand(pHand);
            boolean flag = !pPlayer.getProjectile(pStack).isEmpty();
            ItemStack itemstack = pPlayer.getProjectile(pStack);
            float f = 3.0F;
        if(firing>=fire_rate) {
                if (!itemstack.isEmpty() || flag) {
                    if (itemstack.isEmpty()) {
                        itemstack = new ItemStack(Items.ARROW);
                    }


                    if (!((double) f < 0.1D)) {
                        boolean flag1 = pPlayer.getAbilities().instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem) itemstack.getItem()).isInfinite(itemstack, pStack, pPlayer));
                        if (!pLevel.isClientSide) {
                            ArrowItem arrowitem = (ArrowItem) (itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                            AbstractArrow abstractarrow = arrowitem.createArrow(pLevel, itemstack, pPlayer);
                            abstractarrow = customArrow(abstractarrow);
                            f *= 3.0F;
                            abstractarrow.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 3.0F, 2.0F);

                            if (f == 1.0F) {
                                abstractarrow.setCritArrow(true);
                            }


                            pStack.hurtAndBreak(1, pPlayer, (p_289501_) -> {
                                p_289501_.broadcastBreakEvent(pPlayer.getUsedItemHand());
                            });

                            pLevel.addFreshEntity(abstractarrow);
                        }

                        pLevel.playSound((Player) null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), ModSounds.AR_SHOT.get(), SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                        if (!flag1 && !pPlayer.getAbilities().instabuild) {
                            itemstack.shrink(1);
                            if (itemstack.isEmpty()) {
                                pPlayer.getInventory().removeItem(itemstack);
                            }
                        }

                }
                    reset_firing = true;
                }
            }
            return InteractionResultHolder.sidedSuccess(pStack, pLevel.isClientSide());
        }





    /**
     * Gets the velocity of the arrow entity from the bow's charge
     */

    /**
     * How long it takes to use or consume an item
     */
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    /**
     * Returns the action that specifies what animation to play when the item is being used.
     */
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }





    /**
     * Get the predicate to match ammunition when searching the player's inventory, not their main/offhand
     */
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    public AbstractArrow customArrow(AbstractArrow arrow) {
        return arrow;
    }

    public int getDefaultProjectileRange() {
        return 15;
    }
}


