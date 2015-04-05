package net.arcticraft.main;

import io.netty.buffer.ByteBuf;
import net.arcticraft.entities.EntityCaptainHook;
import net.arcticraft.entities.hostile.EntityCaptain;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class RopePositionPacket implements IMessage
{
	public int captainId;
	public int hookId;

	public RopePositionPacket(){}

	public RopePositionPacket(int captainId, int hookId)
	{
		this.captainId = captainId;
		this.hookId = hookId;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		captainId = buf.readInt();
		hookId = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(captainId);
		buf.writeInt(hookId);
	}
}
