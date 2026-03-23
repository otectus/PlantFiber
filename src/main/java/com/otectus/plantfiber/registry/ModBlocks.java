package com.otectus.plantfiber.registry;

import com.otectus.plantfiber.PlantFiberMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PlantFiberMod.MODID);

    public static final RegistryObject<Block> GRASS_FIBER_BLOCK = BLOCKS.register("grass_fiber_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.6f).sound(SoundType.GRASS).ignitedByLava()) {
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> GRASS_BED = BLOCKS.register("grass_bed",
            () -> new BedBlock(DyeColor.GREEN,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2f).sound(SoundType.WOOD).noOcclusion()));

    private ModBlocks() {
    }
}


