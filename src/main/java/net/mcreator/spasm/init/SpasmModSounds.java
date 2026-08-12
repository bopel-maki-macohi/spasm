/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.spasm.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.spasm.SpasmMod;

public class SpasmModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, SpasmMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_STRIPPED_DIRT_SOAKED = REGISTRY.register("block.stripped_dirt.soaked",
			() -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("spasm", "block.stripped_dirt.soaked")));
}