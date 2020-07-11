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
import se.puggan.colorbricks.blocks.ColorBricksBlock;
import se.puggan.colorbricks.items.ColorBricksItem;

public class RegistryHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, se.puggan.colorbricks.ColorBricks.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, se.puggan.colorbricks.ColorBricks.MOD_ID);

    public static final RegistryObject<Block> BLACK_BRICKS_BLOCK = BLOCKS.register("black_bricks", ColorBricksBlock::black);
    public static final RegistryObject<Block> BLUE_BRICKS_BLOCK = BLOCKS.register("blue_bricks", ColorBricksBlock::blue);
    public static final RegistryObject<Block> BROWN_BRICKS_BLOCK = BLOCKS.register("brown_bricks", ColorBricksBlock::brown);
    public static final RegistryObject<Block> CYAN_BRICKS_BLOCK = BLOCKS.register("cyan_bricks", ColorBricksBlock::cyan);
    public static final RegistryObject<Block> GRAY_BRICKS_BLOCK = BLOCKS.register("gray_bricks", ColorBricksBlock::gray);
    public static final RegistryObject<Block> GREEN_BRICKS_BLOCK = BLOCKS.register("green_bricks", ColorBricksBlock::green);
    public static final RegistryObject<Block> LIGHT_BLUE_BRICKS_BLOCK = BLOCKS.register("light_blue_bricks", ColorBricksBlock::light_blue);
    public static final RegistryObject<Block> LIGHT_GRAY_BRICKS_BLOCK = BLOCKS.register("light_gray_bricks", ColorBricksBlock::light_gray);
    public static final RegistryObject<Block> LIME_BRICKS_BLOCK = BLOCKS.register("lime_bricks", ColorBricksBlock::lime);
    public static final RegistryObject<Block> MAGENTA_BRICKS_BLOCK = BLOCKS.register("magenta_bricks", ColorBricksBlock::magenta);
    public static final RegistryObject<Block> ORANGE_BRICKS_BLOCK = BLOCKS.register("orange_bricks", ColorBricksBlock::orange);
    public static final RegistryObject<Block> PINK_BRICKS_BLOCK = BLOCKS.register("pink_bricks", ColorBricksBlock::pink);
    public static final RegistryObject<Block> PURPLE_BRICKS_BLOCK = BLOCKS.register("purple_bricks", ColorBricksBlock::purple);
    public static final RegistryObject<Block> RED_BRICKS_BLOCK = BLOCKS.register("red_bricks", ColorBricksBlock::red);
    public static final RegistryObject<Block> WHITE_BRICKS_BLOCK = BLOCKS.register("white_bricks", ColorBricksBlock::white);
    public static final RegistryObject<Block> YELLOW_BRICKS_BLOCK = BLOCKS.register("yellow_bricks", ColorBricksBlock::yellow);

    public static final RegistryObject<Item> BLACK_BRICKS_ITEM = ITEMS.register("black_bricks", ColorBricksItem::black);
    public static final RegistryObject<Item> BLUE_BRICKS_ITEM = ITEMS.register("blue_bricks", ColorBricksItem::blue);
    public static final RegistryObject<Item> BROWN_BRICKS_ITEM = ITEMS.register("brown_bricks", ColorBricksItem::brown);
    public static final RegistryObject<Item> CYAN_BRICKS_ITEM = ITEMS.register("cyan_bricks", ColorBricksItem::cyan);
    public static final RegistryObject<Item> GRAY_BRICKS_ITEM = ITEMS.register("gray_bricks", ColorBricksItem::gray);
    public static final RegistryObject<Item> GREEN_BRICKS_ITEM = ITEMS.register("green_bricks", ColorBricksItem::green);
    public static final RegistryObject<Item> LIGHT_BLUE_BRICKS_ITEM = ITEMS.register("light_blue_bricks", ColorBricksItem::light_blue);
    public static final RegistryObject<Item> LIGHT_GRAY_BRICKS_ITEM = ITEMS.register("light_gray_bricks", ColorBricksItem::light_gray);
    public static final RegistryObject<Item> LIME_BRICKS_ITEM = ITEMS.register("lime_bricks", ColorBricksItem::lime);
    public static final RegistryObject<Item> MAGENTA_BRICKS_ITEM = ITEMS.register("magenta_bricks", ColorBricksItem::magenta);
    public static final RegistryObject<Item> ORANGE_BRICKS_ITEM = ITEMS.register("orange_bricks", ColorBricksItem::orange);
    public static final RegistryObject<Item> PINK_BRICKS_ITEM = ITEMS.register("pink_bricks", ColorBricksItem::pink);
    public static final RegistryObject<Item> PURPLE_BRICKS_ITEM = ITEMS.register("purple_bricks", ColorBricksItem::purple);
    public static final RegistryObject<Item> RED_BRICKS_ITEM = ITEMS.register("red_bricks", ColorBricksItem::red);
    public static final RegistryObject<Item> WHITE_BRICKS_ITEM = ITEMS.register("white_bricks", ColorBricksItem::white);
    public static final RegistryObject<Item> YELLOW_BRICKS_ITEM = ITEMS.register("yellow_bricks", ColorBricksItem::yellow);

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