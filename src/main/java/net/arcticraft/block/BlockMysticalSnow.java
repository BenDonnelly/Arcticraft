package net.arcticraft.block;

import net.arcticraft.block.creativetabs.ACCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMysticalSnow extends Block{

	protected BlockMysticalSnow(Material material){
		super(material);
		this.setCreativeTab(ACCreativeTabs.acTabBlock);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
		return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
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

}
