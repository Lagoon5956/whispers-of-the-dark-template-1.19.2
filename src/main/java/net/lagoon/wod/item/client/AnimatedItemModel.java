package net.lagoon.wod.item.client;

import net.lagoon.wod.WhispersOfTheDark;
import net.lagoon.wod.item.custom.VoidStaffitem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedItemModel extends AnimatedGeoModel<VoidStaffitem> {
    @Override
    public Identifier getModelResource(VoidStaffitem voidStaffitem) {
        return new Identifier(WhispersOfTheDark.MOD_ID, "geo/voidstaff.geo.json");
    }

    @Override
    public Identifier getTextureResource(VoidStaffitem voidStaffitem) {
        return new Identifier(WhispersOfTheDark.MOD_ID, "textures/item/staff_texture.png");
    }

    @Override
    public Identifier getAnimationResource(VoidStaffitem voidStaffitem) {
        return new Identifier(WhispersOfTheDark.MOD_ID, "animations/voidstaffidel.animation.json");
    }
}
