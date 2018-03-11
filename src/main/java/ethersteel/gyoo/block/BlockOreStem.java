package ethersteel.gyoo.block;

import ethersteel.gyoo.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockOreStem extends BlockStem {

    private final Block crop;

    public BlockOreStem(String name, Block crop) {
        super(crop);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)).withProperty(FACING, EnumFacing.UP));
        this.crop = crop;
        this.setTickRandomly(true);
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    @Nullable
    @Override
    protected Item getSeedItem()
    {
        if (this.crop == Blocks.COAL_ORE){return ModItems.COAL_ORE_SEEDS;}
        if (this.crop == Blocks.DIAMOND_ORE){return ModItems.DIAMOND_ORE_SEEDS;}
        if (this.crop == Blocks.EMERALD_ORE){return ModItems.EMERALD_ORE_SEEDS;}
        if (this.crop == Blocks.GLOWSTONE){return ModItems.GLOWSTONE_ORE_SEEDS;}
        if (this.crop == Blocks.GOLD_ORE){return ModItems.GOLD_ORE_SEEDS;}
        if (this.crop == Blocks.IRON_ORE){return ModItems.IRON_ORE_SEEDS;}
        if (this.crop == Blocks.LAPIS_ORE){return ModItems.LAPIS_ORE_SEEDS;}
        if (this.crop == Blocks.QUARTZ_ORE){return ModItems.QUARTZ_ORE_SEEDS;}
        if (this.crop == Blocks.REDSTONE_ORE){return ModItems.REDSTONE_ORE_SEEDS;}
        return null;
    }

    @Override
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        {
            Item item = this.getSeedItem();

            if (item != null)
            {
                drops.add(new ItemStack(item));
            }
        }
    }

    @Override
    public void growStem(World worldIn, BlockPos pos, IBlockState state)
    {
        int i = state.getValue(AGE) + MathHelper.getInt(worldIn.rand, 1, 2);
        worldIn.setBlockState(pos, state.withProperty(AGE, Math.min(7, i)), 2);
    }
}
