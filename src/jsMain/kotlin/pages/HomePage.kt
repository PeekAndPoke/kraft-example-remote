package io.peekandpoke.kraft.examples.helloworld.pages

import de.peekandpoke.kraft.components.NoProps
import de.peekandpoke.kraft.components.PureComponent
import de.peekandpoke.kraft.components.comp
import de.peekandpoke.kraft.routing.href
import de.peekandpoke.kraft.vdom.VDom
import de.peekandpoke.ultra.semanticui.noui
import de.peekandpoke.ultra.semanticui.ui
import io.peekandpoke.kraft.examples.helloworld.routes
import kotlinx.html.Tag
import kotlinx.html.a
import kotlinx.html.p

@Suppress("FunctionName")
fun Tag.HomePage() = comp {
    HomePage(it)
}

class HomePage(ctx: NoProps) : PureComponent(ctx) {

    //  STATE  //////////////////////////////////////////////////////////////////////////////////////////////////

    //  IMPL  ///////////////////////////////////////////////////////////////////////////////////////////////////

    override fun VDom.render() {

        ui.header H2 { +"Introduction" }

        p {
            +"These demos use free apis found "
            a(href = "https://apipheny.io/free-api/#apis-without-key") { +"here" }
        }

        ui.header H2 { +"Pick an api to play with" }

        ui.link.cards {

            noui.card A {
                href(routes.agifyIo())
                noui.image {
                    ui.small.image Img {
                        src = "http://i.ytimg.com/vi/PlV_q_bpOCE/maxresdefault.jpg"
                    }
                }
                noui.content {
                    noui.header { +"agify.io" }
                    noui.meta { +"Guees age by name" }
                }
            }

            noui.card A {
                href(routes.catFactNinja())
                noui.image {
                    ui.small.image Img {
                        src =
                            "https://image.petmd.com/files/styles/article_image/public/small-kitten-walking-towards_127900829_0.jpg?VersionId=YgT1J9MSDVEG9fxmyyH0d4bcICrQx7JV&itok=UM3eyMYC"
                    }
                }
                noui.content {
                    noui.header { +"catfact.ninja" }
                    noui.meta { +"Random Cat Facts" }
                }
            }
        }
    }
}
