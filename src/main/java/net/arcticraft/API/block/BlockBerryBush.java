package net.arcticraft.API.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.arcanumLudum.ALCore.colour.ColourRGB;

public class BlockBerryBush extends Block
{
	private int berryColour = 0xFFFFFF;
	
	public BlockBerryBush(ColourRGB berryColour) 
	{
		super(Material.leaves);
		
		this.berryColour = berryColour.rgb();
	}
	
    /**
     * The type of render function that is called for this block
     */
	@Override
    public int getRenderType()
    {
        return 121;
    }
	
	public int getBerryColour() { return this.berryColour; }
}
