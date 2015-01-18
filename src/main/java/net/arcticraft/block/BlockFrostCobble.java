package net.arcticraft.block;

import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class BlockFrostCobble extends Block{

	protected BlockFrostCobble(){
		super(Material.rock);
		this.setBlockName(Arcticraft.MOD_ID + "_" + "frostCobble");
		this.setBlockTextureName(Arcticraft.MOD_ID + ":" +  "frost_cobble");
		this.setHardness(2.0F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypePiston);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

}
