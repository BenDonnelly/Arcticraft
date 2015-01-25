package net.arcticraft.world.gen;

import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.util.vector.Vector3f;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.block.BlockACLeaves;
import net.arcticraft.block.BlockACLog;
import net.arcticraft.util.VectorUtils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenACTrees implements IWorldGenerator
{
	public static WorldGenACTrees[] possibles = new WorldGenACTrees[]
	{
		new WorldGenACTrees(6, 4, 5, 4, 8, 5, 0.7F, 0.6F),
		//new WorldGenACTrees(10, 5, 20, 4, 15, 15, 0.7F, 0.5F)
	};
	
	// For generate() function
	public WorldGenACTrees() {};
	
	public WorldGenACTrees(int height, int extensionHeight, int boughAmount,
			int boughSize, int boughSpread, int branchVariation,
			float resetRate, float resetToLogRate)
	{
		this.height = height;
		this.extensionHeight = extensionHeight;
		this.boughAmount = boughAmount;
		
		this.boughSize = boughSize;
		this.boughSizeBase = boughSize / 2;
		
		this.boughSpreadX = boughSpread;
		this.boughSpreadY = boughSpread;
		this.boughSpreadZ = boughSpread;
		this.branchVariation = branchVariation;
		this.resetRate = resetRate;
		this.resetToLogRate = resetToLogRate;
		
		this.baseHeight = this.height / 2;
		this.baseExtension = this.extensionHeight / 2;
		
		this.boughSpreadXBase = boughSpreadX / 2;
		this.boughSpreadYBase = boughSpreadY / 2;
		this.boughSpreadZBase = boughSpreadZ / 2;
		
		this.branchVariationBase = branchVariation / 2;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if(world.provider.dimensionId == 3)
		{
			for (int i = 0; i < 1; i++)
			{
				int max = 10;
				int min = 0;
				int r = new Random().nextInt(max - min) + min;
				
				if(r == 5)
				{
					int x = chunkX * 16 + random.nextInt(16);
					int y = 256;
					int z = chunkZ * 16 + random.nextInt(16);
					
					while(y > 0 && world.getBlock(x, y - 1, z) != ACBlocks.frostGrass && world.getBlock(x, y - 1, z) != ACBlocks.frostDirt) y -= 1;
					
					if(world.getBlock(x, y - 1, z) == ACBlocks.frostGrass
							&& world.getBlock(x + 1, y - 1, z) == ACBlocks.frostGrass
							&& world.getBlock(x + 1, y - 1, z + 1) == ACBlocks.frostGrass
							&& world.getBlock(x, y - 1, z + 1) == ACBlocks.frostGrass)
					{
						if(world.getBlock(x, y + 1, z) == Blocks.air)
						{
							possibles[random.nextInt(possibles.length)].generateTree(world, random, x, y, z);
						}
					}
					else if(world.getBlock(x, y - 1, z) == ACBlocks.frostDirt
							&& world.getBlock(x + 1, y - 1, z) == ACBlocks.frostDirt
							&& world.getBlock(x + 1, y - 1, z + 1) == ACBlocks.frostDirt
							&& world.getBlock(x, y - 1, z + 1) == ACBlocks.frostDirt)
					{
						if(world.getBlock(x, y + 1, z) == Blocks.air)
						{
							possibles[random.nextInt(possibles.length)].generateTree(world, random, x, y, z);
						}
					}
				}
			}
		}
	}
	
	private static Block log = ACBlocks.acLogs;
	private static int logMeta = ArrayUtils.indexOf(BlockACLog.logs, "glacier");
	
	private static Block leaves = ACBlocks.acLeaves;
	private static int leafMeta = ArrayUtils.indexOf(BlockACLeaves.leaves, "glacier");
	
	int height;
	int extensionHeight;
	
	int boughAmount;
	int boughSize, boughSizeBase;
	
	int boughSpreadX, boughSpreadY, boughSpreadZ;
	
	int branchVariation;
	
	float resetRate;
	float resetToLogRate;
	
	int baseHeight, baseExtension, boughSpreadXBase, boughSpreadYBase, boughSpreadZBase, branchVariationBase;
	
	public WorldGenACTrees(int height, int extensionHeight, int boughAmount,
			int boughSize, int boughSpread, int branchVariation,
			float resetRate, float resetToLogRate,
			Block log, Block leaves)
	{
		this(height, extensionHeight, boughAmount, boughSize, boughSpread, branchVariation, resetRate, resetToLogRate);
		this.log = log;
		this.leaves = leaves;
	}
	
	public WorldGenACTrees(int height, int extensionHeight, int boughAmount,
			int boughSize, int boughSpreadX, int boughSpreadY,
			int boughSpreadZ, int branchVariation,
			float resetRate, float resetToLogRate)
	{
		this(height, extensionHeight, boughAmount, boughSize, boughSpreadX, branchVariation, resetRate, resetToLogRate);
		this.boughSpreadX = boughSpreadX;
		this.boughSpreadY = boughSpreadY;
		this.boughSpreadZ = boughSpreadZ;
		
		this.boughSpreadXBase = boughSpreadX / 2;
		this.boughSpreadYBase = boughSpreadY / 2;
		this.boughSpreadZBase = boughSpreadZ / 2;
	}
	
	public WorldGenACTrees(int height, int extensionHeight, int boughAmount,
			int boughSize, int boughSpreadX, int boughSpreadY,
			int boughSpreadZ, int branchVariation,
			float resetRate, float resetToLogRate,
			Block log, Block leaves)
	{
		this(height, extensionHeight, boughAmount, boughSize, boughSpreadX, boughSpreadY, boughSpreadZ, branchVariation, resetRate, resetToLogRate);
		this.log = log;
		this.leaves = leaves;
	}
	
	private static final int[][] smallBoughCoords = new int[][]
	{
		{0, 1}, {0, 2},
		{1, 1}, {1, 2},
		{2, 1}, {2, 2},
		{3, 1}, {3, 2},
		
		{1, 0}, {2, 0},
		
		{1, 3}, {2, 3}
	};
	
	public void generateTree(World world, Random random, int x, int y, int z)
	{
		int treeHeight = random.nextInt(baseHeight) + baseHeight;
		int logExtension = random.nextInt(baseExtension) + baseExtension;
		
		int maxY = y + treeHeight + logExtension + branchVariationBase;
		for(int i = y; i < maxY; i++)
		{
			world.setBlock(x, i, z, log, logMeta, 2);
			world.setBlock(x + 1, i, z, log, logMeta, 2);
			world.setBlock(x, i, z + 1, log, logMeta, 2);
			world.setBlock(x + 1, i, z + 1, log, logMeta, 2);
			
			if(i > y + 1 && random.nextBoolean())
			{
				int minX = x + random.nextInt(3) - 2;
				int minZ = z + random.nextInt(3) - 2;
				
				for(int[] xz : smallBoughCoords)
				{
					int finalX = minX + xz[0];
					int finalZ = minZ + xz[1];
					if(world.getBlock(finalX, i, finalZ) == Blocks.air)
					{
						world.setBlock(finalX, i, finalZ, leaves, leafMeta, 2);
					}
				}
			}
		}
		
		world.setBlock(x, maxY, z, leaves, leafMeta, 2);
		world.setBlock(x + 1, maxY, z, leaves, leafMeta, 2);
		world.setBlock(x, maxY, z + 1, leaves, leafMeta, 2);
		world.setBlock(x + 1, maxY, z + 1, leaves, leafMeta, 2);
		
		// Random roots
		/*for(int x2 = -1; x2 < 3; x2++)
		{
			for(int z2 = -1; z2 < 3; z2++)
			{
				Block b = world.getBlock(x2, y, z2);
				if((b == Blocks.air || b.isReplaceable(world, x2, y, z2)) && random.nextBoolean())
				{
					world.setBlock(x2, y, z2, log, logMeta, 2);
					if(random.nextBoolean()) world.setBlock(x2, y + 1, z2, log, logMeta, 2);
				}
			}
		}*/
		
		Vector3f boughStart = new Vector3f(x + 1, y + treeHeight + random.nextInt(branchVariation) - branchVariationBase, z + 1);
		
		// Generate boughs
		for(int i = 0; i < boughAmount; i++)
		{
			Vector3f boughLocation = new Vector3f(
				boughStart.x + random.nextInt(boughSpreadX) - boughSpreadXBase,
				boughStart.y + logExtension + random.nextInt(boughSpreadY) - boughSpreadYBase,
				boughStart.z + random.nextInt(boughSpreadZ) - boughSpreadZBase
			);
			
			int boughRadius = random.nextInt(boughSizeBase) + boughSizeBase;
			
			for(int x2 = (int) (boughLocation.x - boughRadius); x2 < boughLocation.x + boughRadius; x2++)
			{
				for(int y2 = (int) (boughLocation.y - boughRadius); y2 < boughLocation.y + boughRadius; y2++)
				{
					for(int z2 = (int) (boughLocation.z - boughRadius); z2 < boughLocation.z + boughRadius; z2++)
					{
						if(world.getBlock(x2, y2, z2) == Blocks.air
								&& VectorUtils.distance(boughLocation, x2, y2, z2) < boughRadius)
						{
							world.setBlock(x2, y2, z2, leaves, leafMeta, 2);
						}
					}
				}
			}
			
			// Draw branch
			Vector3f branch = new Vector3f(boughStart.x, boughStart.y, boughStart.z);
			
			// Continue string of branches
			if(random.nextFloat() <= resetRate)
			{
				if(random.nextFloat() <= resetToLogRate)
					boughStart = new Vector3f(x + 0.5F, y + treeHeight + 0.5F + random.nextInt(branchVariation) - branchVariationBase, z + 0.5F);
				else boughStart = branch;
			}
			
			while(Math.abs(branch.x - boughLocation.x) > 1 ||
					Math.abs(branch.y - boughLocation.y) > 1 ||
					Math.abs(branch.z - boughLocation.z) > 1)
			{
				if(branch.x < boughLocation.x) branch.x++;
				else if(branch.x > boughLocation.x) branch.x--;
				
				if(branch.y < boughLocation.y) branch.y++;
				else if(branch.y > boughLocation.y) branch.y--;
				
				if(branch.z < boughLocation.z) branch.z++;
				else if(branch.z > boughLocation.z) branch.z--;
				
				world.setBlock((int) branch.x, (int) branch.y, (int) branch.z, log, logMeta, 2);
			}
		}
	}
}