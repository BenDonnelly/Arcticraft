package net.arcticraft.block;

import java.util.List;

import net.arcticraft.main.Arcticraft;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockACLeaves extends BlockLeaves {

	public static final String[][] leaftypes = new String[][]{{"leaf_frost", "leaf_glacier"}, {"leaf_frost_opaque", "leaf_glacier_opaque"}};
	public static final String[] leaves = new String[]{"frost", "glacier"};
	
	protected BlockACLeaves(Material material){
		this.setBlockName("acLeaves");
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	
	@Override
	protected void func_150124_c(World world, int x, int y, int z, int side, int meta)
    {
        if ((side & 3) == 1 && world.rand.nextInt(meta) == 0)
        {
            this.dropBlockAsItem(world, x, y, z, new ItemStack(Items.apple, 1, 0));
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
	@Override
	public int damageDropped(int i)
    {
        return super.damageDropped(i) + 4;
    }

    /**
     * Get the block's damage value (for use with pick block).
     */
	@Override
    public int getDamageValue(World world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z) & 3;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
	@Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
    	for(int i = 0; i < leaves.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
    }

	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for (int i = 0; i < leaftypes.length; ++i)
        {
            this.field_150129_M[i] = new IIcon[leaftypes[i].length];

            for (int j = 0; j < leaftypes[i].length; ++j)
            {
                this.field_150129_M[i][j] = iconRegister.registerIcon(Arcticraft.MOD_ID + ":" + leaftypes[i][j]);
            }
        }
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		this.setGraphicsLevel(Minecraft.getMinecraft().gameSettings.fancyGraphics);//Used to get the problem that the leaves would always render fancy, got this strange fix from the forgeforums.
		
		return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1] : this.field_150129_M[this.field_150127_b][0];
	}

	@Override
	public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
    {
		return 0xffffff;
		
    }
	
	@Override
	public String[] func_150125_e()
	{
		return leaves;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		return true;
	}
}
