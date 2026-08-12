/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spasm.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.spasm.item.DirtStickItem;
import net.mcreator.spasm.item.DirtShovelItem;
import net.mcreator.spasm.item.DirtHoeItem;
import net.mcreator.spasm.item.DirtClumpItem;
import net.mcreator.spasm.block.DirtContainerBlock;
import net.mcreator.spasm.SpasmMod;

import java.util.function.Function;

public class SpasmModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(SpasmMod.MODID);
	public static final DeferredItem<Item> DIRT_CLUMP;
	public static final DeferredItem<Item> DIRT_STICK;
	public static final DeferredItem<Item> STRIPPED_DIRT;
	public static final DeferredItem<Item> DIRT_HOE;
	public static final DeferredItem<Item> DIRT_SHOVEL;
	public static final DeferredItem<Item> DIRT_CONTAINER;
	static {
		DIRT_CLUMP = register("dirt_clump", DirtClumpItem::new);
		DIRT_STICK = register("dirt_stick", DirtStickItem::new);
		STRIPPED_DIRT = block(SpasmModBlocks.STRIPPED_DIRT);
		DIRT_HOE = register("dirt_hoe", DirtHoeItem::new);
		DIRT_SHOVEL = register("dirt_shovel", DirtShovelItem::new);
		DIRT_CONTAINER = register("dirt_container", DirtContainerBlock.Item::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, Item.Properties::new);
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), () -> properties);
	}
}