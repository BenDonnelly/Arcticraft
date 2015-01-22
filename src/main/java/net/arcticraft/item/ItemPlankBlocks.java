package net.arcticraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemPlankBlocks extends ItemBlock
{
	public static final String[] planks = new String[]{"frost", "glacier"};
	
	public ItemPlankBlocks(Block block){
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int i = itemStack.getItemDamage();
		if(i < 0 || i >= planks.length)
		{
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + planks[i];
	}

	@Override
	public int getMetadata(int meta){
		return meta;
	}
	
}
