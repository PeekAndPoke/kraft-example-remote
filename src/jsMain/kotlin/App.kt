package io.peekandpoke.kraft.examples.helloworld

import io.peekandpoke.kraft.components.NoProps
import io.peekandpoke.kraft.components.PureComponent
import io.peekandpoke.kraft.components.comp
import io.peekandpoke.kraft.routing.RouterComponent
import io.peekandpoke.kraft.vdom.VDom
import io.peekandpoke.ultra.semanticui.noui
import io.peekandpoke.ultra.semanticui.ui
import kotlinx.html.Tag

@Suppress("FunctionName")
fun Tag.App() = comp {
    App(it)
}

class App(ctx: NoProps) : PureComponent(ctx) {

    //  STATE  //////////////////////////////////////////////////////////////////////////////////////////////////

    //  IMPL  ///////////////////////////////////////////////////////////////////////////////////////////////////

    override fun VDom.render() {
        ui.container {
            ui.basic.segment {
                ui.header H1 { +"KRAFT Remote Apis Demo" }

                noui.content {
                    RouterComponent()
                }
            }
        }
    }
}
