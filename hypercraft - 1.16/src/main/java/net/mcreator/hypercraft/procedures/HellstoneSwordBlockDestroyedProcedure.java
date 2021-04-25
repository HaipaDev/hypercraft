package net.mcreator.hypercraft.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.hypercraft.HypercraftModElements;
import net.mcreator.hypercraft.HypercraftMod;

import java.util.Map;

@HypercraftModElements.ModElement.Tag
public class HellstoneSwordBlockDestroyedProcedure extends HypercraftModElements.ModElement {
	public HellstoneSwordBlockDestroyedProcedure(HypercraftModElements instance) {
		super(instance, 35);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HypercraftMod.LOGGER.warn("Failed to load dependency x for procedure HellstoneSwordBlockDestroyed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HypercraftMod.LOGGER.warn("Failed to load dependency y for procedure HellstoneSwordBlockDestroyed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HypercraftMod.LOGGER.warn("Failed to load dependency z for procedure HellstoneSwordBlockDestroyed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HypercraftMod.LOGGER.warn("Failed to load dependency world for procedure HellstoneSwordBlockDestroyed!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.COBWEB.getDefaultState().getBlock())) {
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 0.5, Explosion.Mode.BREAK);
			}
		}
	}
}
