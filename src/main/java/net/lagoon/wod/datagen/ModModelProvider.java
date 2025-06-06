package net.lagoon.wod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lagoon.wod.block.Modblocks;
import net.lagoon.wod.item.Moditems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(Modblocks.INFUSED_AMETHYST_BLOCK);



    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(Moditems.INFUSED_NAIL, Models.HANDHELD);
        itemModelGenerator.register(Moditems.NAPPING_TOOL, Models.HANDHELD);
        itemModelGenerator.register(Moditems.INFUSED_AMETHYST, Models.GENERATED);
        itemModelGenerator.register(Moditems.INFUSED_STAR, Models.GENERATED);
        itemModelGenerator.register(Moditems.THE_VOID, Models.GENERATED);
        itemModelGenerator.register(Moditems.VOID_SHARDS, Models.GENERATED);
        itemModelGenerator.register(Moditems.STAR_DUST, Models.GENERATED);

    }

}

