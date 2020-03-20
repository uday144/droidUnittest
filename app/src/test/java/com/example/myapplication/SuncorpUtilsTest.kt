package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SuncorpUtilsTest {
    @Test
    fun strAreAnagram() {
       val str1 = "silent"
       val str2 = "listen"
       var result =  SunCorpUtils.isAnagram(str1, str2)
        assertTrue(result)
        result =  SunCorpUtils.areAnagrams(str1, str2)
        assertTrue(result)
    }

    @Test
    fun strAreNotAnagram() {
        val str1 = "silent"
        val str2 = "Not"
        var result =  SunCorpUtils.isAnagram(str1, str2)
        assertFalse(result)
        result =  SunCorpUtils.areAnagrams(str1, str2)
        assertFalse(result)
    }

    @Test
    fun strAreSame() {
        val str1 = "silent"
        val str2 = "silent"
        var result =  SunCorpUtils.isAnagram(str1, str2)
        assertFalse(result)
        result =  SunCorpUtils.areAnagrams(str1, str2)
        assertFalse(result)
    }
}
