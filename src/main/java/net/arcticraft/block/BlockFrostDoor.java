package net.arcticraft.block;

import java.util.Random;

import net.arcticraft.item.ACItems;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFrostDoor extends BlockDoor{

	private static final String[] doorTextures = new String[] {Arcticraft.MOD_ID + ":door_frost_lower", Arcticraft.MOD_ID + ":door_frost_upper"};

	private final int doorTypeMaybe;
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderBlockPass()
    {
        return 1;
    }
    
    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
        return super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, 1 - p_149646_5_);
    }
	
	public BlockFrostDoor(Material material){
		super(material);
		this.setBlockName(Arcticraft.MOD_ID + "_frostDoor");
		this.setHardness(3.0F);
		this.disableStats();
		this.doorTypeMaybe = 0;
		float f = 0.5F;
		float f1 = 1.0F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int meta)
	{
		if(meta != 1 && meta != 0)
		{
			int i1 = this.func_150012_g(blockAccess, x, y, z);
			int j1 = i1 & 3;
			boolean flag = (i1 & 4) != 0;
			boolean flag1 = false;
			boolean flag2 = (i1 & 8) != 0;
			if(flag)
			{
				if(j1 == 0 && meta == 2)
				{
					flag1 = !flag1;
				}
				else if(j1 == 1 && meta == 5)
				{
					flag1 = !flag1;
				}
				else if(j1 == 2 && meta == 3)
				{
					flag1 = !flag1;
				}
				else if(j1 == 3 && meta == 4)
				{
					flag1 = !flag1;
				}
			}
			else
			{
				if(j1 == 0 && meta == 5)
				{
					flag1 = !flag1;
				}
				else if(j1 == 1 && meta == 3)
				{
					flag1 = !flag1;
				}
				else if(j1 == 2 && meta == 4)
				{
					flag1 = !flag1;
				}
				else if(j1 == 3 && meta == 2)
				{
					flag1 = !flag1;
				}
				if((i1 & 16) != 0)
				{
					flag1 = !flag1;
				}
			}
			return this.iconArray[this.doorTypeMaybe + (flag1 ? doorTextures.length : 0) + (flag2 ? 1 : 0)];
		}
		else
		{
			return this.iconArray[this.doorTypeMaybe];
		}
	}

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return this.iconArray[this.doorTypeMaybe];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.iconArray = new IIcon[doorTextures.length * 2];
		for(int i = 0; i < doorTextures.length; ++i)
		{
			this.iconArray[i] = par1IconRegister.registerIcon(doorTextures[i]);
			this.iconArray[i + doorTextures.length] = new IconFlipped(this.iconArray[i], true, false);
		}
	}

	@Override
	public Item getItemDropped(int meta, Random random, int fortune)
	{
		return ACItems.frostDoor;
	}
}
