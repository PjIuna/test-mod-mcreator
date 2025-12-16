package net.mcreator.shadow_s_end.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.shadow_s_end.procedures.FireprojecttaileenderspireProcedure;

public class EnderspireItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 650, 4f, 0, 2, TagKey.create(Registries.ITEM, ResourceLocation.parse("shadows_and_pjlunas_end:enderspire_repair_items")));

	public EnderspireItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 0.5f, -3.3f));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		FireprojecttaileenderspireProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, entity.getItemInHand(hand));
		return ar;
	}
}