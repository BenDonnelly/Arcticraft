package net.arcticraft.item;

import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemIcicleBlocks extends ItemBlock
{
	public static final String[] icicles = new String[]{"large", "regular", "small", "largeUD","regularUD", "smallUD"};
	
	@SideOnly(Side.CLIENT)
    private IIcon icicle;
    private IIcon icicle_ud;
    
    
	public ItemIcicleBlocks(Block block){
		super(block);
		this.setHasSubtypes(true);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
    	icicle = iconRegister.registerIcon(Arcticraft.MOD_ID + ":icicle");
    	icicle_ud = iconRegister.registerIcon(Arcticraft.MOD_ID + ":icicle_ud");
    }
	
    @Override
    public IIcon getIconFromDamage(int damage){
    	
    	if(damage == 0 || damage == 1 || damage == 2){
    		return icicle;
    	}
    	else{
    		return icicle_ud;
    	}
    }

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int i = itemStack.getItemDamage();
		if(i < 0 || i >= icicles.length)
		{
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + icicles[i];
	}

	@Override
	public int getMetadata(int meta){
		return meta;
	}
	
}
