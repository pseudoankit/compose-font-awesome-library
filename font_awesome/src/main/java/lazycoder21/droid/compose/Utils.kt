package lazycoder21.droid.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val FaIcon.fontFamily: FontFamily
    get() {
        return when (this) {
            is FaIcon.Brand -> FontFamily(
                Font(resId = R.font.fa_brands_400)
            )
            is FaIcon.Solid -> FontFamily(
                Font(resId = R.font.fa_solid_900)
            )
            is FaIcon.Regular -> FontFamily(
                Font(resId = R.font.fa_regular_400)
            )
        }
    }

val Dp.scaleIndependentFontSize: TextUnit
    @Composable get() {
        val scaleFactor = LocalConfiguration.current.fontScale
        val materialIconOffset = 3.dp
        return ((this - materialIconOffset).value / scaleFactor).sp
    }
