package mods.flonters.registry;

import mods.flonters.Flonters;
import mods.flonters.items.ItemFlonterFertilizer;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class FlontersItems {
    public static Item FLONTER_FERTILIZER = new ItemFlonterFertilizer(new Item.Settings().group(Flonters.FlontersCoreGroup));

    public static void init() {
        register("eggshell_fertilizer", FLONTER_FERTILIZER);
    }
    public static void register(String name, Item item) {
        Registry.register(Registry.ITEM, Flonters.getId(name), item);
    }
}