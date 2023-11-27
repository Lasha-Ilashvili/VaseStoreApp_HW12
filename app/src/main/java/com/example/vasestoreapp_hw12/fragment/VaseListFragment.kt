package com.example.vasestoreapp_hw12.fragment

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.vasestoreapp_hw12.adapter.VaseItemAdapter
import com.example.vasestoreapp_hw12.data.Datasource
import com.example.vasestoreapp_hw12.databinding.FragmentVaseListBinding

class VaseListFragment : Fragment() {

    private var _binding: FragmentVaseListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: VaseItemAdapter

    private val vaseList = Datasource.vases.values.toList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVaseListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        setUpSearch()
    }

    private fun setUpRecyclerView() {
        adapter = VaseItemAdapter().apply {
            itemOnClick = ::startNewFragment
            submitList(vaseList)
        }
        binding.vaseRecyclerView.adapter = adapter
    }

    private fun startNewFragment(title: String) {
        findNavController().navigate(
            VaseListFragmentDirections.actionVaseListFragmentToVasePageFragment(
                title = title
            )
        )
    }

    private fun setUpSearch() {
        binding.etSearch.addTextChangedListener { title: Editable? ->
            adapter.submitList(
                title?.let { searchedText: Editable ->
                    vaseList.filter { it.title.contains(searchedText, ignoreCase = true) }
                } ?: vaseList
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}