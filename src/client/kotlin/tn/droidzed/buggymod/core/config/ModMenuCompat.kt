package tn.droidzed.buggymod.core.config

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import eu.midnightdust.lib.config.MidnightConfig
import net.minecraft.client.gui.screen.Screen


class ModMenuCompat : ModMenuApi {

    override fun getModConfigScreenFactory(): ConfigScreenFactory<*> {
        return ConfigScreenFactory { parent: Screen? ->
            MidnightConfig.getScreen(
                parent,
                "buggymod"
            )
        }
    }
}