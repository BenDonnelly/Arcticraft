package net.arcticraft.API.item;

import java.util.Set;

import com.google.common.collect.Sets;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.block.ACBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemACPickaxe extends ItemPickaxe{

	private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] {Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice,
			Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail,
			/*START OF AC BLOCKS*/ ACBlocks.arcaneStone, ACBlocks.escariaOre, ACBlocks.frigusOre, ACBlocks.frostCobble, ACBlocks.frostStone, ACBlocks.glacianOre, ACBlocks.rigentemOre, ACBlocks.tekkiteOre, ACBlocks.cannon, ACBlocks.arcticFurnaceBurning, ACBlocks.arcticFurnaceIdle, ACBlocks.caveman, ACBlocks.escariaOre, ACBlocks.eriumBlock, ACBlocks.escariaBlock, ACBlocks.frostWaterIce, ACBlocks.tekkiteBlock, ACBlocks.rigentemBlock, ACBlocks.icicle, ACBlocks.glacianBlock, ACBlocks.captainStatue });

	public ItemACPickaxe(ToolMaterial toolMaterial){
		super(toolMaterial);
		this.setCreativeTab(ACCreativeTabs.acTabTools);
	}

	@Override
	public float func_150893_a(ItemStack itemStack, Block block)
	{
		return this.blocksEffectiveAgainst.contains(block) ? this.efficiencyOnProperMaterial : 1.0F;
	}
}
