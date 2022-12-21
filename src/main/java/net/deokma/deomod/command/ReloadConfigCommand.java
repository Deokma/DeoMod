package net.deokma.deomod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.deokma.deomod.DeoMod;
import net.deokma.deomod.config.ConfigManager;
import net.deokma.deomod.error.LoadConfigException;
import net.deokma.deomod.util.Messages;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

import static net.minecraft.server.command.CommandManager.literal;

public abstract class ReloadConfigCommand {
    // reload config command
    // `/fabsit reload`
    // requires node fabsit.reload or op level 2
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(literal(DeoMod.MOD_ID)
                .then(literal("reload")
                .requires(Permissions.require(DeoMod.MOD_ID + ".reload", 2))
                .executes(ReloadConfigCommand::run)));
    }

    public static int run(CommandContext<ServerCommandSource> context) {
        // attempt to reload config
        try {
            ConfigManager.loadConfig();
        } catch (LoadConfigException ignored) {
            // failure message
            context.getSource().sendError(Messages.configLoadError(context.getSource().getPlayer()));
            return -1;
        }

        // success message
        context.getSource().sendFeedback(Messages.configLoadSuccess(context.getSource().getPlayer()), false);
        return 0;
    }
}
