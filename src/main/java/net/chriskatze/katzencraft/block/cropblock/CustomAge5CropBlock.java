package net.chriskatze.katzencraft.block.cropblock;

import net.chriskatze.katzencraft.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CustomAge5CropBlock extends CropBlock {

    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = IntProperty.of("age", 0, 5);
    String seed;

    public CustomAge5CropBlock(Settings settings, String itemname) {
        super(settings);
        seed = itemname;
    }

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.6D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 5.2D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.8D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.4D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[this.getAge(state)];
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        switch (seed) {
            case "strawberry_crop": return ModItems.STRAWBERRY_SEEDS;

            default: return Items.WHEAT_SEEDS;
        }
    }

    @Override
    protected IntProperty getAgeProperty() {return AGE;}

    @Override
    public int getMaxAge() {return MAX_AGE;}

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {builder.add(AGE);}
}