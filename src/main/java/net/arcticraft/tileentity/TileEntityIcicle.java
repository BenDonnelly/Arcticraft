package net.arcticraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityIcicle extends TileEntity
{
	public int type;
	public int rotation;
	public boolean upsideDown = false;

	public TileEntityIcicle()
	{}

	public TileEntityIcicle(int type, int rotation)
	{
		this.type = type;
		this.rotation = rotation;
		
		if(type == 3 || type == 4 || type == 5) upsideDown = true;
	}

	public TileEntityIcicle(int type, int rotation, boolean upsideDown)
	{
		this.type = type;
		this.rotation = rotation;
		this.upsideDown = upsideDown;
	}
	
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound compound = new NBTTagCompound();
		this.writeToNBT(compound);

		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, compound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
	{
		readFromNBT(packet.func_148857_g());
	}

	@Override
	public boolean canUpdate()
	{
		return false;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.type = compound.getInteger("Type");
		this.rotation = compound.getInteger("Rotation");
		this.upsideDown = compound.getBoolean("UpsideDown");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("Type", type);
		compound.setInteger("Rotation", rotation);
		compound.setBoolean("UpsideDown", upsideDown);
	}
}
