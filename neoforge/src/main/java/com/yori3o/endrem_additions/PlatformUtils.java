package com.yori3o.endrem_additions;

import net.neoforged.fml.ModList;

public class PlatformUtils {

    public static Boolean isModLoaded(String mod) {
        return ModList.get().isLoaded(mod);
    }
}
