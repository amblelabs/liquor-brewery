package dev.amble.liquor.common.lib;

import dev.amble.liquor.api.LiquorAPI;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static dev.amble.liquor.api.LiquorAPI.modLoc;

public class LiquorCreativeTabs {
    public static void registerCreativeTabs(BiConsumer<CreativeModeTab, ResourceLocation> r) {
        for (var e : TABS.entrySet()) {
            r.accept(e.getValue(), e.getKey());
        }
    }

    private static final Map<ResourceLocation, CreativeModeTab> TABS = new LinkedHashMap<>();

    public static final CreativeModeTab LIQUOR = register("liquor", CreativeModeTab.builder(CreativeModeTab.Row.TOP, 7)
            .icon(() -> new ItemStack(LiquorItems.YEAST)));

    private static CreativeModeTab register(String name, CreativeModeTab.Builder tabBuilder) {
        var tab = tabBuilder.title(Component.translatable("itemGroup." + LiquorAPI.MOD_ID + "." + name)).build();
        var old = TABS.put(modLoc(name), tab);

        if (old != null) {
            throw new IllegalArgumentException("Typo? Duplicate id " + name);
        }

        return tab;
    }
}