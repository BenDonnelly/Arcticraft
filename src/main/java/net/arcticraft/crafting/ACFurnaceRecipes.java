package net.arcticraft.crafting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

public class ACFurnaceRecipes{

	private static final ACFurnaceRecipes smeltingBase = new ACFurnaceRecipes();
	/** The list of smelting results. */
	private Map smeltingList = new HashMap();
	private Map experienceList = new HashMap();
	private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
	private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static final ACFurnaceRecipes smelting()
	{
		return smeltingBase;
	}

	private ACFurnaceRecipes()
	{
		this.addSmeltingBlock(Blocks.iron_ore, new ItemStack(Items.iron_ingot), 0.7F);
		this.addSmeltingBlock(Blocks.gold_ore, new ItemStack(Items.gold_ingot), 1.0F);
		this.addSmeltingBlock(Blocks.diamond_ore, new ItemStack(Items.diamond), 1.0F);
		this.addSmeltingBlock(Blocks.sand, new ItemStack(Blocks.glass), 0.1F);
		this.addSmeltingItem(Items.porkchop, new ItemStack(Items.cooked_porkchop), 0.35F);
		this.addSmeltingItem(Items.beef, new ItemStack(Items.cooked_beef), 0.35F);
		this.addSmeltingItem(Items.chicken, new ItemStack(Items.cooked_chicken), 0.35F);
		this.addSmeltingBlock(Blocks.cobblestone, new ItemStack(Blocks.stone), 0.1F);
		this.addSmeltingItem(Items.clay_ball, new ItemStack(Items.brick), 0.3F);
		this.addSmeltingBlock(Blocks.clay, new ItemStack(Blocks.hardened_clay), 0.35F);
		this.addSmeltingBlock(Blocks.cactus, new ItemStack(Items.dye, 1, 2), 0.2F);
		this.addSmeltingBlock(Blocks.log, new ItemStack(Items.coal, 1, 1), 0.15F);
		this.addSmeltingBlock(Blocks.log2, new ItemStack(Items.coal, 1, 1), 0.15F);
		this.addSmeltingBlock(Blocks.emerald_ore, new ItemStack(Items.emerald), 1.0F);
		this.addSmeltingItem(Items.potato, new ItemStack(Items.baked_potato), 0.35F);
		this.addSmeltingBlock(Blocks.netherrack, new ItemStack(Items.netherbrick), 0.1F);
		ItemFishFood.FishType[] afishtype = ItemFishFood.FishType.values();
		int i = afishtype.length;

		for(int j = 0; j < i; ++j)
		{
			ItemFishFood.FishType fishtype = afishtype[j];

			if(fishtype.func_150973_i())
			{
				this.addSmelting(new ItemStack(Items.fish, 1, fishtype.func_150976_a()), new ItemStack(Items.cooked_fished, 1, fishtype.func_150976_a()), 0.35F);
			}
		}

		this.addSmeltingBlock(Blocks.coal_ore, new ItemStack(Items.coal), 0.1F);
		this.addSmeltingBlock(Blocks.redstone_ore, new ItemStack(Items.redstone), 0.7F);
		this.addSmeltingBlock(Blocks.lapis_ore, new ItemStack(Items.dye, 1, 4), 0.2F);
		this.addSmeltingBlock(Blocks.quartz_ore, new ItemStack(Items.quartz), 0.2F);
	}

	public void addSmeltingBlock(Block block, ItemStack itemstack, float xp)
	{
		this.addSmeltingItem(Item.getItemFromBlock(block), itemstack, xp);
	}

	public void addSmeltingItem(Item item, ItemStack itemstack, float xp)
	{
		this.addSmelting(new ItemStack(item, 1, 32767), itemstack, xp);
	}

	public void addSmelting(ItemStack itemstack, ItemStack itemstack1, float xp)
	{
		this.smeltingList.put(itemstack, itemstack1);
		this.experienceList.put(itemstack1, Float.valueOf(xp));
	}

	/**
	 * Returns the smelting result of an item. Deprecated in favor of a metadata sensitive version
	 */
	@Deprecated
	public ItemStack getSmeltingResult(int par1)
	{
		return (ItemStack) this.smeltingList.get(Integer.valueOf(par1));
	}

	public Map getSmeltingList()
	{
		return this.smeltingList;
	}

	@Deprecated
	// In favor of ItemStack sensitive version
	public float getExperience(int par1)
	{
		return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float) this.experienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
	}

	/**
	 * A metadata sensitive version of adding a furnace recipe.
	 */
	public void addSmelting(int itemID, int metadata, ItemStack itemstack, float experience)
	{
		metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
		metaExperience.put(Arrays.asList(itemID, metadata), experience);
	}

	/**
	 * Used to get the resulting ItemStack form a source ItemStack
	 * 
	 * @param item
	 *            The Source ItemStack
	 * @return The result ItemStack
	 */
	public ItemStack getSmeltingResult(ItemStack p_151395_1_)
	{
		Iterator iterator = this.smeltingList.entrySet().iterator();
		Entry entry;

		do
		{
			if(!iterator.hasNext())
			{
				return null;
			}

			entry = (Entry) iterator.next();
		}
		while(!this.func_151397_a(p_151395_1_, (ItemStack) entry.getKey()));

		return (ItemStack) entry.getValue();
	}

	private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
	{
		return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
	}

	/**
	 * Grabs the amount of base experience for this item to give when pulled from the furnace slot.
	 */
	public float getExperience(ItemStack item)
	{
		if(item == null || item.getItem() == null)
		{
			return 0;
		}
		float ret = item.getItem().getSmeltingExperience(item);
		if(ret < 0 && metaExperience.containsKey(Arrays.asList(item, item.getItemDamage())))
		{
			ret = metaExperience.get(Arrays.asList(item, item.getItemDamage()));
		}
		if(ret < 0 && experienceList.containsKey(item))
		{
			ret = ((Float) experienceList.get(item)).floatValue();
		}
		return(ret < 0 ? 0 : ret);
	}

	public Map<List<Integer>, ItemStack> getMetaSmeltingList()
	{
		return metaSmeltingList;
	}

}
