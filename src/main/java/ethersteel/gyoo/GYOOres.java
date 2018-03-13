package ethersteel.gyoo;

import ethersteel.gyoo.proxy.CommonProxy;
import ethersteel.gyoo.utils.LootTableEventHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = GYOOres.MODID, name = GYOOres.NAME, version = GYOOres.VERSION)
public class GYOOres
{
    public static final String MODID = "gyoo";
    public static final String NAME = "Grow Your Own : Ores";
    public static final String VERSION = "1.0";

    @Mod.Instance
    public static GYOOres instance;

    private static Logger logger;

    public static final ModCreativeTab creativeTab = new ModCreativeTab();

    @SidedProxy(serverSide = "ethersteel.gyoo.proxy.CommonProxy", clientSide = "ethersteel.gyoo.proxy.ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(new LootTableEventHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerBlocks();
        proxy.registerItems();
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerModels();
        }

    }
}
