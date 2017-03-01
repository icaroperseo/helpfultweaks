package com.icaroperseo.helpfultweaks.client.core;

/**
 * Created by icaroperseo on 1/03/17.
 */

import com.icaroperseo.helpfultweaks.client.core.config.ConfigHandler;

public class StartupClientOnly {
    public static void preInitClientOnly() {
        ConfigHandler.preInit();
    }
}
