package net.arcticraft.API.item;

import java.util.Set;

import com.google.common.collect.Sets;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.block.ACBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemACAxe extends ItemAxe{

    private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin,
    		/*START OF AC BLOCKS*/ ACBlocks.acLogs, ACBlocks.acPlanks, ACBlocks.acSlab, ACBlocks.acDoubleSlab, ACBlocks.frostStairs, ACBlocks.glacierStairs, ACBlocks.frostDoor, ACBlocks.frostFence});

	public ItemACAxe(ToolMaterial toolMaterial){
		super(toolMaterial);
		this.setCreativeTab(ACCreativeTabs.acTabTools);
	}
	
	@Override
	public float func_150893_a(ItemStack itemStack, Block block)
	{
		return this.blocksEffectiveAgainst.contains(block) ? this.efficiencyOnProperMaterial : 1.0F;
	}
}
