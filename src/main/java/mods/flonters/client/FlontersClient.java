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
                FlontersBlocks.WHITE_TALLFLOWER);
    }
}