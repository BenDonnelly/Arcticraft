package net.arcticraft.main;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.arcticraft.API.misc.EskimoTrade;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class EskimoTradePacketHandler implements IMessageHandler<EskimoTradePacket, IMessage> {
	private void handleEskimoTrade(EskimoTradePacket packet, EntityPlayer plyr)
	{
		/*DataInputStream inputStream = new DataInputStream(packet.bis);

		Item item;
		int stackSize;
		int damageValue;
		int gems;

		try
		{
			item = Item.getItemById(inputStream.readInt());
			stackSize = inputStream.readInt();
			damageValue = inputStream.readInt();
			gems = inputStream.readInt();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return;
		}*/
		
		Item item = packet.item;
		int stackSize = packet.stackSize;
		int damageValue = packet.damage;
		int gems = packet.gems;

		ItemStack stack = new ItemStack(item, stackSize, damageValue);
		EntityPlayer player;

		if(plyr instanceof EntityPlayer)
		{
			player = (EntityPlayer) plyr;
		}
		else
		{
			return;
		}

		if(EskimoTrade.removeGemsFromInventory(player.inventory, gems))
		{
			player.addChatMessage(new ChatComponentText("You have bought: " + stack.stackSize + "x " + stack.getDisplayName()));
			
			player.inventory.addItemStackToInventory(stack);
		}
	}
	
	@Override
	public IMessage onMessage(EskimoTradePacket message, MessageContext ctx) {
		EntityPlayer thePlayer = (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : ctx.getServerHandler().playerEntity);
		
		this.handleEskimoTrade(message, thePlayer);

		return null;
	}
}
