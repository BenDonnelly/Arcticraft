package net.arcticraft.block;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.item.ACItems;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.tileentity.TileEntityCannon;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCannon extends BlockContainer{

	protected BlockCannon(Material material){
		super(material);
		this.setHardness(5.0F);
		this.setResistance(5.0F);
		this.setBlockName(Arcticraft.MOD_ID + "_" + "cannon");
		this.setBlockTextureName(Arcticraft.MOD_ID + ":cannon");
		this.setStepSound(Block.soundTypeStone);
		this.setBlockBounds(-0.25F, 0.0F, -0.25F, 1.25F, 2.0F, 1.25F);
		this.setCreativeTab(ACCreativeTabs.acTabBlock);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are)
	{
		TileEntityCannon cannon = (TileEntityCannon) world.getTileEntity(x, y, z);
		ItemStack hand = player.getCurrentEquippedItem();
		if(!world.isRemote)
		{
			if(!cannon.isLoaded)
			{
				if(hand != null && hand.getItem() == ACItems.cannonball)
				{
					cannon.isLoaded = true;
					world.playSoundAtEntity(player, Arcticraft.MOD_ID + ":block.fuse", 1.5F, 1.5F);
				}
				if(!player.capabilities.isCreativeMode && hand != null && hand.getItem() == ACItems.cannonball)
				{
					hand.stackSize--;
				}
			}
		}
		return true;
	}

	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType()
	{
		return -2;
	}

	/**
	 * Is this block (a) opaque and (B) a full 1m cube? This determines whether or not to render the shared face of two adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemstack)
	{
		int l = MathHelper.floor_double((double) (entityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		int i1 = world.getBlockMetadata(x, y, z) >> 2;
		++l;
		l %= 4;
		if(l == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}
		if(l == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if(l == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if(l == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new TileEntityCannon();
	}
	
    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return world.getBlock(x, y, z).isReplaceable(world, x, y, z);
    }
}
