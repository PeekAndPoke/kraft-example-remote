package io.peekandpoke.kraft.examples.helloworld.pages

import io.peekandpoke.kraft.examples.helloworld.routes
import io.peekandpoke.kraft.routing.href
import io.peekandpoke.ultra.semanticui.icon
import io.peekandpoke.ultra.semanticui.ui
import kotlinx.html.FlowContent

fun FlowContent.renderBackButton() {
    ui.basic.blue.button A {
        href(routes.home())
        icon.backward()
        +"Back"
    }
}
