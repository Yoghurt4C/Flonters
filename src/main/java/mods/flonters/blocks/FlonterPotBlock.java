package mods.flonters.blocks;

import mods.flonters.registry.FlontersBlocks;
import net.minecraft.block.*;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

public class FlonterPotBlock extends FlowerPotBlock implements Stainable {
    public final DyeColor color;

    public FlonterPotBlock(DyeColor color) {
        super(FlontersBlocks.getFlonter(color), Block.Settings.copy(Blocks.POTTED_POPPY));
        this.color = color;
    }

    @Override
    public DyeColor getColor() {
        return color;
    }

    public boolean canGrow(WorldAccess world, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.up()).canPlaceAt(world, pos);
    }
}
