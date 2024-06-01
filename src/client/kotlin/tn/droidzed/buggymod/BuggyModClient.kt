package tn.droidzed.buggymod

import eu.midnightdust.lib.config.MidnightConfig
import net.fabricmc.api.ClientModInitializer
import tn.droidzed.buggymod.core.Registrar
import tn.droidzed.buggymod.core.config.MainConfig


object BuggyModClient : ClientModInitializer {

  override fun onInitializeClient() {
    // This entrypoint is suitable for setting up client-specific logic, such as rendering.
    MidnightConfig.init("buggymod", MainConfig::class.java)
    MidnightConfig.write("buggymod")
    Registrar.register();
  }
}
