package net.hudson.fortcraft.util;

public class ModData {
    int blockRiftTypeOfBlock;

    public int getTypeofBlock(){
        if(blockRiftTypeOfBlock>=3){
            blockRiftTypeOfBlock=0;
        }
        int types = blockRiftTypeOfBlock;
        blockRiftTypeOfBlock++;
        return types;
    }
}
