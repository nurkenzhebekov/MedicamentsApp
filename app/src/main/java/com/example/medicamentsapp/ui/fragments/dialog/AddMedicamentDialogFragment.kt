package com.example.drugsapp.ui.fragment.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.medicamentsapp.R
import com.example.medicamentsapp.data.Medicament
import com.example.medicamentsapp.databinding.FragmentAddMedicamentDialogBinding
import com.example.medicamentsapp.ui.MedicamentViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AddMedicamentDialogFragment : DialogFragment() {

    private var _binding: FragmentAddMedicamentDialogBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MedicamentViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = FragmentAddMedicamentDialogBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MedicamentViewModel::class.java)

        val builder = MaterialAlertDialogBuilder(requireContext())
        builder.setView(binding.root)

        val importanceAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.importance_levels,
            android.R.layout.simple_spinner_item
        )
        importanceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        binding.spinnerImportance.adapter = importanceAdapter

        binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.spinnerImportance.visibility = View.VISIBLE
                binding.btDelay.visibility = View.VISIBLE
            } else {
                binding.spinnerImportance.visibility = View.GONE
                binding.btDelay.visibility = View.GONE
            }
        }

        binding.imgBtClose.setOnClickListener {
            dismiss()
        }

        binding.btAdd.setOnClickListener {
            val title = binding.edtTitle.text.toString()
            val description = binding.edtDescription.text.toString()
            val time = binding.edtTime.text.toString()
            val importance = if (binding.checkbox.isChecked) binding.spinnerImportance.selectedItem else "Green"

            if (title.isNotEmpty() && description.isNotEmpty() && time.isNotEmpty()) {
                viewModel.insert(Medicament(name = title, description = description, time = time, importance = importance.toString()))
                dismiss()
            } else {
                Toast.makeText(requireContext(), "Please, fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btChange.setOnClickListener {
            dismiss()
        }

        return builder.create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}