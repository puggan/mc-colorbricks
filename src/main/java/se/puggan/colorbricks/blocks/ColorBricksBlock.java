package se.puggan.colorbricks.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class ColorBricksBlock extends Block {
    public static Properties properties(MaterialColor color) {
        return AbstractBlock.Properties.create(Material.ROCK, color).func_235861_h_().hardnessAndResistance(2.0F, 6.0F);
    }

    public ColorBricksBlock(MaterialColor color) {
        super(properties(color));
    }

    public static ColorBricksBlock black() {
        return new ColorBricksBlock(MaterialColor.BLACK);
    }

    public static ColorBricksBlock blue() {
        return new ColorBricksBlock(MaterialColor.BLUE);
    }

    public static ColorBricksBlock brown() {
        return new ColorBricksBlock(MaterialColor.BROWN);
    }

    public static ColorBricksBlock cyan() {
        return new ColorBricksBlock(MaterialColor.CYAN);
    }

    public static ColorBricksBlock gray() {
        return new ColorBricksBlock(MaterialColor.GRAY);
    }

    public static ColorBricksBlock green() {
        return new ColorBricksBlock(MaterialColor.GREEN);
    }

    public static ColorBricksBlock light_blue() {
        return new ColorBricksBlock(MaterialColor.LIGHT_BLUE);
    }

    public static ColorBricksBlock light_gray() {
        return new ColorBricksBlock(MaterialColor.LIGHT_GRAY);
    }

    public static ColorBricksBlock lime() {
        return new ColorBricksBlock(MaterialColor.LIME);
    }

    public static ColorBricksBlock magenta() {
        return new ColorBricksBlock(MaterialColor.MAGENTA);
    }

    public static ColorBricksBlock orange() {
        return new ColorBricksBlock(MaterialColor.ORANGE_TERRACOTTA);
    }

    public static ColorBricksBlock pink() {
        return new ColorBricksBlock(MaterialColor.PINK);
    }

    public static ColorBricksBlock purple() {
        return new ColorBricksBlock(MaterialColor.PURPLE);
    }

    public static ColorBricksBlock red() {
        return new ColorBricksBlock(MaterialColor.RED);
    }

    public static ColorBricksBlock white() {
        return new ColorBricksBlock(MaterialColor.WHITE_TERRACOTTA);
    }

    public static ColorBricksBlock yellow() {
        return new ColorBricksBlock(MaterialColor.YELLOW);
    }
}