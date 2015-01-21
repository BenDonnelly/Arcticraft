package net.arcticraft.block;

import java.util.Random;

import net.arcticraft.block.creativetabs.ACCreativeTabs;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockArcaneStone extends Block{

	protected BlockArcaneStone(){
		super(Material.redstoneLight);
		this.setBlockName(Arcticraft.MOD_ID + "_" + "arcaneStone");
		this.setBlockTextureName(Arcticraft.MOD_ID + ":" + "arcane_stone");
		this.setHardness(1.5F);
		this.setStepSound(soundTypeGlass);
		this.setLightLevel(1.0F);
		this.setCreativeTab(ACCreativeTabs.acTabBlock);
	}

	public int quantityDropped(Random random)
	{
		return 2 + random.nextInt(3);
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		//TODO Need to change to arcane dust
		return Items.glowstone_dust;
	}
}
