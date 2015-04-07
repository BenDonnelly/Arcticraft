package net.arcticraft.gui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import net.arcticraft.API.misc.EskimoTrade;
import net.arcticraft.entities.passive.EntityEskimoTrader;
import net.arcticraft.gui.button.GuiTraderButton;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.main.EskimoTradePacket;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S3FPacketCustomPayload;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class GuiTraderEskimo extends GuiScreen 
{
	public InventoryPlayer inventory;
	private EntityEskimoTrader eskimo;
	private int traderWidth = 256;
	private int traderHeight = 256;

	public GuiTraderEskimo(InventoryPlayer inv, EntityEskimoTrader entity) {
		this.inventory = inv;
		this.eskimo = entity;
	}

	@Override
	public void initGui() {
		EskimoTrade[] trades = this.eskimo.getTrades();
		
		for (int ID = 0; ID < trades.length; ID++) 
		{
			EskimoTrade trade = trades[ID];
			
			if (trade != null) {
				int x = (this.width + this.traderWidth) / 2 - 46 - 32
						* (ID % 7);
				int y = (this.height + this.traderHeight) / 2 - 69 - 38
						* (ID / 7);
				
				this.buttonList.add(new GuiTraderButton(ID, x, y, trade,
						this));
			}
		}
	}

	@Override
	public void actionPerformed(GuiButton button) {
		if (button.enabled) 
		{
			EskimoTrade trade = this.eskimo.getTrades()[button.id];
			
			if (trade != null && this.inventory.getFirstEmptyStack() != -1) {				
				ItemStack stack = ItemStack.copyItemStack(trade.itemstack);
				
				Item item = stack.getItem();
				int stackSize = stack.stackSize;
				int damageValue = stack.getItemDamage();
				int gems = trade.gemAmount;
				
				/*ByteArrayOutputStream bos = new ByteArrayOutputStream(16);
				DataOutputStream outputStream = new DataOutputStream(bos);

				try {
					outputStream.writeInt(Item.getIdFromItem(item));
					outputStream.writeInt(stackSize);
					outputStream.writeInt(damageValue);
					outputStream.writeInt(gems);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				S3FPacketCustomPayload packet = new S3FPacketCustomPayload("AC|EskimoTrade",
						bos.toByteArray());
				
				Arcticraft.arcticraftInstance.network.sendToServer(new EskimoTradePacket(new ByteArrayInputStream(bos.toByteArray())));*/
				
				Arcticraft.arcticraftInstance.network.sendToServer(new EskimoTradePacket(item, stackSize, damageValue, gems));
				
				/*if (this.inventory.player instanceof EntityClientPlayerMP) {
					EntityClientPlayerMP player = (EntityClientPlayerMP) this.inventory.player;
					
					player.sendQueue.handleCustomPayload(packet);
				}*/
			} else {
				this.inventory.player.addChatMessage(new ChatComponentText("Something went wrong, is your inventory full?"));
			}
		}
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		FMLClientHandler.instance().getClient().renderEngine
				.bindTexture(new ResourceLocation(Arcticraft.MOD_ID,
						"textures/gui/trading.png"));
		int x = (this.width - this.traderWidth) / 2;
		int y = (this.height - this.traderHeight) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.traderWidth,
				this.traderHeight);
		String gems = EskimoTrade.getGemsFromInventory(this.inventory)
				+ " Gems";
		this.fontRendererObj.drawString(gems,
				x + 41 - (this.fontRendererObj.getStringWidth(gems) / 2),
				y + 6, 0xDC631E);
		super.drawScreen(par1, par2, par3);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	protected void keyTyped(char par1, int par2) {
		if (par2 == 1
				|| par2 == this.mc.gameSettings.keyBindInventory.getKeyCode()) 
		{
			this.mc.thePlayer.closeScreen();
			this.mc.setIngameFocus();
		}
	}
}