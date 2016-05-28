package com.oitsjustjose.tinkers_addons.items;

import java.util.List;

import com.oitsjustjose.tinkers_addons.lib.Lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import slimeknights.tconstruct.library.TinkerRegistry;

public class ItemModMaterial extends Item
{
	String[] materials = new String[] { "MOSS_BALL", "EXTRA_MODIFIER_LVL1", "EXTRA_MODIFIER_LVL2", "EXTRA_MODIFIER_LVL3" };

	public ItemModMaterial()
	{
		this.setHasSubtypes(true);
		this.setCreativeTab(TinkerRegistry.tabGeneral);
		GameRegistry.registerItem(this, "modifier_item");
		registerRecipes();
		Lib.add(this);
	}

	@Override
	public boolean hasEffect(ItemStack itemstack)
	{
		return itemstack.getItemDamage() >= 2 ? true : false;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return "item." + Lib.MODID + "." + materials[itemStack.getItemDamage()];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < materials.length; i++)
			list.add(new ItemStack(item, 1, i));
	}

	void registerRecipes()
	{
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, 1, 0), Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, 1, 1), "gemDiamond", "blockGold"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, 1, 2), "blockDiamond", new ItemStack(Items.golden_apple, 1, 1)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, 1, 3), Items.nether_star, new ItemStack(Items.skull, 1, Short.MAX_VALUE)));
	}
}