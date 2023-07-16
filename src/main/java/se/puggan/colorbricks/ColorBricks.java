package se.puggan.colorbricks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.InvocationTargetException;

public class ColorBricks implements ModInitializer {
    public static final String MOD_ID = "colorbricks";

    @Override
    public void onInitialize() {
        String[] blockTypes = {"bricks", "brick_slab", "brick_stairs", "brick_wall", "brick_column"};
        Item.Settings itemSetting = new Item.Settings().group(ItemGroup.BUILDING_BLOCKS);
        BlockState brickState = Blocks.BRICKS.getDefaultState();
        boolean addColumns = FabricLoader.getInstance().isModLoaded("columns");

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
                if (!addColumns && blockType.equals("brick_column")) {
                    continue;
                }
                String name = color.getName() + "_" + blockType;
                Identifier id = new Identifier(MOD_ID, name);
                Block block;
                try {
                    block = switch (blockType) {
                        case "brick_slab" -> new SlabBlock(blockSettings);
                        case "brick_stairs" -> new BrickStairs(blockSettings);
                        case "brick_wall" -> new WallBlock(blockSettings);
                        // case "brick_column" -> new ColumnBlock(blockSettings);
                        case "brick_column" -> (Block) Class
                                .forName("io.github.haykam821.columns.block.ColumnBlock")
                                .getDeclaredConstructor(AbstractBlock.Settings.class)
                                .newInstance(blockSettings);
                        default -> new Block(blockSettings);
                    };
                } catch (InstantiationException|IllegalAccessException|InvocationTargetException|NoSuchMethodException|ClassNotFoundException e) {
                    System.err.println(e.toString());
                    continue;
                }

                Registry.register(Registry.BLOCK, id, block);
                Item item = new BlockItem(block, itemSetting);
                Registry.register(Registry.ITEM, id, item);
            }
        }
    }
}
