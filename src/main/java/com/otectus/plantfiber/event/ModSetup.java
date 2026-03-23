package com.otectus.plantfiber.event;

import com.otectus.plantfiber.PlantFiberMod;
import com.otectus.plantfiber.registry.ModBlocks;
import java.lang.reflect.Field;
import java.util.Set;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

@Mod.EventBusSubscriber(modid = PlantFiberMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModSetup {
    private ModSetup() {
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(ModSetup::addGrassBedToBedType);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void addGrassBedToBedType() {
        try {
            Field field;
            try {
                field = ObfuscationReflectionHelper.findField(BlockEntityType.class, "f_58915_");
            } catch (Exception ignored) {
                field = ObfuscationReflectionHelper.findField(BlockEntityType.class, "validBlocks");
            }
            field.setAccessible(true);
            Set blocks = (Set) field.get(BlockEntityType.BED);
            
            // The set is immutable, so we need to create a new mutable set
            Set newBlocks = new java.util.HashSet(blocks);
            newBlocks.add(ModBlocks.GRASS_BED.get());
            
            // Replace the field with the new set
            field.set(BlockEntityType.BED, newBlocks);
            PlantFiberMod.LOGGER.info("Successfully registered grass bed with BlockEntityType.BED");
        } catch (Exception e) {
            PlantFiberMod.LOGGER.error("Failed to register grass bed with BlockEntityType.BED", e);
        }
    }
}
