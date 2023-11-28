package com.example.vasestoreapp_hw12.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.vasestoreapp_hw12.databinding.VaseColorItemBinding
import com.example.vasestoreapp_hw12.model.Color

class VaseColorItemAdapter : RecyclerView.Adapter<VaseColorItemAdapter.VaseColorItemViewHolder>() {

    var itemOnClick: ((Int) -> Unit)? = null

    lateinit var currentList: List<Color>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaseColorItemViewHolder {
        return VaseColorItemViewHolder(
            VaseColorItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = currentList.size

    override fun onBindViewHolder(holder: VaseColorItemViewHolder, position: Int) {
        holder.bind()
    }


    inner class VaseColorItemViewHolder(private val binding: VaseColorItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.ivColor.setOnClickListener {
                itemOnClick?.invoke(adapterPosition)
            }
        }

        fun bind() {
            val color = currentList[adapterPosition]

            with(binding) {
                ivColor.setColorFilter(ContextCompat.getColor(itemView.context, color.color))
                ivCheck.setImageResource(color.check)
            }
        }
    }
}