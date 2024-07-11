package com.example.medicamentsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medicamentsapp.MedicamentAdapter
import com.example.medicamentsapp.R
import com.example.medicamentsapp.databinding.FragmentRedBinding
import com.example.medicamentsapp.ui.MedicamentViewModel
import com.example.medicamentsapp.utils.Importance

class RedFragment : Fragment() {

    private var _binding: FragmentRedBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MedicamentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRedBinding.bind(view)

        val adapter = MedicamentAdapter()
        binding.rvRedFrag.layoutManager = LinearLayoutManager(context)
        binding.rvRedFrag.adapter = adapter

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
            .getInstance(requireActivity().application)).get(MedicamentViewModel::class.java)

        viewModel.medicaments.observe(viewLifecycleOwner) { medicaments ->
            val redMedicaments = medicaments.filter { it.importance == Importance.RED }
            adapter.submitList(redMedicaments)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}