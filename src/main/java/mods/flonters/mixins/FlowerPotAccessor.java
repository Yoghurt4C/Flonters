package mods.flonters.mixins;

import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Deprecated
@Mixin(FlowerPotBlock.class)
public interface FlowerPotAccessor {
    @Accessor("CONTENT_TO_POTTED")
    static Map<Block, Block> getContentToPotted() {
        throw new AssertionError("@Accessor dummy body called");
    }
}