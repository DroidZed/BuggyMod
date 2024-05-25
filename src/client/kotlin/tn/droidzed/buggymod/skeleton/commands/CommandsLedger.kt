package tn.droidzed.buggymod.skeleton.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.tree.LiteralCommandNode
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource

object CommandsLedger : BaseCommand {

    override fun register(
        dispatcher: CommandDispatcher<ServerCommandSource?>,
        registryAccess: CommandRegistryAccess,
        environment: CommandManager.RegistrationEnvironment
    ): LiteralCommandNode<ServerCommandSource?>? =
        dispatcher.register(
            LiteralArgumentBuilder.literal<ServerCommandSource>("buggy")
                .then(
                    GreetingCommand.register(
                        dispatcher,
                        registryAccess,
                        environment
                    )
                )
                .then(
                    BroadCastCommand.register(
                        dispatcher,
                        registryAccess,
                        environment
                    )
                )
        )

}
