package net.arcticraft.world;

import net.arcticraft.util.References;
import net.arcticraft.world.gen.ChunkProviderArctic;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderArctic extends WorldProvider {
	
	private static final DimensionType ARCTIC = DimensionType.register(References.DIM_NAME, References.DIM_SUFFIX, References.DIM_ID, WorldProviderArctic.class, false);
	
	@Override
	public DimensionType getDimensionType() {
		return ARCTIC;
	}
	
	@Override
	public String getDepartMessage() {
        return "Leaving the Arctic";
    }
	
	@Override
	public String getWelcomeMessage() {
		return "Entering the Arctic";
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public Vec3d getFogColor(float p_76562_1_, float p_76562_2_)
    {
        return new Vec3d(0.1D, 0.9D, 1.0D);
    }
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkProviderArctic(this.worldObj, this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.worldObj.getSeed());
	}

}
