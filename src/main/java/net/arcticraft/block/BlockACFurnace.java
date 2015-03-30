package net.arcticraft.block;

import java.util.Random;

import javax.swing.Icon;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.tileentity.TileEntityArcticFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockACFurnace extends BlockContainer{

	private final Random furnaceRand = new Random();
	private final boolean isActive;
	/**
	 * This flag is used to prevent the furnace inventory to be dropped upon block removal, is used internally when the furnace block changes from idle to active and vice-versa.
	 */
	private static boolean keepFurnaceInventory = false;
	@SideOnly(Side.CLIENT)
	private IIcon furnaceIconTop;
	// private IIcon sideIcon;
	private IIcon furnaceIconFront;

	public BlockACFurnace(boolean isBurning){
		super(Material.rock);
		this.setHardness(3.5F);
		this.setStepSound(soundTypePiston);
		this.isActive = isBurning;
	}

	@Override
	public Item getItemDropped(int meta, Random random, int fortune)
	{
		return Item.getItemFromBlock(ACBlocks.arcticFurnaceIdle);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.setBlockFace(world, x, y, z);
	}

	private void setBlockFace(World world, int x, int y, int z)
	{
		if(!world.isRemote)
		{
			Block block = world.getBlock(x, y, z - 1);
			Block block1 = world.getBlock(x, y, z + 1);
			Block block2 = world.getBlock(x - 1, y, z);
			Block block3 = world.getBlock(x + 1, y, z);
			byte b0 = 3;

			if(block.func_149730_j() && !block1.func_149730_j())
			{
				b0 = 3;
			}

			if(block1.func_149730_j() && !block.func_149730_j())
			{
				b0 = 2;
			}

			if(block2.func_149730_j() && !block3.func_149730_j())
			{
				b0 = 5;
			}

			if(block3.func_149730_j() && !block2.func_149730_j())
			{
				b0 = 4;
			}

			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return meta == 0 && side == 3 ? this.furnaceIconFront : side == 1 ? this.furnaceIconTop : (side == 0 ? this.furnaceIconTop: (side ==  meta ? this.furnaceIconFront : this.blockIcon));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(Arcticraft.MOD_ID + ":ac_furnace_side");
		// this.furnaceIconFront = iconRegister.registerIcon(Arcticraft.MOD_ID + ":ac_furnace_front_off");
		this.furnaceIconTop = iconRegister.registerIcon(Arcticraft.MOD_ID + ":ac_furnace_top");
		this.furnaceIconFront = iconRegister.registerIcon(this.isActive ? Arcticraft.MOD_ID + ":ac_furnace_front_on" : Arcticraft.MOD_ID + ":ac_furnace_front_off");
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		if(tile_entity == null || player.isSneaking())
		{
			return false;
		}
		player.openGui(Arcticraft.arcticraftInstance, 1, world, x, y, z);
		return true;
	}

	/**
	 * Update which block the furnace is using depending on whether or not it is burning
	 */
	public static void updateFurnaceBlockState(boolean isBurning, World world, int x, int y, int z)
	{
		int l = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		keepFurnaceInventory = true;
		if(isBurning)
		{
			world.setBlock(x, y, z, ACBlocks.arcticFurnaceBurning);
		}
		else
		{
			world.setBlock(x, y, z, ACBlocks.arcticFurnaceIdle);
		}
		keepFurnaceInventory = false;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
		if(tileentity != null)
		{
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TileEntityArcticFurnace();
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an update, as appropriate
	 */
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemstack)
	{
		int l = MathHelper.floor_double((double) (entityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if(l == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if(l == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if(l == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if(l == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}

		if(itemstack.hasDisplayName())
		{
			((TileEntityArcticFurnace) world.getTileEntity(x, y, z)).func_94129_a(itemstack.getDisplayName());
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int p_149749_6_)
	{
		if(!keepFurnaceInventory)
		{
			TileEntityArcticFurnace tileentityfurnace = (TileEntityArcticFurnace) world.getTileEntity(x, y, z);

			if(tileentityfurnace != null)
			{
				for(int i1 = 0; i1 < tileentityfurnace.getSizeInventory(); ++i1)
				{
					ItemStack itemstack = tileentityfurnace.getStackInSlot(i1);

					if(itemstack != null)
					{
						float f = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

						while(itemstack.stackSize > 0)
						{
							int j1 = this.furnaceRand.nextInt(21) + 10;

							if(j1 > itemstack.stackSize)
							{
								j1 = itemstack.stackSize;
							}

							itemstack.stackSize -= j1;
							EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

							if(itemstack.hasTagCompound())
							{
								entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
							}

							float f3 = 0.05F;
							entityitem.motionX = (double) ((float) this.furnaceRand.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) this.furnaceRand.nextGaussian() * f3 + 0.2F);
							entityitem.motionZ = (double) ((float) this.furnaceRand.nextGaussian() * f3);
							world.spawnEntityInWorld(entityitem);
						}
					}
				}

				world.func_147453_f(x, y, z, block);
			}
		}

		super.breakBlock(world, x, y, z, block, p_149749_6_);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World world, int x, int y, int E, Random random)
	{
		if(this.isActive)
		{
			int l = world.getBlockMetadata(x, y, E);
			float f = (float) x + 0.5F;
			float f1 = (float) y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
			float f2 = (float) E + 0.5F;
			float f3 = 0.52F;
			float f4 = random.nextFloat() * 0.6F - 0.3F;

			if(l == 4)
			{
				world.spawnParticle("smoke", (double) (f - f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double) (f - f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
			}
			else if(l == 5)
			{
				world.spawnParticle("smoke", (double) (f + f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double) (f + f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
			}
			else if(l == 2)
			{
				world.spawnParticle("smoke", (double) (f + f4), (double) f1, (double) (f2 - f3), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double) (f + f4), (double) f1, (double) (f2 - f3), 0.0D, 0.0D, 0.0D);
			}
			else if(l == 3)
			{
				world.spawnParticle("smoke", (double) (f + f4), (double) f1, (double) (f2 + f3), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double) (f + f4), (double) f1, (double) (f2 + f3), 0.0D, 0.0D, 0.0D);
			}
		}
	}

	/**
	 * If this returns true, then comparators facing away from this block will use the value from getComparatorInputOverride instead of the actual redstone signal strength.
	 */
	@Override
	public boolean hasComparatorInputOverride()
	{
		return true;
	}

	/**
	 * If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal strength when this block inputs to a comparator.
	 */
	public int getComparatorInputOverride(World world, int x, int y, int z, int p_149736_5_)
	{
		return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
	}

	/**
	 * Gets an item for the block being called on. Args: world, x, y, z
	 */
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z)
	{
		return Item.getItemFromBlock(ACBlocks.arcticFurnaceIdle);
	}

}
