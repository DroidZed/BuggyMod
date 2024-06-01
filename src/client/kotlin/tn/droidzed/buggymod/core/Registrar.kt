package tn.droidzed.buggymod.core

import com.mojang.brigadier.CommandDispatcher
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource
import tn.droidzed.buggymod.skeleton.commands.CommandsLedger

object Registrar {

    fun register() {
        CommandRegistrationCallback.EVENT.register(::commands)
    }


    private fun commands(
        dispatcher: CommandDispatcher<ServerCommandSource?>,
        registryAccess: CommandRegistryAccess,
        environment: CommandManager.RegistrationEnvironment
    ) {
        CommandsLedger.register(dispatcher, registryAccess, environment)
    }
}