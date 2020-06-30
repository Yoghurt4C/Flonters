package mods.flonters;

import mods.flonters.properties.FlontersProperties;
import mods.flonters.registry.FlontersBlocks;
import mods.flonters.registry.FlontersGenerator;
import mods.flonters.registry.FlontersItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Flonters implements ModInitializer {

    public static ItemGroup FlontersCoreGroup = FabricItemGroupBuilder.build(
            getId("core_group"),
            () -> new ItemStack(FlontersBlocks.RED_FLOWER));

    @Override
    public void onInitialize() {
        FlontersBlocks.init();
        FlontersItems.init();
        FlontersProperties.init();
        FlontersGenerator.init();
    }

    public static Identifier getId(String name) {
        return new Identifier("flonters", name);
    }

    public static final String modid = "flonters";
}
