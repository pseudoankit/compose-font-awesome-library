package lazycoder21.droid.compose

sealed class FaIconType(val src: Int) {
    data class Solid(private val icon: Int) : FaIconType(icon)
    data class Regular(private val icon: Int) : FaIconType(icon)
    data class Brand(private val icon: Int) : FaIconType(icon)
}