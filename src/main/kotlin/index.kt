package io.peekandpoke.kraft.examples.helloworld

import de.peekandpoke.kraft.Kraft
import de.peekandpoke.kraft.addons.routing.router
import de.peekandpoke.kraft.vdom.preact.PreactVDomEngine
import io.peekandpoke.kraft.examples.helloworld.pages.NotFoundPage
import kotlinx.browser.document
import org.w3c.dom.HTMLElement

val routes = Routes()
val router = router {
    mount(routes)

    catchAll { NotFoundPage() }
}

fun main() {
    Kraft.initialize()

    // Get the DOM-Element into which the app should be mounted
    val mountPoint = document.getElementById("spa") as HTMLElement

    // Initialize the VDOM-engine (in this case Preact) and render some content
    PreactVDomEngine(mountPoint) {
        App()
    }

    // Tell the router to resolve the current route on app start.
    router.navigateToWindowUri()
}
