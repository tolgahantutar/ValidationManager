package com.validationmanager.library.validations

import java.util.regex.Pattern

object EmailValidation {
   private val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
            "([a-zA-Z0-9._\\-çÇğĞıİöÖşŞüÜ]+@[a-zçğıöşü]+\\.[a-zçğıöşü]+)\\w+"
    )
    fun isEmailValid(email: String): Boolean{
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }
}

