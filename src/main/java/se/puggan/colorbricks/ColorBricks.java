package se.puggan.colorbricks;

import java.util.HashMap;
import java.util.Map;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ColorBricks implements ModInitializer {
    // Directly reference a log4j logger.
    //private static final Logger LOGGER = LogManager.getLogger("ColorBricks");
    private static final String MOD_ID = "colorbricks";
    private static final Item.Settings ITEM_SETTINGS = new Item.Settings().group(ItemGroup.BUILDING_BLOCKS);

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
                        break;
                }

                Registry.register(Registry.BLOCK, id, block);
                Registry.register(Registry.ITEM, id, new BlockItem(block, ITEM_SETTINGS));
            }
        }
    }

    // Since it's such a small class, it should be in here with the rest of the code
    public static class ColoredBrickStairsBlock extends StairsBlock {
        public ColoredBrickStairsBlock(Settings settings) {
            super(Blocks.BRICKS.getDefaultState(), settings);
        }
    }
}
