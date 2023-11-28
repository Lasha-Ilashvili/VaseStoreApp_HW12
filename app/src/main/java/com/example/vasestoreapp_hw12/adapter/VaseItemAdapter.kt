package com.example.vasestoreapp_hw12.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.vasestoreapp_hw12.data.Datasource
import com.example.vasestoreapp_hw12.databinding.VaseListItemBinding
import com.example.vasestoreapp_hw12.model.Vase

class VaseItemAdapter : ListAdapter<Vase, VaseItemAdapter.VaseItemViewHolder>(VaseDiffUtil) {

    object VaseDiffUtil : DiffUtil.ItemCallback<Vase>() {
        override fun areItemsTheSame(oldItem: Vase, newItem: Vase): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Vase, newItem: Vase): Boolean {
            return oldItem == newItem
        }

    }

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

        private val vase = currentList[adapterPosition]

        init {
            binding.ivListVase.setOnClickListener {
                itemOnClick?.invoke(vase.title)
            }
        }

        fun bind() {
            with(binding) {
                ivListVase.setImageResource(vase.image)
                tvListVaseTitle.text = vase.title
                tvListVaseRating.text = vase.rating
                tvListVaseSoldCount.text = vase.soldCount
                Datasource.setPricePrecision(tvListVasePrice, vase.price)
            }
        }
    }
}