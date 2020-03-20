package com.example.myapplication

class SunCorpPresenter(view : SunCorpView) {
    var view: SunCorpView = view

    fun checkForPair(){
        if(view.getIntArray().size <= 1){
            view.setPairResult(R.string.min_num)
            return
        }
        if(view.isDeltaNonEmpty()) view.setPairResult(SunCorpUtils.countPairsWithDiffK(view.getIntArray(), view.getDelta()).toString())
           else view.setPairResult(R.string.enter_delta)
    }


    fun checkForAnagrams(){
        if(view.isStr1NonEmpty() && view.isStr2NonEmpty() ){
            if(SunCorpUtils.isAnagram(view.getStr1(), view.getStr2()))
            {
                view.setAnagramResult(R.string.anagrams)
            }
            else{
                view.setAnagramResult(R.string.non_anagrams)
            }
        } else {
            view.setAnagramResult(R.string.enter_string)
        }
    }

    fun checkForAnagramsAlt(){
        if(view.isStr1NonEmpty() && view.isStr2NonEmpty() ){
            if(SunCorpUtils.areAnagrams(view.getStr1(), view.getStr2()))
            {
                view.setAnagramResult(R.string.anagrams)
            }
            else{
                view.setAnagramResult(R.string.non_anagrams)
            }
        } else {
            view.setAnagramResult(R.string.enter_string)
        }
    }


    fun addMore(){
        var array = ""
        if(view.isNumberNonEmpty()) {
            view.addNumToArray(view.getNumber())
            for (i in view.getIntArray()) array = array + ", " + i
            view.setArrayText(array.substring(1))
        } else  view.setArrayText(R.string.enter_num)
    }

}
