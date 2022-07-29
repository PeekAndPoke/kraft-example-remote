package io.peekandpoke.kraft.examples.helloworld

import de.peekandpoke.kraft.addons.routing.*
import io.peekandpoke.kraft.examples.helloworld.pages.*

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
