package net.mcreator.spasm.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class CobblestoneShovelItem extends ShovelItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 128, 15f, 0, 2, TagKey.create(Registries.ITEM, Identifier.parse("spasm:cobblestone_shovel_repair_items")));

	public CobblestoneShovelItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 0f, 6f, properties);
	}
}