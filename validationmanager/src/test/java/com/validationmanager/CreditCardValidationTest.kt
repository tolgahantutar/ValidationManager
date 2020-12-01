package com.validationmanager

import com.validationmanager.library.validations.CreditCardValidation
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test

class CreditCardValidationTest {

    @Test
    fun testCardDetect(){
        assertEquals("VISA", CreditCardValidation().detectCardType("4000056655665556"))
        assertEquals("VISA", CreditCardValidation().detectCardType("4242424242424242"))

        assertEquals("MASTERCARD", CreditCardValidation().detectCardType("5105105105105100"))
        assertEquals("MASTERCARD", CreditCardValidation().detectCardType("5200828282828210"))
        assertEquals("MASTERCARD", CreditCardValidation().detectCardType("5555555555554444"))

        assertEquals("AMERICAN EXPRESS", CreditCardValidation().detectCardType("371449635398431"))
        assertEquals("AMERICAN EXPRESS", CreditCardValidation().detectCardType("378282246310005"))

        assertEquals("DISCOVER", CreditCardValidation().detectCardType("6011000990139424"))
        assertEquals("DISCOVER", CreditCardValidation().detectCardType("6011111111111117"))

        assertEquals("DINERS CLUB", CreditCardValidation().detectCardType("30569309025904"))
        assertEquals("DINERS CLUB", CreditCardValidation().detectCardType("38520000023237"))

        assertEquals("JCB", CreditCardValidation().detectCardType("3530111333300000"))
        assertEquals("JCB", CreditCardValidation().detectCardType("3566002020360505"))

        assertEquals("UNKNOWN", CreditCardValidation().detectCardType("0000000000000000"))

    }

    @Test
    fun testIsValidReturnTrue(){
        val result = CreditCardValidation().isValid("3566002020360505")
        MatcherAssert.assertThat(result, Matchers.equalTo(true))
    }

    @Test
    fun testIsValidReturnFalse(){
        val result = CreditCardValidation().isValid("536796967")
        MatcherAssert.assertThat(result, Matchers.equalTo(false))
    }
}