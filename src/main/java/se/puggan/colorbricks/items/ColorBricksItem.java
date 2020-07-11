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

    public static ColorBricksItem yellow() {
        return new ColorBricksItem(RegistryHandler.YELLOW_BRICKS_BLOCK);
    }
}