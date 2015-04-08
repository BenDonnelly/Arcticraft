package net.arcticraft.item;

import java.util.List;

import net.arcticraft.helpers.IExtendedPlayerProps;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTeaDrinks extends ItemFood{

	private static final String[] teaFlavours = {"ac:red_tea", "ac:hot_chocolate", "ac:floran_tea", "ac:hot_chocolate_cold"};
	@SideOnly(Side.CLIENT)
	private IIcon[] teaIcon;

	public ItemTeaDrinks(int healAmount, boolean wolfFood){
		super(healAmount, wolfFood);
		this.setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamage(int damage)
	{
		int i = MathHelper.clamp_int(damage, 0, 15);
		return this.teaIcon[i];
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemstack)
	{
		String[] teaFlavours = new String[] {"Ice Red Tea", "Hot Chocolate", "Floran Tea", "Chocolate Milk"};

		return teaFlavours[itemstack.getItemDamage()];
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean dunno)
	{
		if(itemstack.getItemDamage() == 0)
		{
			list.add("Regeneration II (1:00)");
			list.add("Decrease Temperature By 15\u00B0C");
		}
		else if(itemstack.getItemDamage() == 1)
		{
			list.add("Increase Temperature By 30\u00B0C");
		}
		else if(itemstack.getItemDamage() == 2)
		{
			list.add("Jump Boost III (1:00)");
			list.add("Decrease Temperature By 15\u00B0C");
		}
		else if(itemstack.getItemDamage() == 3)
		{
			list.add("Decrease Temperature By 15\u00B0C");
		}

	}

	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player)
	{
		super.onEaten(itemstack, world, player);
		float temp = Arcticraft.arcticraftInstance.tempHandler.getTemperature();
		IExtendedPlayerProps props = IExtendedPlayerProps.get(player);
		NBTTagCompound compound = new NBTTagCompound();
		if(!world.isRemote)
		{
			if(itemstack.getItemDamage() == 0)
			{
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1200, 2));
				temp = temp - 15.0F;
				Arcticraft.arcticraftInstance.tempHandler.setTemperature(temp);
				props.changeTemp(temp);
				props.saveNBTData(compound);
				Arcticraft.arcticraftInstance.tempHandler.setTemperature(props.getCurrentTemp());
				System.out.println(Arcticraft.arcticraftInstance.tempHandler.getTemperature());

			}

			else if(itemstack.getItemDamage() == 1)
			{
				temp = temp + 30.0F;
				Arcticraft.arcticraftInstance.tempHandler.setTemperature(temp);
				props.changeTemp(temp);
				props.saveNBTData(compound);
				Arcticraft.arcticraftInstance.tempHandler.setTemperature(props.getCurrentTemp());
				System.out.println(Arcticraft.arcticraftInstance.tempHandler.getTemperature());

			}
			else if(itemstack.getItemDamage() == 2)
			{
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 1200, 2));
				temp = temp - 15.0F;
				Arcticraft.arcticraftInstance.tempHandler.setTemperature(temp);
				props.changeTemp(temp);
				props.saveNBTData(compound);
				Arcticraft.arcticraftInstance.tempHandler.setTemperature(props.getCurrentTemp());
				System.out.println(Arcticraft.arcticraftInstance.tempHandler.getTemperature());

			}
			else if(itemstack.getItemDamage() == 3)
			{
				temp = temp - 15.0F;
				Arcticraft.arcticraftInstance.tempHandler.setTemperature(temp);
				props.changeTemp(temp);
				props.saveNBTData(compound);
				Arcticraft.arcticraftInstance.tempHandler.setTemperature(props.getCurrentTemp());
				System.out.println(Arcticraft.arcticraftInstance.tempHandler.getTemperature());
			}
		}

		player.inventory.addItemStackToInventory(new ItemStack(ACItems.emptyCup, 1));
		return itemstack;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < 4; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemstack)
	{
		return EnumAction.drink;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.teaIcon = new IIcon[teaFlavours.length];

		for(int i = 0; i < teaFlavours.length; ++i)
		{
			this.teaIcon[i] = iconRegister.registerIcon(teaFlavours[i]);
		}
	}
}
