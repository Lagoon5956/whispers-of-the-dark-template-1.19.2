package net.lagoon.wod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class TheVoiditem extends Item {
    public TheVoiditem(Settings settings) {
        super(settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient() && hand == Hand.MAIN_HAND) {
            // output ran num
            outputRandomNumber(user);
            // add a cooldown
            user.getItemCooldownManager().set(this, 20);



        }

        return super.use(world, user, hand);
    }
    private void outputRandomNumber(PlayerEntity player) {
        player.sendMessage(Text.literal("Your number is " + getRandomNumber()));
    }

    private int getRandomNumber() {
        return Random.createLocal().nextInt(10);
    }
}
