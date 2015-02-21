package net.arcticraft.API.item;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemACSword extends ItemSword{

	public ItemACSword(ToolMaterial toolMaterial){
		super(toolMaterial);
		this.setCreativeTab(ACCreativeTabs.acTabCombat);
	}

}
