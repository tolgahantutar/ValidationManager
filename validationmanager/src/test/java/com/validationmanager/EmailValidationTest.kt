package com.validationmanager

import com.validationmanager.library.validations.EmailValidation
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Test

class EmailValidationTest {
    @Test
    fun test_emailValidation_returnTrue(){
        val result: Boolean = EmailValidation.isEmailValid("tolgahan.tutar@gmail.com")
        MatcherAssert.assertThat(result, Matchers.equalTo(true))
    }
    @Test
    fun test_emailValidation_returnFalse(){
        val result: Boolean = EmailValidation.isEmailValid("tolgahan.tutar@gmail-com")
        MatcherAssert.assertThat(result, Matchers.equalTo(false))
    }
    @Test
    fun test_emailValidation_isValidateTurkishLetter_returnTrue(){
        val result: Boolean = EmailValidation.isEmailValid("osman.gençoğlan@bexfa.com")
        MatcherAssert.assertThat(result,Matchers.equalTo(true))
    }

}