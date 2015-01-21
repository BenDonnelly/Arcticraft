package net.arcticraft.block;

import net.arcticraft.block.creativetabs.ACCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAC extends Block
{
	/** 'Override' the constructor in block,
	 * as it is protected and we need to use it. */
	protected BlockAC(Material material)
	{
		super(material);
		this.setCreativeTab(ACCreativeTabs.acTabBlock);
	}
}