package se.puggan.colorbricks.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import se.puggan.colorbricks.utils.RegistryHandler;

public class ColorBrickSlabItem extends BlockItem {
    public ColorBrickSlabItem(RegistryObject<Block> block) {
        super(block.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
    }

    public static ColorBrickSlabItem black() {
        return new ColorBrickSlabItem(RegistryHandler.BLACK_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem blue() {
        return new ColorBrickSlabItem(RegistryHandler.BLUE_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem brown() {
        return new ColorBrickSlabItem(RegistryHandler.BROWN_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem cyan() {
        return new ColorBrickSlabItem(RegistryHandler.CYAN_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem gray() {
        return new ColorBrickSlabItem(RegistryHandler.GRAY_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem green() {
        return new ColorBrickSlabItem(RegistryHandler.GREEN_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem light_blue() {
        return new ColorBrickSlabItem(RegistryHandler.LIGHT_BLUE_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem light_gray() {
        return new ColorBrickSlabItem(RegistryHandler.LIGHT_GRAY_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem lime() {
        return new ColorBrickSlabItem(RegistryHandler.LIME_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem magenta() {
        return new ColorBrickSlabItem(RegistryHandler.MAGENTA_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem orange() {
        return new ColorBrickSlabItem(RegistryHandler.ORANGE_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem pink() {
        return new ColorBrickSlabItem(RegistryHandler.PINK_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem purple() {
        return new ColorBrickSlabItem(RegistryHandler.PURPLE_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem red() {
        return new ColorBrickSlabItem(RegistryHandler.RED_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem white() {
        return new ColorBrickSlabItem(RegistryHandler.WHITE_BRICK_SLAB_BLOCK);
    }

    public static ColorBrickSlabItem yellow() {
        return new ColorBrickSlabItem(RegistryHandler.YELLOW_BRICK_SLAB_BLOCK);
    }
}