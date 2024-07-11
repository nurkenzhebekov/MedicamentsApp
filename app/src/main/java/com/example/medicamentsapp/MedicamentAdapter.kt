package com.example.medicamentsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.medicamentsapp.data.Medicament
import com.example.medicamentsapp.databinding.ItemMedicamentBinding

class MedicamentAdapter : ListAdapter<Medicament, MedicamentAdapter.MedicamentViewHolder>(MedicamentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicamentViewHolder {
        val binding = ItemMedicamentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MedicamentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MedicamentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MedicamentViewHolder(private val binding: ItemMedicamentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(medicament: Medicament) {
            binding.apply {
                medicamentName.text = medicament.name
                medicamentDescription.text = medicament.description
                medicamentTime.text = medicament.time
                progressBar.progress = 10
            }
        }
    }

    class MedicamentDiffCallback : DiffUtil.ItemCallback<Medicament>() {
        override fun areItemsTheSame(oldItem: Medicament, newItem: Medicament): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Medicament, newItem: Medicament): Boolean {
            return oldItem == newItem
        }

    }
}