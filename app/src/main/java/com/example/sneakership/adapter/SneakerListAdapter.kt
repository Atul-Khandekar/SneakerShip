package com.example.sneakership.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.sneakership.R
import com.example.sneakership.base.BaseAdapter
import com.example.sneakership.databinding.ItemHomeBinding
import com.example.sneakership.listener.ItemClickListener
import com.example.sneakership.model.local.Sneaker

class SneakerListAdapter() : BaseAdapter<Sneaker>(SneakerDiffUtil()) {

    open var btnClickListener: ItemClickListener<Sneaker>? = null

    class SneakerDiffUtil : DiffUtil.ItemCallback<Sneaker>() {
        override fun areItemsTheSame(oldItem: Sneaker, newItem: Sneaker): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Sneaker, newItem: Sneaker): Boolean {
            return oldItem == newItem
        }

    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_home
    }

    override fun setDataForItems(binding: ViewDataBinding, item: Sneaker, position: Int?) {
        super.setDataForItems(binding, item, position)
        (binding as ItemHomeBinding).apply {
            btnAdd.setOnClickListener {
                position?.let {
                    btnClickListener?.onItemClick(item, it)
                }
            }
        }
    }
}