package mods.flonters.registry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.gson.JsonElement;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import mods.flonters.Flonters;
import mods.flonters.world.FlontersFeature;
import mods.flonters.world.FlontersFeatureConfig;
import mods.flonters.world.LegallyDistinctWorldGenConfig;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.decorator.NopeDecoratorConfig;
import net.minecraft.world.gen.feature.*;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FlontersGenerator {
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
        List<List<Supplier<ConfiguredFeature<?, ?>>>> features = biome.getGenerationSettings().getFeatures();

        int stepIndex = feature.ordinal();

        while (features.size() <= stepIndex) {
            features.add(Lists.newArrayList());
        }

        List<Supplier<ConfiguredFeature<?, ?>>> stepList = features.get(feature.ordinal());
        if (stepList instanceof ImmutableList) {
            features.set(feature.ordinal(), stepList = new ArrayList<>(stepList));
        }

        if (!BuiltinRegistries.CONFIGURED_FEATURE.getKey(configuredFeature).isPresent()) {
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

        DataResult<JsonElement> result = LegallyDistinctWorldGenConfig.CODEC.encodeStart(JsonOps.INSTANCE, config);
        JsonElement jsonElement = result.getOrThrow(true, System.out::println);
        String json = jsonElement.toString();

        for (Biome biome : BuiltinRegistries.BIOME) {
            handleBiome(biome, config);
        }
        RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((i, identifier, biome) -> handleBiome(biome, config));
    }
}
