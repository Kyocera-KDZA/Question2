package com.itada.question2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import androidx.navigation.findNavController


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home,container, false)

        val rate = view.findViewById<Spinner>(R.id.spinner)
        val rateBtn = view.findViewById<Button>(R.id.btn_home)

        rateBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_rateActivity)
        }

        return view

    }

}