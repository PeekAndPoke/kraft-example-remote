package io.peekandpoke.kraft.examples.helloworld.pages

import de.peekandpoke.kraft.components.NoProps
import de.peekandpoke.kraft.components.PureComponent
import de.peekandpoke.kraft.components.comp
import de.peekandpoke.kraft.vdom.VDom
import de.peekandpoke.ultra.semanticui.ui
import kotlinx.html.Tag
import kotlinx.html.div

@Suppress("FunctionName")
fun Tag.NotFoundPage() = comp {
    NotFoundPage(it)
}

class NotFoundPage(ctx: NoProps) : PureComponent(ctx) {

    //  STATE  //////////////////////////////////////////////////////////////////////////////////////////////////

    //  IMPL  ///////////////////////////////////////////////////////////////////////////////////////////////////

    override fun VDom.render() {

        div {
            renderBackButton()
        }

        ui.divider()

        ui.header H1 {
            +"Oops ... this page does not exist."
        }
    }
}
