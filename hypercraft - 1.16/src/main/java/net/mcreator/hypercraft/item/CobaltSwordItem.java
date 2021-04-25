
package net.mcreator.hypercraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import net.mcreator.hypercraft.procedures.CobaltSwordMobIsHitProcedure;
import net.mcreator.hypercraft.HypercraftModElements;

import java.util.Map;
import java.util.HashMap;

@HypercraftModElements.ModElement.Tag
public class CobaltSwordItem extends HypercraftModElements.ModElement {
	@ObjectHolder("hypercraft:cobaltsword")
	public static final Item block = null;
	public CobaltSwordItem(HypercraftModElements instance) {
		super(instance, 42);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1605;
			}

			public float getEfficiency() {
				return 1f;
			}

			public float getAttackDamage() {
				return 4.4f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CobaltIngotItem.block, (int) (1)));
			}
		}, 3, -3.2999999999999999f, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					CobaltSwordMobIsHitProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("cobaltsword"));
	}
}
