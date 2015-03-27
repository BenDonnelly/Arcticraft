package net.arcticraft.world.gen;

import java.util.Random;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.main.Arcticraft;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCaveman extends WorldGenerator{

	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		for(int l = 0; l < 10; ++l)
		{
			int i1 = x + random.nextInt(8) - random.nextInt(8);
			int j1 = y + random.nextInt(4) - random.nextInt(4);
			int k1 = z + random.nextInt(8) - random.nextInt(8);
			if(world.isAirBlock(i1, j1, k1))
			{
				int l1 = 1 + random.nextInt(random.nextInt(3) + 1);
				for(int i2 = 0; i2 < l1; ++i2)
				{
					if(ACBlocks.caveman.canBlockStay(world, i1, j1 + i2, k1))
					{
						Arcticraft.notifyOfGenertion("Caveman", Integer.toString(x), Integer.toString(z));
						world.setBlock(i1, j1 + i2, k1, ACBlocks.caveman, 0, 2);
					}
				}
			}
		}
		return true;
	}
}
