package net.arcticraft.block;

import java.util.Random;

import net.arcticraft.block.creativetabs.ACCreativeTabs;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFrostGrass extends Block implements IGrowable
{
    @SideOnly(Side.CLIENT)
    private IIcon texture_top;
    @SideOnly(Side.CLIENT)
    private IIcon texture_side_snowed; 
    @SideOnly(Side.CLIENT)
    private IIcon texture_bottom;

    protected BlockFrostGrass()
    {
        super(Material.grass);
        this.setBlockName(Arcticraft.MOD_ID + "_" + "frostGrass");
        this.setBlockTextureName(Arcticraft.MOD_ID + ":" + "frost_grass");
        this.setHardness(0.5F);
        this.setStepSound(Block.soundTypeGrass);
        this.setTickRandomly(true);
        this.setCreativeTab(ACCreativeTabs.acTabBlock);
       
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? this.texture_top : (side == 0 ? this.texture_bottom : this.blockIcon);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        if (!world.isRemote)
        {
            if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
            {
                world.setBlock(x, y, z, ACBlocks.frostDirt);
            }
            else if (world.getBlockLightValue(x, y + 1, z) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = x + rand.nextInt(3) - 1;
                    int j1 = y + rand.nextInt(5) - 3;
                    int k1 = z + rand.nextInt(3) - 1;
                    Block block = world.getBlock(i1, j1 + 1, k1);

                    if (world.getBlock(i1, j1, k1) == ACBlocks.frostDirt && world.getBlockMetadata(i1, j1, k1) == 0 && world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        world.setBlock(i1, j1, k1, ACBlocks.frostGrass);
                    }
                }
            }
        }
    }

    
    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return ACBlocks.frostDirt.getItemDropped(0, p_149650_2_, p_149650_3_);
    }

    @Override
    public boolean func_149851_a(World world, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
    {
        return true;
    }

    @Override
    public boolean func_149852_a(World world, Random rand, int p_149852_3_, int p_149852_4_, int p_149852_5_)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
        if (side == 1)
        {
            return this.texture_top;
        }
        else if (side == 0)
        {
            return this.texture_bottom;
        }
        else
        {
            Material material = blockAccess.getBlock(x, y + 1, z).getMaterial();
            return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.texture_side_snowed;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(this.getTextureName() + "_side");
        this.texture_top = iconRegister.registerIcon(this.getTextureName() + "_top");
        this.texture_side_snowed = iconRegister.registerIcon(this.getTextureName() + "_side_snow");
        this.texture_bottom = iconRegister.registerIcon(Arcticraft.MOD_ID + ":" +  "dirt_frost");
    }


    @Override
    public void func_149853_b(World world, Random rand, int x, int y, int z)
    {
        int l = 0;

        while (l < 128)
        {
            int i1 = x;
            int j1 = y + 1;
            int k1 = z;
            int l1 = 0;

            while (true)
            {
                if (l1 < l / 16)
                {
                    i1 += rand.nextInt(3) - 1;
                    j1 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
                    k1 += rand.nextInt(3) - 1;

                    if (world.getBlock(i1, j1 - 1, k1) == Blocks.grass && !world.getBlock(i1, j1, k1).isNormalCube())
                    {
                        ++l1;
                        continue;
                    }
                }
                else if (world.getBlock(i1, j1, k1).getMaterial() == Material.air)
                {
                    if (rand.nextInt(8) != 0)
                    {
                        if (Blocks.tallgrass.canBlockStay(world, i1, j1, k1))
                        {
                            world.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 3);
                        }
                    }
                    else
                    {
                        world.getBiomeGenForCoords(i1, k1).plantFlower(world, rand, i1, j1, k1);
                    }
                }

                ++l;
                break;
            }
        }
    }
}
