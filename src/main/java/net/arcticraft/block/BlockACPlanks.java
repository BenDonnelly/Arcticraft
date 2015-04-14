package net.arcticraft.block;

import static net.arcticraft.main.Arcticraft.MOD_ID;

import java.util.List;
import java.util.Random;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockACPlanks extends Block
{
	@SideOnly(Side.CLIENT)
	protected IIcon[] textures = new IIcon[2];
	
	protected BlockACPlanks(Material material)
	{
		super(Material.wood);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setBlockName(MOD_ID + "_planks");
		this.setCreativeTab(ACCreativeTabs.acTabBlock);
	}
	
	
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < BlockACLog.logs.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		for(int i = 0; i < this.textures.length; i++)
		{
			this.textures[i] = iconRegister.registerIcon(MOD_ID + ":planks_" + BlockACLog.logs[i]);
		}

	}
	
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.textures[meta];
    }
    
    @Override
    public Item getItemDropped(int meta, Random rand, int fortune)
    {
    	return Item.getItemFromBlock(this);
    }
    
    @Override
    public int damageDropped(int dmg)
    {
        return dmg;
    }

}
