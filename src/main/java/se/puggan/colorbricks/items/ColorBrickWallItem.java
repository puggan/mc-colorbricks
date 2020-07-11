package se.puggan.colorbricks.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import se.puggan.colorbricks.utils.RegistryHandler;

public class ColorBrickWallItem extends BlockItem {
    public ColorBrickWallItem(RegistryObject<Block> block) {
        super(block.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
    }

    public static ColorBrickWallItem black() {
        return new ColorBrickWallItem(RegistryHandler.BLACK_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem blue() {
        return new ColorBrickWallItem(RegistryHandler.BLUE_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem brown() {
        return new ColorBrickWallItem(RegistryHandler.BROWN_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem cyan() {
        return new ColorBrickWallItem(RegistryHandler.CYAN_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem gray() {
        return new ColorBrickWallItem(RegistryHandler.GRAY_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem green() {
        return new ColorBrickWallItem(RegistryHandler.GREEN_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem light_blue() {
        return new ColorBrickWallItem(RegistryHandler.LIGHT_BLUE_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem light_gray() {
        return new ColorBrickWallItem(RegistryHandler.LIGHT_GRAY_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem lime() {
        return new ColorBrickWallItem(RegistryHandler.LIME_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem magenta() {
        return new ColorBrickWallItem(RegistryHandler.MAGENTA_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem orange() {
        return new ColorBrickWallItem(RegistryHandler.ORANGE_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem pink() {
        return new ColorBrickWallItem(RegistryHandler.PINK_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem purple() {
        return new ColorBrickWallItem(RegistryHandler.PURPLE_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem red() {
        return new ColorBrickWallItem(RegistryHandler.RED_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem white() {
        return new ColorBrickWallItem(RegistryHandler.WHITE_BRICK_WALL_BLOCK);
    }

    public static ColorBrickWallItem yellow() {
        return new ColorBrickWallItem(RegistryHandler.YELLOW_BRICK_WALL_BLOCK);
    }
}