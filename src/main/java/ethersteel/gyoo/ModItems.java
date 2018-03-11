package ethersteel.gyoo;

import ethersteel.gyoo.item.ItemOreSeed;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    public static ItemOreSeed COAL_ORE_SEEDS = new ItemOreSeed("coal_ore_seeds", ModBlocks.COAL_ORE_STEM, Blocks.FARMLAND);
    public static ItemOreSeed DIAMOND_ORE_SEEDS = new ItemOreSeed("diamond_ore_seeds", ModBlocks.DIAMOND_ORE_STEM, Blocks.FARMLAND);
    public static ItemOreSeed EMERALD_ORE_SEEDS = new ItemOreSeed("emerald_ore_seeds", ModBlocks.EMERALD_ORE_STEM, Blocks.FARMLAND);
    public static ItemOreSeed GLOWSTONE_ORE_SEEDS = new ItemOreSeed("glowstone_ore_seeds", ModBlocks.GLOWSTONE_ORE_STEM, Blocks.SOUL_SAND);
    public static ItemOreSeed GOLD_ORE_SEEDS = new ItemOreSeed("gold_ore_seeds", ModBlocks.GOLD_ORE_STEM, Blocks.FARMLAND);
    public static ItemOreSeed IRON_ORE_SEEDS = new ItemOreSeed("iron_ore_seeds", ModBlocks.IRON_ORE_STEM, Blocks.FARMLAND);
    public static ItemOreSeed LAPIS_ORE_SEEDS = new ItemOreSeed("lapis_ore_seeds", ModBlocks.LAPIS_ORE_STEM, Blocks.FARMLAND);
    public static ItemOreSeed QUARTZ_ORE_SEEDS = new ItemOreSeed("quartz_ore_seeds", ModBlocks.QUARTZ_ORE_STEM, Blocks.SOUL_SAND);
    public static ItemOreSeed REDSTONE_ORE_SEEDS = new ItemOreSeed("redstone_ore_seeds", ModBlocks.REDSTONE_ORE_STEM, Blocks.FARMLAND);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                // ...
                COAL_ORE_SEEDS,
                DIAMOND_ORE_SEEDS,
                EMERALD_ORE_SEEDS,
                GLOWSTONE_ORE_SEEDS,
                GOLD_ORE_SEEDS,
                IRON_ORE_SEEDS,
                LAPIS_ORE_SEEDS,
                QUARTZ_ORE_SEEDS,
                REDSTONE_ORE_SEEDS
        );
    }

    public static void registerModels() {

        COAL_ORE_SEEDS.registerItemModel();
        DIAMOND_ORE_SEEDS.registerItemModel();
        EMERALD_ORE_SEEDS.registerItemModel();
        GLOWSTONE_ORE_SEEDS.registerItemModel();
        GOLD_ORE_SEEDS.registerItemModel();
        IRON_ORE_SEEDS.registerItemModel();
        LAPIS_ORE_SEEDS.registerItemModel();
        QUARTZ_ORE_SEEDS.registerItemModel();
        REDSTONE_ORE_SEEDS.registerItemModel();
    }
}
