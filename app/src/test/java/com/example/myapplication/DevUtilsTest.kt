package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.util.*
import kotlin.collections.ArrayList

@RunWith(MockitoJUnitRunner::class)
class DevUtilsTest {
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

    @Test
    fun countPairsWithDiffDeltaTest() {
        var arr = ArrayList<Int>(Arrays.asList(1, 5, 3, 4, 2));
        var result =  SunCorpUtils.countPairsWithDiffDelta(arr, 3)
        assertSame(2, result)
    }

}
