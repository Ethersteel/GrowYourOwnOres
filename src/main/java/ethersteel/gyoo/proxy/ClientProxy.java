package ethersteel.gyoo.proxy;

import ethersteel.gyoo.utils.ColorHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;


@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends ethersteel.gyoo.proxy.CommonProxy {

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ethersteel.gyoo.GYOOres.MODID + ":" + id, "inventory"));
    }

    @Override
    public void registerBlocks() {
        ColorHelper.init();
    }

    @Override
    public void registerItems() {
        ColorHelper.init(Minecraft.getMinecraft().getBlockColors());
    }
}
