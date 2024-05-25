package tn.droidzed.buggymod

import net.fabricmc.api.ClientModInitializer
import tn.droidzed.buggymod.core.Registrar


object BuggyModClient : ClientModInitializer {

  override fun onInitializeClient() {
    // This entrypoint is suitable for setting up client-specific logic, such as rendering.

    Registrar.register();
  }
}
