package net.arcticraft.entities.passive;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.gui.GuiEskimoTalk;
import net.arcticraft.item.ACItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;

public class EntityEskimo extends EntityEskimoDefault{

	public EntityEskimo(World par1World){
		super(par1World);
		this.setSize(1.5F, 1.4F);
	}

	@Override
	public void func_110297_a_(ItemStack itemstack)
	{
		addStuffToBuy(ACItems.arcaneStoneDust, 5, 46, 0.5F);
		addStuffToBuy(ACBlocks.crystalGlass, 10, 20, 0.3F);
		addStuffToBuy(ACBlocks.campfire, 6, 20, 0.6F);
		addStuffToSell(ACItems.bomb, 2, 6, 0.6F);
		addStuffToSell(ACItems.bucketEmpty, 1, 1, 0.59F);
	}

}
