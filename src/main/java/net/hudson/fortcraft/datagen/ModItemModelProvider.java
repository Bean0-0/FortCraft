package net.hudson.fortcraft.datagen;

import net.hudson.fortcraft.FortCraft;
import net.hudson.fortcraft.block.ModBlocks;
import net.hudson.fortcraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, FortCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Foods
        simpleItem(ModItems.BANDAGE,"string");
        simpleItem(ModItems.MEAT,"leather");
        simpleItem(ModItems.MEDKIT,"book");

        simpleItem(ModItems.MINI,"egg");
        simpleItem(ModItems.BIGPOT,"water_bucket");
        simpleItem(ModItems.SLURP_JUICE,"potato");
        simpleItem(ModItems.CHUG_JUG,"apple");

        simpleItem(ModItems.HOP_ROCK,"amethyst_shard");
        simpleItem(ModItems.RIFT_TO_GO,"nether_star");


        //Weapons
        simpleItem(ModItems.AR_GUN,"gold_ingot");
        simpleItem(ModItems.SMG_GUN,"diamond");
        simpleItem(ModItems.SHOTGUN,"gold_ingot");
        simpleItem(ModItems.SNIPER_GUN,"spyglass");

        handheldItem(ModItems.LC_Shovel,"stick");

        //Utility
        simpleItem(ModItems.GLIDER,"string");

        //Other
        simpleItem(ModItems.BLOCK_RIFT,"amethyst_shard");
        simpleItem(ModItems.BLOCK_RIFT_KILL,"stick");

        simpleItem(ModItems.CHUGWU_MUSIC_DISC,"stick");
        simpleItem(ModItems.RIFT_DEVICE);


    }

    //handheld item
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(FortCraft.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item,String minecraftTexture){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation("minecraft", "item/"+minecraftTexture));
    }

    //regular item
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FortCraft.MOD_ID, "item/"+item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item,String minecraftTexture){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation("minecraft", "item/"+minecraftTexture));
    }
}
