package mods.flonters.registry;

import mods.flonters.mixins.BiomeCategoryAccessor;
import mods.flonters.properties.FlontersProperties;
import mods.flonters.world.FlontersFeature;
import mods.flonters.world.FlontersFeatureConfig;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;

import static mods.flonters.Flonters.getId;

public class FlontersGenerator {
    public static final RegistryKey<PlacedFeature> PATCH_O_FLONTERS = RegistryKey.of(Registry.PLACED_FEATURE_KEY, getId("patch_o_flonters"));

    public static void init() {
        Identifier id = getId("patch_o_flonters");
        FlontersFeature feature = Registry.register(Registry.FEATURE, id, new FlontersFeature());
        var cf = ConfiguredFeatures.register(id.toString(), feature, new FlontersFeatureConfig());
        PlacedFeatures.register(id.toString(), cf);

        if (FlontersProperties.flonterPatchQuantity > 0) {
            BiomeModifications.addFeature(ctx -> {
                        Biome biome = ctx.getBiome();
                        Biome.Category category = ((BiomeCategoryAccessor) (Object) biome).getCategory();
                        return category != Biome.Category.NETHER && category != Biome.Category.THEEND;
                    },
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    PATCH_O_FLONTERS);
        }
    }
}
