package io.peekandpoke.kraft.examples.helloworld

import io.peekandpoke.kraft.examples.helloworld.pages.NotFoundPage
import io.peekandpoke.kraft.kraftApp
import io.peekandpoke.kraft.semanticui.semanticUI
import io.peekandpoke.kraft.vdom.preact.PreactVDomEngine

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
