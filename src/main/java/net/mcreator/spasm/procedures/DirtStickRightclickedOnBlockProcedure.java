package net.mcreator.spasm.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.core.BlockPos;

import net.mcreator.spasm.init.SpasmModBlocks;

public class DirtStickRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, ItemStack itemstack) {
		if (blockstate == Blocks.GRASS_BLOCK.defaultBlockState() || blockstate == Blocks.DIRT_PATH.defaultBlockState() || blockstate.is(BlockTags.create(Identifier.parse("minecraft:dirt")))) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
			if (Math.random() >= 0.1) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.WHEAT_SEEDS));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				world.setBlock(BlockPos.containing(x, y, z), SpasmModBlocks.STRIPPED_DIRT.get().defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
			} else {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.DIRT.defaultBlockState(), 3);
			}
		}
	}
}