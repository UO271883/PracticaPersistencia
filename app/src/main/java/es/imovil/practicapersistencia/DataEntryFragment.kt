package es.imovil.practicapersistencia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import es.imovil.practicapersistencia.databinding.FragmentDataEntryBinding
import kotlin.properties.Delegates


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DataEntryFragment : Fragment() {

    private var _binding: FragmentDataEntryBinding? = null
    private val bookViewModel: BookViewModel by activityViewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDataEntryBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener {
            bookViewModel.addBook(getData())
            Navigation.findNavController(it).popBackStack()
        }
        return binding.root

    }
    private fun getData() : Book {
        lateinit var titulo: String
        lateinit var autor: String
        lateinit var isbntmp: String
        lateinit var editorial: String
        var pricetmp by Delegates.notNull<Float>()
        with (binding) {
            titulo = titleEdit.text.toString()
            autor = authorEdit.text.toString()
            isbntmp = isbn.text.toString()
            editorial = editorEdit.text.toString()
            pricetmp = price.text.toString().toFloat()
        }
        return Book(titulo, autor, isbntmp, editorial, pricetmp)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}