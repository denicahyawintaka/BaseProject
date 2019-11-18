package com.example.baseproject.presentation.destination

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigator

import com.example.baseproject.R
import kotlinx.android.synthetic.main.destination_fragment.*

class Destination : Fragment() {

    companion object {
        fun newInstance() = Destination()
    }

    private lateinit var viewModel: DestinationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.destination_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DestinationViewModel::class.java)

        tv_noktp.text = arguments?.getString("noktp")
        tv_namalengkap.text = arguments?.getString("namalengkap")
        tv_provinsi.text = arguments?.getString("provinsi")



    }

}
