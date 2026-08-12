/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spasm.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.spasm.block.StrippedDirtBlock;
import net.mcreator.spasm.block.SoakedDirtBlock;
import net.mcreator.spasm.block.DirtContainerBlock;
import net.mcreator.spasm.SpasmMod;

import java.util.function.Function;

public class SpasmModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(SpasmMod.MODID);
	public static final DeferredBlock<Block> STRIPPED_DIRT;
	public static final DeferredBlock<Block> DIRT_CONTAINER;
	public static final DeferredBlock<Block> SOAKED_DIRT;
	static {
		STRIPPED_DIRT = register("stripped_dirt", StrippedDirtBlock::new);
		DIRT_CONTAINER = register("dirt_container", DirtContainerBlock::new);
		SOAKED_DIRT = register("soaked_dirt", SoakedDirtBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}