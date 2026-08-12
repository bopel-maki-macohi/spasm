package net.mcreator.spasm.procedures;

import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class DirtContainerOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("empty") instanceof BooleanProperty _booleanProp)
				world.setBlock(_pos,
						_bs.setValue(_booleanProp,
								(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() + itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount()
										+ itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount()
										+ itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() < 1)),
						3);
		}
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			ResourceHandler<ItemResource> itemHandler = ext.getCapability(Capabilities.Item.BLOCK, pos, null);
			if (itemHandler != null)
				return ItemUtil.getStack(itemHandler, slot);
		}
		return ItemStack.EMPTY;
	}
}