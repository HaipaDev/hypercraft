package net.mcreator.hypercraft.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.hypercraft.HypercraftModElements;
import net.mcreator.hypercraft.HypercraftMod;

import java.util.Map;

@HypercraftModElements.ModElement.Tag
public class HellrockBlockEntityWalksOnTheBlockProcedure extends HypercraftModElements.ModElement {
	public HellrockBlockEntityWalksOnTheBlockProcedure(HypercraftModElements instance) {
		super(instance, 27);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HypercraftMod.LOGGER.warn("Failed to load dependency entity for procedure HellrockBlockEntityWalksOnTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 1.25);
		entity.attackEntityFrom(DamageSource.ON_FIRE, (float) 1);
	}
}
