package com.icaroperseo.helpfultweaks.client.crafting.recipe;

/**
 * Created by icaroperseo on 1/03/17.
 */

import com.icaroperseo.helpfultweaks.client.core.config.ConfigHandler;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class HelpfulTweaksRecipes {
    public static void addRecipes() {

        if (ConfigHandler.enableSlimeBallRecipe) {
            addSlimeBallRecipe();
        }

        if (ConfigHandler.enableCharcoalRecipe) {
            addCharcoalRecipe();
        }

        if (ConfigHandler.enableFlintRecipe) {
            addFlintRecipe();
        }
    }

    private static void addSlimeBallRecipe() {
        ItemStack clayBall = new ItemStack(Items.CLAY_BALL);
        ItemStack sugar = new ItemStack(Items.SUGAR);
        ItemStack greenDye = new ItemStack(Items.DYE, 1, 2);

        GameRegistry.addShapelessRecipe(new ItemStack(Items.SLIME_BALL), clayBall, sugar, greenDye);
    }

    private static void addCharcoalRecipe() {
        GameRegistry.addSmelting(Blocks.SAPLING, new ItemStack(Items.COAL, 1, 1), 0.35f);
    }

    private static void addFlintRecipe() {
        GameRegistry.addSmelting(Blocks.GRAVEL, new ItemStack(Items.FLINT), 0.35f);
    }
}