package net.arcticraft.main;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.arcticraft.entities.EntityCaptain;
import net.arcticraft.entities.EntityCaptainHook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class RopePositionPacket implements IMessage{

	public int captainId;
	public int hookId;

	public RopePositionPacket(){}

	public RopePositionPacket(int captainId, int hookId){
		this.captainId = captainId;
		this.hookId = hookId;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{

		WorldClient world;
		if(Minecraft.getMinecraft().thePlayer instanceof EntityPlayer)
		{
			world = (WorldClient) ((EntityPlayer) Minecraft.getMinecraft().thePlayer).worldObj;
		}
		else
		{
			return;
		}

		EntityCaptainHook hook = (EntityCaptainHook) world.getEntityByID(hookId);
		EntityCaptain captain = (EntityCaptain) world.getEntityByID(captainId);
		hook.setThrower(captain);
		captain.resetHookCooldown();
		captain.setHookAirBorne(true);
		double rotation = (captain.rotationYaw + 70.0F) / (180.0F / Math.PI);
		double hookLaunchX = Math.cos(rotation);
		double hookLaunchY = 1.4D;
		double hookLaunchZ = Math.sin(rotation);
		for(int i = 0; i < 10; i++)
		{
			captain.worldObj.spawnParticle("smoke", captain.posX + hookLaunchX, captain.posY + hookLaunchY, captain.posZ + hookLaunchZ, (captain.getRNG().nextDouble() - 0.5D) / 5D, (captain.getRNG().nextDouble() - 0.5D) / 5D, (captain.getRNG().nextDouble() - 0.5D) / 5D);
		}
	}

	@Override
	public void toBytes(ByteBuf buf)
	{

	}
}
