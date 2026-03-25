package io.peekandpoke.kraft.examples.helloworld.pages

import io.peekandpoke.kraft.components.NoProps
import io.peekandpoke.kraft.components.PureComponent
import io.peekandpoke.kraft.components.comp
import io.peekandpoke.kraft.examples.helloworld.apis.agifyio.AgifyIo
import io.peekandpoke.kraft.semanticui.forms.UiInputField
import io.peekandpoke.kraft.utils.launch
import io.peekandpoke.kraft.vdom.VDom
import io.peekandpoke.ultra.html.onClick
import io.peekandpoke.ultra.semanticui.ui
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
