package com.example.fitnessworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class WelldoneFragment : Fragment() {

    private lateinit var welldoneButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_welldone, container, false)

        welldoneButton = v.findViewById(R.id.btn_next_workout)

        welldoneButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_welldoneFragment_to_exerciseFragment)
        )
        return v
    }
}