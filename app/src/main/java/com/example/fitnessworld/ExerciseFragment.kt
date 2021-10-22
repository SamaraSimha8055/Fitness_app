package com.example.fitnessworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import pl.droidsonroids.gif.GifImageView
import kotlin.math.min

class ExerciseFragment : Fragment() {

    data class Exercise(
        val exerciseType: String,
        val exerciseCount: Int
    )

    private val exercises: MutableList<Exercise> = mutableListOf(
        Exercise("gifone", 8),
        Exercise("giftwo", 5),
        Exercise("gifthree", 10),
        Exercise("giffour", 15),
        Exercise("giffive", 20)
    )

    private lateinit var nextButton: Button
    private lateinit var exitButton: Button
    private lateinit var imageView: GifImageView
    private lateinit var textView: TextView

    private lateinit var currentExercise: Exercise
    private var count: Int = 0
    private var exerciseIndex: Int = 0
    private var exerciseSize = min((exercises.size + 1) / 2, 3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_exercise, container, false)

        nextButton = v.findViewById(R.id.btn_next)
        exitButton = v.findViewById(R.id.btn_exit)
        imageView = v.findViewById(R.id.exercise_image_view)
        textView = v.findViewById(R.id.exercise_text_view)

        randomizeExercise()

        nextButton.setOnClickListener {

            exerciseIndex++

            if (exerciseIndex < exerciseSize){
                currentExercise = exercises[exerciseIndex]
                setExercise()
            }else{
                view?.findNavController()?.navigate(R.id.action_exerciseFragment_to_welldoneFragment)
            }
        }
        exitButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_exerciseFragment_to_tryAgain)
        )

        return v
    }

    private fun randomizeExercise() {

        exercises.shuffle()
        exerciseIndex = 0
        setExercise()

    }

    private fun setExercise() {

        currentExercise = exercises[exerciseIndex]

        count = currentExercise.exerciseCount

        textView.text = String.format(getString(R.string.exercise_text_view), count)

        imageView.setImageResource(
            resources.getIdentifier(
                currentExercise.exerciseType,
                "drawable", (activity as AppCompatActivity).packageName
            )
        )

        (activity as AppCompatActivity).supportActionBar?.title = String.format(
            getString(R.string.title_fitness_exercise),
            exerciseIndex + 1,
            exerciseSize
        )
    }
}