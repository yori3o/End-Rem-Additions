package com.yori3o.endrem_additions.mixin;

import com.teamremastered.endrem.item.JsonEye;
import com.teamremastered.endrem.util.FileUtils;
import com.yori3o.endrem_additions.PlatformUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(JsonEye.class)
public class JsonEyeMixin {

    @Inject(method = "load()Ljava/util/ArrayList;", at = @At("RETURN"), remap = false)
    private static void onLoadReturn(CallbackInfoReturnable<ArrayList<JsonEye>> cir) throws FileNotFoundException {
        ArrayList<JsonEye> eyes = cir.getReturnValue();

        JsonEye fishingEye = new JsonEye("fishing_eye", "uncommon", "endrem:gameplay/fishing/fish", FileUtils.createStringArrayList("minecraft:gameplay/fishing/fish"));
        JsonEye potatoEye = new JsonEye("potato_eye", "uncommon", "endrem:blocks/potato_eye", FileUtils.createStringArrayList("minecraft:blocks/potatoes"));
        JsonEye trialEye = new JsonEye("trial_eye", "rare", "endrem:trial_chamber/trial_eye", FileUtils.createStringArrayList("minecraft:chests/trial_chambers/reward_ominous_rare"));
        JsonEye sculkEye = new JsonEye("sculk_eye", "uncommon", "endrem:chests/sculk_eye", FileUtils.createStringArrayList("minecraft:chests/ancient_city"));
        
        eyes.add(fishingEye);
        eyes.add(potatoEye);
        eyes.add(trialEye);
        eyes.add(sculkEye);
        
        if (PlatformUtils.isModLoaded("aether")) {
            JsonEye aetherEye = new JsonEye("aether_eye", "uncommon", "endrem:aether/aether_eye", FileUtils.createStringArrayList("aether:chests/ruined_portal"));
            eyes.add(aetherEye);
        }
        if (PlatformUtils.isModLoaded("bosses_of_mass_destruction")) {
            JsonEye blossomEye = new JsonEye("blossom_eye", "rare", "endrem:bosses_of_mass_destruction/void_blossom", FileUtils.createStringArrayList("bosses_of_mass_destruction:entities/void_blossom"));
            eyes.add(blossomEye);
        }

    }
}
