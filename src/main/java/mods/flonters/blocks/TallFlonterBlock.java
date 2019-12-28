package mods.flonters.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.client.block.ColoredBlock;
import net.minecraft.util.DyeColor;

public class TallFlonterBlock extends TallFlowerBlock implements ColoredBlock {
    public final DyeColor color;

    public TallFlonterBlock(Block.Settings settings, DyeColor color) {
        super(settings);
        this.color = color;
    }

    @Override
    public DyeColor getColor() {
        return color;
    }
}
