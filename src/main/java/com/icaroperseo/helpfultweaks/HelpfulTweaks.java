package com.icaroperseo.helpfultweaks;

/**
 * Created by icaroperseo on 1/03/17.
 */

import com.icaroperseo.helpfultweaks.common.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HelpfulTweaks.MODID, name = HelpfulTweaks.NAME, version = HelpfulTweaks.VERSION,
        acceptedMinecraftVersions = HelpfulTweaks.MCVERSION)
public class HelpfulTweaks {
    public static final String MODID = "helpfultweaks";
    public static final String NAME = "Helpful Tweaks";
    public static final String VERSION = "1.6.0";
    public static final String MCVERSION = "1.10.2";

    @Mod.Instance(HelpfulTweaks.MODID)
    public static HelpfulTweaks instance;

    @SidedProxy(clientSide="com.icaroperseo.helpfultweaks.client.core.proxy.ClientOnlyProxy",
            serverSide="com.icaroperseo.helpfultweaks.common.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }
}
