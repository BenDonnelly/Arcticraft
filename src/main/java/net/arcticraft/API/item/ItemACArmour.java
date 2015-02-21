package net.arcticraft.API.item;

import static net.arcticraft.main.Arcticraft.MOD_ID;
import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.item.ACItems;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemACArmour extends ItemArmor{

	public ItemACArmour(ArmorMaterial armourMaterial, int renderIndex, int armourType){
		super(armourMaterial, renderIndex, armourType);
		this.setCreativeTab(ACCreativeTabs.acTabCombat);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == ACItems.tekkiteHelmet || stack.getItem() == ACItems.tekkiteChest || stack.getItem() == ACItems.tekkiteBoots)
		{
			return MOD_ID + ":textures/items/armour/tekkite/tektite_1.png";
		}
		else if(stack.getItem() == ACItems.tekkiteLegs)
		{
			return MOD_ID + ":textures/items/armour/tekkite/tektite_2.png";
		}
		else if(stack.getItem() == ACItems.escariaHelmet || stack.getItem() == ACItems.escariaChest || stack.getItem() == ACItems.escariaBoots)
		{
			return MOD_ID + ":textures/items/armour/escaria/escaria_1.png";
		}
		else if(stack.getItem() == ACItems.escariaLegs)
		{
			return MOD_ID + ":textures/items/armour/escaria/escaria_2.png";
		}
		else if(stack.getItem() == ACItems.glacianHelmet || stack.getItem() == ACItems.glacianChest || stack.getItem() == ACItems.glacianBoots)
		{
			return MOD_ID + ":textures/items/armour/glacian/glacians_1.png";
		}
		else if(stack.getItem() == ACItems.glacianLegs)
		{
			return MOD_ID + ":textures/items/armour/glacian/glacians_2.png";
		}
		else if(stack.getItem() == ACItems.rigentemHelmet || stack.getItem() == ACItems.rigentemChest || stack.getItem() == ACItems.rigentemBoots)
		{
			return MOD_ID + ":textures/items/armour/rigentem/rigentem_1.png";
		}
		else if(stack.getItem() == ACItems.rigentemLegs)
		{
			return MOD_ID + ":textures/items/armour/rigentem/rigentem_2.png";
		}
		else
		{
			return null;
		}
	}
}
