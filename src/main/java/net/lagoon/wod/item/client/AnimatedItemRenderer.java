package net.lagoon.wod.item.client;

import net.lagoon.wod.item.custom.VoidStaffitem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class AnimatedItemRenderer extends GeoItemRenderer<VoidStaffitem> {
    public AnimatedItemRenderer() {
        super(new AnimatedItemModel());
    }
}
