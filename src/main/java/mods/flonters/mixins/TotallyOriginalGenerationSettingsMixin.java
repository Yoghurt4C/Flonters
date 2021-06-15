package mods.flonters.mixins;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@Mixin(GenerationSettings.class)
public abstract class TotallyOriginalGenerationSettingsMixin {
    @Shadow
    @Final
    @Mutable
    private List<List<Supplier<ConfiguredFeature<?, ?>>>> features;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void init(Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, Map<GenerationStep.Carver, List<Supplier<ConfiguredCarver<?>>>> carvers, List<List<Supplier<ConfiguredFeature<?, ?>>>> features, List<Supplier<ConfiguredStructureFeature<?, ?>>> structureFeatures, CallbackInfo info) {
        if (this.features instanceof ImmutableList) {
            this.features = new ArrayList<>(features);
        }
    }
}
