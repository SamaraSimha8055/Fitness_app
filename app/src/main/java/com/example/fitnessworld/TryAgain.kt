package com.example.fitnessworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class TryAgain : Fragment() {

    private lateinit var tryAgainButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_try_again, container, false)

        tryAgainButton = v.findViewById(R.id.btn_try_again)

        tryAgainButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_tryAgain_to_exerciseFragment)
        )
        return v
    }
}