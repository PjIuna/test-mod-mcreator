package net.mcreator.shadow_s_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.shadow_s_end.ShadowsAndPjlunasEndMod;

public class EndermagicWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isAlive()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("shadows_and_pjlunas_end:magic_fly")), SoundSource.AMBIENT, (float) 0.2,
							(float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("shadows_and_pjlunas_end:magic_fly")), SoundSource.AMBIENT, (float) 0.2, (float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5), false);
				}
			}
			ShadowsAndPjlunasEndMod.queueServerWork(100, () -> {
				if (entity.isAlive()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("shadows_and_pjlunas_end:magic_fly")), SoundSource.AMBIENT, (float) 0.2,
									(float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5));
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("shadows_and_pjlunas_end:magic_fly")), SoundSource.AMBIENT, (float) 0.2, (float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5),
									false);
						}
					}
				}
			});
		}
	}
}