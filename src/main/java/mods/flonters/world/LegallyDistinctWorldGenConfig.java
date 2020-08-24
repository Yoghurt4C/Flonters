package mods.flonters.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class LegallyDistinctWorldGenConfig {
    public static final Codec<LegallyDistinctWorldGenConfig> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    ConfiguredFeature.field_25833.fieldOf("patch_o_flonters").forGetter(LegallyDistinctWorldGenConfig::getFlonterPatch)
            )
                    .apply(instance, LegallyDistinctWorldGenConfig::new)
    );

    private final ConfiguredFeature<?, ?> flonter_patch;

    public LegallyDistinctWorldGenConfig(ConfiguredFeature<?, ?> flonter_patch) {
        this.flonter_patch = flonter_patch;
    }

    public ConfiguredFeature<?, ?> getFlonterPatch() {
        return flonter_patch;
    }
}
