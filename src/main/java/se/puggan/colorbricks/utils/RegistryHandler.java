package se.puggan.colorbricks.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import se.puggan.colorbricks.blocks.ColorBrickSlabBlock;
import se.puggan.colorbricks.blocks.ColorBrickStairsBlock;
import se.puggan.colorbricks.blocks.ColorBrickWallBlock;
import se.puggan.colorbricks.blocks.ColorBricksBlock;
import se.puggan.colorbricks.items.ColorBrickSlabItem;
import se.puggan.colorbricks.items.ColorBrickStairsItem;
import se.puggan.colorbricks.items.ColorBrickWallItem;
import se.puggan.colorbricks.items.ColorBricksItem;

public class RegistryHandler {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister(ForgeRegistries.BLOCKS, se.puggan.colorbricks.ColorBricks.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister(ForgeRegistries.ITEMS, se.puggan.colorbricks.ColorBricks.MOD_ID);

    public static final RegistryObject<Block> BLACK_BRICKS_BLOCK = BLOCKS.register("black_bricks", ColorBricksBlock::black);
    public static final RegistryObject<Block> BLACK_BRICK_SLAB_BLOCK = BLOCKS.register("black_brick_slab", ColorBrickSlabBlock::black);
    public static final RegistryObject<Block> BLACK_BRICK_STARIRS_BLOCK = BLOCKS.register("black_brick_stairs", ColorBrickStairsBlock::black);
    public static final RegistryObject<Block> BLACK_BRICK_WALL_BLOCK = BLOCKS.register("black_brick_wall", ColorBrickWallBlock::black);
    public static final RegistryObject<Block> BLUE_BRICKS_BLOCK = BLOCKS.register("blue_bricks", ColorBricksBlock::blue);
    public static final RegistryObject<Block> BLUE_BRICK_SLAB_BLOCK = BLOCKS.register("blue_brick_slab", ColorBrickSlabBlock::blue);
    public static final RegistryObject<Block> BLUE_BRICK_STARIRS_BLOCK = BLOCKS.register("blue_brick_stairs", ColorBrickStairsBlock::blue);
    public static final RegistryObject<Block> BLUE_BRICK_WALL_BLOCK = BLOCKS.register("blue_brick_wall", ColorBrickWallBlock::blue);
    public static final RegistryObject<Block> BROWN_BRICKS_BLOCK = BLOCKS.register("brown_bricks", ColorBricksBlock::brown);
    public static final RegistryObject<Block> BROWN_BRICK_SLAB_BLOCK = BLOCKS.register("brown_brick_slab", ColorBrickSlabBlock::brown);
    public static final RegistryObject<Block> BROWN_BRICK_STARIRS_BLOCK = BLOCKS.register("brown_brick_stairs", ColorBrickStairsBlock::brown);
    public static final RegistryObject<Block> BROWN_BRICK_WALL_BLOCK = BLOCKS.register("brown_brick_wall", ColorBrickWallBlock::brown);
    public static final RegistryObject<Block> CYAN_BRICKS_BLOCK = BLOCKS.register("cyan_bricks", ColorBricksBlock::cyan);
    public static final RegistryObject<Block> CYAN_BRICK_SLAB_BLOCK = BLOCKS.register("cyan_brick_slab", ColorBrickSlabBlock::cyan);
    public static final RegistryObject<Block> CYAN_BRICK_STARIRS_BLOCK = BLOCKS.register("cyan_brick_stairs", ColorBrickStairsBlock::cyan);
    public static final RegistryObject<Block> CYAN_BRICK_WALL_BLOCK = BLOCKS.register("cyan_brick_wall", ColorBrickWallBlock::cyan);
    public static final RegistryObject<Block> GRAY_BRICKS_BLOCK = BLOCKS.register("gray_bricks", ColorBricksBlock::gray);
    public static final RegistryObject<Block> GRAY_BRICK_SLAB_BLOCK = BLOCKS.register("gray_brick_slab", ColorBrickSlabBlock::gray);
    public static final RegistryObject<Block> GRAY_BRICK_STARIRS_BLOCK = BLOCKS.register("gray_brick_stairs", ColorBrickStairsBlock::gray);
    public static final RegistryObject<Block> GRAY_BRICK_WALL_BLOCK = BLOCKS.register("gray_brick_wall", ColorBrickWallBlock::gray);
    public static final RegistryObject<Block> GREEN_BRICKS_BLOCK = BLOCKS.register("green_bricks", ColorBricksBlock::green);
    public static final RegistryObject<Block> GREEN_BRICK_SLAB_BLOCK = BLOCKS.register("green_brick_slab", ColorBrickSlabBlock::green);
    public static final RegistryObject<Block> GREEN_BRICK_STARIRS_BLOCK = BLOCKS.register("green_brick_stairs", ColorBrickStairsBlock::green);
    public static final RegistryObject<Block> GREEN_BRICK_WALL_BLOCK = BLOCKS.register("green_brick_wall", ColorBrickWallBlock::green);
    public static final RegistryObject<Block> LIGHT_BLUE_BRICKS_BLOCK = BLOCKS.register("light_blue_bricks", ColorBricksBlock::light_blue);
    public static final RegistryObject<Block> LIGHT_BLUE_BRICK_SLAB_BLOCK = BLOCKS.register("light_blue_brick_slab", ColorBrickSlabBlock::light_blue);
    public static final RegistryObject<Block> LIGHT_BLUE_BRICK_STARIRS_BLOCK = BLOCKS.register("light_blue_brick_stairs", ColorBrickStairsBlock::light_blue);
    public static final RegistryObject<Block> LIGHT_BLUE_BRICK_WALL_BLOCK = BLOCKS.register("light_blue_brick_wall", ColorBrickWallBlock::light_blue);
    public static final RegistryObject<Block> LIGHT_GRAY_BRICKS_BLOCK = BLOCKS.register("light_gray_bricks", ColorBricksBlock::light_gray);
    public static final RegistryObject<Block> LIGHT_GRAY_BRICK_SLAB_BLOCK = BLOCKS.register("light_gray_brick_slab", ColorBrickSlabBlock::light_gray);
    public static final RegistryObject<Block> LIGHT_GRAY_BRICK_STARIRS_BLOCK = BLOCKS.register("light_gray_brick_stairs", ColorBrickStairsBlock::light_gray);
    public static final RegistryObject<Block> LIGHT_GRAY_BRICK_WALL_BLOCK = BLOCKS.register("light_gray_brick_wall", ColorBrickWallBlock::light_gray);
    public static final RegistryObject<Block> LIME_BRICKS_BLOCK = BLOCKS.register("lime_bricks", ColorBricksBlock::lime);
    public static final RegistryObject<Block> LIME_BRICK_SLAB_BLOCK = BLOCKS.register("lime_brick_slab", ColorBrickSlabBlock::lime);
    public static final RegistryObject<Block> LIME_BRICK_STARIRS_BLOCK = BLOCKS.register("lime_brick_stairs", ColorBrickStairsBlock::lime);
    public static final RegistryObject<Block> LIME_BRICK_WALL_BLOCK = BLOCKS.register("lime_brick_wall", ColorBrickWallBlock::lime);
    public static final RegistryObject<Block> MAGENTA_BRICKS_BLOCK = BLOCKS.register("magenta_bricks", ColorBricksBlock::magenta);
    public static final RegistryObject<Block> MAGENTA_BRICK_SLAB_BLOCK = BLOCKS.register("magenta_brick_slab", ColorBrickSlabBlock::magenta);
    public static final RegistryObject<Block> MAGENTA_BRICK_STARIRS_BLOCK = BLOCKS.register("magenta_brick_stairs", ColorBrickStairsBlock::magenta);
    public static final RegistryObject<Block> MAGENTA_BRICK_WALL_BLOCK = BLOCKS.register("magenta_brick_wall", ColorBrickWallBlock::magenta);
    public static final RegistryObject<Block> ORANGE_BRICKS_BLOCK = BLOCKS.register("orange_bricks", ColorBricksBlock::orange);
    public static final RegistryObject<Block> ORANGE_BRICK_SLAB_BLOCK = BLOCKS.register("orange_brick_slab", ColorBrickSlabBlock::orange);
    public static final RegistryObject<Block> ORANGE_BRICK_STARIRS_BLOCK = BLOCKS.register("orange_brick_stairs", ColorBrickStairsBlock::orange);
    public static final RegistryObject<Block> ORANGE_BRICK_WALL_BLOCK = BLOCKS.register("orange_brick_wall", ColorBrickWallBlock::orange);
    public static final RegistryObject<Block> PINK_BRICKS_BLOCK = BLOCKS.register("pink_bricks", ColorBricksBlock::pink);
    public static final RegistryObject<Block> PINK_BRICK_SLAB_BLOCK = BLOCKS.register("pink_brick_slab", ColorBrickSlabBlock::pink);
    public static final RegistryObject<Block> PINK_BRICK_STARIRS_BLOCK = BLOCKS.register("pink_brick_stairs", ColorBrickStairsBlock::pink);
    public static final RegistryObject<Block> PINK_BRICK_WALL_BLOCK = BLOCKS.register("pink_brick_wall", ColorBrickWallBlock::pink);
    public static final RegistryObject<Block> PURPLE_BRICKS_BLOCK = BLOCKS.register("purple_bricks", ColorBricksBlock::purple);
    public static final RegistryObject<Block> PURPLE_BRICK_SLAB_BLOCK = BLOCKS.register("purple_brick_slab", ColorBrickSlabBlock::purple);
    public static final RegistryObject<Block> PURPLE_BRICK_STARIRS_BLOCK = BLOCKS.register("purple_brick_stairs", ColorBrickStairsBlock::purple);
    public static final RegistryObject<Block> PURPLE_BRICK_WALL_BLOCK = BLOCKS.register("purple_brick_wall", ColorBrickWallBlock::purple);
    public static final RegistryObject<Block> RED_BRICKS_BLOCK = BLOCKS.register("red_bricks", ColorBricksBlock::red);
    public static final RegistryObject<Block> RED_BRICK_SLAB_BLOCK = BLOCKS.register("red_brick_slab", ColorBrickSlabBlock::red);
    public static final RegistryObject<Block> RED_BRICK_STARIRS_BLOCK = BLOCKS.register("red_brick_stairs", ColorBrickStairsBlock::red);
    public static final RegistryObject<Block> RED_BRICK_WALL_BLOCK = BLOCKS.register("red_brick_wall", ColorBrickWallBlock::red);
    public static final RegistryObject<Block> WHITE_BRICKS_BLOCK = BLOCKS.register("white_bricks", ColorBricksBlock::white);
    public static final RegistryObject<Block> WHITE_BRICK_SLAB_BLOCK = BLOCKS.register("white_brick_slab", ColorBrickSlabBlock::white);
    public static final RegistryObject<Block> WHITE_BRICK_STARIRS_BLOCK = BLOCKS.register("white_brick_stairs", ColorBrickStairsBlock::white);
    public static final RegistryObject<Block> WHITE_BRICK_WALL_BLOCK = BLOCKS.register("white_brick_wall", ColorBrickWallBlock::white);
    public static final RegistryObject<Block> YELLOW_BRICKS_BLOCK = BLOCKS.register("yellow_bricks", ColorBricksBlock::yellow);
    public static final RegistryObject<Block> YELLOW_BRICK_SLAB_BLOCK = BLOCKS.register("yellow_brick_slab", ColorBrickSlabBlock::yellow);
    public static final RegistryObject<Block> YELLOW_BRICK_STARIRS_BLOCK = BLOCKS.register("yellow_brick_stairs", ColorBrickStairsBlock::yellow);
    public static final RegistryObject<Block> YELLOW_BRICK_WALL_BLOCK = BLOCKS.register("yellow_brick_wall", ColorBrickWallBlock::yellow);

    public static final RegistryObject<Item> BLACK_BRICKS_ITEM = ITEMS.register("black_bricks", ColorBricksItem::black);
    public static final RegistryObject<Item> BLACK_BRICK_SLAB_ITEM = ITEMS.register("black_brick_slab", ColorBrickSlabItem::black);
    public static final RegistryObject<Item> BLACK_BRICK_STARIRS_ITEM = ITEMS.register("black_brick_stairs", ColorBrickStairsItem::black);
    public static final RegistryObject<Item> BLACK_BRICK_WALL_ITEM = ITEMS.register("black_brick_wall", ColorBrickWallItem::black);
    public static final RegistryObject<Item> BLUE_BRICKS_ITEM = ITEMS.register("blue_bricks", ColorBricksItem::blue);
    public static final RegistryObject<Item> BLUE_BRICK_SLAB_ITEM = ITEMS.register("blue_brick_slab", ColorBrickSlabItem::blue);
    public static final RegistryObject<Item> BLUE_BRICK_STARIRS_ITEM = ITEMS.register("blue_brick_stairs", ColorBrickStairsItem::blue);
    public static final RegistryObject<Item> BLUE_BRICK_WALL_ITEM = ITEMS.register("blue_brick_wall", ColorBrickWallItem::blue);
    public static final RegistryObject<Item> BROWN_BRICKS_ITEM = ITEMS.register("brown_bricks", ColorBricksItem::brown);
    public static final RegistryObject<Item> BROWN_BRICK_SLAB_ITEM = ITEMS.register("brown_brick_slab", ColorBrickSlabItem::brown);
    public static final RegistryObject<Item> BROWN_BRICK_STARIRS_ITEM = ITEMS.register("brown_brick_stairs", ColorBrickStairsItem::brown);
    public static final RegistryObject<Item> BROWN_BRICK_WALL_ITEM = ITEMS.register("brown_brick_wall", ColorBrickWallItem::brown);
    public static final RegistryObject<Item> CYAN_BRICKS_ITEM = ITEMS.register("cyan_bricks", ColorBricksItem::cyan);
    public static final RegistryObject<Item> CYAN_BRICK_SLAB_ITEM = ITEMS.register("cyan_brick_slab", ColorBrickSlabItem::cyan);
    public static final RegistryObject<Item> CYAN_BRICK_STARIRS_ITEM = ITEMS.register("cyan_brick_stairs", ColorBrickStairsItem::cyan);
    public static final RegistryObject<Item> CYAN_BRICK_WALL_ITEM = ITEMS.register("cyan_brick_wall", ColorBrickWallItem::cyan);
    public static final RegistryObject<Item> GRAY_BRICKS_ITEM = ITEMS.register("gray_bricks", ColorBricksItem::gray);
    public static final RegistryObject<Item> GRAY_BRICK_SLAB_ITEM = ITEMS.register("gray_brick_slab", ColorBrickSlabItem::gray);
    public static final RegistryObject<Item> GRAY_BRICK_STARIRS_ITEM = ITEMS.register("gray_brick_stairs", ColorBrickStairsItem::gray);
    public static final RegistryObject<Item> GRAY_BRICK_WALL_ITEM = ITEMS.register("gray_brick_wall", ColorBrickWallItem::gray);
    public static final RegistryObject<Item> GREEN_BRICKS_ITEM = ITEMS.register("green_bricks", ColorBricksItem::green);
    public static final RegistryObject<Item> GREEN_BRICK_SLAB_ITEM = ITEMS.register("green_brick_slab", ColorBrickSlabItem::green);
    public static final RegistryObject<Item> GREEN_BRICK_STARIRS_ITEM = ITEMS.register("green_brick_stairs", ColorBrickStairsItem::green);
    public static final RegistryObject<Item> GREEN_BRICK_WALL_ITEM = ITEMS.register("green_brick_wall", ColorBrickWallItem::green);
    public static final RegistryObject<Item> LIGHT_BLUE_BRICKS_ITEM = ITEMS.register("light_blue_bricks", ColorBricksItem::light_blue);
    public static final RegistryObject<Item> LIGHT_BLUE_BRICK_SLAB_ITEM = ITEMS.register("light_blue_brick_slab", ColorBrickSlabItem::light_blue);
    public static final RegistryObject<Item> LIGHT_BLUE_BRICK_STARIRS_ITEM = ITEMS.register("light_blue_brick_stairs", ColorBrickStairsItem::light_blue);
    public static final RegistryObject<Item> LIGHT_BLUE_BRICK_WALL_ITEM = ITEMS.register("light_blue_brick_wall", ColorBrickWallItem::light_blue);
    public static final RegistryObject<Item> LIGHT_GRAY_BRICKS_ITEM = ITEMS.register("light_gray_bricks", ColorBricksItem::light_gray);
    public static final RegistryObject<Item> LIGHT_GRAY_BRICK_SLAB_ITEM = ITEMS.register("light_gray_brick_slab", ColorBrickSlabItem::light_gray);
    public static final RegistryObject<Item> LIGHT_GRAY_BRICK_STARIRS_ITEM = ITEMS.register("light_gray_brick_stairs", ColorBrickStairsItem::light_gray);
    public static final RegistryObject<Item> LIGHT_GRAY_BRICK_WALL_ITEM = ITEMS.register("light_gray_brick_wall", ColorBrickWallItem::light_gray);
    public static final RegistryObject<Item> LIME_BRICKS_ITEM = ITEMS.register("lime_bricks", ColorBricksItem::lime);
    public static final RegistryObject<Item> LIME_BRICK_SLAB_ITEM = ITEMS.register("lime_brick_slab", ColorBrickSlabItem::lime);
    public static final RegistryObject<Item> LIME_BRICK_STARIRS_ITEM = ITEMS.register("lime_brick_stairs", ColorBrickStairsItem::lime);
    public static final RegistryObject<Item> LIME_BRICK_WALL_ITEM = ITEMS.register("lime_brick_wall", ColorBrickWallItem::lime);
    public static final RegistryObject<Item> MAGENTA_BRICKS_ITEM = ITEMS.register("magenta_bricks", ColorBricksItem::magenta);
    public static final RegistryObject<Item> MAGENTA_BRICK_SLAB_ITEM = ITEMS.register("magenta_brick_slab", ColorBrickSlabItem::magenta);
    public static final RegistryObject<Item> MAGENTA_BRICK_STARIRS_ITEM = ITEMS.register("magenta_brick_stairs", ColorBrickStairsItem::magenta);
    public static final RegistryObject<Item> MAGENTA_BRICK_WALL_ITEM = ITEMS.register("magenta_brick_wall", ColorBrickWallItem::magenta);
    public static final RegistryObject<Item> ORANGE_BRICKS_ITEM = ITEMS.register("orange_bricks", ColorBricksItem::orange);
    public static final RegistryObject<Item> ORANGE_BRICK_SLAB_ITEM = ITEMS.register("orange_brick_slab", ColorBrickSlabItem::orange);
    public static final RegistryObject<Item> ORANGE_BRICK_STARIRS_ITEM = ITEMS.register("orange_brick_stairs", ColorBrickStairsItem::orange);
    public static final RegistryObject<Item> ORANGE_BRICK_WALL_ITEM = ITEMS.register("orange_brick_wall", ColorBrickWallItem::orange);
    public static final RegistryObject<Item> PINK_BRICKS_ITEM = ITEMS.register("pink_bricks", ColorBricksItem::pink);
    public static final RegistryObject<Item> PINK_BRICK_SLAB_ITEM = ITEMS.register("pink_brick_slab", ColorBrickSlabItem::pink);
    public static final RegistryObject<Item> PINK_BRICK_STARIRS_ITEM = ITEMS.register("pink_brick_stairs", ColorBrickStairsItem::pink);
    public static final RegistryObject<Item> PINK_BRICK_WALL_ITEM = ITEMS.register("pink_brick_wall", ColorBrickWallItem::pink);
    public static final RegistryObject<Item> PURPLE_BRICKS_ITEM = ITEMS.register("purple_bricks", ColorBricksItem::purple);
    public static final RegistryObject<Item> PURPLE_BRICK_SLAB_ITEM = ITEMS.register("purple_brick_slab", ColorBrickSlabItem::purple);
    public static final RegistryObject<Item> PURPLE_BRICK_STARIRS_ITEM = ITEMS.register("purple_brick_stairs", ColorBrickStairsItem::purple);
    public static final RegistryObject<Item> PURPLE_BRICK_WALL_ITEM = ITEMS.register("purple_brick_wall", ColorBrickWallItem::purple);
    public static final RegistryObject<Item> RED_BRICKS_ITEM = ITEMS.register("red_bricks", ColorBricksItem::red);
    public static final RegistryObject<Item> RED_BRICK_SLAB_ITEM = ITEMS.register("red_brick_slab", ColorBrickSlabItem::red);
    public static final RegistryObject<Item> RED_BRICK_STARIRS_ITEM = ITEMS.register("red_brick_stairs", ColorBrickStairsItem::red);
    public static final RegistryObject<Item> RED_BRICK_WALL_ITEM = ITEMS.register("red_brick_wall", ColorBrickWallItem::red);
    public static final RegistryObject<Item> WHITE_BRICKS_ITEM = ITEMS.register("white_bricks", ColorBricksItem::white);
    public static final RegistryObject<Item> WHITE_BRICK_SLAB_ITEM = ITEMS.register("white_brick_slab", ColorBrickSlabItem::white);
    public static final RegistryObject<Item> WHITE_BRICK_STARIRS_ITEM = ITEMS.register("white_brick_stairs", ColorBrickStairsItem::white);
    public static final RegistryObject<Item> WHITE_BRICK_WALL_ITEM = ITEMS.register("white_brick_wall", ColorBrickWallItem::white);
    public static final RegistryObject<Item> YELLOW_BRICKS_ITEM = ITEMS.register("yellow_bricks", ColorBricksItem::yellow);
    public static final RegistryObject<Item> YELLOW_BRICK_SLAB_ITEM = ITEMS.register("yellow_brick_slab", ColorBrickSlabItem::yellow);
    public static final RegistryObject<Item> YELLOW_BRICK_STARIRS_ITEM = ITEMS.register("yellow_brick_stairs", ColorBrickStairsItem::yellow);
    public static final RegistryObject<Item> YELLOW_BRICK_WALL_ITEM = ITEMS.register("yellow_brick_wall", ColorBrickWallItem::yellow);

    public static void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    public static void initServerOnly() {
    }

    @OnlyIn(Dist.CLIENT)
    public static void initClientOnly() {
    }
}