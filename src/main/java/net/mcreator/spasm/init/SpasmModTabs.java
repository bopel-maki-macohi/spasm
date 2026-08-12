/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spasm.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.spasm.SpasmMod;

@EventBusSubscriber
public class SpasmModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SpasmMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(SpasmModItems.DIRT_CLUMP.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(SpasmModItems.DIRT_STICK.get());
			tabData.accept(SpasmModItems.DIRT_HOE.get());
			tabData.accept(SpasmModItems.DIRT_SHOVEL.get());
			tabData.accept(SpasmModItems.WOODEN_DIRT_SHOVEL.get());
			tabData.accept(SpasmModItems.WOODEN_DIRT_AXE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(SpasmModBlocks.STRIPPED_DIRT.get().asItem());
			tabData.accept(SpasmModBlocks.SOAKED_DIRT.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			tabData.accept(SpasmModBlocks.DIRT_CONTAINER.get().asItem());
		}
	}
}