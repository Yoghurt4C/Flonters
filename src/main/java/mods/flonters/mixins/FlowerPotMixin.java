package mods.flonters.mixins;

import mods.flonters.blocks.TallFlowerPotBlock;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(FlowerPotBlock.class)
public abstract class FlowerPotMixin {
    @Shadow
    @Final
    private static Map<Block, Block> CONTENT_TO_POTTED;

    @Inject(method = "onUse", at = @At(value = "JUMP", opcode = Opcodes.IFEQ, shift = At.Shift.AFTER, ordinal = 1), cancellable = true)
    public void tallFlowerPotInjection(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> ctx) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        Block flonter = Block.getBlockFromItem(item);
        Block pot = CONTENT_TO_POTTED.getOrDefault(flonter, Blocks.AIR);
        if (flonter instanceof TallFlowerBlock) {
            if (((TallFlowerPotBlock) pot).canPlaceAt(flonter.getDefaultState(), world, pos)) {
                ((TallFlowerPotBlock) pot).placeAt(world, pos, 3);
                player.incrementStat(Stats.POT_FLOWER);
                if (!player.getAbilities().creativeMode) {
                    itemStack.decrement(1);
                }
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                ctx.setReturnValue(ActionResult.success(world.isClient));
            } else {
                ctx.setReturnValue(ActionResult.CONSUME);
            }
        }
    }
}
