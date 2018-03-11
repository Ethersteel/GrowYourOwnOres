package ethersteel.gyoo.proxy;

import ethersteel.gyoo.ModBlocks;
import ethersteel.gyoo.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends ethersteel.gyoo.proxy.CommonProxy {

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ethersteel.gyoo.GYOOres.MODID + ":" + id, "inventory"));
    }

    @Override
    public void registerBlocks() {

        BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
        blockColors.registerBlockColorHandler(new IBlockColor()
        {
            @Override
            public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex)
            {
                int i = ((Integer)state.getValue(BlockStem.AGE)).intValue();
                int j = i * 64;
                int k = 255 - i * 8;
                int l = i * 4;
                return j << 16 | k << 8 | l;
            }
        }, ModBlocks.COAL_ORE_STEM, ModBlocks.DIAMOND_ORE_STEM, ModBlocks.EMERALD_ORE_STEM,
                ModBlocks.GLOWSTONE_ORE_STEM, ModBlocks.GOLD_ORE_STEM, ModBlocks.IRON_ORE_STEM,
                ModBlocks.LAPIS_ORE_STEM, ModBlocks.QUARTZ_ORE_STEM, ModBlocks.REDSTONE_ORE_STEM);
    }

    @Override
    public void registerItems() {

        ItemColors itemColors = Minecraft.getMinecraft().getItemColors();
        itemColors.registerItemColorHandler(new IItemColor()
        {
            public int colorMultiplier(ItemStack stack, int tintIndex)
            {
                return 16777215;
            }
        }, ModItems.IRON_ORE_SEEDS, ModItems.GOLD_ORE_SEEDS);
    }
}
