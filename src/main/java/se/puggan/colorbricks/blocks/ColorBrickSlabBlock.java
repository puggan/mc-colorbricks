package se.puggan.colorbricks.blocks;

import net.minecraft.block.SlabBlock;
import net.minecraft.block.material.MaterialColor;

public class ColorBrickSlabBlock extends SlabBlock {
    public ColorBrickSlabBlock(MaterialColor color) {
        super(ColorBricksBlock.properties(color));
    }

    public static ColorBrickSlabBlock black() {
        return new ColorBrickSlabBlock(MaterialColor.BLACK);
    }

    public static ColorBrickSlabBlock blue() {
        return new ColorBrickSlabBlock(MaterialColor.BLUE);
    }

    public static ColorBrickSlabBlock brown() {
        return new ColorBrickSlabBlock(MaterialColor.BROWN);
    }

    public static ColorBrickSlabBlock cyan() {
        return new ColorBrickSlabBlock(MaterialColor.CYAN);
    }

    public static ColorBrickSlabBlock gray() {
        return new ColorBrickSlabBlock(MaterialColor.GRAY);
    }

    public static ColorBrickSlabBlock green() {
        return new ColorBrickSlabBlock(MaterialColor.GREEN);
    }

    public static ColorBrickSlabBlock light_blue() {
        return new ColorBrickSlabBlock(MaterialColor.LIGHT_BLUE);
    }

    public static ColorBrickSlabBlock light_gray() {
        return new ColorBrickSlabBlock(MaterialColor.LIGHT_GRAY);
    }

    public static ColorBrickSlabBlock lime() {
        return new ColorBrickSlabBlock(MaterialColor.LIME);
    }

    public static ColorBrickSlabBlock magenta() {
        return new ColorBrickSlabBlock(MaterialColor.MAGENTA);
    }

    public static ColorBrickSlabBlock orange() {
        return new ColorBrickSlabBlock(MaterialColor.ORANGE_TERRACOTTA);
    }

    public static ColorBrickSlabBlock pink() {
        return new ColorBrickSlabBlock(MaterialColor.PINK);
    }

    public static ColorBrickSlabBlock purple() {
        return new ColorBrickSlabBlock(MaterialColor.PURPLE);
    }

    public static ColorBrickSlabBlock red() {
        return new ColorBrickSlabBlock(MaterialColor.RED);
    }

    public static ColorBrickSlabBlock white() {
        return new ColorBrickSlabBlock(MaterialColor.WHITE_TERRACOTTA);
    }

    public static ColorBrickSlabBlock yellow() {
        return new ColorBrickSlabBlock(MaterialColor.YELLOW);
    }
}