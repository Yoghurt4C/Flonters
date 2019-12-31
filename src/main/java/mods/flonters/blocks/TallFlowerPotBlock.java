package mods.flonters.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import javax.annotation.Nullable;
import java.util.Random;

public class TallFlowerPotBlock extends FlowerPotBlock implements Fertilizable {
    public static final EnumProperty<DoubleBlockHalf> HALF;

    public TallFlowerPotBlock(Block content, Settings settings){
        super(content,settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(HALF, DoubleBlockHalf.LOWER));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState neighborState, IWorld world, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf)state.get(HALF);
        if (facing.getAxis() == Direction.Axis.Y && doubleBlockHalf == DoubleBlockHalf.LOWER == (facing == Direction.UP) && (neighborState.getBlock() != this || neighborState.get(HALF) == doubleBlockHalf)) {
            return Blocks.AIR.getDefaultState();
        } else {
            return doubleBlockHalf == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, facing, neighborState, world, pos, neighborPos);
        }
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        return blockPos.getY() < 255 && ctx.getWorld().getBlockState(blockPos.up()).canReplace(ctx) ? super.getPlacementState(ctx) : null;
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        world.setBlockState(pos.up(), (BlockState)this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), 3);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (state.get(HALF) != DoubleBlockHalf.UPPER) {
            return super.canPlaceAt(state, world, pos);
        } else {
            BlockState blockState = world.getBlockState(pos.down());
            return blockState.getBlock() == this && blockState.get(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    public void placeAt(IWorld world, BlockPos pos, int flags) {
        world.setBlockState(pos, (BlockState)this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER), flags);
        world.setBlockState(pos.up(), (BlockState)this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), flags);
    }

    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        super.afterBreak(world, player, pos, Blocks.AIR.getDefaultState(), blockEntity, stack);
    }

    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf)state.get(HALF);
        BlockPos blockPos = doubleBlockHalf == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.getBlock() == this && blockState.get(HALF) != doubleBlockHalf) {
            world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), 35);
            world.playLevelEvent(player, 2001, blockPos, Block.getRawIdFromState(blockState));
            if (!world.isClient && !player.isCreative()) {
                dropStacks(state, world, pos, (BlockEntity)null, player, player.getMainHandStack());
                dropStacks(blockState, world, blockPos, (BlockEntity)null, player, player.getMainHandStack());
            }
        }

        super.onBreak(world, pos, state, player);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{HALF});
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    @Environment(EnvType.CLIENT)
    public long getRenderingSeed(BlockState state, BlockPos pos) {
        return MathHelper.hashCode(pos.getX(), pos.down(state.get(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
    }

    static {
        HALF = Properties.DOUBLE_BLOCK_HALF;
    }

    public boolean canReplace(BlockState state, ItemPlacementContext ctx) {
        return false;
    }

    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        dropStack(world, pos, new ItemStack(((FlowerPotBlock)state.getBlock()).getContent().asItem()));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext ePos) {
        if (state.equals(state.getBlock().getDefaultState().with(HALF,DoubleBlockHalf.UPPER))) {return VoxelShapes.empty();}
        else return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, EntityContext ePos) {
        if (state.equals(state.getBlock().getDefaultState().with(HALF,DoubleBlockHalf.UPPER))) {return VoxelShapes.empty();}
        else return SHAPE;
    }
}
