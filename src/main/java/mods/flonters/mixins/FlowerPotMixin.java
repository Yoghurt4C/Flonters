package mods.flonters.mixins;

import mods.flonters.blocks.TallFlonterBlock;
import mods.flonters.blocks.TallFlonterPotBlock;
import mods.flonters.blocks.TallFlowerPotBlock;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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
    @Shadow
    @Final
    private Block content;

    @Inject(method = "onUse", at = @At(value = "JUMP", opcode = Opcodes.IFEQ, shift = At.Shift.AFTER, ordinal = 1), cancellable = true)
    public void tallFlowerPotInjection(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        BlockPos posUp = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        Block block = item instanceof BlockItem ? CONTENT_TO_POTTED.getOrDefault(((BlockItem) item).getBlock(), Blocks.AIR) : Blocks.AIR;
        if (Block.getBlockFromItem(player.getStackInHand(hand).getItem()) instanceof TallFlonterBlock & world.getBlockState(pos.up()).canPlaceAt(world, pos)) {
            ((TallFlonterPotBlock) block).placeAt(world, pos, 3);
        } else if (Block.getBlockFromItem(player.getStackInHand(hand).getItem()) instanceof TallFlowerBlock & world.getBlockState(pos.up()).canPlaceAt(world, pos)) {
            ((TallFlowerPotBlock) block).placeAt(world, pos, 3);
        }
    }
}
