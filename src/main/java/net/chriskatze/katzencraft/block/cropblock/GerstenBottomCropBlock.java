package net.chriskatze.katzencraft.block.cropblock;

import net.chriskatze.katzencraft.block.ModBlocks;
import net.chriskatze.katzencraft.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class GerstenBottomCropBlock extends GerstenCropBlock {

    public static final int MAX_AGE = 3;
    public static final BooleanProperty IS_FINAL_AGE = BooleanProperty.of("is_final");
    public static final IntProperty AGE = IntProperty.of("age", 0, 3);

    private static final VoxelShape[] AGE_TO_SHAPE =
            new VoxelShape[] {
                    Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
                    Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
                    Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
                    Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public GerstenBottomCropBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(IS_FINAL_AGE, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[this.getAge(state)];
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (this.isFinalAge(state)) return;
        if (!world.getBlockState(pos).isOf(ModBlocks.GERSTEN_BOTTOM_CROP)) return;
        if (world.getBaseLightLevel(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i <= this.getMaxAge()) {
                float f = getAvailableMoisture(this, world, pos);
                if (random.nextInt((int)(25.0F / f) + 1) == 0) {
                    if (i < this.getMaxAge()) { world.setBlockState(pos, this.withAge(i + 1), Block.NOTIFY_LISTENERS); }
                    BlockState stateup = world.getBlockState(pos.up(1));
                    if (stateup.isOf(ModBlocks.GERSTEN_TOP_CROP)) {
                        CropBlock topblock = ((CropBlock)(stateup.getBlock()));
                        int j = topblock.getAge(stateup);
                        if (j < topblock.getMaxAge()) {
                            world.setBlockState(pos.up(1), topblock.withAge(j + 1), Block.NOTIFY_LISTENERS);
                        }
                        else {
                            world.setBlockState(pos, state.with(IS_FINAL_AGE, true), Block.NOTIFY_LISTENERS);
                        }
                    }
                }
            }
        }
    }

    public BlockState withIsFinalAge (boolean isFinalAge) {
        return this.getDefaultState().with(this.getFinalAgeProperty(), isFinalAge);
    }

    public boolean isFinalAge(BlockState state) {
        return (Boolean) state.get(this.getFinalAgeProperty());
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return !this.isFinalAge(state);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    protected BooleanProperty getFinalAgeProperty() {
        return IS_FINAL_AGE;
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient && (world.getBlockState(pos.up(1)).isOf(ModBlocks.GERSTEN_TOP_CROP))) {
            world.breakBlock(pos.up(1), true);
        }
        return super.onBreak(world, pos, state, player);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.GERSTEN_SEEDS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(getAgeProperty());
        builder.add(getFinalAgeProperty());
    }
}