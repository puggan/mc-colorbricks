package se.puggan.colorbricks;

import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("colorbricks")
public class ColorBricks {
    //public static final Logger LOGGER = LogManager.getLogger();
    public static String MOD_ID = "colorbricks";
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister(ForgeRegistries.ITEMS, MOD_ID);

    public ColorBricks() {
        String[] blockTypes = {"bricks", "brick_slab", "brick_stairs", "brick_wall"};
        Item.Properties itemProperties = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);

        for(DyeColor color : DyeColor.values()) {
            Block.Properties blockProperties = Block.Properties.create(Material.ROCK, color.getMapColor()).hardnessAndResistance(2.0F, 6.0F);;
            for(String blockType : blockTypes) {
                String name = color.getTranslationKey() + "_" + blockType;
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
