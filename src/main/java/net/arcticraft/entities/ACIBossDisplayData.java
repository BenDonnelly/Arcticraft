package net.arcticraft.entities;

import net.minecraft.entity.boss.IBossDisplayData;


public interface ACIBossDisplayData extends IBossDisplayData
{
	boolean isMiniBoss();
	String getEntityName();
	
}
