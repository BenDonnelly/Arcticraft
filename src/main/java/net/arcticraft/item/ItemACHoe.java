package net.arcticraft.item;

import net.arcticraft.block.creativetabs.ACCreativeTabs;
import net.minecraft.item.ItemHoe;


public class ItemACHoe extends ItemHoe{

	public ItemACHoe(ToolMaterial toolMaterial){
		super(toolMaterial);
		this.setCreativeTab(ACCreativeTabs.acTabTools);
	}

}
