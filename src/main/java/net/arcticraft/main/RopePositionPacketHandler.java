package net.arcticraft.main;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class RopePositionPacketHandler implements IMessageHandler<RopePositionPacket, IMessage>{

	@Override
	public IMessage onMessage(RopePositionPacket message, MessageContext ctx)
	{
		System.out.println("asdfsadfdsf");
		return null;
	}

}
