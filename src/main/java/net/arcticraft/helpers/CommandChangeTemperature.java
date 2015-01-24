package net.arcticraft.helpers;

import net.arcticraft.main.Arcticraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class CommandChangeTemperature extends CommandBase{

	private final String COMMAND_NAME = "changetemp";
	
	@Override
	public String getCommandName()
	{
		return COMMAND_NAME;
	}

	@Override
	public String getCommandUsage(ICommandSender commandSender)
	{
		return "Changes the players temperature value";
	}

	@Override
	public void processCommand(ICommandSender commandSender, String[] string)
	{
		EntityPlayer player = (EntityPlayer) commandSender;
		IExtendedPlayerProps props = IExtendedPlayerProps.get(player);
		
		if(commandSender instanceof EntityPlayer && Arcticraft.DEV_MODE)
		{
			NBTTagCompound compound = new NBTTagCompound();
			props.changeTemp(Integer.parseInt(string[0]));
			props.saveNBTData(compound);
		}
	}

}
