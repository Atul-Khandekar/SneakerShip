package com.example.sneakership.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.sneakership.R
import com.example.sneakership.base.BaseAdapter
import com.example.sneakership.model.local.CheckoutList
import com.example.sneakership.model.local.CheckoutSneaker

class CheckoutAdapter : BaseAdapter<CheckoutList>(CheckoutDiffUtil()) {

    class CheckoutDiffUtil : DiffUtil.ItemCallback<CheckoutList>() {
        override fun areItemsTheSame(oldItem: CheckoutList, newItem: CheckoutList): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CheckoutList, newItem: CheckoutList
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_checkout
    }
}