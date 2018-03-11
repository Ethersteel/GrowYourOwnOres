package ethersteel.gyoo.item;

import ethersteel.gyoo.GYOOres;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.math.BlockPos;

public class ItemOreSeed extends ItemSeeds {

    protected String name;
    protected final Block crops;
    protected final Block soilBlockID;

    public ItemOreSeed(String name, Block crops, Block soil) {
        super(crops, soil);
        this.name = name;
        this.crops = crops;
        this.soilBlockID = soil;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(GYOOres.creativeTab);
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return this.soilBlockID == Blocks.SOUL_SAND ? net.minecraftforge.common.EnumPlantType.Nether : net.minecraftforge.common.EnumPlantType.Crop;
    }

    public void registerItemModel() {
        GYOOres.proxy.registerItemRenderer(this, 0, name);
    }
}
