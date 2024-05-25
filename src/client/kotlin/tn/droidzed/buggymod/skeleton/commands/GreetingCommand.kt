package tn.droidzed.buggymod.skeleton.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.tree.LiteralCommandNode
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.CommandManager.literal
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text

object GreetingCommand : BaseCommand {

    override fun register(
        dispatcher: CommandDispatcher<ServerCommandSource?>,
        registryAccess: CommandRegistryAccess,
        environment: CommandManager.RegistrationEnvironment
    ): LiteralCommandNode<ServerCommandSource?>? =
        dispatcher.register(
            literal("hello")
                .executes { context: CommandContext<ServerCommandSource> ->
                    context.source.sendFeedback(
                        {
                            Text.literal(
                                "world !"
                            )
                        },
                        false
                    )
                    1
                }
        )

}
