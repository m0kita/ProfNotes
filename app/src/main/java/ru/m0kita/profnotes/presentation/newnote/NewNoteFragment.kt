package ru.m0kita.profnotes.presentation.newnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.m0kita.profnotes.R
import ru.m0kita.profnotes.databinding.FragmentNewNoteBinding
import ru.m0kita.profnotes.core.gone
import ru.m0kita.profnotes.core.visible

class NewNoteFragment : Fragment() {
    private var _binding: FragmentNewNoteBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNote.setOnClickListener {
            showNote()
        }

        binding.btnTask.setOnClickListener {
            showTask()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showTask() {
        binding.btnTask.apply {
            this.setBackgroundColor(requireContext().getColor(R.color.yellow))
            this.setTextColor(requireContext().getColor(R.color.black))
            binding.calendar.gone()
            binding.tvFriends.gone()
            binding.recyclerView.gone()
            binding.tvTaskDate.visible()
            binding.etTaskDate.visible()
            binding.btnNote.apply {
                this.setBackgroundColor(requireContext().getColor(R.color.darkest_gray))
                this.setTextColor(requireContext().getColor(R.color.white))
            }
        }
    }

    private fun showNote() {
        binding.btnNote.apply {
            this.setBackgroundColor(requireContext().getColor(R.color.yellow))
            this.setTextColor(requireContext().getColor(R.color.black))
            binding.calendar.visible()
            binding.tvFriends.visible()
            binding.recyclerView.visible()
            binding.tvTaskDate.gone()
            binding.etTaskDate.gone()
            binding.btnTask.apply {
                this.setBackgroundColor(requireContext().getColor(R.color.darkest_gray))
                this.setTextColor(requireContext().getColor(R.color.white))
            }
        }
    }
}