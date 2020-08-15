package se.puggan.colorbricks;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(ColorBricks.MOD_ID)
@Mod.EventBusSubscriber(modid = ColorBricks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColorBricks {
    //public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "colorbricks";
    public static final Set<Block> BLOCKS = new HashSet<>();
    public static final Set<Item> ITEMS = new HashSet<>();

    public ColorBricks() {
        String[] blockTypes = {"bricks", "brick_slab", "brick_stairs", "brick_wall"};
        Item.Properties itemProperties = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);

        // Brick wall was added in 1.14, so we have to make our own
        String brickWallFullName = MOD_ID + ":brick_wall";
        Block.Properties brickWallProperties = Block.Properties.create(Material.ROCK, EnumDyeColor.RED.getMapColor()).hardnessAndResistance(2.0F, 6.0F);;
        Block brickWallBlock = new BlockWall(brickWallProperties);
        ItemBlock brickWallItem = new ItemBlock(brickWallBlock, itemProperties);
        brickWallBlock.setRegistryName(brickWallFullName);
        BLOCKS.add(brickWallBlock);
        brickWallItem.setRegistryName(brickWallFullName);
        ITEMS.add(brickWallItem);

        for(EnumDyeColor color : EnumDyeColor.values()) {
            Block.Properties blockProperties = Block.Properties.create(Material.ROCK, color.getMapColor()).hardnessAndResistance(2.0F, 6.0F);;
            for(String blockType : blockTypes) {
                String name = color.getTranslationKey() + "_" + blockType;
                String fullName = MOD_ID + ":" + name;
                Block block;

                switch (blockType)
                {
                    case "brick_slab":
                        block = new BlockSlab(blockProperties);
                        break;

                    case "brick_stairs":
                        block = new Stairs(Blocks.BRICKS.getDefaultState(), blockProperties);
                        break;

                    case "brick_wall":
                        block = new BlockWall(blockProperties);
                        break;

                    default:
                        block = new Block(blockProperties);
                }
                block.setRegistryName(fullName);
                BLOCKS.add(block);
                ItemBlock item = new ItemBlock(block, itemProperties);
                item.setRegistryName(fullName);
                ITEMS.add(item);
            }
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        BLOCKS.forEach(event.getRegistry()::register);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ITEMS.forEach(event.getRegistry()::register);
    }

    // Wrapper for protected constructor
    public class Stairs extends BlockStairs {
        public Stairs(IBlockState p_i48321_1_, Properties p_i48321_2_) {
            super(p_i48321_1_, p_i48321_2_);
        }
    }
}
