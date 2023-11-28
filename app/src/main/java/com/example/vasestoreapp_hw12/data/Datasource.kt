package com.example.vasestoreapp_hw12.data

import androidx.appcompat.widget.AppCompatTextView
import com.example.vasestoreapp_hw12.R.color.blue
import com.example.vasestoreapp_hw12.R.color.brown_dark
import com.example.vasestoreapp_hw12.R.color.brown_light
import com.example.vasestoreapp_hw12.R.color.purple
import com.example.vasestoreapp_hw12.R.color.teal
import com.example.vasestoreapp_hw12.R.color.white
import com.example.vasestoreapp_hw12.R.drawable.ic_check
import com.example.vasestoreapp_hw12.R.drawable.vase_img1
import com.example.vasestoreapp_hw12.R.drawable.vase_img2
import com.example.vasestoreapp_hw12.R.drawable.vase_img3
import com.example.vasestoreapp_hw12.R.drawable.vase_img4
import com.example.vasestoreapp_hw12.R.drawable.vase_img5
import com.example.vasestoreapp_hw12.R.drawable.vase_img6
import com.example.vasestoreapp_hw12.model.Color
import com.example.vasestoreapp_hw12.model.Vase


object Datasource {
    val vases = listOf(
        Vase(
            image = vase_img4,
            title = "Teak",
            rating = "3.5",
            soldCount = "9563",
            reviewCount = "7,376",
            price = 60.0
        ),
        Vase(
            image = vase_img1,
            title = "Marble",
            rating = "4.7",
            soldCount = "8963",
            reviewCount = "8,357",
            price = 85.0
        ),
        Vase(
            image = vase_img3,
            title = "Pottery",
            rating = "5.0",
            soldCount = "4396",
            reviewCount = "3,941",
            price = 70.0
        ),
        Vase(
            image = vase_img6,
            title = "Line",
            rating = "4.6",
            soldCount = "6547",
            reviewCount = "5,578",
            price = 75.0
        ),
        Vase(
            image = vase_img2,
            title = "Glass",
            rating = "2.7",
            soldCount = "6594",
            reviewCount = "1,976",
            price = 96.0
        ),
        Vase(
            image = vase_img5,
            title = "Cylinder",
            rating = "3.9",
            soldCount = "7347",
            reviewCount = "6,327",
            price = 77.0
        ),
    ).associateBy { it.title }

    fun setPricePrecision(tvPrice: AppCompatTextView, price: Double, precision: String = "%.2f") {
        precision.format(price).also {
            tvPrice.text = it
        }
    }

    val colors = listOf(
        Color(check = ic_check, color = white),
        Color(color = teal),
        Color(color = brown_dark),
        Color(color = brown_light),
        Color(color = purple),
        Color(color = blue)
    )
}

