package com.example.myapplication

import java.util.ArrayList

interface DevView {

    fun setPairResult(resId : Int)

    fun setPairResult(str: String)

    fun setAnagramResult(resId : Int)

    fun setArrayText(resId : Int)

    fun setArrayText(str : String)

    fun getStr1(): String

    fun getStr2(): String

    fun getDelta(): Int

    fun getNumber(): Int

    fun isDeltaNonEmpty(): Boolean

    fun isStr1NonEmpty(): Boolean

    fun isNumberNonEmpty(): Boolean

    fun isStr2NonEmpty(): Boolean

    fun getIntArray(): ArrayList<Int>

    fun addNumToArray(resId : Int)

}