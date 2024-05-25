package tn.droidzed.buggymod.skeleton.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.StringArgumentType.getString
import com.mojang.brigadier.arguments.StringArgumentType.greedyString
import com.mojang.brigadier.tree.LiteralCommandNode
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.command.argument.ColorArgumentType
import net.minecraft.command.argument.ColorArgumentType.getColor
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.CommandManager.argument
import net.minecraft.server.command.CommandManager.literal
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text
import net.minecraft.util.Formatting

object BroadCastCommand : BaseCommand {

    override fun register(
        dispatcher: CommandDispatcher<ServerCommandSource?>,
        registryAccess: CommandRegistryAccess,
        environment: CommandManager.RegistrationEnvironment
    ): LiteralCommandNode<ServerCommandSource?>? =
        dispatcher.register(literal("broadcast")
            .requires { source -> source.hasPermissionLevel(2) } // Must be a game master to use the command. Command will not show up in tab completion or execute to non operators or any operator that is permission level 1.
            .then(
                argument("color", ColorArgumentType.color())
                    .then(
                        argument("message", greedyString())
                            .executes { ctx ->
                                broadcast(
                                    ctx.source,
                                    getColor(ctx, "color"),
                                    getString(ctx, "message")
                                )
                            })
            )
        ) // You can deal with the arguments out here and pipe them into the command.


    private fun broadcast(
        source: ServerCommandSource,
        formatting: Formatting?,
        message: String?
    ): Int {
        source.server.playerManager.broadcast(
            Text.literal(message).formatted(formatting),
            true
        )

        return 1// Success
    }
}