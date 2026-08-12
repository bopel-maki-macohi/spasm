package net.mcreator.spasm.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class DirtStickItem extends ShovelItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 8, 4f, 0, 2, TagKey.create(Registries.ITEM, Identifier.parse("spasm:dirt_stick_repair_items")));

	public DirtStickItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 0f, -3.9f, properties);
	}
}