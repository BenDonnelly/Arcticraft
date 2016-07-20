package net.arcticraft.block;

import net.arcticraft.creativetab.ACCreativeTabs;
import net.arcticraft.util.References;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockAC extends Block {
	
	public BlockAC(String name, Material materialIn, SoundType sound, float hardness, float res) {
		super(materialIn);
		this.setSoundType(sound);
		this.setHardness(hardness);
		this.setResistance(res);
		//Registry (resource) name is the same as unlocalized (language) name
		this.setRegistryName(References.MOD_ID, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ACCreativeTabs.BLOCKS);
	}

}
