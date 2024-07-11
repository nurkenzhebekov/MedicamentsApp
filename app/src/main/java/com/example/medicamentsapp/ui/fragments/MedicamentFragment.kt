package com.example.medicamentsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.medicamentsapp.R
import com.example.medicamentsapp.databinding.FragmentMedicamentBinding
import com.google.android.material.tabs.TabLayoutMediator

class MedicamentFragment : Fragment() {

    private var _binding: FragmentMedicamentBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMedicamentBinding.bind(view)

        val adapter = MedicamentVPAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.icon = when (position) {
                0 -> resources.getDrawable(R.drawable.ic_tab_green, null)
                1 -> resources.getDrawable(R.drawable.ic_tab_red, null)
                2 -> resources.getDrawable(R.drawable.ic_tab_orange, null)
                else -> null
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}