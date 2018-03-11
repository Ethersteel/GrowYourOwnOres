package ethersteel.gyoo.utils;

import ethersteel.gyoo.ModBlocks;
import ethersteel.gyoo.ModItems;
import ethersteel.gyoo.block.BlockOreStem;
import net.minecraft.block.BlockStem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ColorHelper {

    public static BlockColors init(){
        BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
        blockColors.registerBlockColorHandler((state, worldIn, pos, tintIndex) -> {
            int i = state.getValue(BlockOreStem.AGE);
            int j = i * 16;
            int k = 255 - i * 8;
            int l = i * 4;
            return j << 16 | k << 8 | l;
        }, ModBlocks.COAL_ORE_STEM, ModBlocks.DIAMOND_ORE_STEM, ModBlocks.EMERALD_ORE_STEM,
                ModBlocks.GLOWSTONE_ORE_STEM, ModBlocks.GOLD_ORE_STEM, ModBlocks.IRON_ORE_STEM,
                ModBlocks.LAPIS_ORE_STEM, ModBlocks.QUARTZ_ORE_STEM, ModBlocks.REDSTONE_ORE_STEM);
        net.minecraftforge.client.ForgeHooksClient.onBlockColorsInit(blockColors);
        return blockColors;
    }

    public static ItemColors init(final BlockColors colors){
        ItemColors itemColors = Minecraft.getMinecraft().getItemColors();
        //Coal Seed Color
        itemColors.registerItemColorHandler((stack, tintIndex) -> 4144959, ModItems.COAL_ORE_SEEDS);
        //Diamond Seed Color
        itemColors.registerItemColorHandler((stack, tintIndex) -> 6155509, ModItems.DIAMOND_ORE_SEEDS);
        //Emerald Seed Color
        itemColors.registerItemColorHandler((stack, tintIndex) -> 1564002, ModItems.EMERALD_ORE_SEEDS);
        //Glowstone Seed Color
        itemColors.registerItemColorHandler((stack, tintIndex) -> 16759902, ModItems.GLOWSTONE_ORE_SEEDS);
        //Gold Seed Color
        itemColors.registerItemColorHandler((stack, tintIndex) -> 16576075, ModItems.GOLD_ORE_SEEDS);
        //Iron Seed Color
        itemColors.registerItemColorHandler((stack, tintIndex) -> 14200723, ModItems.IRON_ORE_SEEDS);
        //Lapis Seed Color
        itemColors.registerItemColorHandler((stack, tintIndex) -> 1393356, ModItems.LAPIS_ORE_SEEDS);
        //Quartz Seed Color
        itemColors.registerItemColorHandler((stack, tintIndex) -> 15129293, ModItems.QUARTZ_ORE_SEEDS);
        //Redstone Seed Color
        itemColors.registerItemColorHandler((stack, tintIndex) -> 16711680, ModItems.REDSTONE_ORE_SEEDS);
        net.minecraftforge.client.ForgeHooksClient.onItemColorsInit(itemColors, colors);
        return itemColors;
    }
}
