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
	
	private static final Vec3d FOG_COLOR = new Vec3d(0.1D, 0.9D, 1.0D);
	
	@Override
	public DimensionType getDimensionType() {
		return ARCTIC;
	}
	
	@Override
	public String getDepartMessage() {
        return References.DIM_LEAVE;
    }
	
	@Override
	public String getWelcomeMessage() {
		return References.DIM_ENTER;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return false;
	}
	
	@Override
    public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
        return FOG_COLOR;
    }
	
	@Override
	public float getStarBrightness(float par1) {
		return 2.0F;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkProviderArctic(this.worldObj, this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.worldObj.getSeed());
	}

}
