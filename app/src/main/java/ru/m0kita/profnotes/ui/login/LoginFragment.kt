package ru.m0kita.profnotes.ui.login

import android.graphics.Color.green
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.m0kita.profnotes.R
import ru.m0kita.profnotes.core.gone
import ru.m0kita.profnotes.core.spanString
import ru.m0kita.profnotes.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvLoginWithoutAccount.apply {
            text = text.spanString(
                startIndex = 4,
                endIndex = 24,
                color = requireContext().getColor(R.color.light_green)
            )
        }
        binding.tvResetPassword.apply {
            text = text.spanString(
                startIndex = 24,
                endIndex = 43,
                color = requireContext().getColor(R.color.yellow)
            )
        }

        binding.tvLoginWithoutAccount.setOnClickListener{

        }

        binding.tvResetPassword.setOnClickListener {

        }

        binding.btnLogin.setOnClickListener {

        }

        binding.btnCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}