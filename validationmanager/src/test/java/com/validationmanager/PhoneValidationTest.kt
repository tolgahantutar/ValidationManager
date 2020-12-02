package com.validationmanager

import com.validationmanager.library.validations.EmailValidation
import com.validationmanager.library.validations.PhoneValidation
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Test

class PhoneValidationTest {
    @Test
    fun test_phoneValidation_returnTrue(){
        val result: Boolean = PhoneValidation().isPhoneValid("90,","05059639693")
        MatcherAssert.assertThat(result, Matchers.equalTo(true))
    }
    @Test
    fun test_phoneValidation_returnFalse(){
        val result: Boolean = PhoneValidation().isPhoneValid("09,","050596396")
        MatcherAssert.assertThat(result, Matchers.equalTo(false))
    }


}