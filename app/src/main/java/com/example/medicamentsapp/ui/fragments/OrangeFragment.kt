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
import com.example.medicamentsapp.databinding.FragmentOrangeBinding
import com.example.medicamentsapp.ui.MedicamentViewModel
import com.example.medicamentsapp.utils.Importance

class OrangeFragment : Fragment() {

    private var _binding: FragmentOrangeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MedicamentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOrangeBinding.bind(view)

        val adapter = MedicamentAdapter()
        binding.rvOrangeFrag.layoutManager = LinearLayoutManager(context)
        binding.rvOrangeFrag.adapter = adapter

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
            .getInstance(requireActivity().application)).get(MedicamentViewModel::class.java)

        viewModel.medicaments.observe(viewLifecycleOwner) { medicaments ->
            val orangeMedicaments = medicaments.filter { it.importance == Importance.ORANGE }
            adapter.submitList(orangeMedicaments)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}