package net.arcticraft.block;

import java.util.List;
import java.util.Random;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockACSlab extends BlockSlab{

	public static final String[] slabTypes = new String[] {"frost", "glacier"};

	public BlockACSlab(boolean doubleSlab){
		super(doubleSlab, Material.wood);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setStepSound(Block.soundTypeWood);
		this.setBlockName(Arcticraft.MOD_ID + "_acSlabs");
		this.setCreativeTab(ACCreativeTabs.acTabBlock);
		this.useNeighborBrightness = true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return ACBlocks.acPlanks.getIcon(side, meta & 7);
	}

	@Override
	public Item getItemDropped(int meta, Random random, int fortune)
	{
		return Item.getItemFromBlock(ACBlocks.acSlab);
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		//determines weather to drop two for double slab or just one
		return this.field_150004_a ? 2 : 1;
	}
	
	  /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
	@Override
	protected ItemStack createStackedBlock(int meta)
	{
		return new ItemStack(Item.getItemFromBlock(ACBlocks.acSlab), 2, meta & 7);
	}
	
	@Override
	public String func_150002_b(int p_150002_1_)
	{
		if(p_150002_1_ < 0 || p_150002_1_ >= slabTypes.length)
		{
			p_150002_1_ = 0;
		}

		return super.getUnlocalizedName() + "." + slabTypes[p_150002_1_];
	}
	
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        if (item != Item.getItemFromBlock(ACBlocks.acDoubleSlab))
        {
            for (int i = 0; i < slabTypes.length; ++i)
            {
                list.add(new ItemStack(item, 1, i));
            }
        }
    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_){}

}
