package ethersteel.gyoo;

import ethersteel.gyoo.block.BlockOreStem;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

    public static BlockOreStem IRON_ORE_STEM = new BlockOreStem("iron_ore_stem",Blocks.IRON_ORE);
    public static BlockOreStem GOLD_ORE_STEM = new BlockOreStem("gold_ore_stem",Blocks.GOLD_ORE);

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                // ...
                IRON_ORE_STEM,
                GOLD_ORE_STEM
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {

    }

    public static void registerModels() {

    }
}
