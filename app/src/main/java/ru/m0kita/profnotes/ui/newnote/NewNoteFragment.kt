package ru.m0kita.profnotes.ui.newnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import ru.m0kita.profnotes.R
import ru.m0kita.profnotes.core.gone
import ru.m0kita.profnotes.core.visible
import ru.m0kita.profnotes.databinding.FragmentNewNoteBinding
import ru.m0kita.profnotes.databinding.FragmentStatusBinding

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

        binding.btnNote.apply {
            setBackgroundColor(resources.getColor(R.color.yellow))
            setTextColor(resources.getColor(R.color.black))
            setOnClickListener {
                setBackgroundColor(resources.getColor(R.color.yellow))
                setTextColor(resources.getColor(R.color.black))
                binding.tvSetTime.gone()
                binding.etSetTime.gone()
                binding.ivSearch.visible()
                binding.calendar.visible()
                binding.tvFriends.visible()
                binding.recyclerView.visible()
                binding.btnTask.setBackgroundColor(resources.getColor(R.color.darkest_gray))
                binding.btnTask.setTextColor(resources.getColor(R.color.white))
            }
        }

        binding.btnTask.apply {
            setBackgroundColor(resources.getColor(R.color.darkest_gray))
            setTextColor(resources.getColor(R.color.white))
            setOnClickListener {
                setBackgroundColor(resources.getColor(R.color.yellow))
                setTextColor(resources.getColor(R.color.black))
                binding.calendar.gone()
                binding.tvFriends.gone()
                binding.ivSearch.gone()
                binding.recyclerView.gone()
                binding.tvSetTime.visible()
                binding.etSetTime.visible()
                binding.btnNote.setBackgroundColor(resources.getColor(R.color.darkest_gray))
                binding.btnNote.setTextColor(resources.getColor(R.color.white))
            }
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_newNoteFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}