package mods.flonters.blocks;

import mods.flonters.registry.FlontersBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Stainable;
import net.minecraft.util.DyeColor;

public class TallFlonterPotBlock extends TallFlowerPotBlock implements Stainable {
    public final DyeColor color;

    public TallFlonterPotBlock(DyeColor color) {
        super(FlontersBlocks.getTallFlonter(color), Block.Settings.copy(Blocks.POTTED_POPPY));
        this.color = color;
    }

    public DyeColor getColor() {
        return color;
    }
}
