package ethersteel.gyoo;

import ethersteel.gyoo.item.ItemOreSeed;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    public static ItemOreSeed IRON_ORE_SEEDS = new ItemOreSeed("iron_ore_seeds", ModBlocks.IRON_ORE_STEM);
    public static ItemOreSeed GOLD_ORE_SEEDS = new ItemOreSeed("gold_ore_seeds", ModBlocks.GOLD_ORE_STEM);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                // ...
                IRON_ORE_SEEDS,
                GOLD_ORE_SEEDS
        );
    }

    public static void registerModels() {

        IRON_ORE_SEEDS.registerItemModel();
        GOLD_ORE_SEEDS.registerItemModel();
    }
}
