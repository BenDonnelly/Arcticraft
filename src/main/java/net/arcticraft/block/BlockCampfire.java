package net.arcticraft.block;

import java.util.Random;

import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.tileentity.TileEntityCampfire;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCampfire extends BlockContainer{

	public BlockCampfire(Material material){
		super(material);
		this.setBlockName(Arcticraft.MOD_ID + "_" + "campfire");
		this.setBlockTextureName(Arcticraft.MOD_ID + ":campfire_icon_dummy");
		this.setHardness(1.5F);
		this.setLightLevel(1.0F);
		this.setStepSound(Block.soundTypeWood);
		// minX, minY, minZ, maxX, maxY, maxZ
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
		this.setCreativeTab(ACCreativeTabs.acTabBlock);
	}

	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType()
	{
		return -2;
	}

	/**
	 * Is this block (a) opaque and (B) a full 1m cube? This determines whether or not to render the shared face of two adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		entity.setFire(10);
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if(random.nextInt(24) == 0)
		{
			world.playSound((double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), "fire.fire", 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F, false);
		}

		int l = world.getBlockMetadata(x, y, z);
		float f = (float) x + 0.5F;
		float f1 = (float) y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
		float f2 = (float) z + 0.5F;
		float f3 = 0.52F;
		float f4 = random.nextFloat() * 0.6F - 0.3F;
		world.spawnParticle("largesmoke", (double) (f - f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("flame", (double) (f - f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f + f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("flame", (double) (f + f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f + f4), (double) f1, (double) (f2 - f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("flame", (double) (f + f4), (double) f1, (double) (f2 - f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f + f4), (double) f1, (double) (f2 + f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("flame", (double) (f + f4), (double) f1, (double) (f2 + f3), 0.0D, 0.0D, 0.0D);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new TileEntityCampfire();
	}
}
