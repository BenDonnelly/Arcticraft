package net.arcticraft.main;

import com.arcanumLudum.ALCore.ALCore;

import net.arcticraft.entities.EntityCaptainHook;
import net.arcticraft.entities.hostile.EntityCaptain;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class RopePositionPacketHandler implements IMessageHandler<RopePositionPacket, IMessage> {

	private void handleRopePosition(RopePositionPacket packet) {
		EntityCaptainHook hook = (EntityCaptainHook) Minecraft.getMinecraft().theWorld.getEntityByID(packet.hookId);
		EntityCaptain captain = (EntityCaptain) Minecraft.getMinecraft().theWorld.getEntityByID(packet.captainId);
		
		hook.setThrower(captain);
	}

	@Override
	public IMessage onMessage(RopePositionPacket message, MessageContext ctx) {
		this.handleRopePosition(message);

		return null;
	}
}