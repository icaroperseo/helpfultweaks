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

        final boolean ENABLE_CHARCOAL_RECIPE_DEFAULT_VALUE = true;
        Property propEnableCharcoalRecipe = config.get(CATEGORY_NAME_SMELTING, "enableCharcoalRecipe",
                ENABLE_CHARCOAL_RECIPE_DEFAULT_VALUE, "Enables smelting saplings to charcoal.");

        final boolean ENABLE_FLINT_RECIPE_DEFAULT_VALUE = true;
        Property propEnableFlintRecipe = config.get(CATEGORY_NAME_SMELTING, "enableFlintRecipe",
                ENABLE_FLINT_RECIPE_DEFAULT_VALUE, "Enables smelting gravel to flint.");

        List<String> propOrderRecipes = new ArrayList<String>();

        propOrderRecipes.add(propEnableSlimeBallRecipe.getName());
        config.setCategoryPropertyOrder(CATEGORY_NAME_RECIPES, propOrderRecipes);

        List<String> propOrderSmelting = new ArrayList<String>();

        propOrderSmelting.add(propEnableCharcoalRecipe.getName());
        propOrderSmelting.add(propEnableFlintRecipe.getName());
        config.setCategoryPropertyOrder(CATEGORY_NAME_SMELTING, propOrderSmelting);

        /**
         * Read the configuration property values into the class's variables.
         */
        enableSlimeBallRecipe = propEnableSlimeBallRecipe.getBoolean(ENABLE_SLIME_BALL_RECIPE_DEFAULT_VALUE);
        enableCharcoalRecipe = propEnableCharcoalRecipe.getBoolean(ENABLE_CHARCOAL_RECIPE_DEFAULT_VALUE);
        enableFlintRecipe = propEnableFlintRecipe.getBoolean(ENABLE_FLINT_RECIPE_DEFAULT_VALUE);

        /**
         * write the class's variables back into the config properties and save to disk.
         *
         * This is done because some of the properties may have been assigned default values if the file was empty or
         * corrupt.
         */
        propEnableSlimeBallRecipe.set(enableSlimeBallRecipe);
        propEnableCharcoalRecipe.set(enableCharcoalRecipe);
        propEnableFlintRecipe.set(enableFlintRecipe);

        if (config.hasChanged()) {
            config.save();
        }
    }

    private static void setDefaultValuesForConfigFile () {

    }

    private static Configuration config = null;
}
