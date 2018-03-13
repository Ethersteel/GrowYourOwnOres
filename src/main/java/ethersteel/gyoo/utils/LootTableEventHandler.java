package ethersteel.gyoo.utils;

import ethersteel.gyoo.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

@Mod.EventBusSubscriber
public class LootTableEventHandler {

    public Random rng = new Random();

    @SubscribeEvent
    public void lootTableLoad(LootTableLoadEvent event) {

        if (event.getName() == (LootTableList.CHESTS_SIMPLE_DUNGEON)) {
            addPool(event.getTable());
        }
        if (event.getName() == (LootTableList.CHESTS_VILLAGE_BLACKSMITH)) {
            addPool(event.getTable());
        }
        if (event.getName() == (LootTableList.CHESTS_ABANDONED_MINESHAFT)) {
            addPool(event.getTable());
        }
        if (event.getName() == (LootTableList.CHESTS_DESERT_PYRAMID)) {
            addPool(event.getTable());
        }
        if (event.getName() == (LootTableList.CHESTS_JUNGLE_TEMPLE)) {
            addPool(event.getTable());
        }
        if (event.getName() == (LootTableList.CHESTS_NETHER_BRIDGE)) {
            addPool(event.getTable());
        }
        if (event.getName() == (LootTableList.CHESTS_WOODLAND_MANSION)) {
            addPool(event.getTable());
        }
    }

    private void addPool(LootTable table)
    {
        LootEntry seeds = new LootEntryTable(new ResourceLocation("gyoo:chests/simple_dungeon"), 60, 1, new LootCondition[0], "main");

        LootPool pool = new LootPool(new LootEntry[] { seeds }, new LootCondition[0], new RandomValueRange(0, 1), new RandomValueRange(0), "seeds");

        table.addPool(pool);
    }

    @SubscribeEvent
    public void playerHarvestEvent(BlockEvent.HarvestDropsEvent event) {

        if(rng.nextInt(100)<=5){

            if (event.getHarvester() != null) {

                if (event.getState() == Blocks.COAL_ORE.getDefaultState()) {
                    event.getDrops().add(new ItemStack(ModItems.COAL_ORE_SEEDS, 1));
                }
                if (event.getState() == Blocks.DIAMOND_ORE.getDefaultState()) {
                    event.getDrops().add(new ItemStack(ModItems.DIAMOND_ORE_SEEDS, 1));
                }
                if (event.getState() == Blocks.EMERALD_ORE.getDefaultState()) {
                    event.getDrops().add(new ItemStack(ModItems.EMERALD_ORE_SEEDS, 1));
                }
                if (event.getState() == Blocks.GLOWSTONE.getDefaultState()) {
                    event.getDrops().add(new ItemStack(ModItems.GLOWSTONE_ORE_SEEDS, 1));
                }
                if (event.getState() == Blocks.GOLD_ORE.getDefaultState()) {
                    event.getDrops().add(new ItemStack(ModItems.GOLD_ORE_SEEDS, 1));
                }
                if (event.getState() == Blocks.IRON_ORE.getDefaultState()) {
                    event.getDrops().add(new ItemStack(ModItems.IRON_ORE_SEEDS, 1));
                }
                if (event.getState() == Blocks.LAPIS_ORE.getDefaultState()) {
                    event.getDrops().add(new ItemStack(ModItems.LAPIS_ORE_SEEDS, 1));
                }
                if (event.getState() == Blocks.QUARTZ_ORE.getDefaultState()) {
                    event.getDrops().add(new ItemStack(ModItems.QUARTZ_ORE_SEEDS, 1));
                }
                if (event.getState() == Blocks.LIT_REDSTONE_ORE.getDefaultState()) {
                    event.getDrops().add(new ItemStack(ModItems.REDSTONE_ORE_SEEDS, 1));
                }

            }
        }
    }
}
