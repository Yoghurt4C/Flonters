package mods.flonters.world;

import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.world.gen.feature.FeatureConfig;

import static mods.flonters.properties.FlontersProperties.*;

import javax.annotation.Nonnull;

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

    @Nonnull
    @Override
    public <T> Dynamic<T> serialize(@Nonnull DynamicOps<T> ops) {
        return new Dynamic<>(ops);
    }

    public static FlontersFeatureConfig deserialize(Dynamic<?> dynamic) {
        return new FlontersFeatureConfig();
    }
}
