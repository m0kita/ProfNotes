package ru.m0kita.profnotes.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.m0kita.profnotes.R
import ru.m0kita.profnotes.databinding.FragmentRegistrationBinding
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
            findNavController().navigate(R.id.action_statusFragment_to_homeFragment








            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}