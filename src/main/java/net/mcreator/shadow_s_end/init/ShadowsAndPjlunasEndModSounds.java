/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.shadow_s_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.shadow_s_end.ShadowsAndPjlunasEndMod;

public class ShadowsAndPjlunasEndModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, ShadowsAndPjlunasEndMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> TIME_FREEZE = REGISTRY.register("time_freeze", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("shadows_and_pjlunas_end", "time_freeze")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CLOCK_TICKING = REGISTRY.register("clock_ticking", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("shadows_and_pjlunas_end", "clock_ticking")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MAGIC_FLY = REGISTRY.register("magic_fly", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("shadows_and_pjlunas_end", "magic_fly")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SPELL_CASTED = REGISTRY.register("spell_casted", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("shadows_and_pjlunas_end", "spell_casted")));
	public static final DeferredHolder<SoundEvent, SoundEvent> IMPACT = REGISTRY.register("impact", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("shadows_and_pjlunas_end", "impact")));
}