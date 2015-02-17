package net.arcticraft.item;

import net.arcticraft.block.BlockACSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ItemSlabBlocks extends ItemSlab
{
	public static final String[] slabs = new String[]{"frost", "glacier"};
	
	public ItemSlabBlocks(Block block, BlockACSlab singleSlab, BlockACSlab doubleSlab, Boolean isDoubleSlab){
		super(block, singleSlab, doubleSlab, isDoubleSlab);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int i = itemStack.getItemDamage();
		if(i < 0 || i >= slabs.length)
		{
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + slabs[i];
	}

	@Override
	public int getMetadata(int meta){
		return meta;
	}
	
}
