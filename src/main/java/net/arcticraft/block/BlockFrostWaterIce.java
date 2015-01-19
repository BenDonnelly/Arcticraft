package net.arcticraft.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockIce;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;


public class BlockFrostWaterIce extends BlockIce{

	public BlockFrostWaterIce()
	{
		this.setBlockName("frostWaterIce");
		this.setHardness(0.5F);
		this.setLightOpacity(3);
		this.setStepSound(soundTypeGlass);
		this.slipperiness = 1.20F;
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
    public void harvestBlock(World world, EntityPlayer entityPlayer, int x, int y, int z, int p_149636_6_)
    {
        entityPlayer.addStat(StatList.mineBlockStatArray[Block.getIdFromBlock(this)], 1);
        entityPlayer.addExhaustion(0.025F);

        if (this.canSilkHarvest(world, entityPlayer, x, y, z, p_149636_6_) && EnchantmentHelper.getSilkTouchModifier(entityPlayer))
        {
            ArrayList<ItemStack> items = new ArrayList<ItemStack>();
            ItemStack itemstack = this.createStackedBlock(p_149636_6_);

            if (itemstack != null) items.add(itemstack);

            ForgeEventFactory.fireBlockHarvesting(items, world, this, x, y, z, p_149636_6_, 0, 1.0f, true, entityPlayer);
            for (ItemStack is : items)
                this.dropBlockAsItem(world, x, y, z, is);
        }
        else
        {
            if (world.provider.isHellWorld)
            {
                world.setBlockToAir(x, y, z);
                return;
            }

            int i1 = EnchantmentHelper.getFortuneModifier(entityPlayer);
            harvesters.set(entityPlayer);
            this.dropBlockAsItem(world, x, y, z, p_149636_6_, i1);
            harvesters.set(null);
            Material material = world.getBlock(x, y - 1, z).getMaterial();

            if (material.blocksMovement() || material.isLiquid())
            {
                world.setBlock(x, y, z, ACBlocks.frostWaterBlock);
            }
        }
    }


    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        if (world.getSavedLightValue(EnumSkyBlock.Block, x, y, z) > 11 - this.getLightOpacity())
        {
            if (world.provider.isHellWorld)
            {
                world.setBlockToAir(x, y, z);
                return;
            }

            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlock(x, y, z, ACBlocks.frostWaterBlock);
        }
    }
	
}
