package com.example.vasestoreapp_hw12.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.vasestoreapp_hw12.R.drawable.ic_check
import com.example.vasestoreapp_hw12.adapter.VaseColorItemAdapter
import com.example.vasestoreapp_hw12.data.Datasource
import com.example.vasestoreapp_hw12.databinding.FragmentVasePageBinding

class VasePageFragment : Fragment() {

    private var _binding: FragmentVasePageBinding? = null
    private val binding get() = _binding!!

    private val args: VasePageFragmentArgs by navArgs()

    private lateinit var adapter: VaseColorItemAdapter

    private var prevPosition: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVasePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPage()
        setUpRecycler()
        setUpListeners()
    }

    private fun setUpPage() {
        val vase = Datasource.vases[args.title]!!

        with(binding) {
            ivPageVase.setImageResource(vase.image)
            tvPageVaseTitle.text = vase.title
            tvPageVaseSoldCount.text = vase.soldCount
            tvPageVaseReviewCount.text = vase.reviewCount
            Datasource.setPricePrecision(tvTotalPrice, vase.price)
        }
    }

    private fun setUpRecycler() {
        adapter = VaseColorItemAdapter().apply {
            itemOnClick = ::setCheck
            currentList = Datasource.colors
        }
        binding.colorRecyclerView.adapter = adapter
    }


    private fun setCheck(currPosition: Int) {
        if (prevPosition != currPosition) {
            Datasource.apply {
                colors[prevPosition].check = 0
                colors[currPosition].check = ic_check
            }

            with(adapter) {
                notifyItemChanged(prevPosition)
                notifyItemChanged(currPosition)
            }

            prevPosition = currPosition
        }
    }


    private fun setUpListeners() {
        val vase = Datasource.vases[args.title]!!

        with(binding) {

            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            ivMinus.setOnClickListener {
                if (tvNumber.text != "1") {
                    update(tvNumber, precision = "%.0f") { it.minus(1) }
                    update(tvTotalPrice) { it.minus(vase.price) }
                }
            }

            ivPlus.setOnClickListener {
                update(tvNumber, precision = "%.0f") { it.plus(1) }
                update(tvTotalPrice) { it.plus(vase.price) }
            }
        }
    }

    private fun update(
        tv: AppCompatTextView,
        precision: String = "%.2f",
        change: (Double) -> Double
    ) {
        val num = tv.text.toString().toDouble()
        Datasource.setPricePrecision(tv, change(num), precision)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        setCheck(0)
    }
}