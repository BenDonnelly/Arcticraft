package net.arcticraft.block;

import java.util.Random;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.entities.passive.EntityCaveman;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.tileentity.TileEntityCaveman;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCaveman extends BlockContainer{

	public BlockCaveman(Material material){
		super(material);
		this.setBlockName(Arcticraft.MOD_ID + "_caveman");
		this.setBlockTextureName(Arcticraft.MOD_ID + ":caveman_icon_dummy");
		this.setHardness(30.0F);
		this.setResistance(1000.0F);
		this.setTickRandomly(true);
		this.setBlockBounds(-0.25F, 0.0F, -0.25F, 1.25F, 2.0F, 1.25F);
		this.setCreativeTab(ACCreativeTabs.acTabBlock);
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int x, int y, int z, int meta)
	{
		return super.shouldSideBeRendered(iblockaccess, x, y, z, 1 - meta);
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta)
	{
		if(!world.isRemote)
		{
			EntityCaveman caveman = new EntityCaveman(world);
			caveman.setLocationAndAngles((double) x + 0.5D, (double) y, (double) z + 0.5D, 0.0F, 0.0F);
			world.spawnEntityInWorld(caveman);
		}
		super.onBlockDestroyedByPlayer(world, x, y, z, meta);
	}

	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		int randNum = random.nextInt(3 + 1);
		System.out.println("caveman block update");
		if(world.getSavedLightValue(EnumSkyBlock.Block, x, y, z) > 11 - this.getLightOpacity())
		{
			System.out.println("Number: " + randNum);
			if(!world.isRemote && randNum == 1)
			{
				world.setBlockToAir(x, y, z);
				EntityCaveman caveman = new EntityCaveman(world);
				caveman.setLocationAndAngles((double) x + 0.5D, (double) y, (double) z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(caveman);
			}
		}
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
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		if(world.getBlock(x, y - 1, z) == ACBlocks.frostGrass || world.getBlock(x, y - 1, z) == ACBlocks.frostWaterIce)
		{
			return true;
		}
		else
		{
			return false;
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

	@Override
	public TileEntity createNewTileEntity(World world, int something)
	{
		return new TileEntityCaveman();
	}

}
