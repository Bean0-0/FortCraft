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
        simpleItem(ModItems.BANDAGE);
        simpleItem(ModItems.MEAT);
        simpleItem(ModItems.MEDKIT);

        simpleItem(ModItems.MINI);
        simpleItem(ModItems.BIGPOT);
        simpleItem(ModItems.SLURP_JUICE);
        simpleItem(ModItems.CHUG_JUG);

        simpleItem(ModItems.HOP_ROCK);
        simpleItem(ModItems.RIFT_TO_GO);


        //Weapons
        simpleItem(ModItems.AR_GUN);
        simpleItem(ModItems.SMG_GUN);
        simpleItem(ModItems.SHOTGUN);
        simpleItem(ModItems.SNIPER_GUN);

        handheldItem(ModItems.LC_Shovel);

        //Utility
        simpleItem(ModItems.GLIDER);
        simpleItem(ModItems.BLOCK_RIFT);
        simpleItem(ModItems.BLOCK_RIFT_KILL);

        //Building
        simpleItem(ModItems.BUILDING_WALL);
        simpleItem(ModItems.BUILDING_FLOOR);
        simpleItem(ModItems.BUILDING_STAIRS);
        simpleItem(ModItems.BUILDING_PYRAMID, "stick");

        simpleItem(ModItems.CHUGWU_MUSIC_DISC);
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
