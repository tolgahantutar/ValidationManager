package com.validationmanager.library.validations

class PhoneValidation{
fun isPhoneValid(dialCode: String, phoneNumber: String):Boolean {
    var countryCode:ArrayList<String> =ArrayList<String>()
    countryCode.add("90")
    countryCode.add("1")
    countryCode.add("44")
    countryCode.add("30")


 countryCode.contains(dialCode)==true

    var isCorrectPhoneNumberLength: Boolean = false
        if (phoneNumber.length == 11) {
            isCorrectPhoneNumberLength = true

        }
   if (!isCorrectPhoneNumberLength) {
        return false
    }
    return true
    }



    }





