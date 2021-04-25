package net.mcreator.hypercraft.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.hypercraft.HypercraftModVariables;
import net.mcreator.hypercraft.HypercraftModElements;
import net.mcreator.hypercraft.HypercraftMod;

import java.util.Random;
import java.util.Map;
import java.util.Collections;

@HypercraftModElements.ModElement.Tag
public class CobaltCompassRightClickedProcedure extends HypercraftModElements.ModElement {
	public CobaltCompassRightClickedProcedure(HypercraftModElements instance) {
		super(instance, 30);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HypercraftMod.LOGGER.warn("Failed to load dependency entity for procedure CobaltCompassRightClicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				HypercraftMod.LOGGER.warn("Failed to load dependency itemstack for procedure CobaltCompassRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HypercraftMod.LOGGER.warn("Failed to load dependency x for procedure CobaltCompassRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HypercraftMod.LOGGER.warn("Failed to load dependency y for procedure CobaltCompassRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HypercraftMod.LOGGER.warn("Failed to load dependency z for procedure CobaltCompassRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HypercraftMod.LOGGER.warn("Failed to load dependency world for procedure CobaltCompassRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!world.getWorldInfo().isThundering())) {
			if ((!(entity.isSneaking()))) {
				if (((((HypercraftModVariables.WorldVariables.get(world).spawn_x) != 0)
						&& ((HypercraftModVariables.WorldVariables.get(world).spawn_y) != 0))
						&& ((HypercraftModVariables.WorldVariables.get(world).spawn_z) != 0))) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((HypercraftModVariables.WorldVariables.get(world).spawn_x),
								(HypercraftModVariables.WorldVariables.get(world).spawn_y),
								(HypercraftModVariables.WorldVariables.get(world).spawn_z));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((HypercraftModVariables.WorldVariables.get(world).spawn_x),
									(HypercraftModVariables.WorldVariables.get(world).spawn_y),
									(HypercraftModVariables.WorldVariables.get(world).spawn_z), _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.PORTAL, x, y, z, (int) 45, 4, 4, 4, 1);
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.enderman.teleport")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.enderman.teleport")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					{
						ItemStack _ist = (itemstack);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 100);
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 120, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 120, (int) 1, (false), (false)));
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("Use Shift+RMB to set tp point, use only RMB to teleport to that point"), (true));
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.ender_eye.launch")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.ender_eye.launch")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
				}
			} else {
				HypercraftModVariables.WorldVariables.get(world).spawn_x = (double) x;
				HypercraftModVariables.WorldVariables.get(world).syncData(world);
				HypercraftModVariables.WorldVariables.get(world).spawn_y = (double) y;
				HypercraftModVariables.WorldVariables.get(world).syncData(world);
				HypercraftModVariables.WorldVariables.get(world).spawn_z = (double) z;
				HypercraftModVariables.WorldVariables.get(world).syncData(world);
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.PORTAL, x, y, z, (int) 45, 4, 4, 4, 1);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.ender_chest.open")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.ender_chest.open")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				{
					ItemStack _ist = (itemstack);
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 100);
			}
		} else {
			if (world instanceof ServerWorld) {
				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
				_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
				_ent.setEffectOnly(false);
				((World) world).addEntity(_ent);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.hurt")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.hurt")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 5, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 500);
		}
	}
}
