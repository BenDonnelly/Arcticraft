package net.arcticraft.main;

import net.arcticraft.entities.EntityCaptainHook;
import net.arcticraft.entities.hostile.EntityCaptain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class RopePositionPacketHandler implements IMessageHandler<RopePositionPacket, IMessage> {
	int captainID;
	int hookID;

	private void handleRopePosition(RopePositionPacket packet, EntityPlayer plyr) {
		World world;
		captainID = packet.captainId;
		hookID = packet.hookId;
		
		if (plyr instanceof EntityPlayer) {
			world = plyr.worldObj;
		} else {
			return;
		}

		EntityCaptainHook hook = (EntityCaptainHook) world
				.getEntityByID(hookID);
		EntityCaptain captain = (EntityCaptain) world.getEntityByID(captainID);

		hook.setThrower(captain);
		captain.resetHookCooldown();
		captain.setHookAirBorne(true);

		double rotation = (captain.rotationYaw + 70.0F) / (180.0F / Math.PI);
		double hookLaunchX = Math.cos(rotation);
		double hookLaunchY = 1.4D;
		double hookLaunchZ = Math.sin(rotation);

		for (int i = 0; i < 10; i++) {
			captain.worldObj.spawnParticle("smoke", captain.posX + hookLaunchX,
					captain.posY + hookLaunchY, captain.posZ + hookLaunchZ,
					(captain.getRNG().nextDouble() - 0.5D) / 5D, (captain
							.getRNG().nextDouble() - 0.5D) / 5D, (captain
							.getRNG().nextDouble() - 0.5D) / 5D);
		}
	}

	@Override
	public IMessage onMessage(RopePositionPacket message, MessageContext ctx) {
		EntityPlayer thePlayer = (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : ctx.getServerHandler().playerEntity);
		
		this.handleRopePosition(message, thePlayer);

		return null;
	}
}