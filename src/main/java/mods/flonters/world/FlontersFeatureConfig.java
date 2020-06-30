package mods.flonters.world;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.FeatureConfig;

import static mods.flonters.properties.FlontersProperties.*;

public class FlontersFeatureConfig implements FeatureConfig {
    public int getPatchSize() {
        return flonterPatchSize;
    }

    public int getPatchQuantity() {
        return flonterPatchQuantity;
    }

    public int getPatchDensity() {
        return flonterPatchDensity;
    }

    public int getPatchChance() {
        return flonterPatchChance;
    }

    public double getTallChance() {
        return tallFlonterChance;
    }

    public static final Codec<FlontersFeatureConfig> CODEC = Codec.unit(new FlontersFeatureConfig());
}
