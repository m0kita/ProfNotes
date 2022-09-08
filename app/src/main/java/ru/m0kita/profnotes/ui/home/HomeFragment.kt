package ru.m0kita.profnotes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.w3c.dom.Text
import ru.m0kita.profnotes.databinding.FragmentHomeBinding
import ru.m0kita.profnotes.model.Note
import ru.m0kita.profnotes.model.Status
import ru.m0kita.profnotes.ui.home.adapter.MyTasksAdapter

class HomeFragment : Fragment() {
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvMyTasks.adapter = MyTasksAdapter(listOf(Note("Test", "Test", status = Status.New), Note("Test", "Test", status = Status.New),Note("Test", "Test", status = Status.New),Note("Test", "Test", status = Status.New),Note("Test", "Test", status = Status.HoldOver)), requireContext(), this )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}