package lazycoder21.droid.compose

sealed class FaIcon(val src: String) {
    data class Solid(private val icon: String) : FaIcon(icon) {
        constructor(intIcon: Int) : this(intIcon.asString)
    }

    data class Regular(private val icon: String) : FaIcon(icon) {
        constructor(intIcon: Int) : this(intIcon.asString)
    }

    data class Brand(private val icon: String) : FaIcon(icon) {
        constructor(intIcon: Int) : this(intIcon.asString)
    }

    companion object {
        private val Int.asString get() = toChar().toString()
    }
}