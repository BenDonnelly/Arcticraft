package net.arcticraft.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class ACBossStatus{

	public static float healthScale;
	public static int statusBarLength;
	public static boolean hasColourModifier;
	public static String bossName;
	public static boolean isMiniBoss;

	public static void setBossStatus(ACIBossDisplayData bossData, boolean par1)
	{
		healthScale = bossData.getHealth() / bossData.getMaxHealth();
		statusBarLength = 100;
		bossName = bossData.getEntityName();
		isMiniBoss = bossData.isMiniBoss();
		hasColourModifier = par1;
	}
}
