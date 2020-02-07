package com.zennymorh.charades.scoreFragments

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import kotlinx.android.synthetic.main.score_fragment.*
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.zennymorh.charades.BuildConfig


class ScoreFragment : Fragment() {

    var newScore = 0
    private lateinit var sharedPreferences: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args = ScoreFragmentArgs.fromBundle(arguments!!)
        newScore = args.score
        sharedPreferences = activity!!.getSharedPreferences(
            BuildConfig.APPLICATION_ID, MODE_PRIVATE)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            com.zennymorh.charades.R.layout.score_fragment,
            container, false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        actual_score.text = newScore.toString()
        playAgain()

        var prevHighScore = sharedPreferences.getInt("HighScore",0)
        if (prevHighScore < newScore) {
            val editor = sharedPreferences.edit()
            editor.putInt("HighScore", newScore)
            editor.apply()
            high_score_text_view.text = "High Score: $newScore"
        } else {
            high_score_text_view.text = "High Score: $prevHighScore"
        }
    }

    private fun playAgain(){
        play_again_button.setOnClickListener (
            Navigation.createNavigateOnClickListener(
                com.zennymorh.charades.R.id.action_scoreFragment_to_gameFragment)
        )
    }

}
