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

        if (ConfigHandler.enableLeatherRecipe) {
            addLeatherRecipe();
        }

        if (ConfigHandler.enableStringRecipe) {
            addStringRecipe();
        }

        if (ConfigHandler.enableWebRecipe) {
            addWebRecipe();
        }

        if (ConfigHandler.enableGlowstoneRecipe) {
            addGlowstoneRecipe();
        }

        if (ConfigHandler.enableGunpowderRecipe) {
            addGunpowderRecipe();
        }

        if (ConfigHandler.enableNetherWartRecipe) {
            addNetherWartRecipe();
        }

        if (ConfigHandler.enableNetherQuartzRecipe) {
            addNetherQuartzRecipe();
        }

        if (ConfigHandler.enablePrismarineCrystalRecipe) {
            addPrismarineCrystalRecipe();
        }

        if (ConfigHandler.enablePrismarineShardRecipe) {
            addPrismarineShardRecipe();
        }
    }

    private static void addSlimeBallRecipe() {
        ItemStack clayBall = new ItemStack(Items.CLAY_BALL);
        ItemStack sugar = new ItemStack(Items.SUGAR);
        ItemStack greenDye = new ItemStack(Items.DYE, 1, 2);    // Cactus green

        GameRegistry.addShapelessRecipe(new ItemStack(Items.SLIME_BALL), clayBall, sugar, greenDye);
    }

    private static void addCharcoalRecipe() {
        GameRegistry.addSmelting(Blocks.SAPLING, new ItemStack(Items.COAL, 1, 1), 0.35f);
    }

    private static void addFlintRecipe() {
        GameRegistry.addSmelting(Blocks.GRAVEL, new ItemStack(Items.FLINT), 0.35f);
    }

    private static void addLeatherRecipe() {
        GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.LEATHER), 0.35f);
    }

    private static void addStringRecipe() {
        ItemStack web = new ItemStack(Blocks.WEB);

        GameRegistry.addShapelessRecipe(new ItemStack(Items.STRING), web);
    }

    private static void addWebRecipe() {
        GameRegistry.addRecipe(new ItemStack(Blocks.WEB), new Object[] {
                "S.S",
                ".S.",
                "S.S",
                'S', Items.STRING
        });
    }

    private static void addGlowstoneRecipe() {
        GameRegistry.addRecipe(new ItemStack(Items.GLOWSTONE_DUST), new Object[] {
                "NYN",
                "YRY",
                "NYN",
                'N', Items.GOLD_NUGGET,
                'Y', new ItemStack(Items.DYE, 1 , 11),  // Dandelion yellow
                'R', Items.REDSTONE
        });
    }

    private static void addGunpowderRecipe() {
        GameRegistry.addRecipe(new ItemStack(Items.GUNPOWDER), new Object[] {
                "CHC",
                "SFS",
                "CHC",
                'C', Items.CLAY_BALL,
                'H', new ItemStack(Items.COAL, 1, 1),   // Charcoal
                'S', Items.SUGAR,
                'F', Items.FLINT
        });
    }

    private static void addNetherWartRecipe() {
        GameRegistry.addRecipe(new ItemStack(Items.NETHER_WART), new Object[] {
                ".B.",
                "FDF",
                ".B.",
                'B', new ItemStack(Items.DYE, 1, 15),   // Bone meal
                'F', Items.FERMENTED_SPIDER_EYE,
                'D', new ItemStack(Blocks.DEADBUSH)
        });
    }

    private static void addNetherQuartzRecipe() {
        GameRegistry.addRecipe(new ItemStack(Items.QUARTZ), new Object[] {
                "DAD",
                "BSB",
                "DAD",
                'A', new ItemStack(Blocks.STONE, 1, 5), // Andesite
                'D', new ItemStack(Blocks.STONE,1, 3),  // Diorite
                'B', new ItemStack(Items.DYE, 1, 15),   // Bone meal
                'S', Items.SUGAR

        });
    }

    private static void addPrismarineCrystalRecipe() {
        GameRegistry.addRecipe(new ItemStack(Items.PRISMARINE_CRYSTALS, 2), new Object[] {
                "LSL",
                "RGR",
                "LSL",
                'L', new ItemStack(Items.DYE, 1, 4),    // Lapis lazuli
                'S', Items.SUGAR,
                'R', Items.REDSTONE,
                'G', Items.GLOWSTONE_DUST
        });
    }

    private static void addPrismarineShardRecipe() {
        GameRegistry.addRecipe(new ItemStack(Items.PRISMARINE_SHARD, 2), new Object[] {
                "CLC",
                "QAQ",
                "CLC",
                'C', new ItemStack(Blocks.COBBLESTONE),
                'L', new ItemStack(Items.DYE, 1, 4),    // Lapis lazuli
                'Q', Items.QUARTZ,
                'A', new ItemStack(Blocks.STONE, 1, 5), // Andesite
        });
    }
}
