package io.peekandpoke.kraft.examples.helloworld.pages

import de.peekandpoke.kraft.components.NoProps
import de.peekandpoke.kraft.components.PureComponent
import de.peekandpoke.kraft.components.comp
import de.peekandpoke.kraft.utils.launch
import de.peekandpoke.kraft.vdom.VDom
import de.peekandpoke.ultra.html.onClick
import de.peekandpoke.ultra.semanticui.noui
import de.peekandpoke.ultra.semanticui.ui
import io.peekandpoke.kraft.examples.helloworld.apis.catfactninja.CatFactNinja
import kotlinx.html.Tag
import kotlinx.html.a
import kotlinx.html.p

@Suppress("FunctionName")
fun Tag.CatFactNinjaPage() = comp {
    CatFactNinjaPage(it)
}

class CatFactNinjaPage(ctx: NoProps) : PureComponent(ctx) {

    //  STATE  //////////////////////////////////////////////////////////////////////////////////////////////////

    private val api = CatFactNinja()

    private var facts: List<CatFactNinja.Fact> by value(emptyList())

    //  IMPL  ///////////////////////////////////////////////////////////////////////////////////////////////////

    private fun loadFact() {
        launch {
            api.apiClient.getFact().collect {
                facts = listOf(it).plus(facts)
            }
        }
    }

    private fun loadManyFacts(num: Int) {
        launch {
            api.apiClient.getFacts(num).collect {
                facts = it.data.plus(facts)
            }
        }
    }

    override fun VDom.render() {

        ui.header H2 { +"Cat Fact Ninja" }

        p {
            +"Find the api docs "
            a(href = "https://catfact.ninja/") { +"here" }
        }

        ui.header H2 { +"Let's play" }

        ui.buttons {
            ui.button {
                onClick { loadFact() }
                +"Get one fact"
            }
            ui.button {
                onClick { loadManyFacts(5) }
                +"Get 5 facts"
            }
        }

        ui.header H2 { +"Facts" }

        ui.divided.very.relaxed.list {
            facts.forEach { fact ->
                noui.item {
                    +fact.fact
                }
            }
        }
    }
}
