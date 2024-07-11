package com.example.medicamentsapp.ui.fragments

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MedicamentVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GreenFragment()
            1 -> RedFragment()
            2 -> OrangeFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }

}
