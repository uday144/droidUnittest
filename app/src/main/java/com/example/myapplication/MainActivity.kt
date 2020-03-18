package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var arraylist = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        anagrams.setOnClickListener {
            anagramslayout.visibility = View.VISIBLE
            pairslayout.visibility = View.GONE
        }
        pairs.setOnClickListener {
            pairslayout.visibility = View.VISIBLE
            anagramslayout.visibility = View.GONE
        }

        anagramsBtn.setOnClickListener { checkForAnagrams() }
        addMore.setOnClickListener {
            var array = ""
            arraylist.add(number.text.toString().toInt())
            for(i in arraylist) array = array + ", " + i
            arraytxt.setText(array.substring(1))
        }
        clear.setOnClickListener { arraylist.clear()
            arraytxt.setText("Array: Empty Array")
        }
        pairBtn.setOnClickListener { checkForPair() }

    }

    private fun checkForPair(){
        if(arraylist.size <= 1){
            pairsResult.setText("Int Array should have minimum two number")
            return
        }
        if(delta.text.isEmpty()){
            pairsResult.setText("Please enter Delta")
            return
        }
        pairsResult.setText(("Pairs: "+countPairsWithDiffK(arraylist, delta.text.toString().toInt())))
    }

    private fun checkForAnagrams(){
      if(anagramsTxt1.text.isNotEmpty() && anagramsTxt2.text.isNotEmpty() ){
          var result = if(isAnagram(anagramsTxt1.text.toString(), anagramsTxt2.text.toString()))  "Strings are Anagrams" else "Strings are Not Anagrams"
          anagramsResult.setText(result)
      } else {
          anagramsResult.setText("Please Enter String in Both Fields")
          anagramsResult.setTextColor(Color.RED)
      }
    }

    private fun isAnagram(str1: String, str2: String): Boolean{
        return Arrays.equals(str1.chars().sorted().toArray(),
            str2.chars().sorted().toArray())
    }

    fun countPairsWithDiffK(arr: ArrayList<Int>, k: Int): Int {
        var count = 0
        for (i in 0 until arr.size) {
            for (j in i + 1 until arr.size)
                if (arr[i] - arr[j] == k || arr[j] - arr[i] == k)
                    count++
        }
        return count
    }
}
