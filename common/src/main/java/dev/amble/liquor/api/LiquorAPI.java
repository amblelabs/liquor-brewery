package dev.amble.liquor.api;

import com.google.common.base.Suppliers;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public interface LiquorAPI {
    String MOD_ID = "liquor";
    Logger LOGGER = LogManager.getLogger(MOD_ID);

    Supplier<LiquorAPI> INSTANCE = Suppliers.memoize(() -> {
        try {
            return (LiquorAPI) Class.forName("dev.amble.liquor.common.impl.LiquorAPIImpl")
                    .getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            LogManager.getLogger().warn("Unable to find LiquorAPIImpl, using a dummy");
            return new LiquorAPI() {
            };
        }
    });

    String DRUNKNESS_USERDATA = modLoc("drunkness").toString();

    static LiquorAPI instance() {
        return INSTANCE.get();
    }

    static ResourceLocation modLoc(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
