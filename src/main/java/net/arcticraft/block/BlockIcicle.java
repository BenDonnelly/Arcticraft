package net.arcticraft.block;

import java.util.List;
import java.util.Random;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.tileentity.TileEntityIcicle;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIcicle extends BlockContainer{

	public static final String[] icicles = new String[] {"large", "regular", "small", "largeUD", "regularUD", "smallUD"};
	public static final String[] iciclesTextures = new String[] {"icicle", "icicle", "icicle", "icicle_ud", "icicle_ud", "icicle_ud"};
	@SideOnly(Side.CLIENT)
	private IIcon[] texture;

	protected BlockIcicle(Material material){
		super(material);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setBlockName(Arcticraft.MOD_ID + "_icicle");
		this.setBlockTextureName(Arcticraft.MOD_ID + ":icicle");
		this.setCreativeTab(ACCreativeTabs.acTabBlock);
		this.setBlockBounds(0, 0, 0, 1, 1.5F, 1);
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
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int x, int y, int z, int meta)
	{
		return super.shouldSideBeRendered(iblockaccess, x, y, z, 1 - meta);
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return -2;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < icicles.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int id)
	{
		return new TileEntityIcicle(id, 0);
	}
}
