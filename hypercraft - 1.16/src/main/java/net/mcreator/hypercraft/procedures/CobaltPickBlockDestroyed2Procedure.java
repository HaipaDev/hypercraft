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
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.block.Block;

import net.mcreator.hypercraft.item.IronOreItemItem;
import net.mcreator.hypercraft.item.GoldOreItemItem;
import net.mcreator.hypercraft.item.EmeraldOreItemItem;
import net.mcreator.hypercraft.item.DiamondOreItemItem;
import net.mcreator.hypercraft.HypercraftModElements;
import net.mcreator.hypercraft.HypercraftMod;

import java.util.Random;
import java.util.Map;

@HypercraftModElements.ModElement.Tag
public class CobaltPickBlockDestroyed2Procedure extends HypercraftModElements.ModElement {
	public CobaltPickBlockDestroyed2Procedure(HypercraftModElements instance) {
		super(instance, 12);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				HypercraftMod.LOGGER.warn("Failed to load dependency itemstack for procedure CobaltPickBlockDestroyed2!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HypercraftMod.LOGGER.warn("Failed to load dependency x for procedure CobaltPickBlockDestroyed2!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HypercraftMod.LOGGER.warn("Failed to load dependency y for procedure CobaltPickBlockDestroyed2!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HypercraftMod.LOGGER.warn("Failed to load dependency z for procedure CobaltPickBlockDestroyed2!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HypercraftMod.LOGGER.warn("Failed to load dependency world for procedure CobaltPickBlockDestroyed2!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((ItemTags.getCollection().getTagByID(new ResourceLocation(("oreIron").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem()))
				|| (ItemTags.getCollection().getTagByID(new ResourceLocation(("oreGold").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem())))
				|| ((ItemTags.getCollection().getTagByID(new ResourceLocation(("oreDiamond").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem()))
						|| ((ItemTags.getCollection().getTagByID(new ResourceLocation(("oreEmerald").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem()))
								|| (ItemTags.getCollection().getTagByID(new ResourceLocation(("oreCoal").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))
												.getItem())))))) {
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 2, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.PORTAL, x, y, z, (int) 16, 3, 3, 3, 2);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.death")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.death")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("oreIron").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem()))) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(IronOreItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(IronOreItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(IronOreItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 2));
				}
			} else if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("oreGold").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem()))) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(GoldOreItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(GoldOreItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(GoldOreItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 3));
				}
			} else if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("oreDiamond").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem()))) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(DiamondOreItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(DiamondOreItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(DiamondOreItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 4));
				}
			} else if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("oreEmerald").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem()))) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(EmeraldOreItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(EmeraldOreItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(EmeraldOreItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 5));
				}
			} else if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("oreCoal").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getItem()))) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.COAL, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.COAL, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.COAL, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.COAL, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.COAL, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 5));
				}
			} else {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
							new BlockPos((int) x, (int) y, (int) z));
					world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
				}
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
