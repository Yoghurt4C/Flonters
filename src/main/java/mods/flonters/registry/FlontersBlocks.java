package mods.flonters.registry;

import mods.flonters.Flonters;
import mods.flonters.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FlontersBlocks {
    public static Block RED_FLOWER = new FlonterBlock(DyeColor.RED);
    public static Block GREEN_FLOWER = new FlonterBlock(DyeColor.GREEN);
    public static Block PURPLE_FLOWER = new FlonterBlock(DyeColor.PURPLE);
    public static Block CYAN_FLOWER = new FlonterBlock(DyeColor.CYAN);
    public static Block LIGHT_GRAY_FLOWER = new FlonterBlock(DyeColor.LIGHT_GRAY);
    public static Block LLWYD_FLOWER = new FlonterBlock(DyeColor.GRAY);
    public static Block PINK_FLOWER = new FlonterBlock(DyeColor.PINK);
    public static Block LIME_FLOWER = new FlonterBlock(DyeColor.LIME);
    public static Block YELLOW_FLOWER = new FlonterBlock(DyeColor.YELLOW);
    public static Block LIGHT_BLUE_FLOWER = new FlonterBlock(DyeColor.LIGHT_BLUE);
    public static Block MAGENTA_FLOWER = new FlonterBlock(DyeColor.MAGENTA);
    public static Block ORANGE_FLOWER = new FlonterBlock(DyeColor.ORANGE);
    public static Block BLUE_FLOWER = new FlonterBlock(DyeColor.BLUE);
    public static Block BROWN_FLOWER = new FlonterBlock(DyeColor.BROWN);
    public static Block BLACK_FLOWER = new FlonterBlock(DyeColor.BLACK);
    public static Block WHITE_FLOWER = new FlonterBlock(DyeColor.WHITE);

    public static Block RED_TALLFLOWER = new TallFlonterBlock(DyeColor.RED);
    public static Block GREEN_TALLFLOWER = new TallFlonterBlock(DyeColor.GREEN);
    public static Block PURPLE_TALLFLOWER = new TallFlonterBlock(DyeColor.PURPLE);
    public static Block CYAN_TALLFLOWER = new TallFlonterBlock(DyeColor.CYAN);
    public static Block LIGHT_GRAY_TALLFLOWER = new TallFlonterBlock(DyeColor.LIGHT_GRAY);
    public static Block LLWYD_TALLFLOWER = new TallFlonterBlock(DyeColor.GRAY);
    public static Block PINK_TALLFLOWER = new TallFlonterBlock(DyeColor.PINK);
    public static Block LIME_TALLFLOWER = new TallFlonterBlock(DyeColor.LIME);
    public static Block YELLOW_TALLFLOWER = new TallFlonterBlock(DyeColor.YELLOW);
    public static Block LIGHT_BLUE_TALLFLOWER = new TallFlonterBlock(DyeColor.LIGHT_BLUE);
    public static Block MAGENTA_TALLFLOWER = new TallFlonterBlock(DyeColor.MAGENTA);
    public static Block ORANGE_TALLFLOWER = new TallFlonterBlock(DyeColor.ORANGE);
    public static Block BLUE_TALLFLOWER = new TallFlonterBlock(DyeColor.BLUE);
    public static Block BROWN_TALLFLOWER = new TallFlonterBlock(DyeColor.BROWN);
    public static Block BLACK_TALLFLOWER = new TallFlonterBlock(DyeColor.BLACK);
    public static Block WHITE_TALLFLOWER = new TallFlonterBlock(DyeColor.WHITE);

    //potables
    public static Block POTTED_RED_FLOWER = new FlonterPotBlock(DyeColor.RED);
    public static Block POTTED_GREEN_FLOWER = new FlonterPotBlock(DyeColor.GREEN);
    public static Block POTTED_PURPLE_FLOWER = new FlonterPotBlock(DyeColor.PURPLE);
    public static Block POTTED_CYAN_FLOWER = new FlonterPotBlock(DyeColor.CYAN);
    public static Block POTTED_LIGHT_GRAY_FLOWER = new FlonterPotBlock(DyeColor.LIGHT_GRAY);
    public static Block POTTED_LLWYD_FLOWER = new FlonterPotBlock(DyeColor.GRAY);
    public static Block POTTED_PINK_FLOWER = new FlonterPotBlock(DyeColor.PINK);
    public static Block POTTED_LIME_FLOWER = new FlonterPotBlock(DyeColor.LIME);
    public static Block POTTED_YELLOW_FLOWER = new FlonterPotBlock(DyeColor.YELLOW);
    public static Block POTTED_LIGHT_BLUE_FLOWER = new FlonterPotBlock(DyeColor.LIGHT_BLUE);
    public static Block POTTED_MAGENTA_FLOWER = new FlonterPotBlock(DyeColor.MAGENTA);
    public static Block POTTED_ORANGE_FLOWER = new FlonterPotBlock(DyeColor.ORANGE);
    public static Block POTTED_BLUE_FLOWER = new FlonterPotBlock(DyeColor.BLUE);
    public static Block POTTED_BROWN_FLOWER = new FlonterPotBlock(DyeColor.BROWN);
    public static Block POTTED_BLACK_FLOWER = new FlonterPotBlock(DyeColor.BLACK);
    public static Block POTTED_WHITE_FLOWER = new FlonterPotBlock(DyeColor.WHITE);

    public static Block POTTED_RED_TALLFLOWER = new TallFlonterPotBlock(DyeColor.RED);
    public static Block POTTED_GREEN_TALLFLOWER = new TallFlonterPotBlock(DyeColor.GREEN);
    public static Block POTTED_PURPLE_TALLFLOWER = new TallFlonterPotBlock(DyeColor.PURPLE);
    public static Block POTTED_CYAN_TALLFLOWER = new TallFlonterPotBlock(DyeColor.CYAN);
    public static Block POTTED_LIGHT_GRAY_TALLFLOWER = new TallFlonterPotBlock(DyeColor.LIGHT_GRAY);
    public static Block POTTED_LLWYD_TALLFLOWER = new TallFlonterPotBlock(DyeColor.GRAY);
    public static Block POTTED_PINK_TALLFLOWER = new TallFlonterPotBlock(DyeColor.PINK);
    public static Block POTTED_LIME_TALLFLOWER = new TallFlonterPotBlock(DyeColor.LIME);
    public static Block POTTED_YELLOW_TALLFLOWER = new TallFlonterPotBlock(DyeColor.YELLOW);
    public static Block POTTED_LIGHT_BLUE_TALLFLOWER = new TallFlonterPotBlock(DyeColor.LIGHT_BLUE);
    public static Block POTTED_MAGENTA_TALLFLOWER = new TallFlonterPotBlock(DyeColor.MAGENTA);
    public static Block POTTED_ORANGE_TALLFLOWER = new TallFlonterPotBlock(DyeColor.ORANGE);
    public static Block POTTED_BLUE_TALLFLOWER = new TallFlonterPotBlock(DyeColor.BLUE);
    public static Block POTTED_BROWN_TALLFLOWER = new TallFlonterPotBlock(DyeColor.BROWN);
    public static Block POTTED_BLACK_TALLFLOWER = new TallFlonterPotBlock(DyeColor.BLACK);
    public static Block POTTED_WHITE_TALLFLOWER = new TallFlonterPotBlock(DyeColor.WHITE);

    //missing vanilla potables
    public static Block POTTED_SUNFLOWER = new TallFlowerPotBlock(Blocks.SUNFLOWER, Block.Settings.copy(Blocks.POTTED_POPPY));
    public static Block POTTED_LILAC= new TallFlowerPotBlock(Blocks.LILAC, Block.Settings.copy(Blocks.POTTED_POPPY));
    public static Block POTTED_ROSE_BUSH = new TallFlowerPotBlock(Blocks.ROSE_BUSH, Block.Settings.copy(Blocks.POTTED_POPPY));
    public static Block POTTED_PEONY = new TallFlowerPotBlock(Blocks.PEONY, Block.Settings.copy(Blocks.POTTED_POPPY));

    public static void init(){
        register ("red_flower",RED_FLOWER);
        register ("green_flower",GREEN_FLOWER);
        register ("purple_flower",PURPLE_FLOWER);
        register ("cyan_flower",CYAN_FLOWER);
        register ("light_gray_flower",LIGHT_GRAY_FLOWER);
        register ("gray_flower",LLWYD_FLOWER);
        register ("pink_flower",PINK_FLOWER);
        register ("lime_flower",LIME_FLOWER);
        register ("yellow_flower",YELLOW_FLOWER);
        register ("light_blue_flower",LIGHT_BLUE_FLOWER);
        register ("magenta_flower",MAGENTA_FLOWER);
        register ("orange_flower",ORANGE_FLOWER);
        register ("blue_flower",BLUE_FLOWER);
        register ("brown_flower",BROWN_FLOWER);
        register ("black_flower",BLACK_FLOWER);
        register ("white_flower",WHITE_FLOWER);

        register ("red_tallflower",RED_TALLFLOWER);
        register ("green_tallflower",GREEN_TALLFLOWER);
        register ("purple_tallflower",PURPLE_TALLFLOWER);
        register ("cyan_tallflower",CYAN_TALLFLOWER);
        register ("light_gray_tallflower",LIGHT_GRAY_TALLFLOWER);
        register ("gray_tallflower",LLWYD_TALLFLOWER);
        register ("pink_tallflower",PINK_TALLFLOWER);
        register ("lime_tallflower",LIME_TALLFLOWER);
        register ("yellow_tallflower",YELLOW_TALLFLOWER);
        register ("light_blue_tallflower",LIGHT_BLUE_TALLFLOWER);
        register ("magenta_tallflower",MAGENTA_TALLFLOWER);
        register ("orange_tallflower",ORANGE_TALLFLOWER);
        register ("blue_tallflower",BLUE_TALLFLOWER);
        register ("brown_tallflower",BROWN_TALLFLOWER);
        register ("black_tallflower",BLACK_TALLFLOWER);
        register ("white_tallflower",WHITE_TALLFLOWER);

        subRegister ("potted_red_flower",POTTED_RED_FLOWER);
        subRegister ("potted_green_flower",POTTED_GREEN_FLOWER);
        subRegister ("potted_purple_flower",POTTED_PURPLE_FLOWER);
        subRegister ("potted_cyan_flower",POTTED_CYAN_FLOWER);
        subRegister ("potted_light_gray_flower",POTTED_LIGHT_GRAY_FLOWER);
        subRegister ("potted_gray_flower",POTTED_LLWYD_FLOWER);
        subRegister ("potted_pink_flower",POTTED_PINK_FLOWER);
        subRegister ("potted_lime_flower",POTTED_LIME_FLOWER);
        subRegister ("potted_yellow_flower",POTTED_YELLOW_FLOWER);
        subRegister ("potted_light_blue_flower",POTTED_LIGHT_BLUE_FLOWER);
        subRegister ("potted_magenta_flower",POTTED_MAGENTA_FLOWER);
        subRegister ("potted_orange_flower",POTTED_ORANGE_FLOWER);
        subRegister ("potted_blue_flower",POTTED_BLUE_FLOWER);
        subRegister ("potted_brown_flower",POTTED_BROWN_FLOWER);
        subRegister ("potted_black_flower",POTTED_BLACK_FLOWER);
        subRegister ("potted_white_flower",POTTED_WHITE_FLOWER);

        subRegister ("potted_red_tallflower",POTTED_RED_TALLFLOWER);
        subRegister ("potted_green_tallflower",POTTED_GREEN_TALLFLOWER);
        subRegister ("potted_purple_tallflower",POTTED_PURPLE_TALLFLOWER);
        subRegister ("potted_cyan_tallflower",POTTED_CYAN_TALLFLOWER);
        subRegister ("potted_light_gray_tallflower",POTTED_LIGHT_GRAY_TALLFLOWER);
        subRegister ("potted_gray_tallflower",POTTED_LLWYD_TALLFLOWER);
        subRegister ("potted_pink_tallflower",POTTED_PINK_TALLFLOWER);
        subRegister ("potted_lime_tallflower",POTTED_LIME_TALLFLOWER);
        subRegister ("potted_yellow_tallflower",POTTED_YELLOW_TALLFLOWER);
        subRegister ("potted_light_blue_tallflower",POTTED_LIGHT_BLUE_TALLFLOWER);
        subRegister ("potted_magenta_tallflower",POTTED_MAGENTA_TALLFLOWER);
        subRegister ("potted_orange_tallflower",POTTED_ORANGE_TALLFLOWER);
        subRegister ("potted_blue_tallflower",POTTED_BLUE_TALLFLOWER);
        subRegister ("potted_brown_tallflower",POTTED_BROWN_TALLFLOWER);
        subRegister ("potted_black_tallflower",POTTED_BLACK_TALLFLOWER);
        subRegister ("potted_white_tallflower",POTTED_WHITE_TALLFLOWER);

        subRegister ("potted_sunflower",POTTED_SUNFLOWER);
        subRegister ("potted_lilac",POTTED_LILAC);
        subRegister ("potted_rose_bush",POTTED_ROSE_BUSH);
        subRegister ("potted_peony",POTTED_PEONY);
    }

    public static BlockItem register(String name, Block block, Item.Settings settings) {
        Identifier id = Flonters.getId(name);
        Registry.register(Registry.BLOCK, id, block);
        BlockItem item = new BlockItem(block, settings);
        item.appendBlocks(Item.BLOCK_ITEMS, item);
        Registry.register(Registry.ITEM, id, item);
        return item;
    }

    public static BlockItem register(String name, Block block) {
        return register(name, block, new Item.Settings().group(Flonters.FlontersCoreGroup));
    }

    public static Block subRegister(String name, Block block){
        Identifier id = Flonters.getId(name);
        Registry.register(Registry.BLOCK, id, block);
        return block;
    }

    public static Block getFlonter(DyeColor color) {
        switch (color) {
            default:
            case RED:return RED_FLOWER;
            case GREEN:return GREEN_FLOWER;
            case PURPLE:return PURPLE_FLOWER;
            case CYAN:return CYAN_FLOWER;
            case LIGHT_GRAY:return LIGHT_GRAY_FLOWER;
            case GRAY:return LLWYD_FLOWER;
            case PINK:return PINK_FLOWER;
            case LIME:return LIME_FLOWER;
            case YELLOW:return YELLOW_FLOWER;
            case LIGHT_BLUE:return LIGHT_BLUE_FLOWER;
            case MAGENTA:return MAGENTA_FLOWER;
            case ORANGE:return ORANGE_FLOWER;
            case BLUE:return BLUE_FLOWER;
            case BROWN:return BROWN_FLOWER;
            case BLACK:return BLACK_FLOWER;
            case WHITE:return WHITE_FLOWER;
        }
    }
    public static Block getTallFlonter(DyeColor color) {
        switch (color) {
            default:
            case RED:return RED_TALLFLOWER;
            case GREEN:return GREEN_TALLFLOWER;
            case PURPLE:return PURPLE_TALLFLOWER;
            case CYAN:return CYAN_TALLFLOWER;
            case LIGHT_GRAY:return LIGHT_GRAY_TALLFLOWER;
            case GRAY:return LLWYD_TALLFLOWER;
            case PINK:return PINK_TALLFLOWER;
            case LIME:return LIME_TALLFLOWER;
            case YELLOW:return YELLOW_TALLFLOWER;
            case LIGHT_BLUE:return LIGHT_BLUE_TALLFLOWER;
            case MAGENTA:return MAGENTA_TALLFLOWER;
            case ORANGE:return ORANGE_TALLFLOWER;
            case BLUE:return BLUE_TALLFLOWER;
            case BROWN:return BROWN_TALLFLOWER;
            case BLACK:return BLACK_TALLFLOWER;
            case WHITE:return WHITE_TALLFLOWER;
        }
    }

    public static Block getPottedFlonter(DyeColor color) {
        switch (color) {
            default:
            case RED:return POTTED_RED_FLOWER;
            case GREEN:return POTTED_GREEN_FLOWER;
            case PURPLE:return POTTED_PURPLE_FLOWER;
            case CYAN:return POTTED_CYAN_FLOWER;
            case LIGHT_GRAY:return POTTED_LIGHT_GRAY_FLOWER;
            case GRAY:return POTTED_LLWYD_FLOWER;
            case PINK:return POTTED_PINK_FLOWER;
            case LIME:return POTTED_LIME_FLOWER;
            case YELLOW:return POTTED_YELLOW_FLOWER;
            case LIGHT_BLUE:return POTTED_LIGHT_BLUE_FLOWER;
            case MAGENTA:return POTTED_MAGENTA_FLOWER;
            case ORANGE:return POTTED_ORANGE_FLOWER;
            case BLUE:return POTTED_BLUE_FLOWER;
            case BROWN:return POTTED_BROWN_FLOWER;
            case BLACK:return POTTED_BLACK_FLOWER;
            case WHITE:return POTTED_WHITE_FLOWER;
        }
    }
    public static Block getPottedTallFlonter(DyeColor color) {
        switch (color) {
            default:
            case RED:return POTTED_RED_TALLFLOWER;
            case GREEN:return POTTED_GREEN_TALLFLOWER;
            case PURPLE:return POTTED_PURPLE_TALLFLOWER;
            case CYAN:return POTTED_CYAN_TALLFLOWER;
            case LIGHT_GRAY:return POTTED_LIGHT_GRAY_TALLFLOWER;
            case GRAY:return POTTED_LLWYD_TALLFLOWER;
            case PINK:return POTTED_PINK_TALLFLOWER;
            case LIME:return POTTED_LIME_TALLFLOWER;
            case YELLOW:return POTTED_YELLOW_TALLFLOWER;
            case LIGHT_BLUE:return POTTED_LIGHT_BLUE_TALLFLOWER;
            case MAGENTA:return POTTED_MAGENTA_TALLFLOWER;
            case ORANGE:return POTTED_ORANGE_TALLFLOWER;
            case BLUE:return POTTED_BLUE_TALLFLOWER;
            case BROWN:return POTTED_BROWN_TALLFLOWER;
            case BLACK:return POTTED_BLACK_TALLFLOWER;
            case WHITE:return POTTED_WHITE_TALLFLOWER;
        }
    }
}
