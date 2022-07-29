package io.peekandpoke.kraft.examples.helloworld.pages

import de.peekandpoke.kraft.semanticui.icon
import de.peekandpoke.kraft.semanticui.ui
import io.peekandpoke.kraft.examples.helloworld.routes
import kotlinx.html.FlowContent

fun FlowContent.renderBackButton() {
    ui.basic.blue.button A {
        href = routes.home()
        icon.backward()
        +"Back"
    }
}
