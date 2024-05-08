package net.hudson.fortcraft.item;

import net.hudson.fortcraft.FortCraft;
import net.hudson.fortcraft.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FortCraft.MOD_ID);


    public static final RegistryObject<Item> RIFT_DEVICE = ITEMS.register("rift_device",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MEAT = ITEMS.register("meat",
            () -> new Item(new Item.Properties().food(ModFoods.MEAT)));

    public static final RegistryObject<Item> BANDAGE = ITEMS.register("bandage",
            () -> new Item(new Item.Properties().food(ModFoods.BANDAGE)));

    public static final RegistryObject<Item> MEDKIT = ITEMS.register("medkit",
            () -> new Item(new Item.Properties().food(ModFoods.MEDKIT)));

    public static final RegistryObject<Item> CHUGWU_MUSIC_DISC = ITEMS.register("chugwu_music_disc",
            () -> new RecordItem(1, ModSounds.CHUGWU, new Item.Properties().stacksTo(1), 3280));

    public static final RegistryObject<Item> LC_Shovel = ITEMS.register("lc_shovel",
            () -> new SwordItem(ModToolTiers.LC,4,-2,new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
