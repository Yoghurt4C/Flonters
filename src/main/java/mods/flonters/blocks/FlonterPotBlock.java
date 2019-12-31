package mods.flonters.blocks;

import mods.flonters.registry.FlontersBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.client.block.ColoredBlock;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class FlonterPotBlock extends FlowerPotBlock implements ColoredBlock {
    public final DyeColor color;

    public FlonterPotBlock(DyeColor color){
        super(FlontersBlocks.getFlonter(color), Block.Settings.copy(Blocks.POTTED_POPPY));
        this.color = color;
    }

    @Override
    public DyeColor getColor() { return color; }

    public boolean canGrow(IWorld world, BlockPos pos, BlockState state) { return world.getBlockState(pos.up()).canPlaceAt(world, pos); }
}
