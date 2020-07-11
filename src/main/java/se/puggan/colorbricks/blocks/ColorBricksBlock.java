package se.puggan.colorbricks.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class ColorBricksBlock extends Block
{
    public static Properties properties(MaterialColor color) {
        return AbstractBlock.Properties.create(Material.ROCK, color).func_235861_h_().hardnessAndResistance(2.0F, 6.0F);
    }

    public ColorBricksBlock(MaterialColor color)
    {
        super(properties(color));
    }

    public static ColorBricksBlock yellow()
    {
        return new ColorBricksBlock(MaterialColor.YELLOW);
    }
}