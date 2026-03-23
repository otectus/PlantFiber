package com.otectus.plantfiber.client;

import com.otectus.plantfiber.PlantFiberMod;
import com.otectus.plantfiber.registry.ModBlocks;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = PlantFiberMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            try {
                Material grassBedMaterial = new Material(Sheets.BED_SHEET, 
                    new ResourceLocation(PlantFiberMod.MODID, "entity/bed/grass"));
                
                // Use reflection to access and modify BED_MATERIALS
                Field field;
                try {
                    field = ObfuscationReflectionHelper.findField(Sheets.class, "f_110744_");
                } catch (Exception ignored) {
                    field = ObfuscationReflectionHelper.findField(Sheets.class, "BED_MATERIALS");
                }
                
                field.setAccessible(true);
                @SuppressWarnings("unchecked")
                Map<Block, Material> originalMap = (Map<Block, Material>) field.get(null);

                Map<Block, Material> newMap = new HashMap<>(originalMap);
                newMap.put(ModBlocks.GRASS_BED.get(), grassBedMaterial);

                field.set(null, newMap);
                PlantFiberMod.LOGGER.info("Successfully registered grass bed material. Total beds: " + newMap.size());
            } catch (Exception e) {
                PlantFiberMod.LOGGER.error("Failed to register grass bed material", e);
                e.printStackTrace();
            }
        });
    }
}
