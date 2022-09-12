package ru.m0kita.profnotes.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.onEach
import ru.m0kita.profnotes.presentation.main.MainActivity
import ru.m0kita.profnotes.viewmodel.core.BaseViewModel
import ru.m0kita.profnotes.viewmodel.core.Event

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    protected abstract val viewModel: VM

    abstract fun setupViews()

    protected val mainActivity = requireActivity() as MainActivity

    abstract fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = inflateViewBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenCreated {
            viewModel.isLoading.collect {

            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.eventState.onEach(::renderState)
        }

        setupViews()
    }

    private fun renderState(event: Event) {
        when (event) {
            is Event.Idle -> {}
            is Event.Toast -> {
                Toast.makeText(requireContext(), event.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}