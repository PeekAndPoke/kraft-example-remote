package io.peekandpoke.kraft.examples.helloworld

import de.peekandpoke.kraft.addons.routing.RouterComponent
import de.peekandpoke.kraft.components.NoProps
import de.peekandpoke.kraft.components.PureComponent
import de.peekandpoke.kraft.components.comp
import de.peekandpoke.kraft.semanticui.noui
import de.peekandpoke.kraft.semanticui.ui
import de.peekandpoke.kraft.vdom.VDom
import kotlinx.html.Tag

@Suppress("FunctionName")
fun Tag.App() = comp {
    App(it)
}

class App(ctx: NoProps) : PureComponent(ctx) {

    //  STATE  //////////////////////////////////////////////////////////////////////////////////////////////////

    @Suppress("unused")
    private val activeRoute by subscribingTo(router.current)

    //  IMPL  ///////////////////////////////////////////////////////////////////////////////////////////////////

    override fun VDom.render() {
        ui.container {
            ui.basic.segment {
                ui.header H1 { +"KRAFT Remote Apis Demo" }

                noui.content {
                    RouterComponent(router = router)
                }
            }
        }
    }
}
