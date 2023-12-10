package com.example.vasestoreapp_hw12.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.vasestoreapp_hw12.R
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
        binding.etSearch.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.gray))
        binding.etSearch.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String?): Boolean {
                    adapter.submitList(
                        newText?.let {
                            getSearchedVase(it)
                        }
                    )

                    return true
                }

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }
            }
        )
    }

    private fun getSearchedVase(searchedVase: String) =
        vaseList.filter {
            it.title.contains(searchedVase, ignoreCase = true)
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}