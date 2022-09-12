package ru.m0kita.profnotes.presentation.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.m0kita.profnotes.R
import ru.m0kita.profnotes.databinding.FragmentStatusBinding

class StatusFragment : Fragment() {
    private var _binding: FragmentStatusBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatusBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnCancel.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.statusNew.setOnClickListener {
            binding.statusNew.background = requireContext().getDrawable(R.drawable.bg_status_button)
            binding.statusComplete.setBackgroundColor(requireContext().getColor(R.color.black))
            binding.statusInWork.setBackgroundColor(requireContext().getColor(R.color.black))
            binding.statusHoldOver.setBackgroundColor(requireContext().getColor(R.color.black))
        }

        binding.statusComplete.setOnClickListener {
            binding.statusNew.setBackgroundColor(requireContext().getColor(R.color.black))
            binding.statusComplete.background = requireContext().getDrawable(R.drawable.bg_status_button)
            binding.statusInWork.setBackgroundColor(requireContext().getColor(R.color.black))
            binding.statusHoldOver.setBackgroundColor(requireContext().getColor(R.color.black))
        }

        binding.statusInWork.setOnClickListener {
            binding.statusNew.setBackgroundColor(requireContext().getColor(R.color.black))
            binding.statusComplete.setBackgroundColor(requireContext().getColor(R.color.black))
            binding.statusInWork.background = requireContext().getDrawable(R.drawable.bg_status_button)
            binding.statusHoldOver.setBackgroundColor(requireContext().getColor(R.color.black))
        }

        binding.statusHoldOver.setOnClickListener {
            binding.statusNew.setBackgroundColor(requireContext().getColor(R.color.black))
            binding.statusComplete.setBackgroundColor(requireContext().getColor(R.color.black))
            binding.statusInWork.setBackgroundColor(requireContext().getColor(R.color.black))
            binding.statusHoldOver.background = requireContext().getDrawable(R.drawable.bg_status_button)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}