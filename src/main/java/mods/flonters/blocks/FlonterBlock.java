package mods.flonters.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.client.block.ColoredBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class FlonterBlock extends FlowerBlock implements ColoredBlock {
    public final DyeColor color;

    public FlonterBlock(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings, DyeColor color) {
        super(suspiciousStewEffect,effectDuration,settings);
        this.color = color;
    }

    @Override
    public DyeColor getColor() { return color; }

    public boolean canGrow(IWorld world, BlockPos pos, BlockState state) { return world.getBlockState(pos.up()).canPlaceAt(world, pos); }
}
