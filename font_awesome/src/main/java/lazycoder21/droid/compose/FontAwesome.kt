package lazycoder21.droid.compose

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * FaIcon composable to draw Font awesome icons
 * @param faIconType supports solid, regular and brand icons.
 * @param modifier to apply layout changes.
 * @param size Provide the Icon size in DP. Since it's a font to not change Icon size with
 * font scaling of device it ignores device font scaling.
 * @param tint By default it uses the onSurface color of the theme if not provided
 * You can provide any color you want to set tint for
 */

@Composable
fun FontAwesomeIcon(
    faIconType: FaIconType,
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    tint: Color = Color.Unspecified
) {
    val scaleFactor = LocalConfiguration.current.fontScale

    val scaleIndependentFontSize =
        scaleIndependentFontSize(sizeInDp = size, scaleFactor = scaleFactor)

    val faTextStyle =
        TextStyle(
            color = tint,
            fontFamily = getFontFamily(faIconType),
            fontSize = scaleIndependentFontSize
        )

    BasicText(
        text = faIconType.src.codePointToString(),
        modifier = modifier,
        style = faTextStyle,
    )
}

private fun getFontFamily(faIconType: FaIconType): FontFamily {
    return when (faIconType) {
        is FaIconType.Brand -> FontFamily(
            Font(resId = R.font.fa_brands_400)
        )
        is FaIconType.Solid -> FontFamily(
            Font(resId = R.font.fa_solid_900)
        )
        is FaIconType.Regular -> FontFamily(
            Font(resId = R.font.fa_regular_400)
        )
    }
}

private fun scaleIndependentFontSize(sizeInDp: Dp, scaleFactor: Float): TextUnit {
    val materialIconOffset = 3.dp
    return ((sizeInDp - materialIconOffset).value  / scaleFactor).sp
}

private fun Int.codePointToString() = this.toChar().toString()




