package com.icaroperseo.helpfultweaks.client.core.proxy;

/**
 * Created by icaroperseo on 1/03/17.
 */

import com.icaroperseo.helpfultweaks.common.proxy.CommonProxy;
import com.icaroperseo.helpfultweaks.client.core.StartupClientOnly;
import com.icaroperseo.helpfultweaks.client.crafting.recipe.HelpfulTweaksRecipes;

public class ClientOnlyProxy extends CommonProxy {
    public void preInit() {
        super.preInit();

        StartupClientOnly.preInitClientOnly();
    }

    public void init() {
        super.init();

        HelpfulTweaksRecipes.addRecipes();
    }
}
