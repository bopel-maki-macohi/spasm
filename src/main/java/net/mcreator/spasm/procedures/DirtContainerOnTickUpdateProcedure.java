package net.mcreator.spasm.procedures;

import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class DirtContainerOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String id = "";
		String cmd = "";
		String cmd2 = "";
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putString("id", ("dirt_container_" + (Math.round(x) + "_") + (Math.round(y) + "_") + (Math.round(z) + "_") + "label"));
				_blockEntity.getPersistentData().putString("kill_cmd", ("/kill @e[type=text_display,tag=" + getBlockNBTString(world, BlockPos.containing(x, y, z), "id") + "]"));
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		cmd = "/summon text_display ~ ~1 ~ " + "{width:320f, height:320f, " + "billboard:\"center\", " + "Tags:[\"" + getBlockNBTString(world, BlockPos.containing(x, y, z), "id") + "\"], text:\""
				+ ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getDisplayName().getString() + " x" + itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount()) + "\"}";
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getStringOr(tag, "");
		return "";
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