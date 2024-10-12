package net.chriskatze.katzencraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class GerstenCropBlock extends CropBlock {

    public GerstenCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return false;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(getAgeProperty());
    }
}
