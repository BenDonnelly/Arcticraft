package net.arcticraft.entities.passive;

import java.util.Iterator;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.item.ACItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityIceMage extends EntityAnimal{

	public EntityIceMage(World world){
		super(world);
		setSize(1.5F, 1.9F);
		this.tasks.addTask(0, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(1, new EntityAILookIdle(this));

	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEFINED;
	}

	@Override
	public boolean canDespawn()
	{
		return false;
	}

	public boolean interact(EntityPlayer player)
	{
		ItemStack stack = player.inventory.getCurrentItem();
		if(stack != null && stack.getItem() ==  Item.getItemFromBlock(ACBlocks.mysticalSnow))
		{
			this.randomChat("trade");
			if(--stack.stackSize <= 0)
			{
				player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(ACItems.mystFruit));
			}
			else if(!player.inventory.addItemStackToInventory(new ItemStack(ACItems.mystFruit))) 
			{
				player.dropPlayerItemWithRandomChoice(new ItemStack(ACItems.mystFruit, 1, 0), false);
			}
			return true;
		}
		else
		{
			this.randomChat("give");
			return super.interact(player);
		}
	}

	public void randomChat(String type)
	{
		int i = rand.nextInt(3);
		if(type.equals("trade"))
		{
			if(i == 2)
			{
				this.talkStuff("If you feel the need for some new adventures, eat this!", this.worldObj);
			}
			else if(i == 1)
			{
				this.talkStuff("Devouring this will send you off into the cold!", this.worldObj);
			}
			else
			{
				this.talkStuff("Eating this will cast you into the snow barren Arctic!", this.worldObj);
			}
		}
		if(type.equals("give"))
		{
			if(i == 2)
			{
				this.talkStuff("If you give me some Mystical Snow I will show you the way to a new world", this.worldObj);
			}
			else if(i == 1)
			{
				this.talkStuff("Adventures await if you hand me some Mystical Snow", this.worldObj);
			}
			else
			{
				this.talkStuff("A Freezing future awaits if I can have some Mystical Snow from you", this.worldObj);
			}
		}
	}

	public static void talkStuff(String s, World world)
	{
		Iterator<EntityPlayer> players = world.playerEntities.iterator();
		while(players.hasNext())
		{
			EntityPlayer player = players.next();
			if(player instanceof EntityPlayerMP)
			{
				Minecraft.getMinecraft().thePlayer.sendChatMessage(s);
			}
		}
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityAgeable)
	{
		return null;
	}
}
