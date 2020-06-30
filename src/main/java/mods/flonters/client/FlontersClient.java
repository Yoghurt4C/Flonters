package mods.flonters.client;

import mods.flonters.registry.FlontersBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.render.RenderLayer;

@SuppressWarnings("unused")
public class FlontersClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMapImpl.INSTANCE.putBlocks(RenderLayer.getCutout(),
                FlontersBlocks.RED_FLOWER,
                FlontersBlocks.GREEN_FLOWER,
                FlontersBlocks.PURPLE_FLOWER,
                FlontersBlocks.CYAN_FLOWER,
                FlontersBlocks.LIGHT_GRAY_FLOWER,
                FlontersBlocks.LLWYD_FLOWER,
                FlontersBlocks.PINK_FLOWER,
                FlontersBlocks.LIME_FLOWER,
                FlontersBlocks.YELLOW_FLOWER,
                FlontersBlocks.LIGHT_BLUE_FLOWER,
                FlontersBlocks.MAGENTA_FLOWER,
                FlontersBlocks.ORANGE_FLOWER,
                FlontersBlocks.BLUE_FLOWER,
                FlontersBlocks.BROWN_FLOWER,
                FlontersBlocks.BLACK_FLOWER,
                FlontersBlocks.WHITE_FLOWER,

                FlontersBlocks.RED_TALLFLOWER,
                FlontersBlocks.GREEN_TALLFLOWER,
                FlontersBlocks.PURPLE_TALLFLOWER,
                FlontersBlocks.CYAN_TALLFLOWER,
                FlontersBlocks.LIGHT_GRAY_TALLFLOWER,
                FlontersBlocks.LLWYD_TALLFLOWER,
                FlontersBlocks.PINK_TALLFLOWER,
                FlontersBlocks.LIME_TALLFLOWER,
                FlontersBlocks.YELLOW_TALLFLOWER,
                FlontersBlocks.LIGHT_BLUE_TALLFLOWER,
                FlontersBlocks.MAGENTA_TALLFLOWER,
                FlontersBlocks.ORANGE_TALLFLOWER,
                FlontersBlocks.BLUE_TALLFLOWER,
                FlontersBlocks.BROWN_TALLFLOWER,
                FlontersBlocks.BLACK_TALLFLOWER,
                FlontersBlocks.WHITE_TALLFLOWER,

                //potables
                FlontersBlocks.POTTED_RED_FLOWER,
                FlontersBlocks.POTTED_GREEN_FLOWER,
                FlontersBlocks.POTTED_PURPLE_FLOWER,
                FlontersBlocks.POTTED_CYAN_FLOWER,
                FlontersBlocks.POTTED_LIGHT_GRAY_FLOWER,
                FlontersBlocks.POTTED_LLWYD_FLOWER,
                FlontersBlocks.POTTED_PINK_FLOWER,
                FlontersBlocks.POTTED_LIME_FLOWER,
                FlontersBlocks.POTTED_YELLOW_FLOWER,
                FlontersBlocks.POTTED_LIGHT_BLUE_FLOWER,
                FlontersBlocks.POTTED_MAGENTA_FLOWER,
                FlontersBlocks.POTTED_ORANGE_FLOWER,
                FlontersBlocks.POTTED_BLUE_FLOWER,
                FlontersBlocks.POTTED_BROWN_FLOWER,
                FlontersBlocks.POTTED_BLACK_FLOWER,
                FlontersBlocks.POTTED_WHITE_FLOWER,

                FlontersBlocks.POTTED_RED_TALLFLOWER,
                FlontersBlocks.POTTED_GREEN_TALLFLOWER,
                FlontersBlocks.POTTED_PURPLE_TALLFLOWER,
                FlontersBlocks.POTTED_CYAN_TALLFLOWER,
                FlontersBlocks.POTTED_LIGHT_GRAY_TALLFLOWER,
                FlontersBlocks.POTTED_LLWYD_TALLFLOWER,
                FlontersBlocks.POTTED_PINK_TALLFLOWER,
                FlontersBlocks.POTTED_LIME_TALLFLOWER,
                FlontersBlocks.POTTED_YELLOW_TALLFLOWER,
                FlontersBlocks.POTTED_LIGHT_BLUE_TALLFLOWER,
                FlontersBlocks.POTTED_MAGENTA_TALLFLOWER,
                FlontersBlocks.POTTED_ORANGE_TALLFLOWER,
                FlontersBlocks.POTTED_BLUE_TALLFLOWER,
                FlontersBlocks.POTTED_BROWN_TALLFLOWER,
                FlontersBlocks.POTTED_BLACK_TALLFLOWER,
                FlontersBlocks.POTTED_WHITE_TALLFLOWER,

                FlontersBlocks.POTTED_SUNFLOWER,
                FlontersBlocks.POTTED_LILAC,
                FlontersBlocks.POTTED_ROSE_BUSH,
                FlontersBlocks.POTTED_PEONY
        );
    }
}