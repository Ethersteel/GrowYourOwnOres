package ethersteel.gyoo.item;

import ethersteel.gyoo.GYOOres;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemOreSeed extends ItemSeeds {

    protected String name;

    public ItemOreSeed(String name, Block crops, Block soil) {
        super(crops, soil);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(GYOOres.creativeTab);
    }

    public void registerItemModel() {
        GYOOres.proxy.registerItemRenderer(this, 0, name);
    }
}
