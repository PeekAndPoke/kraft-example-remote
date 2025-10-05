package io.peekandpoke.kraft.examples.helloworld

import de.peekandpoke.kraft.kraftApp
import de.peekandpoke.kraft.semanticui.semanticUI
import de.peekandpoke.kraft.vdom.preact.PreactVDomEngine
import io.peekandpoke.kraft.examples.helloworld.pages.NotFoundPage

val routes = Routes()

val kraft = kraftApp {
    semanticUI { }

    routing {
        mount(routes)
        catchAll { NotFoundPage() }
    }
}

fun main() {
    kraft.mount(selector = "#spa", engine = PreactVDomEngine()) {
        App()
    }
}
