package com.example.vasestoreapp_hw12.data

import com.example.vasestoreapp_hw12.R.drawable.vase_img1
import com.example.vasestoreapp_hw12.R.drawable.vase_img2
import com.example.vasestoreapp_hw12.R.drawable.vase_img3
import com.example.vasestoreapp_hw12.R.drawable.vase_img4
import com.example.vasestoreapp_hw12.R.drawable.vase_img5
import com.example.vasestoreapp_hw12.R.drawable.vase_img6
import com.example.vasestoreapp_hw12.model.Vase

object Datasource {
    val vases = listOf(
        Vase(
            image = vase_img4,
            title = "Teak",
            rating = "3.5",
            soldCount = "9563",
            price = "$60.00",
            reviewCount = "7,376"
        ),
        Vase(
            image = vase_img1,
            title = "Marble",
            rating = "4.7",
            soldCount = "8963",
            reviewCount = "8,357",
            price = "$85.00"
        ),
        Vase(
            image = vase_img3,
            title = "Pottery",
            rating = "5.0",
            soldCount = "4396",
            reviewCount = "3,941",
            price = "$70.00"
        ),
        Vase(
            image = vase_img6,
            title = "Line",
            rating = "4.6",
            soldCount = "6547",
            reviewCount = "5,578",
            price = "$75.00"
        ),
        Vase(
            image = vase_img2,
            title = "Glass",
            rating = "2.7",
            soldCount = "6594",
            reviewCount = "1,976",
            price = "$96.00"
        ),
        Vase(
            image = vase_img5,
            title = "Cylinder",
            rating = "3.9",
            soldCount = "7347",
            reviewCount = "6,327",
            price = "$77.00"
        ),
    ).associateBy { it.title }
}