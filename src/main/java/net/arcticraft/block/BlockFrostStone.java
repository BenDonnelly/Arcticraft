package net.arcticraft.block;

import java.util.Random;

import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;


public class BlockFrostStone extends Block{

	protected BlockFrostStone(){
		super(Material.rock);
		this.setBlockName(Arcticraft.MOD_ID + "_" + "frostStone");
		this.setBlockTextureName(Arcticraft.MOD_ID + ":" +  "frost_stone");
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypePiston);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(ACBlocks.frostCobble);
    }
	
}
