package net.arcticraft.gui;

import net.arcticraft.containers.ContainerArcticPouch;
import net.arcticraft.item.ItemArcticPouchInventory;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class GuiArcticPouch extends GuiContainer
{

	public ItemArcticPouchInventory backpack;

	public GuiArcticPouch(EntityPlayer player, InventoryPlayer playerInv, ItemArcticPouchInventory apInv)
	{
		super(new ContainerArcticPouch(player, playerInv, apInv));
		this.backpack = apInv;
	}


	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y)
	{
		this.fontRendererObj.drawString("Arctic Pouch", 8, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Arcticraft.MOD_ID, "/textures/gui/arctic_pouch.png"));
		int k = this.guiLeft;
		int l = this.guiTop;
		this.drawTexturedModalRect(k, l, 0, 0, 256, 256);
	}
}
