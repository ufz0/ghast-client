package at.ghasty.utils;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;

public class commands {
    public static void registerCommands(){
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("foo").executes(context -> {
                context.getSource().sendFeedback(() -> Text.literal("bar"), false);
                return 1;
            }));
        });
    }
}
