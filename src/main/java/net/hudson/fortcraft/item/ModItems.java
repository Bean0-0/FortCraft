package net.hudson.fortcraft.item;

import net.hudson.fortcraft.FortCraft;
import net.hudson.fortcraft.item.custom.*;
import net.hudson.fortcraft.item.custom.BuildingWallItem;
import net.hudson.fortcraft.sound.ModSounds;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> MINI = ITEMS.register("mini",
            () -> new Item(new Item.Properties().food(ModFoods.MINI)));

    public static final RegistryObject<Item> BIGPOT = ITEMS.register("bigpot",
            () -> new Item(new Item.Properties().food(ModFoods.BIGPOT)));

    public static final RegistryObject<Item> CHUG_JUG = ITEMS.register("chug_jug",
            () -> new Item(new Item.Properties().food(ModFoods.CHUG_JUG)));

    public static final RegistryObject<Item> SLURP_JUICE = ITEMS.register("slurp_juice",
            () -> new Item(new Item.Properties().food(ModFoods.SLURP_JUICE)));

    public static final RegistryObject<Item> HOP_ROCK = ITEMS.register("hop_rock",
            () -> new Item(new Item.Properties().food(ModFoods.HOP_ROCK)));

    public static final RegistryObject<Item> RIFT_TO_GO = ITEMS.register("rift_to_go",
            () ->  new RiftToGoItem((new Item.Properties()).food(ModFoods.RIFT_TO_GO)));

    public static final RegistryObject<Item> CHUGWU_MUSIC_DISC = ITEMS.register("chugwu_music_disc",
            () -> new RecordItem(1, ModSounds.CHUGWU, new Item.Properties().stacksTo(1), 3280));

    public static final RegistryObject<Item> LC_Shovel = ITEMS.register("lc_shovel",
            () -> new SwordItem(ModToolTiers.LC,4,-2,new Item.Properties()));

    public static final RegistryObject<Item> AR_GUN = ITEMS.register("ar_gun",
            () -> new ArGunItem(new Item.Properties().durability(60)));

    public static final RegistryObject<Item> SMG_GUN = ITEMS.register("smg_gun",
            () -> new SmgGunItem(new Item.Properties().durability(60)));

    public static final RegistryObject<Item> SHOTGUN = ITEMS.register("shotgun",
            () -> new ShotgunItem(new Item.Properties().durability(12)));

    public static final RegistryObject<Item> SNIPER_GUN= ITEMS.register("sniper_gun",
            () -> new SniperGunItem(new Item.Properties().durability(4)));

    public static final RegistryObject<Item> GLIDER= ITEMS.register("glider",
            () -> new GliderArmorItem(new Item.Properties()));

    public static final RegistryObject<Item> BLOCK_RIFT= ITEMS.register("block_rift",
            () -> new BlockRiftItem(new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_RIFT_KILL= ITEMS.register("block_rift_kill",
            () -> new BlockRiftKillItem(new Item.Properties()));

    public static final RegistryObject<Item> BUILDING_WALL = ITEMS.register("building_wall",
            () -> new BuildingWallItem(new Item.Properties()));

    public static final RegistryObject<Item> BUILDING_FLOOR = ITEMS.register("building_floor",
            () -> new BuildingFloorItem(new Item.Properties()));

    public static final RegistryObject<Item> BUILDING_STAIRS = ITEMS.register("building_stairs",
            () -> new BuildingStairsItem(new Item.Properties()));

    public static final RegistryObject<Item> BUILDING_PYRAMID = ITEMS.register("building_pyramid",
            () -> new BuildingPyramidItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
