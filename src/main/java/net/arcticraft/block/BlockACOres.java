package net.arcticraft.block;

import java.util.Random;

import net.arcticraft.block.creativetabs.ACCreativeTabs;
import net.arcticraft.item.ACItems;
import net.arcticraft.item.ItemACPickaxe;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockACOres extends Block{

	/* All ordered in rarity */

	protected BlockACOres(){
		super(Material.rock);
		this.setCreativeTab(ACCreativeTabs.acTabBlock);
		this.setStepSound(Block.soundTypeStone);
	}

	@Override
	public Item getItemDropped(int i, Random rand, int i1)
	{
		if(this == ACBlocks.tekkiteOre)
		{
			return ACItems.tekkiteGem;
		}
		if(this == ACBlocks.escariaOre)
		{
			return ACItems.escariaGem;
		}
		if(this == ACBlocks.glacianOre)
		{
			return Item.getItemFromBlock(ACBlocks.glacianOre);
		}
		if(this == ACBlocks.eriumOre)
		{
			return ACItems.eriumGem;
		}
		if(this == ACBlocks.rigentemOre)
		{
			return Item.getItemFromBlock(ACBlocks.rigentemOre);
		}
		else
			return ACItems.frigus;
	}

	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
	{
		ItemStack itemstack = player.getCurrentEquippedItem();
		if(itemstack != null && itemstack.getItem() instanceof ItemACPickaxe)
		{
			this.setHarvestLevels();
			this.setHardness(3.0F);
			this.setResistance(5.0F);
		}
		else
		{
			this.setBlockUnbreakable();
		}
	}

	private void setHarvestLevels()
	{
		if(this == ACBlocks.tekkiteOre) this.setHarvestLevel("pickaxe", 2);
		if(this == ACBlocks.escariaOre) this.setHarvestLevel("pickaxe", 2);
		if(this == ACBlocks.glacianOre) this.setHarvestLevel("pickaxe", 1);
		if(this == ACBlocks.frigusOre) this.setHarvestLevel("pickaxe", 0);
		if(this == ACBlocks.eriumOre) this.setHarvestLevel("pickaxe", 0);
		
	}
	
}
