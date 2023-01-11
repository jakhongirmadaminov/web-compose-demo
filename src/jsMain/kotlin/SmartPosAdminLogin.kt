import androidx.compose.runtime.*
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun smartposAdminLogin() {

    Div(attrs = {
        style {
            margin(-8.px)
        }
    }) {

        Img("logo.png", attrs = {
            style {
                alignContent(AlignContent.Start)
                paddingTop(50.px)
                paddingLeft(150.px)
            }
        }
        )
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                background("#DEDEDE")
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.Center)
                flexDirection(FlexDirection.Column)
            }
        }) {
            H1(
                attrs = {
                    style {
                        color(Color("#1D2939"))
                        fontFamily("Roboto", "Helvetica", "Arial", "sans-serif")
                        fontSize(36.px)
                        fontWeight("bold")
                    }
                }) {
                Text("Авторизация")
            }
            P(attrs = {
                style {
                    color(Color("#1D2939"))
                    fontFamily("Roboto", "Helvetica", "Arial", "sans-serif")
                    fontWeight("lighter")
                    fontSize(14.px)
                }
            }) {
                Text("Как вы хотите войти в систему?")
            }

            TabSwitch()


        }

    }

}

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun TabSwitch() {

    val selectedOne = remember { mutableStateOf(true) }

    Div(attrs = {
        style {
            borderRadius(8.px)
            display(DisplayStyle.Grid)
            background("#F9FAFB")
            alignItems(AlignItems.Center)
            padding(6.px)
            gridTemplateColumns("1fr 1fr")
        }
    }) {

        Div(attrs = {
            onClick {
                selectedOne.value = false
            }
            style {
                tabItemStyle(selectedOne.value)
            }
        }) {
            Text("По логину и паролю")
        }


        Div(attrs = {
            onClick {
                selectedOne.value = true
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
    display(DisplayStyle.Flex)
    justifyContent(JustifyContent.Center)
    if (isSelected) notSelectedTabItemStyle()
    else selectedTabItemStyle()
    paddingTop(10.px)
    paddingBottom(10.px)
    paddingLeft(22.px)
    paddingRight(22.px)
    borderRadius(8.px)
    alignItems(AlignItems.Center)
    fontSize(16.px)
    property("transition", "ease-in 0.1s")
}

fun StyleScope.selectedTabItemStyle() {
    color(Color("#1D2939"))
    fontFamily("Roboto", "Helvetica", "Arial", "sans-serif")
    fontWeight("bold")
    background("#fff")
    property("box-shadow","0px 1px 2px rgb(29 27 51 / 5%)")
}

fun StyleScope.notSelectedTabItemStyle() {
    color(Color("#667085"))
    fontFamily("Roboto", "Helvetica", "Arial", "sans-serif")
    fontWeight("lighter")
    background("00FFFFFF")
}
