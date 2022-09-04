package ru.m0kita.profnotes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ru.m0kita.profnotes.databinding.FragmentHomeBinding
import ru.m0kita.profnotes.model.NewNote
import ru.m0kita.profnotes.ui.home.adapter.NewNotesAdapter

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
        val notes = listOf(NewNote("https://img-fotki.yandex.ru/get/17865/39478662.2e/0_8157a_f1b63570_XXL.jpg", "Побрей мать", "8 часов блять спустя", "Мамку побрей тварь", listOf("https://img-fotki.yandex.ru/get/17865/39478662.2e/0_8157a_f1b63570_XXL.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2mH8w36otnsqjMAxgwbmkNPKW-elTGLdHwhfFQjMtMdRcj94P2hGB210mhXTBKejk1ns&usqp=CAU", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTdSPBcpnLwHWxyrBAoyNGKRSGQSiRGYfzBasCPrbv_XBphT4vsb8DQh6FeDJw6eTcRcXM&usqp=CAU")),
            NewNote("https://img-fotki.yandex.ru/get/17865/39478662.2e/0_8157a_f1b63570_XXL.jpg", "Побрей мать", "8 часов блять спустя", "Мамку побрей тварь", listOf("https://img-fotki.yandex.ru/get/17865/39478662.2e/0_8157a_f1b63570_XXL.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2mH8w36otnsqjMAxgwbmkNPKW-elTGLdHwhfFQjMtMdRcj94P2hGB210mhXTBKejk1ns&usqp=CAU", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTdSPBcpnLwHWxyrBAoyNGKRSGQSiRGYfzBasCPrbv_XBphT4vsb8DQh6FeDJw6eTcRcXM&usqp=CAU")),
            NewNote("https://img-fotki.yandex.ru/get/17865/39478662.2e/0_8157a_f1b63570_XXL.jpg", "Побрей мать", "8 часов блять спустя", "Мамку побрей тварь", listOf("https://img-fotki.yandex.ru/get/17865/39478662.2e/0_8157a_f1b63570_XXL.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2mH8w36otnsqjMAxgwbmkNPKW-elTGLdHwhfFQjMtMdRcj94P2hGB210mhXTBKejk1ns&usqp=CAU", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTdSPBcpnLwHWxyrBAoyNGKRSGQSiRGYfzBasCPrbv_XBphT4vsb8DQh6FeDJw6eTcRcXM&usqp=CAU")))

        binding.rvNewNotes.adapter =NewNotesAdapter(notes, requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}