package se.puggan.colorbricks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
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

public class ColorBricks implements ModInitializer {
    // Directly reference a log4j logger.
    //public static final Logger LOGGER = LogManager.getLogger();
    public static String MOD_ID = "colorbricks";

    public ColorBricks() {
    }

    @Override
    public void onInitialize() {
        String[] blockTypes = {"bricks", "brick_slab", "brick_stairs", "brick_wall"};
        Item.Settings itemSetting = new Item.Settings().group(ItemGroup.BUILDING_BLOCKS);

        class BrickStairs extends StairsBlock {
            public BrickStairs(Settings settings) {
                super(Blocks.BRICKS.getDefaultState(), settings);
            }
        }

        for(DyeColor color : DyeColor.values()) {
            FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.STONE, color.getMaterialColor()).requiresTool().strength(2.0F, 6.0F);
            for (String blockType : blockTypes) {
                String name = color.getName() + "_" + blockType;
                Identifier id = new Identifier(MOD_ID, name);
                Block block;

                switch (blockType) {
                    case "brick_slab":
                        block = new SlabBlock(blockSettings);
                        break;

                    case "brick_stairs":
                        block = new BrickStairs(blockSettings);
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
