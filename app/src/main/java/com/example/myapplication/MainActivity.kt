package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), DevView{
    var arraylist = ArrayList<Int>()
    private lateinit var presenter: DevPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = DevPresenter(this)
        pairBtn.setOnClickListener { presenter.checkForPair()}
        anagramsBtn.setOnClickListener { presenter.checkForAnagrams() }
        addMore.setOnClickListener { presenter.addMore() }
    }

    override fun setPairResult(resId: Int) {
        pairsResult.setText(resId)
    }

    override fun setAnagramResult(resId : Int) {
        anagramsResult.setText(resId)
    }

    fun showAnagramsView(v: View){
        anagramslayout.visibility = View.VISIBLE
        pairslayout.visibility = View.GONE
    }

    fun showPairView(v: View){
        pairslayout.visibility = View.VISIBLE
        anagramslayout.visibility = View.GONE
    }

    fun clearArray(v: View){
        arraylist.clear()
        arraytxt.setText(getString(R.string.empty_array))
    }

    override fun setArrayText(resId : Int) {
        arraytxt.setText(resId)
    }

    override fun setArrayText(str : String) {
        arraytxt.setText(str)
    }

    override fun getStr1(): String {
        return anagramsTxt1.text.toString()
    }

    override fun getStr2(): String {
        return anagramsTxt2.text.toString()
    }

    override fun getIntArray(): ArrayList<Int> {
        return arraylist
    }

    override fun getDelta(): Int {
        return delta.text.toString().toInt()
    }

    override fun isDeltaNonEmpty(): Boolean {
        return  delta.text.isNotEmpty()
    }

    override fun isStr1NonEmpty(): Boolean {
        return  anagramsTxt1.text.isNotEmpty()
    }

    override fun isStr2NonEmpty(): Boolean {
        return  anagramsTxt2.text.isNotEmpty()
    }

    override fun isNumberNonEmpty(): Boolean {
        return  number.text.isNotEmpty()
    }

    override fun getNumber(): Int {
        return number.text.toString().toInt()
    }

    override fun addNumToArray(num: Int) {
        arraylist.add(num)
    }

    override fun setPairResult(str: String) {
        pairsResult.setText(str)
    }
}
