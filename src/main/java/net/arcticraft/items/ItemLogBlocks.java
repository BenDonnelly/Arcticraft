package net.arcticraft.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLogBlocks extends ItemBlock{

	public static final String[] logs = new String[]{"frost", "glacier"};
	
	public ItemLogBlocks(Block block){
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int i = itemStack.getItemDamage();
		if(i < 0 || i >= logs.length)
		{
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + logs[i];
	}

	@Override
	public int getMetadata(int meta){
		return meta;
	}
	
}
