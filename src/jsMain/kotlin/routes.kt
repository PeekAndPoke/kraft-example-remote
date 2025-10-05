package io.peekandpoke.kraft.examples.helloworld

import de.peekandpoke.kraft.routing.RouterBuilder
import de.peekandpoke.kraft.routing.Static
import io.peekandpoke.kraft.examples.helloworld.pages.AgifyIoPage
import io.peekandpoke.kraft.examples.helloworld.pages.CatFactNinjaPage
import io.peekandpoke.kraft.examples.helloworld.pages.HomePage

class Routes {
    val home = Static("")
    val homeSlash = Static("/")

    val agifyIo = Static("/api/agify-io")
    val catFactNinja = Static("/api/cat-fact-ninja")
}

fun RouterBuilder.mount(routes: Routes) {
    mount(routes.home) { HomePage() }
    mount(routes.homeSlash) { HomePage() }

    mount(routes.agifyIo) { AgifyIoPage() }
    mount(routes.catFactNinja) { CatFactNinjaPage() }
}
