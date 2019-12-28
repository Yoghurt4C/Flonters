package mods.flonters.registry;

import mods.flonters.Flonters;
import mods.flonters.blocks.FlonterBlock;
import mods.flonters.blocks.TallFlonterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FlontersBlocks {
    //todo better potions effects
    public static Block RED_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.RED);
    public static Block GREEN_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.GREEN);
    public static Block PURPLE_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.PURPLE);
    public static Block CYAN_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.CYAN);
    public static Block LIGHT_GRAY_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.LIGHT_GRAY);
    public static Block LLWYD_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.GRAY);
    public static Block PINK_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.PINK);
    public static Block LIME_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.LIME);
    public static Block YELLOW_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.YELLOW);
    public static Block LIGHT_BLUE_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.LIGHT_BLUE);
    public static Block MAGENTA_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.MAGENTA);
    public static Block ORANGE_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.ORANGE);
    public static Block BLUE_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.BLUE);
    public static Block BROWN_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.BROWN);
    public static Block BLACK_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.BLACK);
    public static Block WHITE_FLOWER = new FlonterBlock(StatusEffects.NIGHT_VISION, 5,Block.Settings.copy(Blocks.POPPY),DyeColor.WHITE);

    public static Block RED_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.RED);
    public static Block GREEN_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.GREEN);
    public static Block PURPLE_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.PURPLE);
    public static Block CYAN_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.CYAN);
    public static Block LIGHT_GRAY_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.LIGHT_GRAY);
    public static Block LLWYD_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.GRAY);
    public static Block PINK_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.PINK);
    public static Block LIME_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.LIME);
    public static Block YELLOW_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.YELLOW);
    public static Block LIGHT_BLUE_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.LIGHT_BLUE);
    public static Block MAGENTA_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.MAGENTA);
    public static Block ORANGE_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.ORANGE);
    public static Block BLUE_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.BLUE);
    public static Block BROWN_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.BROWN);
    public static Block BLACK_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.BLACK);
    public static Block WHITE_TALLFLOWER = new TallFlonterBlock(Block.Settings.copy(Blocks.ROSE_BUSH),DyeColor.WHITE);

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
}
