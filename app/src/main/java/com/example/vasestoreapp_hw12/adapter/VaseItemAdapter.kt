package com.example.vasestoreapp_hw12.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.vasestoreapp_hw12.databinding.VaseListItemBinding
import com.example.vasestoreapp_hw12.model.Vase

class VaseItemAdapter : ListAdapter<Vase, VaseItemAdapter.VaseItemViewHolder>(
    object : DiffUtil.ItemCallback<Vase>() {
        override fun areItemsTheSame(oldItem: Vase, newItem: Vase): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Vase, newItem: Vase): Boolean {
            return oldItem == newItem
        }

    }
) {

    var itemOnClick: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaseItemViewHolder {
        return VaseItemViewHolder(
            VaseListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: VaseItemViewHolder, position: Int) {
        holder.bind()
    }


    inner class VaseItemViewHolder(private val binding: VaseListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val vase = currentList[adapterPosition]

            with(binding) {
                ivListVase.setImageResource(vase.image)
                tvListVaseTitle.text = vase.title
                tvListVaseRating.text = vase.rating
                tvListVaseSoldCount.text = vase.soldCount

                "%.2f".format(vase.price).also {
                    tvListVasePrice.text = it
                }

                ivListVase.setOnClickListener {
                    itemOnClick?.invoke(vase.title)
                }
            }
        }
    }
}