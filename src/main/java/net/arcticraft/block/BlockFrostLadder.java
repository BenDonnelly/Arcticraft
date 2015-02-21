package net.arcticraft.block;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.material.Material;

public class BlockFrostLadder extends BlockLadder{

	protected BlockFrostLadder(Material material){
		this.setBlockName(Arcticraft.MOD_ID + "_frostLadders");
		this.setBlockTextureName(Arcticraft.MOD_ID + ":ladder_frost");
		this.setHardness(0.4F);
		this.setStepSound(Block.soundTypeLadder);
		this.setCreativeTab(ACCreativeTabs.acTabDecoration);
	}

}
