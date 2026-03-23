package com.otectus.plantfiber.item;

import com.otectus.plantfiber.config.PlantFiberConfig;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BedItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

public class ConfigurableBedItem extends BedItem {
    public ConfigurableBedItem(Block block, Item.Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!PlantFiberConfig.COMMON.enableGrassBed.get()) {
            return InteractionResult.FAIL;
        }
        return super.useOn(context);
    }
}


