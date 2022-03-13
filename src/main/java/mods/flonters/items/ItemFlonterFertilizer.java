package mods.flonters.items;

import mods.flonters.blocks.FlonterBlock;
import mods.flonters.blocks.FlonterPotBlock;
import mods.flonters.blocks.TallFlonterBlock;
import mods.flonters.blocks.TallFlonterPotBlock;
import mods.flonters.registry.FlontersBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ItemFlonterFertilizer extends Item {
    public ItemFlonterFertilizer(Settings settings) {
        super(settings);
    }

    @Nonnull
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        final int range = 3;
        Block block = world.getBlockState(pos).getBlock();
        if (block.getRegistryEntry().isIn(BlockTags.BAMBOO_PLANTABLE_ON)) {
            if (!world.isClient) {
                List<BlockPos> validPosList = new ArrayList<>();

                for (int i = -range - 1; i < range; i++)
                    for (int j = -range - 1; j < range; j++) {
                        for (int k = 2; k >= -2; k--) {
                            BlockPos newPos = pos.add(i + 1, k + 1, j + 1);
                            if (world.isAir(newPos) && (!world.getDimension().isPiglinSafe() || newPos.getY() < 255) && FlontersBlocks.RED_FLOWER.getDefaultState().canPlaceAt(world, newPos))
                                validPosList.add(newPos);
                        }
                    }

                int flowerCount = Math.min(validPosList.size(), world.random.nextBoolean() ? 3 : 4);
                for (int i = 0; i < flowerCount; i++) {
                    BlockPos validBlockPos = validPosList.get(world.random.nextInt(validPosList.size()));
                    validPosList.remove(validBlockPos);
                    world.setBlockState(validBlockPos, FlontersBlocks.getFlonter(DyeColor.byId(world.random.nextInt(16))).getDefaultState());
                }
                context.getStack().decrement(1);
            } else {
                for (int i = 0; i < 15; i++) {
                    spawnSpreadFX(world, pos, range);
                }
            }
            return ActionResult.SUCCESS;
        } else if (block instanceof FlonterBlock) {
            if (((FlonterBlock) block).canGrow(world, pos, world.getBlockState(pos))) {
                if (!world.isClient) {
                    TallFlonterBlock tall = (TallFlonterBlock) FlontersBlocks.getTallFlonter(((FlonterBlock) block).getColor());
                    TallPlantBlock.placeAt(world, tall.getDefaultState(), pos, 3);
                    context.getStack().decrement(1);
                } else {
                    for (int p = 0; p < 15; p++) {
                        spawnFX(world, pos, range);
                    }
                }
            }
            return ActionResult.SUCCESS;
        } else if (block instanceof TallFlonterBlock) {
            if (!world.isClient) {
                ServerWorld serverWorld = world instanceof ServerWorld ? (ServerWorld) world : null;
                ((TallFlonterBlock) block).grow(serverWorld, world.random, pos, world.getBlockState(pos));
                context.getStack().decrement(1);
            } else {
                for (int p = 0; p < 15; p++) {
                    spawnFX(world, pos, range);
                }
            }
            return ActionResult.SUCCESS;
        } else if (block instanceof FlonterPotBlock) {
            if (((FlonterPotBlock) block).canGrow(world, pos, world.getBlockState(pos))) {
                if (!world.isClient) {
                    ((TallFlonterPotBlock) FlontersBlocks.getPottedTallFlonter(((FlonterPotBlock) block).getColor())).placeAt(world, pos, 3);
                    context.getStack().decrement(1);
                } else {
                    for (int p = 0; p < 15; p++) {
                        spawnFX(world, pos, range);
                    }
                }
            }


            return ActionResult.SUCCESS;
        } else if (block instanceof TallFlonterPotBlock) {
            if (!world.isClient) {
                ServerWorld serverWorld = world instanceof ServerWorld ? (ServerWorld) world : null;
                ((TallFlonterPotBlock) block).grow(serverWorld, world.random, pos, world.getBlockState(pos));
                context.getStack().decrement(1);
            } else {
                for (int p = 0; p < 15; p++) {
                    spawnFX(world, pos, range);
                }
            }
            return ActionResult.SUCCESS;
        } else return ActionResult.PASS;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        TranslatableText text;
        text = new TranslatableText("tooltip.flonters.eggshell_fertilizer.tooltip");
        text.formatted(Formatting.GRAY);
        text.formatted(Formatting.ITALIC);
        tooltip.add(text);
    }

    public void spawnSpreadFX(World world, BlockPos pos, int range) {
        world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() - range + world.random.nextInt(range * 2 + 1) + Math.random(), pos.getY() + 1.25, pos.getZ() - range + world.random.nextInt(range * 2 + 1) + Math.random(), 0, (float) Math.random() * 0.1F - 0.05F, 0);
    }

    public void spawnFX(World world, BlockPos pos, int range) {
        world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + Math.random(), pos.getY() + 0.25 + Math.random(), pos.getZ() + Math.random(), range, (float) Math.random() * 0.1F - 0.05F, range);
    }
}
