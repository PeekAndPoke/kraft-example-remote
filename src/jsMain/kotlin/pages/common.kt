package io.peekandpoke.kraft.examples.helloworld.pages

import de.peekandpoke.kraft.routing.href
import de.peekandpoke.ultra.semanticui.icon
import de.peekandpoke.ultra.semanticui.ui
import io.peekandpoke.kraft.examples.helloworld.routes
import kotlinx.html.FlowContent

fun FlowContent.renderBackButton() {
    ui.basic.blue.button A {
        href(routes.home())
        icon.backward()
        +"Back"
    }
}
