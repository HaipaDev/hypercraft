package net.mcreator.hypercraft.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.Entity;

import net.mcreator.hypercraft.HypercraftModElements;
import net.mcreator.hypercraft.HypercraftMod;

import java.util.Map;

@HypercraftModElements.ModElement.Tag
public class HellstoneSwordMobIsHitProcedure extends HypercraftModElements.ModElement {
	public HellstoneSwordMobIsHitProcedure(HypercraftModElements instance) {
		super(instance, 33);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HypercraftMod.LOGGER.warn("Failed to load dependency entity for procedure HellstoneSwordMobIsHit!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HypercraftMod.LOGGER.warn("Failed to load dependency x for procedure HellstoneSwordMobIsHit!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HypercraftMod.LOGGER.warn("Failed to load dependency y for procedure HellstoneSwordMobIsHit!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HypercraftMod.LOGGER.warn("Failed to load dependency z for procedure HellstoneSwordMobIsHit!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HypercraftMod.LOGGER.warn("Failed to load dependency world for procedure HellstoneSwordMobIsHit!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 5, 3, 3, 3, 1);
		}
		entity.setFire((int) 7);
	}
}
