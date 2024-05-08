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
        simpleItem(ModItems.BANDAGE,"string");
        simpleItem(ModItems.MEAT,"leather");
        simpleItem(ModItems.CHUGWU_MUSIC_DISC,"stick");
        simpleItem(ModItems.MEDKIT,"book");
        simpleItem(ModItems.RIFT_DEVICE);

        handheldItem(ModItems.LC_Shovel,"stick");
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
