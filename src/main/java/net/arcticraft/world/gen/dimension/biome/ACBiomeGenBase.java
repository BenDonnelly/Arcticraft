package net.arcticraft.world.gen.dimension.biome;

import java.util.Random;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.entities.passive.EntityPenguin;
import net.arcticraft.world.gen.WorldGenACTrees;
import net.arcticraft.world.gen.WorldGenFrostTrees;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class ACBiomeGenBase extends BiomeGenBase
{
	protected boolean enableSnow;
    public static final ACBiomeGenBase frostMountains;
	public static final ACBiomeGenBase frostForest;
	public static final ACBiomeGenBase glacier;
	public static final ACBiomeGenBase snowPlains;
	public static final ACBiomeGenBase frostOcean;
	protected WorldGenACTrees genGlacierTrees;
	protected WorldGenFrostTrees genFrostTrees;

	public ACBiomeGenBase(int i)
	{
		super(i);
		
		this.topBlock = ACBlocks.frostGrass;
		this.fillerBlock =  ACBlocks.frostDirt;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		//this.spawnableCreatureList.add(new SpawnListEntry(EntityPenguin.class, 8, 2, 6));
		this.genGlacierTrees = new WorldGenACTrees();
		this.genFrostTrees = new WorldGenFrostTrees(true);
	}

	@Override
	public boolean getEnableSnow()
	{
		return true;
	}

	static
	{
		frostMountains = (ACBiomeGenBase) (new BiomeFrostMountains(141)).setBiomeName("Arctic Mountains");
		frostForest = (ACBiomeGenBase) (new BiomeFrostForest(142)).setBiomeName("Frost Forest");
		glacier = (ACBiomeGenBase) (new BiomeGlacier(143)).setBiomeName("Glacier");
		snowPlains = (ACBiomeGenBase) (new BiomeSnowPlains(144)).setBiomeName("Snow Plains");
		frostOcean = (ACBiomeGenBase) (new BiomeFrostOcean(145)).setBiomeName("Arctic Ocean");
	}
    
	public static void registerWithBiomeDictionary()
    {
        BiomeDictionary.registerBiomeType(frostForest, Type.COLD);
        BiomeDictionary.registerBiomeType(glacier, Type.COLD);
        BiomeDictionary.registerBiomeType(snowPlains, Type.COLD);
        BiomeDictionary.registerBiomeType(frostMountains, Type.COLD);
        BiomeDictionary.registerBiomeType(frostOcean, Type.COLD);
        BiomeDictionary.registerBiomeType(frozenOcean, Type.COLD);
        BiomeDictionary.registerAllBiomes();
    }
	
    @Override
    public void genTerrainBlocks(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
        genBiomeModdedTerrain(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
    }

    /**
     * Replaces custom Stone to allow top/filler blocks to work in dimension.
     * 
     * @param world
     * @param random
     * @param replacableBlock
     * @param aByte
     * @param x
     * @param y
     * @param z
     */
    public void genBiomeModdedTerrain(World world, Random random, Block[] replacableBlock, byte[] aByte, int x, int y, double z)
    {
        Block block = this.topBlock;
        byte b0 = (byte) (this.field_150604_aj & 255);
        Block block1 = this.fillerBlock;
        int k = -1;
        int l = (int) (z / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        int i1 = x & 15;
        int j1 = y & 15;
        int k1 = replacableBlock.length / 256;
        for (int l1 = 255; l1 >= 0; --l1)
        {
            int i2 = (j1 * 16 + i1) * k1 + l1;

            if (l1 <= 0 + random.nextInt(5))
            {
                replacableBlock[i2] = Blocks.bedrock;
            }
            else
            {
                Block block2 = replacableBlock[i2];

                if (block2 != null && block2.getMaterial() != Material.air)
                {
                    if (block2 == ACBlocks.frostStone)
                    {
                        if (k == -1)
                        {
                            if (l <= 0)
                            {
                                block = null;
                                b0 = 0;
                                block1 = ACBlocks.frostStone;
                            }
                            else if (l1 >= 59 && l1 <= 64)
                            {
                                block = this.topBlock;
                                b0 = (byte) (this.field_150604_aj & 255);
                                block1 = this.fillerBlock;
                            }

                            if (l1 < 63 && (block == null || block.getMaterial() == Material.air))
                            {
                                if (this.getFloatTemperature(x, l1, y) < 0.15F)
                                {
                                    block = ACBlocks.frostWaterIce;
                                    b0 = 0;
                                }
                                else
                                {
                                    block = ACBlocks.frostWaterBlock;
                                    b0 = 0;
                                }
                            }

                            k = l;

                            if (l1 >= 62)
                            {
                                replacableBlock[i2] = block;
                                aByte[i2] = b0;
                            }
                            else if (l1 < 56 - l)
                            {
                                block = null;
                                block1 = ACBlocks.frostStone;
                                replacableBlock[i2] = ACBlocks.frostWaterIce;
                            }
                            else
                            {
                                replacableBlock[i2] = block1;
                            }
                        }
                        else if (k > 0)
                        {
                            --k;
                            replacableBlock[i2] = block1;
                        }
                    }
                }
                else
                {
                    k = -1;
                }
            }
        }
    }
}