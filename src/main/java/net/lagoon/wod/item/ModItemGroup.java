package net.lagoon.wod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.lagoon.wod.WhispersOfTheDark;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup WHISPERS_OF_THE_DARK = FabricItemGroupBuilder.build(
            new Identifier(WhispersOfTheDark.MOD_ID, "whisp-d"), () -> new ItemStack(Moditems.THE_VOID));

}
