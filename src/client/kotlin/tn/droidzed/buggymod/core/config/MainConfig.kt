package tn.droidzed.buggymod.core.config

import eu.midnightdust.lib.config.MidnightConfig
import com.google.common.collect.Lists;
import java.util.ArrayList


class MainConfig : MidnightConfig() {

    @Comment(category = "text")
    var text1: Comment? =
        null // Comments are rendered like an option without a button and are excluded from the config file

    @Comment(category = "text", centered = true)
    var text2: Comment? =
        null // Centered comments are the same as normal ones - just centered!

    @Comment(category = "text")
    var spacer1: Comment? =
        null // Comments containing the word "spacer" will just appear as a blank line

    @Entry(category = "text")
    var showInfo: Boolean = true // Example for a boolean option

    @Entry(category = "text")
    var name: String =
        "Hello World!" // Example for a string option, which is in a category!

    @Entry(category = "text")
    var testEnum: TestEnum = TestEnum.FABRIC // Example for an enum option

    enum class TestEnum {
        // Enums allow the user to cycle through predefined options
        QUILT, FABRIC, FORGE
    }

    @Entry(category = "numbers")
    var fabric: Int = 16777215 // Example for an int option

    @Entry(category = "numbers")
    var world: Double = 1.4 // Example for a double option

    @Entry(category = "numbers", min = 69.0, max = 420.0)
    var hello: Int =
        420 // - The entered number has to be larger than 69 and smaller than 420

    @Entry(
        category = "text",
        width = 7,
        min = 7.0,
        isColor = true,
        name = "I am a color!"
    )
    var titleColor: String =
        "#ffffff" // The isColor property adds a preview box for a hexadecimal color

//    @Entry(category = "text", name = "I am an array list!")
//    var items: ArrayList<String> = Lists.newArrayList(
//        "String1",
//        "String2"
//    ) // Array String Lists are also supported

    @Entry(
        category = "sliders",
        name = "I am an int slider.",
        isSlider = true,
        min = 0.0,
        max = 100.0
    )
    var intSlider: Int = 35 // Int fields can also be displayed as a Slider

    @Entry(
        category = "sliders",
        name = "I am a float slider!",
        isSlider = true,
        min = 0.0,
        max = 1.0,
        precision = 1000
    )
    var floatSlider: Float =
        0.24f // And so can floats! Precision defines the amount of decimal places


    // The name field can be used to specify a custom translation string or plain text

    var imposter: Int =
        16777215 // - Entries without an @Entry or @Comment annotation are ignored
}
