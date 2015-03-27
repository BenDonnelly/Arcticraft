package net.arcticraft.item;

import cpw.mods.fml.common.eventhandler.Event;
import net.arcticraft.block.ACBlocks;
import net.arcticraft.world.gen.dimension.WorldProviderDim;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class ItemACBucket extends ItemBucket{

	private Block isFull;

	public ItemACBucket(Block block){
		super(block);
		isFull = block;
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
        boolean flag = this.isFull == Blocks.air;
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, flag);
		if(movingobjectposition == null)
		{
			return itemstack;
		}
		else
		{
			if(movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
			{
				int i = movingobjectposition.blockX;
				int j = movingobjectposition.blockY;
				int k = movingobjectposition.blockZ;
				if(!world.canMineBlock(player, i, j, k))
				{
					return itemstack;
				}
				if(this.isFull == Blocks.air)
				{
					if(!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemstack))
					{
						return itemstack;
					}
					if(world.getBlock(i, j, k).getMaterial() == Material.water && world.getBlockMetadata(i, j, k) == 0)
					{
						world.setBlockToAir(i, j, k);
						if(player.capabilities.isCreativeMode)
						{
							return itemstack;
						}
						if(--itemstack.stackSize <= 0)
						{
							return new ItemStack(ACItems.bucketFrostWater);
						}
						if(!player.inventory.addItemStackToInventory(new ItemStack(ACItems.bucketFrostWater)))
						{
							player.dropPlayerItemWithRandomChoice(new ItemStack(ACItems.bucketFrostWater, 1, 0), false);
						}
						return itemstack;
					}
				}
				else
				{
					if(this.isFull  == Blocks.air)
					{
						return new ItemStack(ACItems.bucketEmpty);
					}
					if(movingobjectposition.sideHit == 0)
					{
						--j;
					}
					if(movingobjectposition.sideHit == 1)
					{
						++j;
					}
					if(movingobjectposition.sideHit == 2)
					{
						--k;
					}
					if(movingobjectposition.sideHit == 3)
					{
						++k;
					}
					if(movingobjectposition.sideHit == 4)
					{
						--i;
					}
					if(movingobjectposition.sideHit == 5)
					{
						++i;
					}
					if(!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemstack))
					{
						return itemstack;
					}
					if(this.tryPlaceContainedLiquid(world, i, j, k) && !player.capabilities.isCreativeMode)
					{
						return new ItemStack(ACItems.bucketEmpty);
					}
				}
			}
		}
		return itemstack;
	}

}
