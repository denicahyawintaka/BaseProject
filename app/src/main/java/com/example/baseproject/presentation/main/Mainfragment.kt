package com.example.baseproject.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.baseproject.R
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class Mainfragment : Fragment() {

    private val viewModel: MainfragmentViewModel by viewModel()

    companion object {
        fun newInstance() = Mainfragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        btn_submit.setOnClickListener{
            validForm()
        }

        observeViewModel()
    }

    private fun validForm() {
        val nomorKTP: String = edt_ktp.text.toString()
        val namaLengkap: String = edt_nama.text.toString()
        val provinsi: String = provinsi_spinner.getSelectedItem().toString()


        if (nomorKTP.isEmpty() || namaLengkap.isEmpty() || provinsi.isEmpty()) {
            Toast.makeText(context, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show()
        } else {
            var bundle = bundleOf("namalengkap" to namaLengkap, "provinsi" to provinsi, "noktp" to nomorKTP)
            findNavController().navigate(R.id.action_mainfragment_to_destination, bundle)

        }

    }

    private fun observeViewModel() {

        viewModel.provinsi.observe(this, Observer {
            provinsi_spinner.adapter = ArrayAdapter(
                activity!!.applicationContext,
                android.R.layout.simple_spinner_dropdown_item,
                it
            )
        })
        // Observe showError value and display the error message as a Toast
        viewModel.showError.observe(this, Observer { showError ->
            Toast.makeText(context, showError, Toast.LENGTH_SHORT).show()
        })
    }


}
