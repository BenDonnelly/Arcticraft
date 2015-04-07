package net.arcticraft.entities.passive;

import net.arcticraft.API.misc.EskimoTrade;
import net.arcticraft.gui.GuiTraderEskimo;
import net.arcticraft.item.ACItems;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;

public class EntityEskimoTrader extends EntityMob implements IMob {

	private EskimoTrade[] trades = new EskimoTrade[35];

	public EntityEskimoTrader(World par1World) {
		super(par1World);
		
		this.setSize(1.5F, 1.4F);
		this.tasks.addTask(1, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.tasks.addTask(11, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		
		this.addTrades();
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(40.0D);
		// Follow Range - default 32.0D - min 0.0D - max 2048.0D
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
				.setBaseValue(32.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.23000000417232513D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setBaseValue(3.0D);
	}

	@Override
	public boolean interact(EntityPlayer player) {
		if (player.getHeldItem() != null && player.getHeldItem().getItem() != null && player.getHeldItem().getItem() == ACItems.eriumGem) {
			FMLClientHandler.instance().displayGuiScreen(player,
					new GuiTraderEskimo(player.inventory, this));
			return true;
		} else {
			if (player.worldObj.isRemote) {
				Minecraft.getMinecraft().thePlayer
						.sendChatMessage("You require Erium gems if you want to trade with me. Hold them in your hand.");
			}
			
			return false;
		}
	}

	private void addTrades() {
		this.addTrade(0, Blocks.fence, 6, 5);
		this.addTrade(1, Items.cake, 2);
		this.addTrade(2, Blocks.anvil, 10);
		this.addTrade(3, Blocks.jukebox, 5);
		this.addTrade(4, Items.bow, 5);
		this.addTrade(5, Items.ender_pearl, 3);
		this.addTrade(6, Items.arrow, 32, 7);
		this.addTrade(7, Items.apple, 1);
	}

	public void addTrade(int slotIndex, ItemStack ID, int amount, int damage,
			int price, boolean abc) {
		int lastID = this.trades.length - 1;
		int index = lastID - MathHelper.clamp_int(slotIndex, 0, lastID);

		if (this.trades[index] != null) {
			throw new IllegalArgumentException("Slot " + index
					+ " is already occupied by " + this.trades[index]);
		} else {
			this.trades[index] = new EskimoTrade(new ItemStack(ID.getItem(),
					amount, damage), price);
		}
	}

	public EskimoTrade[] getTrades() {
		return this.trades;
	}

	public boolean isAIEnabled() {
		return true;
	}

	public boolean canDespawn() {
		return false;
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
		return false;
	}

	// public int getMaxHealth()
	// {
	// return 40;
	// }

	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}

	public void addTrade(int slotIndex, Block block, int amount, int damage,
			int price) {
		this.addTrade(slotIndex, new ItemStack(block), amount, damage, price, true);
	}

	public void addTrade(int slotIndex, Block block, int amount, int price) {
		this.addTrade(slotIndex, new ItemStack(block), amount, 0, price, true);
	}

	public void addTrade(int slotIndex, Block block, int price) {
		this.addTrade(slotIndex, new ItemStack(block), 1, 0, price, true);
	}

	public void addTrade(int slotIndex, Item item, int amount, int damage,
			int price) {
		this.addTrade(slotIndex, new ItemStack(item), amount, damage, price, true);
	}

	public void addTrade(int slotIndex, Item item, int amount, int price) {
		this.addTrade(slotIndex, new ItemStack(item), amount, 0, price, true);
	}

	public void addTrade(int slotIndex, Item item, int price) {
		this.addTrade(slotIndex, new ItemStack(item), 1, 0, price, true);
	}
}