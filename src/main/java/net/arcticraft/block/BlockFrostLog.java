package net.arcticraft.block;

import java.util.Random;

import net.arcticraft.block.creativetabs.ACCreativeTabs;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFrostLog extends Block{

	private IIcon top_bottom;
	private IIcon side;

	protected BlockFrostLog(){
		super(Material.wood);
		this.setBlockName(Arcticraft.MOD_ID + "_" + "frostLog");
        this.setHardness(2.0F);
        this.setStepSound(Block.soundTypeWood);
        this.setCreativeTab(ACCreativeTabs.acTabBlock);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister texture)
	{
		this.side = texture.registerIcon(this.getTextureName() + "_side");
		this.top_bottom = texture.registerIcon(this.getTextureName() + "_top_bottom");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if(side == 0 || side == 1)
		{
			return top_bottom;
		}
		return this.side;
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return Item.getItemFromBlock(this);
	}

	@Override
	public void breakBlock(World world, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
	{
		byte b0 = 4;
		int i1 = b0 + 1;
		if(world.checkChunksExist(p_149749_2_ - i1, p_149749_3_ - i1, p_149749_4_ - i1, p_149749_2_ + i1, p_149749_3_ + i1, p_149749_4_ + i1))
		{
			for(int j1 = -b0; j1 <= b0; ++j1)
			{
				for(int k1 = -b0; k1 <= b0; ++k1)
				{
					for(int l1 = -b0; l1 <= b0; ++l1)
					{
						Block block = world.getBlock(p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1);
						if(block.isLeaves(world, p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1))
						{
							block.beginLeavesDecay(world, p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1);
						}
					}
				}
			}
		}
	}
}
