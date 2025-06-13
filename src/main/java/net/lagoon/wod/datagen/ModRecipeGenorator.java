package net.lagoon.wod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lagoon.wod.item.Moditems;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeGenorator extends FabricRecipeProvider {
    public ModRecipeGenorator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {

        ShapelessRecipeJsonBuilder.create(Moditems.NAPPING_TOOL, 1)
                .input(Items.COBBLESTONE)
                .input(Items.BONE)
                .criterion("has_cobblestone", conditionsFromItem(Items.COBBLESTONE))
                .criterion("has_bone", conditionsFromItem(Items.BONE))
                .offerTo(exporter, new Identifier("wod", "napping_tool"));


        ShapedRecipeJsonBuilder.create(Moditems.INFUSED_NAIL)
                .pattern("  #")
                .pattern(" # ")
                .pattern("#A ")
                .input('A', Moditems.NAPPING_TOOL)
                .input('#', Moditems.INFUSED_AMETHYST)
                .criterion(RecipeProvider.hasItem(Moditems.NAPPING_TOOL),
                        RecipeProvider.conditionsFromItem(Moditems.NAPPING_TOOL))
                .criterion(RecipeProvider.hasItem(Moditems.INFUSED_AMETHYST),
                        RecipeProvider.conditionsFromItem(Moditems.INFUSED_AMETHYST))

                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(Moditems.INFUSED_NAIL)));

        ShapedRecipeJsonBuilder.create(Moditems.VOID_BLADE, 1)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" A ")
                .input('#', Moditems.INFUSED_STAR)
                .input('A', Moditems.COSMIC_HANDLE)
                .criterion(RecipeProvider.hasItem(Moditems.INFUSED_STAR),
                        RecipeProvider.conditionsFromItem(Moditems.INFUSED_STAR))
                .criterion(RecipeProvider.hasItem(Moditems.COSMIC_HANDLE),
                        RecipeProvider.conditionsFromItem(Moditems.COSMIC_HANDLE))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(Moditems.VOID_BLADE)));
    }



    private static void offerShapelessRecipe() {

    }
}
