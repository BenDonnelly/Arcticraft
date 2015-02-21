package net.arcticraft.API.item;

import java.util.Set;

import com.google.common.collect.Sets;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.block.ACBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemACSpade extends ItemSpade{

	private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium, 
			/*START OF AC BLOCKS*/ ACBlocks.frostGrass, ACBlocks.frostDirt, ACBlocks.frostSnow});

	public ItemACSpade(ToolMaterial toolMaterial){
		super(toolMaterial);
		this.setCreativeTab(ACCreativeTabs.acTabTools);
	}

	@Override
	public float func_150893_a(ItemStack itemStack, Block block)
	{
		return this.blocksEffectiveAgainst.contains(block) ? this.efficiencyOnProperMaterial : 1.0F;
	}

}
