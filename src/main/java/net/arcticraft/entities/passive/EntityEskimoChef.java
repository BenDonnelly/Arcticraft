package net.arcticraft.entities.passive;

import net.arcticraft.gui.GuiEskimoTalk;
import net.arcticraft.item.ACItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;

public class EntityEskimoChef extends EntityEskimoDefault {

	public EntityEskimoChef(World par1World) {
		super(par1World);
		this.setSize(1.5F, 1.4F);
		this.tasks.addTask(1, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));

	}


	
	public boolean isAIEnabled() {
		return true;
	}

	public boolean canDespawn() {
		return false;
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}

	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}

	@Override
	public void func_110297_a_(ItemStack itemstack)
	{
		addStuffToBuy(Items.cooked_fished, 1, 3, 0.3F);
		addStuffToBuy(Items.fish, 2, 5, 0.4F);
		//addStuffToBuy(AC_Block.floranBerry, 1,2, 0.1F);
		addStuffToSell(ACItems.penguinMeatCooked, 1, 6, 0.58F);
		addStuffToSell(ACItems.boarMeat, 1, 4, 0.5F);		
	}

}