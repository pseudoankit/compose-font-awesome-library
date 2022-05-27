package lazycoder21.droid.compose

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * FaIcon composable to draw Font awesome icons
 * @param faIcon supports solid, regular and brand icons.
 * @param modifier to apply layout changes.
 * @param size Provide the Icon size in DP. Since it's a font to not change Icon size with
 * font scaling of device it ignores device font scaling.
 * @param tint By default it uses the onSurface color of the theme if not provided
 * You can provide any color you want to set tint for
 */

@Composable
fun FontAwesomeIcon(
    faIcon: FaIcon,
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    tint: Color = Color.Unspecified,
    textStyle: TextStyle = TextStyle.Default
) {

    val fontSize = size.scaleIndependentFontSize

    val faTextStyle = textStyle.copy(
        color = tint,
        fontFamily = faIcon.fontFamily,
        fontSize = fontSize
    )

    BasicText(
        text = faIcon.icon,
        modifier = modifier,
        style = faTextStyle,
    )
}