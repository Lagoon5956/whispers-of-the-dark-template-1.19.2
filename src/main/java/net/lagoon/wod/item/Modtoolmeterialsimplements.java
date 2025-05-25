package net.lagoon.wod.item;

import net.fabricmc.yarn.constants.MiningLevels;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum Modtoolmeterialsimplements implements ToolMaterial {

    INFUSED_AMETHYST(MiningLevels.WOOD, 132, 0.5F, 2.5F, 22,
            () -> Ingredient.ofItems(Moditems.INFUSED_AMETHYST)),
    INFUSED_STAR(MiningLevels.DIAMOND, 4000, 1,1.5F,15,
            () -> Ingredient.ofItems(Moditems.INFUSED_STAR));


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private Modtoolmeterialsimplements(int miningLevel, int itemDurability, float miningSpeed, float attackDamage,
                                       int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

