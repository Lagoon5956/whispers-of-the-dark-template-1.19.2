package net.lagoon.wod.item.custom;

import net.lagoon.wod.item.Moditems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.server.world.ServerWorld;

public class TheVoiditem extends Item {
    public TheVoiditem(Settings settings) {
        super(settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }
    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        return stack.getMaxDamage() > 0;
    }
    @Override
    public int getItemBarStep(ItemStack stack) {
        return Math.round(13.0F - ((float) stack.getDamage() * 13.0F / stack.getMaxDamage()));
    }

    @Override
    public int getItemBarColor(ItemStack stack) {
        return 0x5500AA;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getWorld().isClient()) {
            ServerWorld world = (ServerWorld) user.getWorld();

            if (isPassiveOverworldMob(entity)) {
                entity.kill();

                if (stack.getDamage() > 0) {
                    stack.setDamage(stack.getDamage() - 1);
                }

                user.getItemCooldownManager().set(stack.getItem(), 20);
                entity.playSound(SoundEvents.BLOCK_PORTAL_TRIGGER, 0.3F, 1.0F);

                world.spawnParticles(ParticleTypes.PORTAL,
                        entity.getX(), entity.getY() + 1.0, entity.getZ(),
                        20, 0.5, 0.5, 0.5, 0.1);

                world.spawnParticles(ParticleTypes.LARGE_SMOKE,
                        entity.getX(), entity.getY() + 1.0, entity.getZ(),
                        10, 0.3, 0.3, 0.3, 0.05);

            } else {
                if (stack.getDamage() + 5 >= stack.getMaxDamage()) {
                    user.sendToolBreakStatus(hand);
                    user.setStackInHand(hand, new ItemStack(Moditems.VOID_SHARDS));
                    Explode(user);
                } else {
                    stack.damage(5, user, p -> p.sendToolBreakStatus(hand));
                }
                user.sendMessage(Text.translatable("message.void_item.bringin"), true);
            }
        }

        return ActionResult.SUCCESS;
    }
    private static void Explode(PlayerEntity player) {
        ServerWorld world = (ServerWorld) player.getWorld();
        player.sendMessage(Text.translatable("message.void_item.failed"), true); // false = no overlay, feels more serious

        world.createExplosion(player, player.getX(), player.getY(), player.getZ(), 5.0F, Explosion.DestructionType.DESTROY);


        world.spawnParticles(ParticleTypes.PORTAL,
                player.getX(), player.getY() + 1.0, player.getZ(),
                50, 1.0, 1.0, 1.0, 0.2);

        world.spawnParticles(ParticleTypes.LARGE_SMOKE,
                player.getX(), player.getY() + 1.0, player.getZ(),
                30, 0.7, 0.7, 0.7, 0.1);
    }



    private boolean isPassiveOverworldMob(Entity entity) {
        return entity instanceof CowEntity ||
                entity instanceof SheepEntity ||
                entity instanceof PigEntity ||
                entity instanceof ChickenEntity ||
                entity instanceof VillagerEntity ||
                entity instanceof RabbitEntity ||
                entity instanceof HorseEntity ||
                entity instanceof DonkeyEntity ||
                entity instanceof MuleEntity ||
                entity instanceof LlamaEntity ||
                entity instanceof CatEntity ||
                entity instanceof MooshroomEntity ||
                entity instanceof FoxEntity ||
                entity instanceof ParrotEntity;
    }
}
