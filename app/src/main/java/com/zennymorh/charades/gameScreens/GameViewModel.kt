package com.zennymorh.charades.gameScreens

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.time.minutes

class GameViewModel : ViewModel() {

    val ONE_SEC = 1000L
    val COUNTDOWN_TIMER = 60000L

    private lateinit var wordList: MutableList<String>
    private val _word = MutableLiveData<String>()
    private val _score = MutableLiveData<Int>()
    private val _timeLeft = MutableLiveData<Int>()
    private val timer: CountDownTimer
//    private val _gameFinished = MutableLiveData<Boolean>()

    val word: LiveData<String>
        get() = _word
    val score: LiveData<Int>
        get() = _score
    val timeLeft: LiveData<Int>
        get() = _timeLeft
//    val gameFinished: LiveData<Boolean>
//        get() = _gameFinished

    init {
//        _gameFinished.value = false
        resetList()
        next()
        _score.value = 0

        timer = object : CountDownTimer(COUNTDOWN_TIMER, ONE_SEC) {
            override fun onTick(millisUntilFinished: Long) {
                _timeLeft.value = (millisUntilFinished/1000).toInt()
            }

            override fun onFinish() {
//                _eventGameFinished.value = true
            }
        }.start()
    }

    private fun next() {
        if (wordList.isEmpty()) {
            resetList()
        }
        _word.value = wordList.removeAt(0)
    }

    fun onSkip() {
        if ((_score.value)!! > 0) {
            _score.value = (score.value)?.minus(1)
        }
        next()
    }

    fun onCorrect() {
        _score.value = (score.value)?.plus(1)
        next()
    }

//    fun onGameFinish() {
//        _gameFinished.value = false
//    }

    private fun resetList(){
        wordList = mutableListOf(
            "Airplane",
            "Ears",
            "Piano",
            "Angry",
            "Elephant",
            "Pinch",
            "Baby",
            "Fish",
            "Reach",
            "Ball",
            "Flick",
            "Remote",
            "Baseball",
            "Football",
            "Roll",
            "Basketball",
            "Fork",
            "Sad",
            "Bounce",
            "Giggle",
            "Scissors",
            "Cat",
            "Golf",
            "Skip",
            "Chicken",
            "Guitar",
            "Sneeze",
            "Chimpanzee",
            "Hammer",
            "Spin",
            "Clap",
            "Happy",
            "Spoon",
            "Cough",
            "Horns",
            "Stomp",
            "Cry",
            "Joke",
            "Stop",
            "Dog",
            "Mime",
            "Tail",
            "Drink",
            "Penguin",
            "Toothbrush",
            "Drums",
            "Phone",
            "Wiggle",
            "Duck",
            "Photographer",
            "Archer",
            "Ghost",
            "Rock star",
            "Balance beam",
            "Haircut",
            "Shoelaces",
            "Ballet",
            "Halo",
            "Sick",
            "Balloon",
            "Hiccup",
            "Singer",
            "Banana peel",
            "Hot dog",
            "Skateboard",
            "Book",
            "Hungry",
            "Slippery",
            "Braces",
            "Hurt",
            "Soccer",
            "Button",
            "Ice skating",
            "Strong",
            "Car",
            "Karate",
            "Stubbed toe",
            "Cheers",
            "Ladder",
            "Sunshine",
            "Clown",
            "Light bulb",
            "Surprise",
            "Dinosaur",
            "Limbo",
            "Swing",
            "Disco",
            "Macarena",
            "Sword",
            "Dizzy",
            "Paint",
            "Tap dance",
            "Fart",
            "Pirate",
            "Wheelbarrow",
            "Fishing",
            "Read",
            "Wizard of Oz",
            "Gallop",
            "River dance"

        )
        wordList.shuffle()
    }


}
