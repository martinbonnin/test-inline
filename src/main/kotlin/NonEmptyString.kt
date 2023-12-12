@JvmInline
value class NonEmptyString private constructor(val value: String) {
    companion object {
        fun create(value: String): NonEmptyString {
            return NonEmptyString(value)
        }
    }
}