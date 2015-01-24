package net.arcticraft.item;

import net.arcticraft.block.creativetabs.ACCreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemACSword extends ItemSword{

	public ItemACSword(ToolMaterial toolMaterial){
		super(toolMaterial);
		this.setCreativeTab(ACCreativeTabs.acTabCombat);
	}

}
