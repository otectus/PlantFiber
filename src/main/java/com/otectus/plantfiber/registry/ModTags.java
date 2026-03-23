package com.otectus.plantfiber.registry;

import com.otectus.plantfiber.PlantFiberMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class ModTags {
    public static final TagKey<Block> VEGETATION = TagKey.create(Registries.BLOCK, new ResourceLocation(PlantFiberMod.MODID, "vegetation"));
    public static final TagKey<Item> BANDAGE_PLANTS = TagKey.create(Registries.ITEM, new ResourceLocation(PlantFiberMod.MODID, "bandage_plants"));

    private ModTags() {
    }
}


