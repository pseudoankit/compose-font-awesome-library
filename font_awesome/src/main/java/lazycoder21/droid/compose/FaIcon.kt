package lazycoder21.droid.compose

sealed class FaIcon(val src: Int) {
    data class Solid(private val icon: Int) : FaIcon(icon)
    data class Regular(private val icon: Int) : FaIcon(icon)
    data class Brand(private val icon: Int) : FaIcon(icon)
}