package net.lagoon.wod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lagoon.wod.WhispersOfTheDark;
import net.lagoon.wod.item.custom.TheVoidBlade;
import net.lagoon.wod.item.custom.TheVoiditem;
import net.lagoon.wod.item.custom.VoidStaffitem;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class Moditems {


    public static final Item INFUSED_AMETHYST = registerItem("infused_amethyst",
            new Item(new FabricItemSettings().group(ModItemGroup.WHISPERS_OF_THE_DARK).rarity(Rarity.UNCOMMON)));



    public static final Item VOID_SHARDS = registerItem("void_shards",
            new Item(new FabricItemSettings().group(ModItemGroup.WHISPERS_OF_THE_DARK).maxCount(1).rarity(Rarity.EPIC)));

    public static final Item INFUSED_STAR = registerItem("infused_star",
            new Item(new FabricItemSettings().group(ModItemGroup.WHISPERS_OF_THE_DARK).rarity(Rarity.RARE)));

    public static final Item THE_VOID = registerItem("the_void",
            new TheVoiditem(new FabricItemSettings().group(ModItemGroup.WHISPERS_OF_THE_DARK).maxCount(1).maxDamage(100).rarity(Rarity.EPIC)));


    public static final Item INFUSED_NAIL = (SwordItem) registerItem("infused_nail",
            new SwordItem(Modtoolmeterialsimplements.INFUSED_AMETHYST, 2, -1,
                    new FabricItemSettings().group(ModItemGroup.WHISPERS_OF_THE_DARK).maxCount(1).rarity(Rarity.RARE)));

    public static final Item VOID_BLADE = (SwordItem) registerItem("void_blade",
            new TheVoidBlade(Modtoolmeterialsimplements.INFUSED_STAR, 6, -2.3f,
                    new FabricItemSettings().group(ModItemGroup.WHISPERS_OF_THE_DARK).maxCount(1).rarity(Rarity.EPIC)));

    public static final Item NAPPING_TOOL = registerItem("napping_tool",
            new Item(new FabricItemSettings()
                    .group(ModItemGroup.WHISPERS_OF_THE_DARK).maxCount(1).maxDamage(100)));

    public static final Item STAR_DUST = registerItem("star_dust",
            new Item(new FabricItemSettings()
                    .group(ModItemGroup.WHISPERS_OF_THE_DARK).rarity(Rarity.UNCOMMON)));


    public static final Item VOIDSTAFFITEM = registerItem("void_staff",
            new VoidStaffitem(new FabricItemSettings()
                    .group(ModItemGroup.WHISPERS_OF_THE_DARK).maxCount(1).maxDamage(7000).rarity(Rarity.EPIC)));

    private static Item registerItem(String name, Item item) {
       return Registry.register(Registry.ITEM, new Identifier(WhispersOfTheDark.MOD_ID, name), item);
   }




    public static void registerModItems(){
        WhispersOfTheDark.LOGGER.info("Registering mod items for " + WhispersOfTheDark.MOD_ID);
    }

}
