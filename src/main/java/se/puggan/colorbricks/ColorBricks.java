package se.puggan.colorbricks;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("colorbricks")
public class ColorBricks {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static String MOD_ID = "colorbricks";
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public ColorBricks() {
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

        Item.Properties itemProperties = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);

        for(Map.Entry<String, MaterialColor> color : colors.entrySet()) {
            AbstractBlock.Properties blockProperties = AbstractBlock.Properties.create(Material.ROCK, color.getValue()).func_235861_h_().hardnessAndResistance(2.0F, 6.0F);;
            for(String blockType : blockTypes) {
                String name = color.getKey() + "_" + blockType;
                Supplier<Block> blockSupplier;

                switch (blockType)
                {
                    case "brick_slab":
                        blockSupplier = () -> new SlabBlock(blockProperties);
                        break;

                    case "brick_stairs":
                        blockSupplier = () -> new StairsBlock(Blocks.BRICKS::getDefaultState, blockProperties);
                        break;

                    case "brick_wall":
                        blockSupplier = () -> new WallBlock(blockProperties);
                        break;

                    default:
                        blockSupplier = () -> new Block(blockProperties);
                }
                RegistryObject<Block> roBlock = BLOCKS.register(name, blockSupplier);
                ITEMS.register(name, () -> new BlockItem(roBlock.get(), itemProperties));
            }
        }

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }
}
