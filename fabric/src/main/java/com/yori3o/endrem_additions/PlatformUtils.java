package com.yori3o.endrem_additions;

import net.fabricmc.loader.api.FabricLoader;

public class PlatformUtils {

    public static Boolean isModLoaded(String mod) {
        return FabricLoader.getInstance().isModLoaded(mod);
    }
}
