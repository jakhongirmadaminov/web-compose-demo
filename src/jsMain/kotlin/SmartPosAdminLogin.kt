import androidx.compose.runtime.*
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Block
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Flex
import org.jetbrains.compose.web.dom.*

@Composable
fun smartposAdminLogin() {
    Div(attrs = {
        style {
            margin(-8.px)
            property("font-family", "Arial, Helvetica, sans-serif")
        }
    }) {

        Img("logo.png", attrs = {
            style {
                alignContent(AlignContent.Start)
                paddingTop(50.px)
                paddingLeft(150.px)
            }
        })
        Div(attrs = {
            style {
                display(Flex)
                background("#h4h4h4")
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.Center)
                flexDirection(FlexDirection.Column)
            }
        }) {
            Div(attrs = {
                style {
                    display(Flex)
                    background("#DEDEDE")
                    alignItems(AlignItems.Center)
                    justifyContent(JustifyContent.Center)
                    flexDirection(FlexDirection.Column)
                }
            }) {
                LoginTitle()
                LoginSubtitle()

                val selectedOne = remember { mutableStateOf(true) }
                TabSwitch(selectedOne)
                Form(attrs = {
                    style {
                        display(Flex)
                        justifyContent(JustifyContent.SpaceBetween)
                        flexDirection(FlexDirection.Column)
                        if (selectedOne.value) {
                            minHeight(350.px)
                        }
                    }
                }) {
                    if (selectedOne.value) {
                        WithLoginPass()
                    }
                }
            }
        }
    }

}

@Composable
fun WithLoginPass() {
    Div(attrs = {
        style {
            background("#ufufuf")
            display(Block)
            property("vertical-align", "top")
            fontSize(14.px)
            width(100.percent)
            maxWidth(100.percent)
            textAlign("left")
            position(Position.Relative)
            paddingBottom(8.px)
        }
    }) {
        Label {
            Text("Номер телефона")
        }

        val phoneInput = remember { mutableStateOf("+998 __ ___ __ __") }

        Input(type = InputType.Text) {
            style {
                border(width = 1.px, LineStyle.Solid, Color("#D0D5DD"))
            }
            defaultValue("+998 __ ___ __ __") // optional
            onInput { event -> println(event.value) }
        }
    }
}

@Composable
private fun LoginSubtitle() {
    P(attrs = {
        style {
            color(Color("#1D2939"))
            fontFamily("Roboto", "Helvetica", "Arial", "sans-serif")
            fontWeight("lighter")
            fontSize(14.px)
            display(Flex)
            justifyContent(JustifyContent.Center)
        }
    }) {
        Text("Как вы хотите войти в систему?")
    }
}

@Composable
private fun LoginTitle() {
    H1(
        attrs = {
            style {
                color(Color("#1D2939"))
                fontFamily("Roboto", "Helvetica", "Arial", "sans-serif")
                fontSize(36.px)
                fontWeight(800)
                textAlign("center")
            }
        }) {
        Text("Авторизация")
    }
}

@Composable
fun TabSwitch(selectedOne: MutableState<Boolean>) {

    Div(attrs = {
        style {
            gap(6.px)
            borderRadius(8.px)
            display(DisplayStyle.Grid)
            background("#F9FAFB")
            padding(6.px)
            gridTemplateColumns("1fr 1fr")
        }
    }) {

        Div(attrs = {
            onClick {
                selectedOne.value = true
            }
            style {
                tabItemStyle(selectedOne.value)
            }

        }) {
            Text("По логину и паролю")
        }


        Div(attrs = {
            onClick {
                selectedOne.value = false
            }
            style {
                tabItemStyle(!selectedOne.value)
            }
        }) {
            Text("По ключу ЭЦП")
        }
    }
}

fun StyleScope.tabItemStyle(isSelected: Boolean) {
    display(Flex)
    justifyContent(JustifyContent.Center)
    if (isSelected) selectedTabItemStyle()
    else notSelectedTabItemStyle()
    fontFamily("Roboto", "Helvetica", "Arial", "sans-serif")
    paddingTop(10.px)
    paddingBottom(10.px)
    paddingLeft(22.px)
    paddingRight(22.px)
    borderRadius(8.px)
    alignItems(AlignItems.Center)
    fontSize(16.px)
    cursor("pointer")
    property("transition", "ease-in 0.1s")
}

fun StyleScope.selectedTabItemStyle() {
    color(Color("#1D2939"))
    fontWeight(600)
    background("#ffffff")
    property("box-shadow", "0px 1px 2px rgb(29 27 51 / 5%)")
}

fun StyleScope.notSelectedTabItemStyle() {
    color(Color("#667085"))
    background("00FFFFFF")
}
