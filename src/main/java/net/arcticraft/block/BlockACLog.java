package net.arcticraft.block;

import static net.arcticraft.main.Arcticraft.MOD_ID;

import java.util.List;

import net.arcticraft.block.creativetabs.ACCreativeTabs;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockACLog extends BlockLog
{
	public static final String[] logs = new String[] {"frost", "glacier"};

	protected BlockACLog(Material material){
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setBlockName(MOD_ID + "_log");
		this.setCreativeTab(ACCreativeTabs.acTabBlock);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < logs.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		// A side icon B top icon
		this.field_150167_a = new IIcon[logs.length];
		this.field_150166_b = new IIcon[logs.length];
		for(int i = 0; i < this.field_150167_a.length; i++)
		{
			this.field_150167_a[i] = iconRegister.registerIcon(Arcticraft.MOD_ID + ":" + "log_" + logs[i]);
			this.field_150166_b[i] = iconRegister.registerIcon(Arcticraft.MOD_ID + ":" + "log_" + logs[i] + "_top");
		}

	}
}
