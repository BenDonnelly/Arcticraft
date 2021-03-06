package net.arcticraft.world.gen.dimension;

import java.util.Iterator;
import java.util.Random;

import net.arcticraft.block.ACBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class TeleporterDim extends Teleporter
{
	public static double portalX = 0.0D;
	public static double portalY = 0.0D;
	public static double portalZ = 0.0D;
	
	public TeleporterDim(WorldServer p_i1963_1_) {
		super(p_i1963_1_);
	}

	public static int DIMENSION_ID = 3;

	public static void teleportEntity(Entity entity, int dimensionId)
	{
		if(entity.worldObj.isRemote)
			return;

		if(entity instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP) entity;
			
			if (player.timeUntilPortal > 0)
			{
				player.timeUntilPortal = 10;
			}
			else if (player.dimension != 3)
			{
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 3, new TeleporterDim(player.mcServer.worldServerForDimension(3)));
			}
			else {
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterDim(player.mcServer.worldServerForDimension(3)));
			}
			
			generateStructureIfRequired(player);
		}
	}

	private static void syncPlayer(EntityPlayerMP player, World world)
	{
		player.theItemInWorldManager.setWorld((WorldServer) world);
		player.mcServer.getConfigurationManager().updateTimeAndWeatherForPlayer(player, (WorldServer) world);
		player.mcServer.getConfigurationManager().syncPlayerInventory(player);

		Iterator iter = player.getActivePotionEffects().iterator();

		while(iter.hasNext())
		{
			PotionEffect effect = (PotionEffect) iter.next();
		}
	}

	private static void generateStructureIfRequired(Entity entity)
	{
		int x = MathHelper.floor_double(entity.posX), y = MathHelper.floor_double(entity.posY), z = MathHelper.floor_double(entity.posZ);

		if(entity.worldObj.getBlock(x, y - 2, z) == Blocks.bedrock)
			return;

		generateStructure(entity.worldObj, MathHelper.floor_double(entity.posX), MathHelper.floor_double(entity.posY), MathHelper.floor_double(entity.posZ));
	}

	private static void generateStructure(World world, int x, int y, int z)
	{
		if(world.provider.dimensionId != DIMENSION_ID)
			return;

		int oldX = x;
		int oldY = y;
		int oldZ = z;
		
		y += 3;
		x -= 3;
		z -= 3;

		String[][] data = new String[][] { {"XXXXXXXXX" , "XXXXXXXXX" , "XXXXXXXXX" , "TTTTTTXXX" , "XXXXXXXXX" , "XXXXXXXXX" , "XXXXXXXXX"} , {"XXXXXXXXX" , "XXXXXXXXX" , "TTTTTTXXX" , "TXXXXFXXX" , "TTTTTTXXX" , "XXXXXXXXX" , "XXXXXXXXX"} ,
				{"XXXXXXXXX" , "TTTTTTXXX" , "TXXXXXXXX" , "TXXXXFXXX" , "TXXXXXXXX" , "TTTTTTXXX" , "XXXXXXXXX"} , {"TTTTTTXXX" , "TXXXXXXXX" , "TXXXXXXXX" , "TCXXXFXXX" , "TXXXXXXXX" , "TXXXXXXXX" , "TTTTTTXXX"} ,
				{"GGGGGGGGG" , "GGGGGGGGG" , "GGGGGGGGG" , "GGGBGGGGG" , "GGGGGGGGG" , "GGGGGGGGG" , "GGGGGGGGG"} , {"RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR"} ,
				{"RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR"} , {"RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR"} ,
				{"RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR" , "RRRRRRRRR"}};

		for(String[] row : data)
		{
			for(String col : row)
			{
				for(Character c : col.toCharArray())
				{
					Block id = null;
					int damage = 0;

					switch(c)
					{
					case 'X':
						id = Blocks.air;
						damage = 0;
						break;
					case 'T':
						id = Blocks.wool;
						damage = 13;
						break;
					case 'F':
						id = Blocks.fence;
						damage = 0;
						break;
					case 'G':
						if(world.getBlock(x, y - 1, z) == ACBlocks.frostSnow || world.getBlock(x, y - 1, z) == ACBlocks.frostWaterBlock)
						{
							id = ACBlocks.frostGrass;
						}
						else
						{
							id = world.getBlock(x, y - 1, z);
						}
						
						damage = 0;
						break;
					case 'R':
						id = Blocks.dirt;
						damage = 0;
						break;
					case 'C':
						id = Blocks.chest;
						damage = 0;
						break;
					case 'B':
						id = Blocks.bedrock;
						damage = 0;
						
						portalX = x;
						portalY = y;
						portalZ = z;
						
						break;
					}

					if(world.getBlock(x, y, z) != id)
					{
						if((id == ACBlocks.frostDirt || id == ACBlocks.frostGrass || id == ACBlocks.frostWaterIce || id == Blocks.snow) && world.getBlock(x, y, z) != Blocks.air && world.getBlock(x, y, z) != Blocks.snow /* && world.getBlockId(x, y, z) != MainRegistry.thickSnow.blockID */)
						{
							x++;
							
							continue;
						}

						world.setBlock(x, y, z, id, damage, 2);

						if(id == Blocks.chest)
						{
							TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y, z);
							chest.setInventorySlotContents(0, new ItemStack(Items.boat, 1));
							//chest.setInventorySlotContents(0, new ItemStack(ACItems.GlacierFruit, 1));
						}
					}

					x++;
				}

				x -= 9;
				z++;
			}

			y -= 1;
			z -= 7;
		}
	}
}