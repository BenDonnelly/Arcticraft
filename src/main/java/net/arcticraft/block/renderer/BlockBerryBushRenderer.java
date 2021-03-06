package net.arcticraft.block.renderer;

import net.arcticraft.API.block.BlockBerryBush;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class BlockBerryBushRenderer implements ISimpleBlockRenderingHandler {
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId,
			RenderBlocks renderer) {
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {

		int l = ((BlockBerryBush)block).getBerryColour();
		
		float f = (float) (l >> 16 & 255) / 255.0F;
		float f1 = (float) (l >> 8 & 255) / 255.0F;
		float f2 = (float) (l & 255) / 255.0F;

		if (EntityRenderer.anaglyphEnable) {
			float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
			float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
			float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
			f = f3;
			f1 = f4;
			f2 = f5;
		}

		return Minecraft.isAmbientOcclusionEnabled()
				&& block.getLightValue() == 0 ? (RenderBlocks.getInstance().partialRenderBounds ? RenderBlocks
				.getInstance().renderStandardBlockWithAmbientOcclusionPartial(
						block, x, y, z, f, f1, f2) : RenderBlocks.getInstance()
				.renderStandardBlockWithAmbientOcclusion(block, x, y, z, f, f1,
						f2))
				: RenderBlocks.getInstance()
						.renderStandardBlockWithColorMultiplier(block, x, y, z,
								f, f1, f2);
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return 121;
	}
}
