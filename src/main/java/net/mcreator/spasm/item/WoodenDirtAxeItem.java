package net.mcreator.spasm.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class WoodenDirtAxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 12, 15f, 0, 1, TagKey.create(Registries.ITEM, Identifier.parse("spasm:wooden_dirt_axe_repair_items")));

	public WoodenDirtAxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 0f, -2f, properties);
	}
}