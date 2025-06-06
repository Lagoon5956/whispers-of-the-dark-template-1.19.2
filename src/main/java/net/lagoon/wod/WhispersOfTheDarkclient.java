package net.lagoon.wod;

import net.fabricmc.api.ClientModInitializer;
import net.lagoon.wod.item.Moditems;
import net.lagoon.wod.item.client.AnimatedItemRenderer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class WhispersOfTheDarkclient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        GeoItemRenderer.registerItemRenderer(Moditems.VOIDSTAFFITEM, new AnimatedItemRenderer());

    }
}
