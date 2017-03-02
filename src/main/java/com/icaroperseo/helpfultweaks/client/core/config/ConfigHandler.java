package com.icaroperseo.helpfultweaks.client.core.config;

/**
 * Created by icaroperseo on 1/03/17.
 */

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ConfigHandler {
    public static boolean enableCharcoalRecipe;
    public static boolean enableFlintRecipe;
    public static boolean enableSlimeBallRecipe;
    public static boolean enableLeatherRecipe;
    public static boolean enableStringRecipe;
    public static boolean enableWebRecipe;
    public static boolean enableGlowstoneRecipe;
    public static boolean enableGunpowderRecipe;

    public static final String CATEGORY_NAME_RECIPES = "Recipes";
    public static final String CATEGORY_NAME_SMELTING = "Smelting";

    public static void preInit() {
        File configFile = new File(Loader.instance().getConfigDir(), "helpfultweaks.cfg");

        config = new Configuration(configFile);

        loadConfigFromFile();
    }

    private static void loadConfigFromFile() {
        /**
         * Load raw values from config file.
         */
        config.load();

        /**
         * Define the properties in the configuration file.
         */
        final boolean ENABLE_SLIME_BALL_RECIPE_DEFAULT_VALUE = true;
        Property propEnableSlimeBallRecipe = config.get(CATEGORY_NAME_RECIPES, "enableSlimeBallRecipe",
                ENABLE_SLIME_BALL_RECIPE_DEFAULT_VALUE, "Enables crafting slime balls recipe.");

        final boolean ENABLE_STRING_RECIPE_DEFAULT_VALUE = true;
        Property propEnableStringRecipe = config.get(CATEGORY_NAME_RECIPES, "enableStringRecipe",
                ENABLE_STRING_RECIPE_DEFAULT_VALUE, "Enables crafting web to string.");

        final boolean ENABLE_WEB_RECIPE_DEFAULT_VALUE = true;
        Property propEnableWebRecipe = config.get(CATEGORY_NAME_RECIPES, "enableWebRecipe",
                ENABLE_WEB_RECIPE_DEFAULT_VALUE, "Enables crafting string to web.");

        final boolean ENABLE_CHARCOAL_RECIPE_DEFAULT_VALUE = true;
        Property propEnableCharcoalRecipe = config.get(CATEGORY_NAME_SMELTING, "enableCharcoalRecipe",
                ENABLE_CHARCOAL_RECIPE_DEFAULT_VALUE, "Enables smelting saplings to charcoal.");

        final boolean ENABLE_FLINT_RECIPE_DEFAULT_VALUE = true;
        Property propEnableFlintRecipe = config.get(CATEGORY_NAME_SMELTING, "enableFlintRecipe",
                ENABLE_FLINT_RECIPE_DEFAULT_VALUE, "Enables smelting gravel to flint.");

        final boolean ENABLE_LEATHER_RECIPE_DEFAULT_VALUE = true;
        Property propEnableLeatherRecipe = config.get(CATEGORY_NAME_SMELTING, "enableLeatherRecipe",
                ENABLE_LEATHER_RECIPE_DEFAULT_VALUE, "Enables smelting rotten flesh to leather.");

        final boolean ENABLE_GLOWSTONE_RECIPE_DEFAULT_VALUE = true;
        Property propEnableGlowstoneRecipe = config.get(CATEGORY_NAME_RECIPES, "enableGlowstoneRecipe",
                ENABLE_GLOWSTONE_RECIPE_DEFAULT_VALUE, "Enables glowstone recipe.");

        final boolean ENABLE_GUNPOWDER_RECIPE_DEFAULT_VALUE = true;
        Property propEnableGunpowderRecipe = config.get(CATEGORY_NAME_RECIPES, "enableGunpowderRecipe",
                ENABLE_GUNPOWDER_RECIPE_DEFAULT_VALUE, "Enables gunpowder recipe.");

        List<String> propOrderRecipes = new ArrayList<String>();

        propOrderRecipes.add(propEnableSlimeBallRecipe.getName());
        propOrderRecipes.add(propEnableStringRecipe.getName());
        propOrderRecipes.add(propEnableWebRecipe.getName());
        propOrderRecipes.add(propEnableGlowstoneRecipe.getName());
        propOrderRecipes.add(propEnableGunpowderRecipe.getName());
        config.setCategoryPropertyOrder(CATEGORY_NAME_RECIPES, propOrderRecipes);

        List<String> propOrderSmelting = new ArrayList<String>();

        propOrderSmelting.add(propEnableCharcoalRecipe.getName());
        propOrderSmelting.add(propEnableFlintRecipe.getName());
        propOrderSmelting.add(propEnableLeatherRecipe.getName());
        config.setCategoryPropertyOrder(CATEGORY_NAME_SMELTING, propOrderSmelting);

        /**
         * Read the configuration property values into the class's variables.
         */
        enableSlimeBallRecipe = propEnableSlimeBallRecipe.getBoolean(ENABLE_SLIME_BALL_RECIPE_DEFAULT_VALUE);
        enableStringRecipe = propEnableStringRecipe.getBoolean(ENABLE_STRING_RECIPE_DEFAULT_VALUE);
        enableCharcoalRecipe = propEnableCharcoalRecipe.getBoolean(ENABLE_CHARCOAL_RECIPE_DEFAULT_VALUE);
        enableFlintRecipe = propEnableFlintRecipe.getBoolean(ENABLE_FLINT_RECIPE_DEFAULT_VALUE);
        enableLeatherRecipe = propEnableLeatherRecipe.getBoolean(ENABLE_LEATHER_RECIPE_DEFAULT_VALUE);
        enableWebRecipe = propEnableWebRecipe.getBoolean(ENABLE_WEB_RECIPE_DEFAULT_VALUE);
        enableGlowstoneRecipe = propEnableGlowstoneRecipe.getBoolean(ENABLE_GLOWSTONE_RECIPE_DEFAULT_VALUE);
        enableGunpowderRecipe = propEnableGunpowderRecipe.getBoolean(ENABLE_GUNPOWDER_RECIPE_DEFAULT_VALUE);

        /**
         * Write the class's variables back into the config properties and save to disk.
         *
         * This is done because some of the properties may have been assigned default values if the file was empty or
         * corrupt.
         */
        propEnableSlimeBallRecipe.set(enableSlimeBallRecipe);
        propEnableStringRecipe.set(enableStringRecipe);
        propEnableCharcoalRecipe.set(enableCharcoalRecipe);
        propEnableFlintRecipe.set(enableFlintRecipe);
        propEnableLeatherRecipe.set(enableLeatherRecipe);
        propEnableWebRecipe.set(enableWebRecipe);
        propEnableGlowstoneRecipe.set(enableGlowstoneRecipe);
        propEnableGunpowderRecipe.set(enableGunpowderRecipe);

        if (config.hasChanged()) {
            config.save();
        }
    }

    private static Configuration config = null;
}
