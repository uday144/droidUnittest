package com.example.myapplication

import java.util.*

object SunCorpUtils {

     fun countPairsWithDiffDelta(arr: ArrayList<Int>, delta: Int): Int {
        var count = 0
        for (i in 0 until arr.size) {
            for (j in i + 1 until arr.size)
                if (arr[i] - arr[j] == delta || arr[j] - arr[i] == delta)
                    count++
        }
        return count
    }

     fun isAnagram(str1: String, str2: String): Boolean{
        if(str1 == str2)  return false
        return Arrays.equals(str1.chars().sorted().toArray(),
            str2.chars().sorted().toArray())
    }

     fun areAnagrams(str1: String, str2: String): Boolean {
        val map = HashMap<Char, Int>()
         if(str1 == str2)  return false
        for (c in str1.toCharArray())
            if (map.containsKey(c))
                map[c] = map[c]!! + 1
            else
                map[c] = 1

        for (c in str2.toCharArray())
            if (!map.containsKey(c))
                return false
            else {
                map[c] = map[c]!! - 1

                if (map[c] == 0)
                    map.remove(c)
            }
        return map.isEmpty()
    }
}