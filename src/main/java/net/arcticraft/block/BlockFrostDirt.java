package net.arcticraft.block;

import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockFrostDirt extends Block{

	protected BlockFrostDirt(){
		super(Material.ground);
		this.setBlockName(Arcticraft.MOD_ID + "_" + "frostDirt");
		this.setBlockTextureName(Arcticraft.MOD_ID + ":" +  "frost_dirt");
        this.setHardness(0.5F);
        this.setStepSound(Block.soundTypeGravel);
        this.setCreativeTab(CreativeTabs.tabBlock);
	}

}
