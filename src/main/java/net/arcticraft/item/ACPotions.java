package net.arcticraft.item;

import net.arcticraft.main.Arcticraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.client.FMLClientHandler;

public class ACPotions extends Potion{

	public static Potion frostbitePotion;

	public ACPotions(int id, boolean fullyEffcetive, int colourOfBottle){
		super(id, fullyEffcetive, colourOfBottle);
	}

	public static void loadPotions()
	{
		frostbitePotion = new ACPotions(27, true, 0xffff).setIconIndex(2, 2).setPotionName(Arcticraft.MOD_ID + "_frostbite");
	}

	@Override
	public int getStatusIconIndex()
	{
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Arcticraft.MOD_ID, "textures/gui/inventory.png"));
		return super.getStatusIconIndex();
	}

}
