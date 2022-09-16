package com.example.android.guesstheword.screens.game

import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.guesstheword.R

class GameViewModel : ViewModel() {
    var image : Int = 0

    // The current word
    var word = ""

    // The current score
    var score = 0

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>
    private lateinit var imageList: MutableList<Int>

    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )

        imageList = mutableListOf(
            R.drawable.queen,
            R.drawable.hospital,
            R.drawable.basketball,
            R.drawable.cat,
            R.drawable.change,
            R.drawable.snail,
            R.drawable.soup,
            R.drawable.calendar,
            R.drawable.sad,
            R.drawable.desk,
            R.drawable.guitar,
            R.drawable.home,
            R.drawable.railway,
            R.drawable.zebra,
            R.drawable.jelly,
            R.drawable.car,
            R.drawable.crow,
            R.drawable.trade,
            R.drawable.bag,
            R.drawable.roll,
            R.drawable.bubble
        )

        wordList.shuffle()
        imageList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            word = wordList.removeAt(0)
        }
    }

    private fun nextImage() {
        if (!imageList.isEmpty()) {
            //Select and remove a word from the list
            image = imageList.removeAt(0)
        }
    }

    /** Methods for buttons presses **/

    fun onSkip() {
        score--
        nextWord()
        nextImage()
    }

    fun onCorrect() {
        score++
        nextWord()
        nextImage()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    init {
        resetList()
        nextWord()
        nextImage()
        Log.i("GameViewModel", "GameViewModel created!")
    }
}