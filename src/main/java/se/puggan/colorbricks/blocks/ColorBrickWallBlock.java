package se.puggan.colorbricks.blocks;

import net.minecraft.block.WallBlock;
import net.minecraft.block.material.MaterialColor;

public class ColorBrickWallBlock extends WallBlock {
    public ColorBrickWallBlock(MaterialColor color) {
        super(ColorBricksBlock.properties(color));
    }

    public static ColorBrickWallBlock black() {
        return new ColorBrickWallBlock(MaterialColor.BLACK);
    }

    public static ColorBrickWallBlock blue() {
        return new ColorBrickWallBlock(MaterialColor.BLUE);
    }

    public static ColorBrickWallBlock brown() {
        return new ColorBrickWallBlock(MaterialColor.BROWN);
    }

    public static ColorBrickWallBlock cyan() {
        return new ColorBrickWallBlock(MaterialColor.CYAN);
    }

    public static ColorBrickWallBlock gray() {
        return new ColorBrickWallBlock(MaterialColor.GRAY);
    }

    public static ColorBrickWallBlock green() {
        return new ColorBrickWallBlock(MaterialColor.GREEN);
    }

    public static ColorBrickWallBlock light_blue() {
        return new ColorBrickWallBlock(MaterialColor.LIGHT_BLUE);
    }

    public static ColorBrickWallBlock light_gray() {
        return new ColorBrickWallBlock(MaterialColor.LIGHT_GRAY);
    }

    public static ColorBrickWallBlock lime() {
        return new ColorBrickWallBlock(MaterialColor.LIME);
    }

    public static ColorBrickWallBlock magenta() {
        return new ColorBrickWallBlock(MaterialColor.MAGENTA);
    }

    public static ColorBrickWallBlock orange() {
        return new ColorBrickWallBlock(MaterialColor.ORANGE_TERRACOTTA);
    }

    public static ColorBrickWallBlock pink() {
        return new ColorBrickWallBlock(MaterialColor.PINK);
    }

    public static ColorBrickWallBlock purple() {
        return new ColorBrickWallBlock(MaterialColor.PURPLE);
    }

    public static ColorBrickWallBlock red() {
        return new ColorBrickWallBlock(MaterialColor.RED);
    }

    public static ColorBrickWallBlock white() {
        return new ColorBrickWallBlock(MaterialColor.WHITE_TERRACOTTA);
    }

    public static ColorBrickWallBlock yellow() {
        return new ColorBrickWallBlock(MaterialColor.YELLOW);
    }
}