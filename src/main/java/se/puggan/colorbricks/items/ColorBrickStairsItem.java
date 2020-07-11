package se.puggan.colorbricks.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import se.puggan.colorbricks.utils.RegistryHandler;

public class ColorBrickStairsItem extends BlockItem {
    public ColorBrickStairsItem(RegistryObject<Block> block) {
        super(block.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
    }

    public static ColorBrickStairsItem black() {
        return new ColorBrickStairsItem(RegistryHandler.BLACK_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem blue() {
        return new ColorBrickStairsItem(RegistryHandler.BLUE_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem brown() {
        return new ColorBrickStairsItem(RegistryHandler.BROWN_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem cyan() {
        return new ColorBrickStairsItem(RegistryHandler.CYAN_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem gray() {
        return new ColorBrickStairsItem(RegistryHandler.GRAY_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem green() {
        return new ColorBrickStairsItem(RegistryHandler.GREEN_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem light_blue() {
        return new ColorBrickStairsItem(RegistryHandler.LIGHT_BLUE_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem light_gray() {
        return new ColorBrickStairsItem(RegistryHandler.LIGHT_GRAY_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem lime() {
        return new ColorBrickStairsItem(RegistryHandler.LIME_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem magenta() {
        return new ColorBrickStairsItem(RegistryHandler.MAGENTA_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem orange() {
        return new ColorBrickStairsItem(RegistryHandler.ORANGE_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem pink() {
        return new ColorBrickStairsItem(RegistryHandler.PINK_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem purple() {
        return new ColorBrickStairsItem(RegistryHandler.PURPLE_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem red() {
        return new ColorBrickStairsItem(RegistryHandler.RED_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem white() {
        return new ColorBrickStairsItem(RegistryHandler.WHITE_BRICK_STARIRS_BLOCK);
    }

    public static ColorBrickStairsItem yellow() {
        return new ColorBrickStairsItem(RegistryHandler.YELLOW_BRICK_STARIRS_BLOCK);
    }
}