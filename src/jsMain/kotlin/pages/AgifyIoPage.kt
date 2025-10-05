package io.peekandpoke.kraft.examples.helloworld.pages

import de.peekandpoke.kraft.components.NoProps
import de.peekandpoke.kraft.components.PureComponent
import de.peekandpoke.kraft.components.comp
import de.peekandpoke.kraft.semanticui.forms.UiInputField
import de.peekandpoke.kraft.utils.launch
import de.peekandpoke.kraft.vdom.VDom
import de.peekandpoke.ultra.html.onClick
import de.peekandpoke.ultra.semanticui.ui
import io.peekandpoke.kraft.examples.helloworld.apis.agifyio.AgifyIo
import kotlinx.html.*

@Suppress("FunctionName")
fun Tag.AgifyIoPage() = comp {
    AgifyIoPage(it)
}

class AgifyIoPage(ctx: NoProps) : PureComponent(ctx) {

    //  STATE  //////////////////////////////////////////////////////////////////////////////////////////////////

    private val api = AgifyIo()

    private var name by value("")

    private var results: List<AgifyIo.Result> by value(emptyList())

    //  IMPL  ///////////////////////////////////////////////////////////////////////////////////////////////////

    private fun loadAge(name: String) {
        launch {
            api.apiClient.get(name).collect {
                results = listOf(it).plus(results)
            }
        }
    }

    override fun VDom.render() {

        ui.header H2 { +"AgifyIo" }

        p {
            +"Find the api docs "
            a(href = "https://agify.io") { +"here" }
        }

        ui.header H2 { +"Let's play" }

        ui.form {
            ui.two.fields {
                UiInputField(::name) {
                    placeholder("Enter a name")
                }

                ui.field {
                    ui.primary.button {
                        onClick {
                            loadAge(name)
                        }
                        +"Guess age"
                    }
                }
            }
        }

        ui.header H2 { +"Results" }

        ui.celled.striped.table Table {
            thead {
                tr {
                    th { +"Name" }
                    th { +"Age" }
                    th { +"Count" }
                }
            }
            tbody {
                results.forEach { result ->
                    tr {
                        td { +result.name }
                        td { +"${result.age}" }
                        td { +"${result.count}" }
                    }
                }
            }
        }
    }
}
