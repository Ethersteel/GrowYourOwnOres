package ethersteel.gyoo;

import ethersteel.gyoo.block.BlockOreStem;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

    public static BlockOreStem COAL_ORE_STEM = new BlockOreStem("coal_ore_stem",Blocks.COAL_ORE, EnumPlantType.Crop);
    public static BlockOreStem DIAMOND_ORE_STEM = new BlockOreStem("diamond_ore_stem",Blocks.DIAMOND_ORE, EnumPlantType.Crop);
    public static BlockOreStem EMERALD_ORE_STEM = new BlockOreStem("emerald_ore_stem",Blocks.EMERALD_ORE, EnumPlantType.Crop);
    public static BlockOreStem GLOWSTONE_ORE_STEM = new BlockOreStem("glowstone_ore_stem",Blocks.GLOWSTONE, EnumPlantType.Nether);
    public static BlockOreStem GOLD_ORE_STEM = new BlockOreStem("gold_ore_stem",Blocks.GOLD_ORE, EnumPlantType.Crop);
    public static BlockOreStem IRON_ORE_STEM = new BlockOreStem("iron_ore_stem",Blocks.IRON_ORE, EnumPlantType.Crop);
    public static BlockOreStem LAPIS_ORE_STEM = new BlockOreStem("lapis_ore_stem",Blocks.LAPIS_ORE, EnumPlantType.Crop);
    public static BlockOreStem QUARTZ_ORE_STEM = new BlockOreStem("quartz_ore_stem",Blocks.QUARTZ_ORE, EnumPlantType.Nether);
    public static BlockOreStem REDSTONE_ORE_STEM = new BlockOreStem("redstone_ore_stem",Blocks.REDSTONE_ORE, EnumPlantType.Crop);

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                // ...
                COAL_ORE_STEM,
                DIAMOND_ORE_STEM,
                EMERALD_ORE_STEM,
                GLOWSTONE_ORE_STEM,
                GOLD_ORE_STEM,
                IRON_ORE_STEM,
                LAPIS_ORE_STEM,
                QUARTZ_ORE_STEM,
                REDSTONE_ORE_STEM
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {

    }

    public static void registerModels() {

    }
}
