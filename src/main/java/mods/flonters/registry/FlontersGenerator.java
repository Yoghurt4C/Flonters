package mods.flonters.registry;

import mods.flonters.properties.FlontersProperties;
import mods.flonters.world.FlontersFeature;
import mods.flonters.world.FlontersFeatureConfig;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;

import static mods.flonters.Flonters.getId;

public class FlontersGenerator {
    public static final Feature<FlontersFeatureConfig> PATCH_O_FLONTERS = new FlontersFeature();
    public static final ConfiguredFeature<?, ?> CONFIGURED_PATCH = PATCH_O_FLONTERS.configure(new FlontersFeatureConfig());
    public static final PlacedFeature PLACED_PATCH = CONFIGURED_PATCH.withPlacement();

    public static void init() {
        Registry.register(Registry.FEATURE, getId("patch_o_flonters"), PATCH_O_FLONTERS);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, getId("patch_o_flonters"), CONFIGURED_PATCH);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, getId("patch_o_flonters"), PLACED_PATCH);
        if (FlontersProperties.flonterPatchQuantity > 0) {
            BiomeModifications.addFeature(ctx -> {
                        Biome.Category category = ctx.getBiome().getCategory();
                        return category != Biome.Category.NETHER && category != Biome.Category.THEEND;
                    },
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    BuiltinRegistries.PLACED_FEATURE.getKey(PLACED_PATCH).orElseThrow());
        }
    }
    /*
    private static final List<Biome> checkedBiomes = new ArrayList<>();
    @Nullable
    public static LegallyDistinctWorldGenConfig config;

    public static <F extends FeatureConfig, D extends DecoratorConfig> ConfiguredFeature<?, ?> configureFeature(Feature<F> feature, F featureConfig, Decorator<D> decorator, D decoratorConfig) {
        Feature<DecoratedFeatureConfig> feature2 = feature instanceof FlowerFeature ? Feature.DECORATED : Feature.DECORATED;
        return new ConfiguredFeature<>(feature2, new DecoratedFeatureConfig(() -> feature.configure(featureConfig), decorator.configure(decoratorConfig)));
    }

    public static final Feature<FlontersFeatureConfig> PATCH_O_FLONTERS = register("patch_o_flonters", new FlontersFeature(FlontersFeatureConfig.CODEC));

    public static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return Registry.register(Registry.FEATURE, Flonters.getId(name), feature);
    }

    private static void handleBiome(Biome biome, LegallyDistinctWorldGenConfig config) {
        if (checkedBiomes.contains(biome)) {
            return;
        }
        checkedBiomes.add(biome);

        if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
            addFeature(biome, Flonters.getId("patch_o_flonters"), GenerationStep.Feature.VEGETAL_DECORATION, config.getFlonterPatch());
        }
    }

    private static void addFeature(Biome biome, Identifier identifier, GenerationStep.Feature feature, ConfiguredFeature<?, ?> configuredFeature) {
        List<List<Supplier<PlacedFeature>>> features = biome.getGenerationSettings().getFeatures();

        int stepIndex = feature.ordinal();

        while (features.size() <= stepIndex) {
            features.add(Lists.newArrayList());
        }

        List<Supplier<PlacedFeature>> stepList = features.get(feature.ordinal());
        if (stepList instanceof ImmutableList) {
            features.set(feature.ordinal(), stepList = new ArrayList<>(stepList));
        }

        if (BuiltinRegistries.CONFIGURED_FEATURE.getKey(configuredFeature).isEmpty()) {
            if (BuiltinRegistries.CONFIGURED_FEATURE.getOrEmpty(identifier).isPresent()) {
                throw new RuntimeException("[Flonters] :) : " + identifier.toString());
            } else {
                BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_FEATURE, identifier, configuredFeature);
            }
        }

        stepList.add(() -> configuredFeature);
    }

    public static void init() {
        config = new LegallyDistinctWorldGenConfig(configureFeature(PATCH_O_FLONTERS, new FlontersFeatureConfig(), Decorator.NOPE, NopeDecoratorConfig.DEFAULT));

        for (Biome biome : BuiltinRegistries.BIOME) {
            handleBiome(biome, config);
        }

        RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((i, identifier, biome) -> handleBiome(biome, config));
    }*/
}
