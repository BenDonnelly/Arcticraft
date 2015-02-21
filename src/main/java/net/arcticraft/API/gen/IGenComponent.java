package net.arcticraft.API.gen;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public interface IGenComponent {
	public int minCount = 0;
	public int maxCount = 0;
	public int minHeight = 0;
	public int maxHeight = 0;
	public int heightFromGround = 0;
	public boolean canSpawnEverywhere = false;
	public ArrayList<Class> bottomBlocks = new ArrayList<Class>();
	
	public boolean generate(World world, Random rand, int i, int j, int k);
}
