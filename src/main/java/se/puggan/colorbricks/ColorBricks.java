package se.puggan.colorbricks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
public class ColorBricks implements ModInitializer {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static String MOD_ID = "colorbricks";

    public ColorBricks() {
    }

    @Override
    public void onInitialize() {
        String[] blockTypes = {"bricks", "brick_slab", "brick_stairs", "brick_wall"};
        String[] colors = {"black",
                "blue",
                "brown",
                "cyan",
                "gray",
                "green",
                "light_blue",
                "light_gray",
                "lime",
                "magenta",
                "orange",
                "pink",
                "purple",
                "red",
                "white",
                "yellow"
        };

        Item.Settings itemSetting = new Item.Settings().group(ItemGroup.BUILDING_BLOCKS);

        for(String color : colors) {
            for(String blockType : blockTypes) {
                String name = color + "_" + blockType;
                Identifier id = new Identifier(MOD_ID, name);
                Block block;

                switch (blockType)
                {
                    case "brick_slab":
                        block = new SlabBlock(FabricBlockSettings.copyOf(Blocks.BRICKS));
                        break;

                    case "brick_stairs":
                        block = new ColoredBrickStairsBlock(Blocks.BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BRICKS));
                        break;

                    case "brick_wall":
                        block = new WallBlock(FabricBlockSettings.copyOf(Blocks.BRICKS));
                        break;

                    default:
                        block = new Block(FabricBlockSettings.copyOf(Blocks.BRICKS));
                }

                Registry.register(Registry.BLOCK, id, block);
                Item item = new BlockItem(block, itemSetting);
                Registry.register(Registry.ITEM, id, item);
            }
        }
    }
}
