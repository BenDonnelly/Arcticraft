package net.arcticraft.API.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.BlockJukebox;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemACRecord extends ItemRecord
{
    private static final Map recordMap = new HashMap();
    
    /** The name of the record. */
    public final String recordName;
    public final String cpID;
    private static final String __OBFID = "CL_00000057";

    public ItemACRecord(String name, String cpID)
    {
    	super(name);
    	
        this.recordName = name;
        this.cpID = cpID;
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabMisc);
        recordMap.put(cpID + ":records." + name, this); //Forge Bug Fix: RenderGlobal adds a "records." when looking up below.
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage)
    {
        return this.itemIcon;
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == Blocks.jukebox && world.getBlockMetadata(p_77648_4_, p_77648_5_, p_77648_6_) == 0)
        {
            if (world.isRemote)
            {
                return true;
            }
            else
            {
                ((BlockJukebox)Blocks.jukebox).func_149926_b(world, p_77648_4_, p_77648_5_, p_77648_6_, itemstack);
                world.playAuxSFXAtEntity((EntityPlayer)null, 1005, p_77648_4_, p_77648_5_, p_77648_6_, Item.getIdFromItem(this));
                --itemstack.stackSize;
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List infoList, boolean p_77624_4_)
    {
    	infoList.add(this.getRecordNameLocal());
    }

    @SideOnly(Side.CLIENT)
    public String getRecordNameLocal()
    {
        return StatCollector.translateToLocal("item.record." + this.recordName + ".desc");
    }

    /**
     * Return an item rarity from EnumRarity
     */
    public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.rare;
    }

    /**
     * Return the record item corresponding to the given name.
     */
    @SideOnly(Side.CLIENT)
    public static ItemRecord getRecord(String name)
    {
        return (ItemRecord)recordMap.get(name);
    }

    /**
     * Retrieves the resource location of the sound to play for this record.
     * 
     * @param name The name of the record to play
     * @return The resource location for the audio, null to use default.
     */
    public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation(this.cpID + ":" + name);
    }
}