package com.zennymorh.charades.gameScreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.zennymorh.charades.R
import com.zennymorh.charades.databinding.GameFragmentBinding
import kotlinx.android.synthetic.main.game_fragment.*


class GameFragment : Fragment() {
    //create an instance of the GameViewModel class
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GameFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.game_fragment, container, false)

        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        binding.skip.setOnClickListener{
            viewModel.onSkip()
        }
        binding.gotIt.setOnClickListener {
            viewModel.onCorrect()
        }

        viewModel.score.observe(viewLifecycleOwner, Observer {newScore ->
            binding.scoreText.text = newScore.toString()
        })

        viewModel.word.observe(viewLifecycleOwner, Observer { newWord ->
            binding.wordText.text = newWord.toString()
        })


        viewModel.timeLeft.observe(viewLifecycleOwner, Observer { newTime ->
            val min = newTime/60
            val sec = newTime%60
            binding.timeText.text = "$min:$sec" // newTime.toString()
        })
//        viewModel.gameFinished.observe(viewLifecycleOwner, Observer { hasFinished ->
//            if (hasFinished){
//                gameFinished()
//            }
//        })

        return binding.root
    }

//    private fun gameFinished() {
//        val action = GameFragmentDirections.actionGameToScore(viewModel.score.value ?: 0 )
//        findNavController(this).navigate(action)
//    }
}
