package mods.flonters.world;

import com.mojang.serialization.Codec;
import mods.flonters.blocks.FlonterBlock;
import mods.flonters.blocks.TallFlonterBlock;
import mods.flonters.registry.FlontersBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class FlontersFeature extends Feature<FlontersFeatureConfig> {

    public FlontersFeature(Codec<FlontersFeatureConfig> featureConfig) {
        super(featureConfig);
    }

    @Override
    public boolean generate(FeatureContext<FlontersFeatureConfig> ctx) {
        return generate(ctx.getWorld(), ctx.getGenerator(), ctx.getRandom(), ctx.getOrigin(), ctx.getConfig());
    }

    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, FlontersFeatureConfig config) {
        boolean doug = false;
        int distance = Math.min(8, Math.max(1, config.getPatchSize()));
        for (int i = 0; i < config.getPatchQuantity(); i++) {
            if (random.nextInt(config.getPatchChance()) == 0) {
                int x = blockPos.getX() + random.nextInt(16);
                int z = blockPos.getZ() + random.nextInt(16);
                int y = world.getTopPosition(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, blockPos).getY();

                DyeColor color = DyeColor.byId(random.nextInt(16));
                BlockState flonter = FlontersBlocks.getFlonter(color).getDefaultState();
                for (int j = 0; j < config.getPatchDensity() * config.getPatchChance(); j++) {
                    int x1 = x + random.nextInt(distance * 2) - distance;
                    int y1 = y + random.nextInt(4) - random.nextInt(4);
                    int z1 = z + random.nextInt(distance * 2) - distance;
                    BlockPos pos2 = new BlockPos(x1, y1, z1);
                    if (world.isAir(pos2) && (!world.getDimension().isPiglinSafe() || y1 < 127) && flonter.canPlaceAt(world, pos2)) {
                        world.setBlockState(pos2, flonter, 2);
                        doug = true;
                        if (random.nextDouble() < config.getTallChance() && ((FlonterBlock) flonter.getBlock()).canGrow(world, pos2, world.getBlockState(pos2))) {
                            Block block = FlontersBlocks.getTallFlonter(color);
                            if (block instanceof TallFlonterBlock) {
                                TallFlonterBlock.placeAt(world, block.getDefaultState(), pos2, 3);
                            }
                        }
                    }
                }
            }
        }
        return doug;
    }
}