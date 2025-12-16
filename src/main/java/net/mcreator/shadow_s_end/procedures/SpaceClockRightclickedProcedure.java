package net.mcreator.shadow_s_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.shadow_s_end.network.ShadowsAndPjlunasEndModVariables;
import net.mcreator.shadow_s_end.init.ShadowsAndPjlunasEndModGameRules;
import net.mcreator.shadow_s_end.ShadowsAndPjlunasEndMod;

public class SpaceClockRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ShadowsAndPjlunasEndModVariables.WorldVariables.get(world).time_freezen = 1;
		ShadowsAndPjlunasEndModVariables.WorldVariables.get(world).markSyncDirty();
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack, 460);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("shadows_and_pjlunas_end:time_freeze")), SoundSource.AMBIENT, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("shadows_and_pjlunas_end:time_freeze")), SoundSource.AMBIENT, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("/tick rate " + (world instanceof ServerLevel _serverLevelGR3 ? _serverLevelGR3.getGameRules().getInt(ShadowsAndPjlunasEndModGameRules.AMOUNTSLOWEDDOWN) : 0)));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.SPEED, (world instanceof ServerLevel _serverLevelGR5 ? _serverLevelGR5.getGameRules().getInt(ShadowsAndPjlunasEndModGameRules.SPACECLOCKTIMEAMOUNTSLOWEDDOWNFOR) : 0) + 5, 3));
		if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
			AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("shadows_and_pjlunas_end:madeinheaven"));
			if (_adv != null) {
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		SpaceClockEveryTickWhileUsingItemProcedure.execute(world, x, y, z);
		ShadowsAndPjlunasEndMod.queueServerWork((world instanceof ServerLevel _serverLevelGR8 ? _serverLevelGR8.getGameRules().getInt(ShadowsAndPjlunasEndModGameRules.SPACECLOCKTIMEAMOUNTSLOWEDDOWNFOR) : 0), () -> {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "/tick rate 20");
			ShadowsAndPjlunasEndModVariables.WorldVariables.get(world).time_freezen = 0;
			ShadowsAndPjlunasEndModVariables.WorldVariables.get(world).markSyncDirty();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("shadows_and_pjlunas_end:time_freeze")), SoundSource.AMBIENT, 1, (float) 1.4);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("shadows_and_pjlunas_end:time_freeze")), SoundSource.AMBIENT, 1, (float) 1.4, false);
				}
			}
		});
	}
}