package net.arcticraft.block;

import static net.arcticraft.main.Arcticraft.MOD_ID;

import java.util.ArrayList;
import java.util.Random;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.API.item.ItemACSword;
import net.arcticraft.item.ACItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFrostWaterIce extends BlockBreakable{

	Random rand;

	public BlockFrostWaterIce(){
		super("ice", Material.ice, false);
		rand = new Random();
		this.setBlockName(MOD_ID + "_frostWaterIce");
		this.setHardness(0.5F);
		this.setStepSound(soundTypeGlass);
        this.slipperiness = 0.98F;
		this.setTickRandomly(true);
		this.setCreativeTab(ACCreativeTabs.acTabBlock);
	}

	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}

	/**
	 * Returns the mobility information of the block, 0 = free, 1 = can't push but can move over, 2 = total immobility and stop pistons
	 */
	@Override
	public int getMobilityFlag()
	{
		return 0;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random rand)
	{
		return 0;
	}

	/**
	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given coordinates. Args: blockAccess, x, y, z, side
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		return super.shouldSideBeRendered(blockAccess, x, y, z, 1 - side);
	}


	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
	{
		if(!world.isRemote)
		{
			ItemStack hand = player.getCurrentEquippedItem();
			if(hand != null && hand.getItem() instanceof ItemACSword)
			{
				int r = rand.nextInt(25);
				int r2 = rand.nextInt(4) + 1;
				System.out.println("r: " + r + " r2: " + r2);
				hand.damageItem(1, player);
				if(r == 3)
				{
					world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ACItems.iceChunk, r2)));
				}
			}
		}
	}

	@Override
	public void harvestBlock(World world, EntityPlayer entityPlayer, int x, int y, int z, int p_149636_6_)
	{
		entityPlayer.addStat(StatList.mineBlockStatArray[Block.getIdFromBlock(this)], 1);
		entityPlayer.addExhaustion(0.025F);

		if(this.canSilkHarvest(world, entityPlayer, x, y, z, p_149636_6_) && EnchantmentHelper.getSilkTouchModifier(entityPlayer))
		{
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			ItemStack itemstack = this.createStackedBlock(p_149636_6_);

			if(itemstack != null) items.add(itemstack);

			ForgeEventFactory.fireBlockHarvesting(items, world, this, x, y, z, p_149636_6_, 0, 1.0f, true, entityPlayer);
			for(ItemStack is : items)
				this.dropBlockAsItem(world, x, y, z, is);
		}
		else
		{
			if(world.provider.isHellWorld)
			{
				world.setBlockToAir(x, y, z);
				return;
			}

			int i1 = EnchantmentHelper.getFortuneModifier(entityPlayer);
			harvesters.set(entityPlayer);
			this.dropBlockAsItem(world, x, y, z, p_149636_6_, i1);
			harvesters.set(null);
			Material material = world.getBlock(x, y - 1, z).getMaterial();

			if(material.blocksMovement() || material.isLiquid())
			{
				world.setBlock(x, y, z, ACBlocks.frostWaterBlock);
			}
		}
	}
}
