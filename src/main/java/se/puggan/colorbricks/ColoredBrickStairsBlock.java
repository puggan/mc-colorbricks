package se.puggan.colorbricks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;

public class ColoredBrickStairsBlock extends StairsBlock {
    public ColoredBrickStairsBlock(Settings settings) {
        super(Blocks.BRICKS.getDefaultState(), settings);
    }
}
