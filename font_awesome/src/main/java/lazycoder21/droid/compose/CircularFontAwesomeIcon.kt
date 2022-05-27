package lazycoder21.droid.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircularFontAwesomeIcon(
    modifier: Modifier = Modifier,
    icon: FaIcon,
    size: Dp = 22.dp,
    tint: Color = Color.Unspecified,
    textStyle: TextStyle = TextStyle.Default,
    padding: Dp = 5.dp,
    strokeWidth: Dp = 1.dp,
    strokeColor: Color = Color(0xFFA39696),
    backgroundColor: Color = Color.Transparent,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: (() -> Unit)? = null,
) {

    val scaleFactor = LocalConfiguration.current.fontScale
    val fontSize = size.scaleIndependentFontSize

    val faTextStyle = textStyle.copy(
        color = tint,
        fontFamily = icon.fontFamily,
        fontSize = fontSize
    )

    BasicText(
        text = icon.icon,
        modifier = modifier
            .wrapContentWidth()
            .clip(CircleShape)
            .border(
                width = strokeWidth,
                color = strokeColor,
                shape = CircleShape
            )
            .background(color = backgroundColor)
            .clickable(enabled, onClickLabel, role) { onClick?.invoke() }
            .padding(padding),
        style = faTextStyle,
    )
}