import androidx.compose.runtime.*
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

@Composable
fun TabSwitch() {

    var selectedOne by remember { mutableStateOf(true) }

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
            style {
                borderRadius(8.px)
                background("#F9FAFB")
                alignItems(AlignItems.Center)
                padding(6.px)
                gridTemplateColumns("1fr 1fr")
            }
        }) {
            Text("По логину и паролю")
        }


        Div(attrs = {
            style {
                if (selectedOne) selectedTabItemStyle()
                else notSelectedTabItemStyle()
                borderRadius(8.px)
                background("#F9FAFB")
                alignItems(AlignItems.Center)
                padding(6.px)
                gridTemplateColumns("1fr 1fr")
                fontSize(16.px)
            }
        }) {
            Text("По ключу ЭЦП")
        }
    }
}

@Composable
fun StyleScope.selectedTabItemStyle() {
    color(Color("#1D2939"))
    fontFamily("Roboto", "Helvetica", "Arial", "sans-serif")
    fontWeight("bold")
    background("#fff")
    Color.transparent
}

@Composable
fun StyleScope.notSelectedTabItemStyle() {
    color(Color("#667085"))
    fontFamily("Roboto", "Helvetica", "Arial", "sans-serif")
    fontWeight("lighter")
    background("00FFFFFF")

}
