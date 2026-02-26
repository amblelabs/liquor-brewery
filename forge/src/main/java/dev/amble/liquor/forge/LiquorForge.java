package dev.amble.liquor.forge;

import dev.amble.liquor.api.LiquorAPI;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LiquorAPI.MOD_ID)
public final class LiquorForge {

    public LiquorForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(LiquorAPI.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
    }
}
