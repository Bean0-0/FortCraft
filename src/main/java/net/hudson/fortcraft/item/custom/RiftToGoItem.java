package net.hudson.fortcraft.item.custom;

import net.hudson.fortcraft.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityTeleportEvent;

public class RiftToGoItem extends Item {
    public RiftToGoItem(Item.Properties pProperties) {
        super(pProperties);
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        ItemStack itemstack = super.finishUsingItem(pStack, pLevel, pEntityLiving);
        if (!pLevel.isClientSide) {
            double d0 = pEntityLiving.getX();
            double d1 = pEntityLiving.getY();
            double d2 = pEntityLiving.getZ();

            double d3 = pEntityLiving.getX();
            double d4 = pLevel.getMaxBuildHeight()-4;
            double d5 = pEntityLiving.getZ();

            pEntityLiving.teleportTo(d3,d4,d5);
                Vec3 vec3 = pEntityLiving.position();
                pLevel.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(pEntityLiving));
                SoundEvent soundevent = pEntityLiving instanceof Fox ? SoundEvents.FOX_TELEPORT : SoundEvents.CHORUS_FRUIT_TELEPORT;
                pLevel.playSound((Player) null, d0, d1, d2, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                pEntityLiving.playSound(soundevent, 1.0F, 1.0F);

            }

            if (pEntityLiving instanceof Player) {
                ((Player) pEntityLiving).getCooldowns().addCooldown(this, 80);
                ((Player) pEntityLiving).setItemSlot(EquipmentSlot.CHEST,new ItemStack(ModItems.GLIDER.get()));

            }


        return itemstack;
    }
}
