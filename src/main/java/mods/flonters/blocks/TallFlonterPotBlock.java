package mods.flonters.blocks;

import mods.flonters.registry.FlontersBlocks;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class TallFlonterPotBlock extends TallFlowerPotBlock implements Stainable {
    public final DyeColor color;

    public TallFlonterPotBlock(DyeColor color) {
        super(FlontersBlocks.getTallFlonter(color), Block.Settings.copy(Blocks.POTTED_POPPY));
        this.color = color;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ePos) {
        if (state.equals(state.getBlock().getDefaultState().with(HALF, DoubleBlockHalf.UPPER))) {
            return VoxelShapes.empty();
        } else return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ePos) {
        if (state.equals(state.getBlock().getDefaultState().with(HALF, DoubleBlockHalf.UPPER))) {
            return VoxelShapes.empty();
        } else return SHAPE;
    }

    public DyeColor getColor() {
        return color;
    }
}
