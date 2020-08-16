package se.puggan.colorbricks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfStoneSlab;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.BlockWall;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid=ColorBricks.MOD_ID, name = "ColorBricks", version = "1.1.1")
@Mod.EventBusSubscriber(modid=ColorBricks.MOD_ID)
public class ColorBricks {
    public static final String MOD_ID = "colorbricks";
    public static final HashMap<Block, Item> BLOCKS = new HashMap();

    public static void init() {
        new ColorBricks();
    }

    public ColorBricks() {
        IBlockState brickState = Blocks.BRICK_BLOCK.getDefaultState();

        addBlock(new BlockWall(Blocks.BRICK_BLOCK), "brick_wall");
        for(EnumDyeColor color : EnumDyeColor.values()) {
            String colorPrefix = color.getName() + "_";
            MapColor mapColor = MapColor.getBlockColor(color);
            Block baseBlock = new Block(Material.ROCK, mapColor);
            addBlock(baseBlock, colorPrefix + "bricks");
            addBlock(new Slab(mapColor), colorPrefix + "brick_slab");
            addBlock(new Stairs(brickState, mapColor), colorPrefix + "brick_stairs");
            addBlock(new Wall(baseBlock, mapColor), colorPrefix + "brick_wall");
        }
    }

    public void addBlock(Block block, String name)
    {
        block.setRegistryName(MOD_ID, name);
        block.setUnlocalizedName(name);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(MOD_ID, name);
        item.setUnlocalizedName(name);
        BLOCKS.put(block, item);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        BLOCKS.keySet().forEach(event.getRegistry()::register);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        BLOCKS.values().forEach(event.getRegistry()::register);
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        for(Map.Entry<Block, Item> row : BLOCKS.entrySet())
        {
            Block block = row.getKey();
            Item item = row.getValue();
            String variant = "";
            if(block instanceof Wall) {
                variant = "east=true";
            } else if(block instanceof Slab) {
                variant = "type=bottom";
            } else if(block instanceof Stairs) {
                variant = "facing=east,half=bottom,shape=straight";
            }
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), variant));
        }
    }

    public static class Stairs extends BlockStairs {
        private final MapColor mapColor;
        public Stairs(IBlockState modelState, MapColor color) {
            super(modelState);
            mapColor = color;
        }
        public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
        {
            return mapColor;
        }
    }
    public static class Slab extends BlockHalfStoneSlab {
        private final MapColor mapColor;
        public Slab(MapColor color) {
            super();
            mapColor = color;
        }
        public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
        {
            return mapColor;
        }
    }
    public static class Wall extends BlockWall {
        private final MapColor mapColor;
        public Wall(Block modelBlock, MapColor color) {
            super(modelBlock);
            mapColor = color;
        }
        public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
        {
            return mapColor;
        }
    }
}
