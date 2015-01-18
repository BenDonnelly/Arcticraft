package net.arcticraft.block;

import java.util.Random;

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
        this.setCreativeTab(CreativeTabs.tabBlock);
       
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
    public void updateTick(World world, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        if (!world.isRemote)
        {
            if (world.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) < 4 && world.getBlockLightOpacity(p_149674_2_, p_149674_3_ + 1, p_149674_4_) > 2)
            {
                world.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, ACBlocks.frostDirt);
            }
            else if (world.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
                    int j1 = p_149674_3_ + p_149674_5_.nextInt(5) - 3;
                    int k1 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
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
    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
    {
        return true;
    }

    @Override
    public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
    {
        if (p_149673_5_ == 1)
        {
            return this.texture_top;
        }
        else if (p_149673_5_ == 0)
        {
            return this.texture_bottom;
        }
        else
        {
            Material material = p_149673_1_.getBlock(p_149673_2_, p_149673_3_ + 1, p_149673_4_).getMaterial();
            return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.texture_side_snowed;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister texture)
    {
        this.blockIcon = texture.registerIcon(this.getTextureName() + "_side");
        this.texture_top = texture.registerIcon(this.getTextureName() + "_top");
        this.texture_side_snowed = texture.registerIcon(this.getTextureName() + "_side_snow");
        this.texture_bottom = texture.registerIcon(Arcticraft.MOD_ID + ":" +  "frost_dirt");
    }


    @Override
    public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_)
    {
        int l = 0;

        while (l < 128)
        {
            int i1 = p_149853_3_;
            int j1 = p_149853_4_ + 1;
            int k1 = p_149853_5_;
            int l1 = 0;

            while (true)
            {
                if (l1 < l / 16)
                {
                    i1 += p_149853_2_.nextInt(3) - 1;
                    j1 += (p_149853_2_.nextInt(3) - 1) * p_149853_2_.nextInt(3) / 2;
                    k1 += p_149853_2_.nextInt(3) - 1;

                    if (p_149853_1_.getBlock(i1, j1 - 1, k1) == Blocks.grass && !p_149853_1_.getBlock(i1, j1, k1).isNormalCube())
                    {
                        ++l1;
                        continue;
                    }
                }
                else if (p_149853_1_.getBlock(i1, j1, k1).getMaterial() == Material.air)
                {
                    if (p_149853_2_.nextInt(8) != 0)
                    {
                        if (Blocks.tallgrass.canBlockStay(p_149853_1_, i1, j1, k1))
                        {
                            p_149853_1_.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 3);
                        }
                    }
                    else
                    {
                        p_149853_1_.getBiomeGenForCoords(i1, k1).plantFlower(p_149853_1_, p_149853_2_, i1, j1, k1);
                    }
                }

                ++l;
                break;
            }
        }
    }
}