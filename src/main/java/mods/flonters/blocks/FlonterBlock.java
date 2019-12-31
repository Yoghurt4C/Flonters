package mods.flonters.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.client.block.ColoredBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class FlonterBlock extends FlowerBlock implements ColoredBlock {
    public final DyeColor color;

    public FlonterBlock(DyeColor color) {
        super(getPotionEffect(color),4, Block.Settings.copy(Blocks.POPPY));
        this.color = color;
    }

    private static StatusEffect getPotionEffect(DyeColor color) {
        switch (color) {
            case WHITE: return StatusEffects.SPEED;
            case ORANGE: return StatusEffects.FIRE_RESISTANCE;
            case MAGENTA: return StatusEffects.MINING_FATIGUE;
            case LIGHT_BLUE: return StatusEffects.JUMP_BOOST;
            case YELLOW: return StatusEffects.ABSORPTION;
            case LIME: return StatusEffects.POISON;
            case PINK: return StatusEffects.REGENERATION;
            case GRAY: return StatusEffects.RESISTANCE;
            case LIGHT_GRAY: return StatusEffects.WEAKNESS;
            case CYAN: return StatusEffects.WATER_BREATHING;
            case PURPLE: return StatusEffects.NAUSEA;
            case BLUE: return StatusEffects.NIGHT_VISION;
            case BROWN: return StatusEffects.WITHER;
            case GREEN: return StatusEffects.HUNGER;
            case RED: return StatusEffects.STRENGTH;
            case BLACK: return StatusEffects.BLINDNESS;
        }
        return StatusEffects.REGENERATION;
    }

    @Override
    public DyeColor getColor() { return color; }

    public boolean canGrow(IWorld world, BlockPos pos, BlockState state) { return world.getBlockState(pos.up()).canPlaceAt(world, pos); }
}
