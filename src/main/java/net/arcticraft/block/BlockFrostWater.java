package net.arcticraft.block;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFrostWater extends BlockFluidClassic
{
	@SideOnly(Side.CLIENT)
	protected IIcon stillIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon flowingIcon;

	public BlockFrostWater(Fluid fluid){
		super(fluid, Material.water);
		this.setBlockName(Arcticraft.MOD_ID + "_" +"frostWater");
		this.blockHardness = 100F;
		this.setCreativeTab(ACCreativeTabs.acTabBlock);
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return (side == 0 || side == 1) ? stillIcon : flowingIcon;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		stillIcon = iconRegister.registerIcon(Arcticraft.MOD_ID + ":" + "frost_water_still");
		flowingIcon = iconRegister.registerIcon(Arcticraft.MOD_ID + ":" + "frost_water_flowing");
	}

	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z)
	{
		if(world.getBlock(x, y, z).getMaterial().isLiquid()) return false;
		return super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		if(world.getBlock(x, y, z).getMaterial().isLiquid()) return false;
		return super.displaceIfPossible(world, x, y, z);
	}

}
