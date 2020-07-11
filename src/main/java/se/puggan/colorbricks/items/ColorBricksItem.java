package se.puggan.colorbricks.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import se.puggan.colorbricks.utils.RegistryHandler;

public class ColorBricksItem extends BlockItem {
    public ColorBricksItem(RegistryObject<Block> block) {
        super(block.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
    }

    public static ColorBricksItem black() {
        return new ColorBricksItem(RegistryHandler.BLACK_BRICKS_BLOCK);
    }

    public static ColorBricksItem blue() {
        return new ColorBricksItem(RegistryHandler.BLUE_BRICKS_BLOCK);
    }

    public static ColorBricksItem brown() {
        return new ColorBricksItem(RegistryHandler.BROWN_BRICKS_BLOCK);
    }

    public static ColorBricksItem cyan() {
        return new ColorBricksItem(RegistryHandler.CYAN_BRICKS_BLOCK);
    }

    public static ColorBricksItem gray() {
        return new ColorBricksItem(RegistryHandler.GRAY_BRICKS_BLOCK);
    }

    public static ColorBricksItem green() {
        return new ColorBricksItem(RegistryHandler.GREEN_BRICKS_BLOCK);
    }

    public static ColorBricksItem light_blue() {
        return new ColorBricksItem(RegistryHandler.LIGHT_BLUE_BRICKS_BLOCK);
    }

    public static ColorBricksItem light_gray() {
        return new ColorBricksItem(RegistryHandler.LIGHT_GRAY_BRICKS_BLOCK);
    }

    public static ColorBricksItem lime() {
        return new ColorBricksItem(RegistryHandler.LIME_BRICKS_BLOCK);
    }

    public static ColorBricksItem magenta() {
        return new ColorBricksItem(RegistryHandler.MAGENTA_BRICKS_BLOCK);
    }

    public static ColorBricksItem orange() {
        return new ColorBricksItem(RegistryHandler.ORANGE_BRICKS_BLOCK);
    }

    public static ColorBricksItem pink() {
        return new ColorBricksItem(RegistryHandler.PINK_BRICKS_BLOCK);
    }

    public static ColorBricksItem purple() {
        return new ColorBricksItem(RegistryHandler.PURPLE_BRICKS_BLOCK);
    }

    public static ColorBricksItem red() {
        return new ColorBricksItem(RegistryHandler.RED_BRICKS_BLOCK);
    }

    public static ColorBricksItem white() {
        return new ColorBricksItem(RegistryHandler.WHITE_BRICKS_BLOCK);
    }

    public static ColorBricksItem yellow() {
        return new ColorBricksItem(RegistryHandler.YELLOW_BRICKS_BLOCK);
    }
}