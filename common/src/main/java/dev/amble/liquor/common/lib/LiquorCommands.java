package dev.amble.liquor.common.lib;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class LiquorCommands {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        var mainCmd = Commands.literal("liquor");

        // CommandImpl.add(mainCmd)

        dispatcher.register(mainCmd);
    }
}