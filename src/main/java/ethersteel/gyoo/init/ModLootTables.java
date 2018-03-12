package ethersteel.gyoo.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class ModLootTables
{
    public static ResourceLocation simple_dungeon;

    public static void register()
    {
        simple_dungeon = register("chests/simple_dungeon");
    }

    private static ResourceLocation register(String id)
    {
        return LootTableList.register(new ResourceLocation("gyoo", id));
    }
}
