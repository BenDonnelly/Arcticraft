package net.arcticraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemIcicleBlocks extends ItemBlock
{
	public static final String[] icicles = new String[]{"large", "regular", "small", "largeUD","regularUD", "smallUD"};
	
	public ItemIcicleBlocks(Block block){
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int i = itemStack.getItemDamage();
		if(i < 0 || i >= icicles.length)
		{
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + icicles[i];
	}

	@Override
	public int getMetadata(int meta){
		return meta;
	}
	
}
