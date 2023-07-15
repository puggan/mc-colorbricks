package se.puggan.colorbricks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import com.google.gson.Gson;

public class ColorBricks implements ModInitializer {
    // Directly reference a log4j logger.
    //public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "colorbricks";

    public ColorBricks() {
    }

    @Override
    public void onInitialize() {
        String[] blockTypes = {"bricks", "brick_slab", "brick_stairs", "brick_wall"};
        Item.Settings itemSetting = new Item.Settings().group(ItemGroup.BUILDING_BLOCKS);
        BlockState brickState = Blocks.BRICKS.getDefaultState();

        class BrickStairs extends StairsBlock {
            public BrickStairs(Settings settings) {
                super(brickState, settings);
            }
        }

        FabricBlockSettings baseBlockSettings = FabricBlockSettings.copyOf(Blocks.BRICKS);

        for(DyeColor color : DyeColor.values()) {
            FabricBlockSettings blockSettings = FabricBlockSettings.copyOf(baseBlockSettings);
            blockSettings.mapColor(color);

            for (String blockType : blockTypes) {
                String name = color.getName() + "_" + blockType;
                Identifier id = new Identifier(MOD_ID, name);
                Block block = switch (blockType) {
                    case "brick_slab" -> new SlabBlock(blockSettings);
                    case "brick_stairs" -> new BrickStairs(blockSettings);
                    case "brick_wall" -> new WallBlock(blockSettings);
                    default -> new Block(blockSettings);
                };

                Registry.register(Registry.BLOCK, id, block);
                Item item = new BlockItem(block, itemSetting);
                Registry.register(Registry.ITEM, id, item);
            }
        }
    }
}
