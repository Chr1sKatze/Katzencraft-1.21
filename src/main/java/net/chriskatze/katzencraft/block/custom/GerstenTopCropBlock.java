package net.chriskatze.katzencraft.block.custom;

import net.chriskatze.katzencraft.block.ModBlocks;
import net.chriskatze.katzencraft.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class GerstenTopCropBlock extends GerstenCropBlock {

    public static final int MAX_AGE = 2;
    public static final IntProperty AGE = IntProperty.of("age", 0, 2);

    private static final VoxelShape[] AGE_TO_SHAPE =
            new VoxelShape[] {
                    Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 5.3D, 16.0D),
                    Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.6D, 16.0D),
                    Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public GerstenTopCropBlock(Settings settings) {
        super (settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[this.getAge(state)];
    }

    @Override
    public int getMaxAge() {
        return 2;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return super.canPlaceAt(state, world, pos) || (world.getBlockState(pos.down(1)).isOf(ModBlocks.GERSTEN_BOTTOM_CROP) &&
                world.getBlockState(pos.down(1)).get(GerstenBottomCropBlock.AGE) == GerstenBottomCropBlock.MAX_AGE);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient && (world.getBlockState(pos.down(1)).isOf(ModBlocks.GERSTEN_BOTTOM_CROP))) {
            world.breakBlock(pos.down(1), false);
        }
        return super.onBreak(world, pos, state, player);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.STRAWBERRY;
    }
}