package net.arcticraft.main;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.Item;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class EskimoTradePacket implements IMessage
{
	//public ByteArrayInputStream bis = null;

	public Item item;
	public int stackSize;
	public int damage;
	public int gems;
	
	public EskimoTradePacket(){}
	
	public EskimoTradePacket(Item item, int stackSize, int damage, int gems)
	{
		this.item = item;
		this.stackSize = stackSize;
		this.damage = damage;
		this.gems = gems;
	}

	/*public EskimoTradePacket(ByteArrayInputStream bis)
	{
		this.bis = bis;
	}*/

	@Override
	public void fromBytes(ByteBuf buf)
	{
		//bis = new ByteArrayInputStream(buf.array());
		
		this.item = Item.getItemById(buf.readInt());
		this.stackSize = buf.readInt();
		this.damage = buf.readInt();
		this.gems = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(Item.getIdFromItem(this.item));
		buf.writeInt(this.stackSize);
		buf.writeInt(this.damage);
		buf.writeInt(this.gems);
		
		/*try 
		{
			buf.writeBytes(bis, 4);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}*/
	}
}