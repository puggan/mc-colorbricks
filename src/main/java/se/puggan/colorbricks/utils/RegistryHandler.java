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

    public static final RegistryObject<Block> YELLOW_BRICKS_BLOCK = BLOCKS.register("yellow_bricks", ColorBricksBlock::yellow);
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