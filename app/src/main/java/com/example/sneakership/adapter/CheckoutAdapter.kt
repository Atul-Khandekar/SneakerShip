package com.example.sneakership.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.sneakership.R
import com.example.sneakership.base.BaseAdapter
import com.example.sneakership.databinding.ItemCheckoutBinding
import com.example.sneakership.listener.ItemClickListener
import com.example.sneakership.model.local.CheckoutSneaker

class CheckoutAdapter : BaseAdapter<CheckoutSneaker>(CheckoutDiffUtil()) {

    open var btnClickListener: ItemClickListener<CheckoutSneaker>? = null

    class CheckoutDiffUtil : DiffUtil.ItemCallback<CheckoutSneaker>() {
        override fun areItemsTheSame(oldItem: CheckoutSneaker, newItem: CheckoutSneaker): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CheckoutSneaker, newItem: CheckoutSneaker
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_checkout
    }

    override fun setDataForItems(binding: ViewDataBinding, item: CheckoutSneaker, position: Int?) {
        super.setDataForItems(binding, item, position)
        (binding as ItemCheckoutBinding).apply {
            btnRemove.setOnClickListener {
                position?.let { it1 ->
                    btnClickListener?.onItemClick(
                        item, it1
                    )
                }
            }
        }
    }
}