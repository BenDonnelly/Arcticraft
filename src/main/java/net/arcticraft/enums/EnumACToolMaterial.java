package net.arcticraft.enums;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;


public class EnumACToolMaterial{

	/*Sorted from best to worst*/
	/**Params go as follows : name, harvest level(3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = WOOD/GOLD), max uses, efficiency, damage, enchantability**/
	public static ToolMaterial TekkiteTool = EnumHelper.addToolMaterial("Tekkite", 3, 1750, 9.0F, 3.5F, 14); 
	public static ToolMaterial EscariaTool = EnumHelper.addToolMaterial("Escaria", 3, 1400, 7.5F, 2.5F, 16);
	public static ToolMaterial GlacianTool = EnumHelper.addToolMaterial("Glacian", 2, 200, 6.5F, 2.0F, 18);
	public static ToolMaterial RigentemTool = EnumHelper.addToolMaterial("Rigentem", 1, 125, 4.5F, 1.0F, 20); 
	
	/*Vinallas for reference
    WOOD(0, 59, 2.0F, 0.0F, 15),
    STONE(1, 131, 4.0F, 1.0F, 5),
    IRON(2, 250, 6.0F, 2.0F, 14),
    EMERALD(3, 1561, 8.0F, 3.0F, 10),
    GOLD(0, 32, 12.0F, 0.0F, 22);*/
}
