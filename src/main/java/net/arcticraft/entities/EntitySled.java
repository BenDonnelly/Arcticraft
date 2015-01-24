package net.arcticraft.entities;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.item.ACItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntitySled extends ACEntity {
	private double speedMultiplier;
	private int sledPosRotationIncrements;
	private double sledX;
	private double sledY;
	private double sledZ;
	private double sledYaw;
	private double sledPitch;
	@SideOnly(Side.CLIENT)
	private double velocityX;
	@SideOnly(Side.CLIENT)
	private double velocityY;
	@SideOnly(Side.CLIENT)
	private double velocityZ;
	
	public EntitySled(World world) {
		super(world);
		
		this.stepHeight = 0.25F;
		this.speedMultiplier = 0.01D;
		this.preventEntitySpawning = true;
		this.setSize(0.9F, 0.25F);
	}

	public EntitySled(World world, double x, double y, double z) {
		super(world);
		
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
		this.setPosition(x, y + (double) this.yOffset, z);
	}


	/**
	 * First layer of player interaction
	 */
	@Override
	public boolean interactFirst(EntityPlayer p_130002_1_) {
		if (this.riddenByEntity != null
				&& this.riddenByEntity instanceof EntityPlayer
				&& this.riddenByEntity != p_130002_1_) {
			return true;
		} else if (this.riddenByEntity != null
				&& this.riddenByEntity != p_130002_1_) {
			return false;
		} else {
			if (!this.worldObj.isRemote) {
				p_130002_1_.mountEntity(this);
			}

			return true;
		}
	}
	
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void entityInit() {

	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		Block blockID = this.worldObj.getBlock((int) Math.floor(this.posX),
				(int) Math.floor(this.posY), (int) Math.floor(this.posZ));

		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		if (!this.onGround) {
			this.motionY -= 0.05F;
		}

        double d71 = 0;
        double d81 = 0;
        double d91 = 0;
        double d101 = 0;
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase)
        {
            d71 = (double)((EntityLivingBase)this.riddenByEntity).moveForward;

            if (d71 > 0.0D)
            {
                d81 = -Math.sin((double)(this.riddenByEntity.rotationYaw * (float)Math.PI / 180.0F));
                d91 = Math.cos((double)(this.riddenByEntity.rotationYaw * (float)Math.PI / 180.0F));
                d101 = this.motionX * this.motionX + this.motionZ * this.motionZ;

                if (d101 < 0.01D)
                {
                    this.motionX += d81 * 0.1D;
                    this.motionZ += d91 * 0.1D;
                }
            }
        }
		
		if (blockID == Blocks.snow_layer
				|| blockID == Blocks.snow
						|| blockID == ACBlocks.frostSnow || blockID == ACBlocks.frostStone) {
			speedMultiplier += 0.0001f;
			
			int x, y, z;
			int meta = this.worldObj.getBlockMetadata(
					(int) Math.floor(this.posX), (int) Math.floor(this.posY),
					(int) Math.floor(this.posZ));
			int[] direction = { 0, 0 };

			if (blockID == ACBlocks.frostSnow) {
				meta = 1;
			}

			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					x = (int) Math.floor(this.posX + (double) i);
					y = (int) Math.floor(this.posY);
					z = (int) Math.floor(this.posZ + (double) j);

					if (((this.worldObj.getBlock(x, y, z) == Blocks.snow || this.worldObj.getBlock(x, y, z) == Blocks.snow_layer || this.worldObj
							.getBlock(x, y, z) == ACBlocks.frostSnow|| this.worldObj
							.getBlock(x, y, z) == ACBlocks.frostStone) && meta > this.worldObj
							.getBlockMetadata(x, y, z))
							|| (this.worldObj.getBlock(x, y - 1, z) == Blocks.snow || this.worldObj.getBlock(x, y - 1, z) == Blocks.snow_layer || this.worldObj
									.getBlock(x, y - 1, z) == ACBlocks.frostSnow || this.worldObj
									.getBlock(x, y - 1, z) == ACBlocks.frostStone)) {
						meta = this.worldObj.getBlockMetadata(x, y, z);
						direction[0] = i;
						direction[1] = j;
					}
				}
			}

			this.motionX += (double) direction[0] * this.speedMultiplier;
			this.motionZ += (double) direction[1] * this.speedMultiplier;

			double d4 = Math.cos((double) this.rotationYaw * Math.PI / 180.0D);
			double d5 = Math.sin((double) this.rotationYaw * Math.PI / 180.0D);

			if (this.onGround) {
				for (int j = 0; j < Math.sqrt(this.motionX * this.motionX
						+ this.motionZ * this.motionZ) * 100; j++) {
					double d6 = (double) (this.rand.nextFloat() * 2.0F - 1.0F);
					double d7 = (double) (this.rand.nextInt(2) * 2 - 1) * 0.4D;
					double d8 = this.posX - d4 * d6 * 0.4D + d5 * d7;
					double d9 = this.posZ - d5 * d6 * 0.4D - d4 * d7;

					this.worldObj.spawnParticle("snowshovel", d8,
							this.posY + 0.125D, d9, this.motionX, this.motionY,
							this.motionZ);
				}
			}
		}

		if (this.motionX != 0 || this.motionZ != 0) {
			this.rotationYaw = (180.0F / (float) Math.PI)
					* (float) Math.atan2((double) this.motionZ,
							(double) this.motionX) - 180.0F;
		}

		this.motionX *= 0.98F;
		this.motionZ *= 0.98F;

        this.posX = posX * d71;
        this.posZ = posZ * d71;
		
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.setPosition(this.posX, this.posY, this.posZ);
		this.setRotation(this.rotationYaw, this.rotationPitch);
	}

	@Override
	public void updateRiderPosition() {
		if (this.riddenByEntity != null) {
			double d0 = Math.cos((double) this.rotationYaw * Math.PI / 180.0D) * 0.4D;
			double d1 = Math.sin((double) this.rotationYaw * Math.PI / 180.0D) * 0.4D;
			this.riddenByEntity.setPosition(
					this.posX + d0,
					this.posY + this.getMountedYOffset()
							+ this.riddenByEntity.getYOffset(), this.posZ + d1);
		}
	}

	@Override
	public void setPositionAndRotation2(double par1, double par3, double par5,
			float par7, float par8, int par9) {
		this.sledPosRotationIncrements = 10;

		this.sledX = par1;
		this.sledY = par3;
		this.sledZ = par5;
		this.sledYaw = (double) par7;
		this.sledPitch = (double) par8;
		this.motionX = this.velocityX;
		this.motionY = this.velocityY;
		this.motionZ = this.velocityZ;
	}

	@Override
	public void setVelocity(double par1, double par3, double par5) {
		this.velocityX = this.motionX = par1;
		this.velocityY = this.motionY = par3;
		this.velocityZ = this.motionZ = par5;
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else if (!this.worldObj.isRemote && !this.isDead) {
			this.setBeenAttacked();
			boolean creative = par1DamageSource.getEntity() instanceof EntityPlayer
					&& ((EntityPlayer) par1DamageSource.getEntity()).capabilities.isCreativeMode;

			if (!creative) {
				this.dropItem(ACItems.itemSled, 1);
			}

			this.setDead();

			return true;
		} else {
			return true;
		}
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {

	}

	@Override
	public boolean canBePushed() {
		return true;
	}

	@Override
	public double getMountedYOffset() {
		return (double) this.height;
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity par1Entity) {
		return par1Entity.boundingBox;
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return this.boundingBox;
	}

	@Override
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	@Override
	public float getShadowSize() {
		return 0.0F;
	}
}