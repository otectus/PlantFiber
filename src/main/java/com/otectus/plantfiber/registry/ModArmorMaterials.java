package com.otectus.plantfiber.registry;

import com.otectus.plantfiber.PlantFiberMod;
import com.otectus.plantfiber.config.PlantFiberConfig;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public final class ModArmorMaterials {
    public static final ArmorMaterial GRASS = new ArmorMaterial() {
        private final int[] baseDurability = new int[]{13, 15, 16, 11};
        private final int[] defense = new int[]{1, 2, 3, 1};

        @Override
        public int getDurabilityForType(ArmorItem.Type type) {
            int index = getTypeIndex(type);
            double multiplier = PlantFiberConfig.COMMON.grassArmorDurabilityMultiplier.get();
            double leatherMultiplier = 5.0d;
            return Math.max(1, (int) Math.floor(baseDurability[index] * leatherMultiplier * multiplier));
        }

        @Override
        public int getDefenseForType(ArmorItem.Type type) {
            return defense[getTypeIndex(type)];
        }

        @Override
        public int getEnchantmentValue() {
            return 15;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_LEATHER;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(ModItems.PLANT_FIBER.get());
        }

        @Override
        public String getName() {
            return PlantFiberMod.MODID + ":grass";
        }

        @Override
        public float getToughness() {
            return 0.0f;
        }

        @Override
        public float getKnockbackResistance() {
            return 0.0f;
        }

        private int getTypeIndex(ArmorItem.Type type) {
            return switch (type) {
                case BOOTS -> 0;
                case LEGGINGS -> 1;
                case CHESTPLATE -> 2;
                case HELMET -> 3;
            };
        }
    };

    private ModArmorMaterials() {
    }
}


