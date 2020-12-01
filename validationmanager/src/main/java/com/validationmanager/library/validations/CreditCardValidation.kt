package com.validationmanager.library.validations

import java.util.regex.Pattern

class CreditCardValidation{

    val VISA_PATTERN : Pattern = Pattern.compile(
        "^4[0-9]{12}(?:[0-9]{3}){0,2}$"
    )
    val MASTERCARD_PATTERN : Pattern = Pattern.compile(
        "^(?:5[1-5]|2(?!2([01]|20)|7(2[1-9]|3))[2-7])\\d{14}$"
    )
    val AMERICAN_EXPRESS_PATTERN : Pattern = Pattern.compile(
        "^3[47][0-9]{13}$"
    )
    val DINERS_CLUB_PATTERN : Pattern = Pattern.compile(
            "^3(?:0[0-5]|[68][0-9])[0-9]{4,}$"
    )
    val DISCOVER_PATTERN : Pattern = Pattern.compile(
        "^6(?:011|[45][0-9]{2})[0-9]{12}$"
    )
    val JCB_PATTERN : Pattern = Pattern.compile(
        "^(?:2131|1800|35\\d{3})\\d{11}$"
    )

    fun detectCardType(cardNumber : String) : String{
        when {
            VISA_PATTERN.matcher(cardNumber).matches() -> {
                return "VISA"
            }
            MASTERCARD_PATTERN.matcher(cardNumber).matches() -> {
                return "MASTERCARD"
            }
            AMERICAN_EXPRESS_PATTERN.matcher(cardNumber).matches() -> {
                return "AMERICAN EXPRESS"
            }
            DINERS_CLUB_PATTERN.matcher(cardNumber).matches() -> {
                return "DINERS CLUB"
            }
            DISCOVER_PATTERN.matcher(cardNumber).matches() -> {
                return "DISCOVER"
            }
            JCB_PATTERN.matcher(cardNumber).matches() -> {
                return "JCB"
            }
            else -> {
                return "UNKNOWN"
            }
        }
    }

    fun isValid(cardNumber: String) : Boolean{
        var sum = 0
        var alternate = false
        for (i in cardNumber.length-1 downTo 0){
            var n = Integer.parseInt(cardNumber.substring(i, i + 1))
            if (alternate) {
                n *= 2
                if (n > 9) {
                    n = (n % 10) + 1
                }
            }
            sum += n
            alternate = !alternate
        }
        return (sum % 10 == 0)
    }
}