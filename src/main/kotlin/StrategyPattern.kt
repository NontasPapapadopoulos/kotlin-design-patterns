package org.example



typealias Validator = (String) -> Boolean

val emailValidator: Validator = { it.contains("@") && it.contains(".")}
val usernameValidator: Validator = { it.isNotEmpty() }
val passwordValidator: Validator = { it.length > 8 }



class FormField(val name: String, val value: String, private val validator: Validator) {
    fun isValid() = validator(value)
}


fun Validator.optional(): Validator = { it.isEmpty() || this(it) }

fun main() {
    val emailField = FormField("email", "test@example.com", emailValidator.optional())
    println("Email validation: ${emailField.isValid()}")

    val usernameField = FormField("username", "user4", usernameValidator)
    println("Username validation: ${usernameField.isValid()}")

    val passwordField = FormField("password", "123123", passwordValidator)
    println("Password validation: ${passwordField.isValid()}")
}