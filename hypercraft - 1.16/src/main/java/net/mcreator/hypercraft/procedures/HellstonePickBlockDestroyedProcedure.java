package net.mcreator.hypercraft.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.mcreator.hypercraft.HypercraftModElements;
import net.mcreator.hypercraft.HypercraftMod;

import java.util.Random;
import java.util.Map;

@HypercraftModElements.ModElement.Tag
public class HellstonePickBlockDestroyedProcedure extends HypercraftModElements.ModElement {
	public HellstonePickBlockDestroyedProcedure(HypercraftModElements instance) {
		super(instance, 20);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HypercraftMod.LOGGER.warn("Failed to load dependency entity for procedure HellstonePickBlockDestroyed!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				HypercraftMod.LOGGER.warn("Failed to load dependency itemstack for procedure HellstonePickBlockDestroyed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HypercraftMod.LOGGER.warn("Failed to load dependency x for procedure HellstonePickBlockDestroyed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HypercraftMod.LOGGER.warn("Failed to load dependency y for procedure HellstonePickBlockDestroyed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HypercraftMod.LOGGER.warn("Failed to load dependency z for procedure HellstonePickBlockDestroyed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HypercraftMod.LOGGER.warn("Failed to load dependency world for procedure HellstonePickBlockDestroyed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((ItemTags.getCollection().getTagByID(new ResourceLocation(("oreIron").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem()))
				|| (ItemTags.getCollection().getTagByID(new ResourceLocation(("oreGold").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem())))) {
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 5);
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 32, 1, 1, 1, 0.5);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("oreIron").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem()))) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.IRON_INGOT, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 2));
				}
			} else if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("oreGold").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem()))) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.GOLD_INGOT, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 3));
				}
			} else {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
							new BlockPos((int) x, (int) y, (int) z));
					world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
				}
			}
		} else if (((ItemTags.getCollection().getTagByID(new ResourceLocation(("oreDiamond").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem()))
				|| (ItemTags.getCollection().getTagByID(new ResourceLocation(("oreEmerald").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem())))) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 5));
			}
		} else if ((((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))
				.getItem() == new ItemStack(Blocks.STONE, (int) (1)).getItem())
				|| ((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))
						.getItem() == new ItemStack(Blocks.COBBLESTONE, (int) (1)).getItem()))) {
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 0, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 5);
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 32, 1, 1, 1, 0.5);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.STONE, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 1));
			}
		} else if (((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))
				.getItem() == new ItemStack(Blocks.OAK_LOG, (int) (1)).getItem())) {
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 0, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 5);
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 32, 1, 1, 1, 0.5);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.CHARCOAL, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 1));
			}
		} else if ((((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))
				.getItem() == new ItemStack(Blocks.SAND, (int) (1)).getItem())
				|| ((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))
						.getItem() == new ItemStack(Blocks.RED_SAND, (int) (1)).getItem()))) {
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 0, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 5);
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 32, 1, 1, 1, 0.5);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.GLASS, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 1));
			}
		} else {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			}
		}
	}
}
