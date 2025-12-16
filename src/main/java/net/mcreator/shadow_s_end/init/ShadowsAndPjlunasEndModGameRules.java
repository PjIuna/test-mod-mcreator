/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.shadow_s_end.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber
public class ShadowsAndPjlunasEndModGameRules {
	public static GameRules.Key<GameRules.IntegerValue> SPACECLOCKTIMEAMOUNTSLOWEDDOWNFOR;
	public static GameRules.Key<GameRules.IntegerValue> AMOUNTSLOWEDDOWN;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		SPACECLOCKTIMEAMOUNTSLOWEDDOWNFOR = GameRules.register("spaceclocktimeamountsloweddownfor", GameRules.Category.MISC, GameRules.IntegerValue.create(95));
		AMOUNTSLOWEDDOWN = GameRules.register("amountsloweddown", GameRules.Category.PLAYER, GameRules.IntegerValue.create(5));
	}
}