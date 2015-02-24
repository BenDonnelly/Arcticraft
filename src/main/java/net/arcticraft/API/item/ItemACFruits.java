package net.arcticraft.API.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.arcticraft.item.ACItems;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.world.gen.dimension.TeleporterDim;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemACFruits extends ItemFood{

	private int dimension;

	public ItemACFruits(){
		super(0, false);
		this.setAlwaysEdible();
		dimension = 3;
	}

	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
	{
		attemptToTeleport(itemStack, world, player);
		// TODO fix sound
		// Minecraft.getMinecraft().sndManager.playSoundFX("ac:misc.portal", 4.0F, 4.0F);
		// player.addStat(AC_Achievements.AC_ENTER, 1);
		itemStack.stackSize--;
		return itemStack;
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if(player.capabilities.isCreativeMode)
		{
			attemptToTeleport(itemstack, world, player);
		}
		return super.onItemUse(itemstack, player, world, x, y, z, side, hitX, hitY, hitZ);
	}

	private void attemptToTeleport(ItemStack itemStack, World world, EntityPlayer player)
	{
		if(itemStack.getItem() == ACItems.mystFruit)
		{
			if(player.dimension == 0)
			{
				TeleporterDim.teleportEntity(player, dimension);
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 120, 50));
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));
			}
		}
		else if(itemStack.getItem() == ACItems.glacierFruit)
		{
			int newDimension = player.dimension == 0 ? dimension : 0;
			TeleporterDim.teleportEntity(player, newDimension);
			player.addPotionEffect(new PotionEffect(Potion.confusion.id, 250, 50));
			player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));
		}
	}

    @SideOnly(Side.CLIENT)
	@Override
	public boolean hasEffect(ItemStack itemstack)
	{
		return false;
	}

	@Override
	public EnumRarity getRarity(ItemStack itemstack)
	{
		return EnumRarity.epic;
	
	}
}
