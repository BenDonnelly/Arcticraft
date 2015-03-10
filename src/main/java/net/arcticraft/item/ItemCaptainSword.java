package net.arcticraft.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemCaptainSword extends ItemSword{

	public ItemCaptainSword(ToolMaterial toolMaterial){
		super(toolMaterial);
	}

	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase entity, EntityLivingBase entity2)
	{
		itemStack.damageItem(1, entity2);
		entity.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 2));
		return true;
	}

}
