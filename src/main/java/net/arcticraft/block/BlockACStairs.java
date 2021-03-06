package net.arcticraft.block;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;

public class BlockACStairs extends BlockStairs{

	protected BlockACStairs(Block stairBlock, int meta, Material meterial){
		super(stairBlock, meta);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setStepSound(Block.soundTypeWood);
		this.setCreativeTab(ACCreativeTabs.acTabDecoration);
		this.useNeighborBrightness = true;
	}

}
