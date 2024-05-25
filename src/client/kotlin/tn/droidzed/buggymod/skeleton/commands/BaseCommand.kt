package tn.droidzed.buggymod.skeleton.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.tree.LiteralCommandNode
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource

fun interface BaseCommand {
    fun register(
        dispatcher: CommandDispatcher<ServerCommandSource?>,
        registryAccess: CommandRegistryAccess,
        environment: CommandManager.RegistrationEnvironment
    ): LiteralCommandNode<ServerCommandSource?>?
}
