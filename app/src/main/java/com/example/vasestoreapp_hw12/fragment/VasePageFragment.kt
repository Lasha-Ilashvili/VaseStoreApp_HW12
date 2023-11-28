package com.example.vasestoreapp_hw12.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.vasestoreapp_hw12.data.Datasource
import com.example.vasestoreapp_hw12.databinding.FragmentVasePageBinding

class VasePageFragment : Fragment() {

    private var _binding: FragmentVasePageBinding? = null
    private val binding get() = _binding!!

    private val args: VasePageFragmentArgs by navArgs()

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
        setUpListener()
    }

    private fun setUpPage() {
        val vase = Datasource.vases[args.title]!!

        with(binding) {
            ivPageVase.setImageResource(vase.image)
            tvPageVaseTitle.text = vase.title
            tvPageVaseSoldCount.text = vase.soldCount
            tvPageVaseReviewCount.text = vase.reviewCount
            "%.2f".format(vase.price).also {
                tvTotalPrice.text = it
            }
        }
    }

    private fun setUpListener() {
        val vase = Datasource.vases[args.title]!!

        with(binding) {

                ivMinus.setOnClickListener {
                    if (tvNumber.text.toString().toInt() > 1) {
                    "%.2f".format(tvTotalPrice.text.toString().toDouble() - vase.price).also {
                        tvTotalPrice.text = it
                    }
                    tvNumber.text = (tvNumber.text.toString().toInt() - 1).toString()
                }
            }

            ivPlus.setOnClickListener {
                "%.2f".format(tvTotalPrice.text.toString().toDouble() + vase.price).also {
                    tvTotalPrice.text = it
                }
                tvNumber.text = (tvNumber.text.toString().toInt() + 1).toString()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}