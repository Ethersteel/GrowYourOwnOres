package ethersteel.gyoo.item;

import ethersteel.gyoo.GYOOres;
import ethersteel.gyoo.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;

public class ItemOreSeed extends ItemSeeds {

    private String name;
    private final Block crops;
    private final Block soilBlockID;
    private static HashMap<String, Item> hashmap = new HashMap<>();

    public ItemOreSeed(String name, Block crops, Block soil) {
        super(crops, soil);
        this.name = name;
        this.crops = crops;
        this.soilBlockID = soil;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(GYOOres.creativeTab);

        hashmap.put("minecraft:coal_ore", ModItems.COAL_ORE_SEEDS);
        hashmap.put("minecraft:iron_ore", ModItems.IRON_ORE_SEEDS);
        hashmap.put("minecraft:gold_ore", ModItems.GOLD_ORE_SEEDS);
        hashmap.put("minecraft:diamond_ore", ModItems.DIAMOND_ORE_SEEDS);
        hashmap.put("minecraft:emerald_ore", ModItems.EMERALD_ORE_SEEDS);
        hashmap.put("minecraft:lit_redstone_ore", ModItems.REDSTONE_ORE_SEEDS);
        hashmap.put("minecraft:lapis_ore", ModItems.LAPIS_ORE_SEEDS);
        hashmap.put("minecraft:glowstone_ore", ModItems.GLOWSTONE_ORE_SEEDS);
        hashmap.put("minecraft:quartz_ore", ModItems.QUARTZ_ORE_SEEDS);
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);
        net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
        if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up()))
        {
            worldIn.setBlockState(pos.up(), this.crops.getDefaultState());

            if (player instanceof EntityPlayerMP)
            {
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos.up(), itemstack);
            }

            itemstack.shrink(1);
            return EnumActionResult.SUCCESS;
        }
        else if(state.getBlock().getRegistryName().toString().contains("ore")){

            //System.out.println("Unlocalized Name >> "+state.getBlock().getUnlocalizedName());
            //System.out.println("Registry Name >> "+state.getBlock().getRegistryName());

            EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(getSeedFromOre(state.getBlock().getRegistryName().toString()), 1));
            if (!worldIn.isRemote) {
                worldIn.destroyBlock(pos, false);
                worldIn.spawnEntity(item);
            }
            itemstack.shrink(1);
            return EnumActionResult.SUCCESS;
        }
        else
        {
            return EnumActionResult.FAIL;
        }
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return this.soilBlockID == Blocks.SOUL_SAND ? net.minecraftforge.common.EnumPlantType.Nether : net.minecraftforge.common.EnumPlantType.Crop;
    }

    public void registerItemModel() {
        GYOOres.proxy.registerItemRenderer(this, 0, name);
    }

    public Item getSeedFromOre(String ore){

        if(ore.equals("minecraft:lit_redstone_ore")){
            return ModItems.REDSTONE_ORE_SEEDS;
        }else{
            return hashmap.get(ore);
        }
    }
}
