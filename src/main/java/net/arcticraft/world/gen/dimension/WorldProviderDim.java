package net.arcticraft.world.gen.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderDim extends WorldProvider {
	public void registerWorldChunkManager() {
		/** tells Minecraft to use our new WorldChunkManager **/
		this.worldChunkMgr = new WorldChunkMangerDim(worldObj.getSeed(),
				terrainType);
		this.hasNoSky = false;
	}

	@Override
	/** Dimension Name **/
	public String getDimensionName() {
		return "The Arcanus";
	}

	/** Get Provider for dimension **/
	public static WorldProvider getProviderForDimension(int id) {
		return DimensionManager.createProviderFor(id);
	}

	/** Welcome message **/
	@Override
	public String getWelcomeMessage() {
		return "Entering the Artic";
	}

	/** What chunk provider to use **/
	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderDim(worldObj, worldObj.getSeed(), true);
	}

	@Override
	public float calculateCelestialAngle(long par1, float par3)
	{
		return 3.7F;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Vec3 getFogColor(float par1, float par2)
	{
		return Vec3.createVectorHelper(0.1, 0.9, 1.0);
	}

	/** Can player re-spawn here **/
	@Override
	public boolean canRespawnHere() {
		return true;
	}

	/** Determines the dimension the player will be respawned in **/
	@Override
	public int getRespawnDimension(EntityPlayerMP player) {
		return 3;
	}
}