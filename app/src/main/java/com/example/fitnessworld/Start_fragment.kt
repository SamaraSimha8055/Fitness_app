package com.example.fitnessworld

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI


class StartFragment : Fragment() {

    private lateinit var goButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_start_fragment, container, false)

        goButton = v.findViewById(R.id.btn_go)

        goButton.setOnClickListener {

            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_start_fragment_to_exerciseFragment)
            }
        }
        setHasOptionsMenu(true)

        return v
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())||
        super.onOptionsItemSelected(item)
    }
}