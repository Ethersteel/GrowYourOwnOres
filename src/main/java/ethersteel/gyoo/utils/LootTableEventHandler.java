package ethersteel.gyoo.utils;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class LootTableEventHandler {

    @SubscribeEvent
    public static void lootTableLoad(LootTableLoadEvent event) {
        if (event.getName() == LootTableList.CHESTS_SIMPLE_DUNGEON) {
            addPool(event.getTable());
        }

    }

    private static void addPool(LootTable table)
    {
        LootEntry seeds = new LootEntryTable(new ResourceLocation("gyoo:chests/simple_dungeon"), 60, 1, new LootCondition[0], "main");

        LootPool pool = new LootPool(new LootEntry[] { seeds }, new LootCondition[0], new RandomValueRange(0, 1), new RandomValueRange(0), "seeds");

        table.addPool(pool);
    }
}
