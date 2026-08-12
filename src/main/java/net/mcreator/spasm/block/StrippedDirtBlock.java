package net.mcreator.spasm.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import com.mojang.serialization.MapCodec;

public class StrippedDirtBlock extends FallingBlock {
	public static final MapCodec<StrippedDirtBlock> CODEC = simpleCodec(StrippedDirtBlock::new);

	@Override
	public MapCodec<StrippedDirtBlock> codec() {
		return CODEC;
	}

	@Override
	public int getDustColor(BlockState blockstate, BlockGetter world, BlockPos pos) {
		return blockstate.getMapColor(world, pos).col;
	}

	public StrippedDirtBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.DIRT).sound(SoundType.GRAVEL).strength(0.5f));
	}
}