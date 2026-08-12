/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spasm.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.spasm.item.DirtClumpItem;
import net.mcreator.spasm.SpasmMod;

import java.util.function.Function;

public class SpasmModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(SpasmMod.MODID);
	public static final DeferredItem<Item> DIRT_CLUMP;
	static {
		DIRT_CLUMP = register("dirt_clump", DirtClumpItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, Item.Properties::new);
	}
}