package net.arcticraft.block;

import java.util.Random;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.tileentity.TileEntityCampfire;
import net.arcticraft.tileentity.TileEntityCaptainStatue;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCaptainStatue extends BlockContainer{

	public BlockCaptainStatue(Material material){
		super(material);
		this.setBlockName(Arcticraft.MOD_ID + "_" + "captain_statue");
		this.setBlockTextureName(Arcticraft.MOD_ID + ":captain_statue_icon");
		this.setHardness(1.5F);
		this.setResistance(2.0F);
		this.setStepSound(Block.soundTypeWood);
		this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 3.0F, 0.9F);		
		this.setCreativeTab(ACCreativeTabs.acTabBlock);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack)
	{
		int l = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if(l == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if(l == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if(l == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		if(l == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}
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
	public TileEntity createNewTileEntity(World world, int id)
	{
		return new TileEntityCaptainStatue();
	}
}
