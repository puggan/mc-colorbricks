package se.puggan.colorbricks;

import java.util.HashMap;
import java.util.Map;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ColorBricks implements ModInitializer {
    // Directly reference a log4j logger.
    //public static final Logger LOGGER = LogManager.getLogger();
    public static String MOD_ID = "colorbricks";

    public ColorBricks() {
    }

    @Override
    public void onInitialize() {
        String[] blockTypes = {"bricks", "brick_slab", "brick_stairs", "brick_wall"};
        Map<String, MaterialColor> colors = new HashMap<String, MaterialColor>() {{
            put("black", MaterialColor.BLACK);
            put("blue", MaterialColor.BLUE);
            put("brown", MaterialColor.BROWN);
            put("cyan", MaterialColor.CYAN);
            put("gray", MaterialColor.GRAY);
            put("green", MaterialColor.GREEN);
            put("light_blue", MaterialColor.LIGHT_BLUE);
            put("light_gray", MaterialColor.LIGHT_GRAY);
            put("lime", MaterialColor.LIME);
            put("magenta", MaterialColor.MAGENTA);
            put("orange", MaterialColor.ORANGE_TERRACOTTA);
            put("pink", MaterialColor.PINK);
            put("purple", MaterialColor.PURPLE);
            put("red", MaterialColor.RED);
            put("white", MaterialColor.WHITE_TERRACOTTA);
            put("yellow", MaterialColor.YELLOW);
        }};

        Item.Settings itemSetting = new Item.Settings().group(ItemGroup.BUILDING_BLOCKS);

        for (Map.Entry<String, MaterialColor> color : colors.entrySet()) {
            FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.STONE, color.getValue()).requiresTool().strength(2.0F, 6.0F);
            for (String blockType : blockTypes) {
                String name = color.getKey() + "_" + blockType;
                Identifier id = new Identifier(MOD_ID, name);
                Block block;

                switch (blockType) {
                    case "brick_slab":
                        block = new SlabBlock(blockSettings);
                        break;

                    case "brick_stairs":
                        block = new ColoredBrickStairsBlock(blockSettings);
                        break;

                    case "brick_wall":
                        block = new WallBlock(blockSettings);
                        break;

                    default:
                        block = new Block(blockSettings);
                }

                Registry.register(Registry.BLOCK, id, block);
                Item item = new BlockItem(block, itemSetting);
                Registry.register(Registry.ITEM, id, item);
            }
        }
    }
}
