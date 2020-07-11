package se.puggan.colorbricks.blocks;

import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.MaterialColor;

public class ColorBrickStairsBlock extends StairsBlock {
    public ColorBrickStairsBlock(MaterialColor color) {
        super(Blocks.BRICKS.getDefaultState(), ColorBricksBlock.properties(color));
    }

    public static ColorBrickStairsBlock black() {
        return new ColorBrickStairsBlock(MaterialColor.BLACK);
    }

    public static ColorBrickStairsBlock blue() {
        return new ColorBrickStairsBlock(MaterialColor.BLUE);
    }

    public static ColorBrickStairsBlock brown() {
        return new ColorBrickStairsBlock(MaterialColor.BROWN);
    }

    public static ColorBrickStairsBlock cyan() {
        return new ColorBrickStairsBlock(MaterialColor.CYAN);
    }

    public static ColorBrickStairsBlock gray() {
        return new ColorBrickStairsBlock(MaterialColor.GRAY);
    }

    public static ColorBrickStairsBlock green() {
        return new ColorBrickStairsBlock(MaterialColor.GREEN);
    }

    public static ColorBrickStairsBlock light_blue() {
        return new ColorBrickStairsBlock(MaterialColor.LIGHT_BLUE);
    }

    public static ColorBrickStairsBlock light_gray() {
        return new ColorBrickStairsBlock(MaterialColor.LIGHT_GRAY);
    }

    public static ColorBrickStairsBlock lime() {
        return new ColorBrickStairsBlock(MaterialColor.LIME);
    }

    public static ColorBrickStairsBlock magenta() {
        return new ColorBrickStairsBlock(MaterialColor.MAGENTA);
    }

    public static ColorBrickStairsBlock orange() {
        return new ColorBrickStairsBlock(MaterialColor.ORANGE_TERRACOTTA);
    }

    public static ColorBrickStairsBlock pink() {
        return new ColorBrickStairsBlock(MaterialColor.PINK);
    }

    public static ColorBrickStairsBlock purple() {
        return new ColorBrickStairsBlock(MaterialColor.PURPLE);
    }

    public static ColorBrickStairsBlock red() {
        return new ColorBrickStairsBlock(MaterialColor.RED);
    }

    public static ColorBrickStairsBlock white() {
        return new ColorBrickStairsBlock(MaterialColor.WHITE_TERRACOTTA);
    }

    public static ColorBrickStairsBlock yellow() {
        return new ColorBrickStairsBlock(MaterialColor.YELLOW);
    }
}