package net.arcticraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLeafBlocks extends ItemBlock
{
	public static final String[] leaves = new String[]{"frost", "glacier"};
	
	public ItemLeafBlocks(Block block){
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int i = itemStack.getItemDamage();
		if(i < 0 || i >= leaves.length)
		{
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + leaves[i];
	}

	@Override
	public int getMetadata(int meta){
		return meta;
	}
	
}
