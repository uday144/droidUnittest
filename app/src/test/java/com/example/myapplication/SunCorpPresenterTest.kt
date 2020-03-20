package com.example.myapplication

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.*


@RunWith(MockitoJUnitRunner::class)
class SunCorpPresenterTest {

    @Mock
    lateinit var view: SunCorpView

    lateinit var presenter: SunCorpPresenter

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = SunCorpPresenter(view)
    }


    @Test
    @Throws(Exception::class)
    fun checkForNonAnagramStrinsTest() {
        `when`(view.isStr1NonEmpty()).thenReturn(true)
        `when`(view.isStr2NonEmpty()).thenReturn(true)
        `when`(view.getStr1()).thenReturn("Uday")
        `when`(view.getStr2()).thenReturn("Singh")
        presenter.checkForAnagrams()
        verify(view).setAnagramResult(R.string.non_anagrams)
    }

    @Test
    @Throws(Exception::class)
    fun checkForNonAnagramStrinsAltTest() {
        `when`(view.isStr1NonEmpty()).thenReturn(true)
        `when`(view.isStr2NonEmpty()).thenReturn(true)
        `when`(view.getStr1()).thenReturn("Uday")
        `when`(view.getStr2()).thenReturn("Singh")
        presenter.checkForAnagramsAlt()
        verify(view).setAnagramResult(R.string.non_anagrams)
    }

    @Test
    @Throws(Exception::class)
    fun checkForAnagramStrinsTest() {
        `when`(view.isStr1NonEmpty()).thenReturn(true)
        `when`(view.isStr2NonEmpty()).thenReturn(true)
        `when`(view.getStr1()).thenReturn("silent")
        `when`(view.getStr2()).thenReturn("listen")
        presenter.checkForAnagrams()
        verify(view).setAnagramResult(R.string.anagrams)
    }

    @Test
    @Throws(Exception::class)
    fun checkForAnagramStrinsAltTest() {
        `when`(view.isStr1NonEmpty()).thenReturn(true)
        `when`(view.isStr2NonEmpty()).thenReturn(true)
        `when`(view.getStr1()).thenReturn("silent")
        `when`(view.getStr2()).thenReturn("listen")
        presenter.checkForAnagramsAlt()
        verify(view).setAnagramResult(R.string.anagrams)
    }

    @Test
    @Throws(Exception::class)
    fun checkForEmptyStringTest() {
        `when`(view.isStr1NonEmpty()).thenReturn(false)
        presenter.checkForAnagrams()
        verify(view).setAnagramResult(R.string.enter_string)
    }

    @Test
    @Throws(Exception::class)
    fun checkForEmptyStringAltTest() {
        `when`(view.isStr1NonEmpty()).thenReturn(false)
        presenter.checkForAnagramsAlt()
        verify(view).setAnagramResult(R.string.enter_string)
    }

    @Test
    @Throws(Exception::class)
    fun checkForPairTestTest() {
        `when`(view.getIntArray()).thenReturn(arrayListOf(1))
        presenter.checkForPair()
        verify(view).setPairResult(R.string.min_num)
    }

    @Test
    @Throws(Exception::class)
    fun checkForEmptyDeltaTestTest() {
        `when`(view.getIntArray()).thenReturn(arrayListOf(1,2,4))
        `when`(view.isDeltaNonEmpty()).thenReturn(false)
        presenter.checkForPair()
        verify(view).setPairResult(R.string.enter_delta)
    }

    @Test
    @Throws(Exception::class)
    fun checkForPairTest() {
        `when`(view.getIntArray()).thenReturn(arrayListOf(1, 4, 5, 7, 8, 9))
        `when`(view.isDeltaNonEmpty()).thenReturn(true)
        `when`(view.getDelta()).thenReturn(3)
        presenter.checkForPair()
        verify(view).setPairResult("3")
    }

    @Test
    @Throws(Exception::class)
    fun checkForAddMoreEmptyNumberTest() {
        `when`(view.isNumberNonEmpty()).thenReturn(false)
        presenter.addMore()
        verify(view).setArrayText(R.string.enter_num)
    }

    @Test
    @Throws(Exception::class)
    fun checkForAddMoreTest() {
        `when`(view.isNumberNonEmpty()).thenReturn(true)
        `when`(view.getNumber()).thenReturn(7)
        `when`(view.getIntArray()).thenReturn(arrayListOf(1, 4, 7))
        presenter.addMore()
        verify(view).setArrayText(" 1, 4, 7")
    }
}