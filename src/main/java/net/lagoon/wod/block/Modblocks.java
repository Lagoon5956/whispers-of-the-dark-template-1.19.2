package net.lagoon.wod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lagoon.wod.WhispersOfTheDark;
import net.lagoon.wod.block.custom.pedistal_block;
import net.lagoon.wod.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Modblocks {
    public static final Block INFUSED_AMETHYST_BLOCK = registerBlock("infused_amethyst_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).strength(4f).requiresTool().luminance(state -> 5)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)), ModItemGroup.WHISPERS_OF_THE_DARK);

    public static final Block PEDISTAL_BLOCK = registerBlock("pedistal_block",
            new pedistal_block(FabricBlockSettings.of(Material.STONE)
                    .strength(3f).requiresTool().luminance(state -> 3).nonOpaque().sounds(BlockSoundGroup.STONE)), ModItemGroup.WHISPERS_OF_THE_DARK);


    private static Block registerBlock(String name, Block block, ItemGroup tab) {
    registerBlockitem(name, block, tab);
     return Registry.register(Registry.BLOCK, new Identifier(WhispersOfTheDark.MOD_ID, name), block);
    }

    private static Item registerBlockitem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(WhispersOfTheDark.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModblocks() {
        WhispersOfTheDark.LOGGER.debug("Registering Modblocks for" + WhispersOfTheDark.MOD_ID);
    }
}
