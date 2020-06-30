package mods.flonters.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Stainable;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.util.DyeColor;

public class TallFlonterBlock extends TallFlowerBlock implements Stainable {
    public final DyeColor color;

    public TallFlonterBlock(DyeColor color) {
        super(Block.Settings.copy(Blocks.ROSE_BUSH));
        this.color = color;
    }

    @Override
    public DyeColor getColor() {
        return color;
    }
}
