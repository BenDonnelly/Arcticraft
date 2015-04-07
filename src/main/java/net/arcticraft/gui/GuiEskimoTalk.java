package net.arcticraft.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.item.ItemStack;

import com.arcanumLudum.ALCore.chat.MobBot;
import com.google.code.chatterbotapi.ChatterBotType;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class GuiEskimoTalk extends GuiScreen 
{
	public MobBot mobBot = new MobBot();
	
	private GuiTextField textfield;
	
    protected String respond = "";
    protected String input = "";
    protected String oldInput = "";
	
	public GuiEskimoTalk(String defaultChatText) {
		mobBot.init(ChatterBotType.JABBERWACKY, "");
		
		this.input = defaultChatText;
	}

	public void initGui() {
		if(input != "" && !input.isEmpty())
		{
			respond = mobBot.getResponse(input);
		}
		
		buttonList = new ArrayList();
		
		this.buttonList.add(new GuiButton(0, ((width - 60) / 2), ((height - 20) / 2), 60, 20, "Talk"));
		this.buttonList.add(new GuiButton(1, ((width - 60) / 2), ((height - 20) / 2) - 50, 60, 20, "Exit"));
		
        textfield = new GuiTextField(fontRendererObj, ((width - 300) / 2), ((height - 20) / 2) + 25, 300, 20);
        textfield.setFocused(true);
        textfield.setMaxStringLength(100);
	}

	public void actionPerformed(GuiButton button) {
		int buttonID = button.id;
		
		if(buttonID == 0 && input != "" && !input.isEmpty())
		{
			respond = mobBot.getResponse(input);  	
        	oldInput = input;
        	
        	textfield.setText("");
		}
		else if(buttonID == 1)
		{
			mc.thePlayer.closeScreen();
		}
	}
	
	private static void sendRewardToPlayer(EntityClientPlayerMP player,
			ItemStack stack) {
		int item = stack.getItemDamage();
		int stackSize = stack.stackSize;
		int damageValue = stack.getItemDamage();

		ByteArrayOutputStream bos = new ByteArrayOutputStream(12);
		DataOutputStream outputStream = new DataOutputStream(bos);

		try {
			outputStream.writeInt(item);
			outputStream.writeInt(stackSize);
			outputStream.writeInt(damageValue);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void keyTyped(char par1, int par2) {			
    	if(textfield.isFocused())
    	{
    		textfield.textboxKeyTyped(par1, par2);
    	}
	}
	
    @Override
    public void mouseClicked(int i, int j, int k)
    {
    	super.mouseClicked(i, j, k);

    	textfield.mouseClicked(i, j, k);
    }

    @Override
    public void drawScreen(int i, int j, float f) 
    {
        textfield.drawTextBox();
        
        drawString(fontRendererObj, "> " + oldInput, ((width - fontRendererObj.getStringWidth(oldInput)) / 2), ((height - fontRendererObj.FONT_HEIGHT) / 2) + 60, 0xffffff);
        drawString(fontRendererObj, "> " + respond, ((width - fontRendererObj.getStringWidth(respond)) / 2), ((height - fontRendererObj.FONT_HEIGHT) / 2) + 70, 0xffffff);
        
        super.drawScreen(i, j, f);
    }
    
    @Override
    public void updateScreen()
    {
    	input = textfield.getText();
    }
    
	public boolean doesGuiPauseGame() {
		return false;
	}

	public static void out(String text) {
		System.out.println(getSideAsString() + ": " + text);
	}

	@Deprecated
	public static String getSideAsString() {
		return FMLCommonHandler.instance().getSide() == Side.CLIENT ? "client" : "server";
	}
}