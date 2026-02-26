package dev.amble.liquor.common.lib;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.alchemy.Potion;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static dev.amble.liquor.api.LiquorAPI.modLoc;

public class LiquorPotions {
    public static void register(BiConsumer<Potion, ResourceLocation> r) {
        for (var e : POTIONS.entrySet()) {
            r.accept(e.getValue(), e.getKey());
        }
        LiquorPotions.addRecipes();
    }

    private static final Map<ResourceLocation, Potion> POTIONS = new LinkedHashMap<>();

    //

    public static void addRecipes() {
//        AccessorPotionBrewing.addMix(SHRINK_GRID, Items.REDSTONE, SHRINK_GRID_LONG);
    }

    private static <T extends Potion> T make(String id, T potion) {
        var old = POTIONS.put(modLoc(id), potion);
        if (old != null) {
            throw new IllegalArgumentException("Typo? Duplicate id " + id);
        }
        return potion;
    }
}