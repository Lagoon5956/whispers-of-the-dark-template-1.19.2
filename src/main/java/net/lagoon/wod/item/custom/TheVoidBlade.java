package net.lagoon.wod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class TheVoidBlade extends SwordItem {

    public TheVoidBlade(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }



    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {



        }





        return super.use(world, user, hand);
    }

    private void outputRandom(PlayerEntity player) {
        player.sendMessage(Text.literal("your num is " + getRandomNumber()));
    }


    private int getRandomNumber() {
        return Random.createLocal().nextInt(11);
    }

}
