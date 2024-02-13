package com.example.sneakership.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sneakership.BR
import com.example.sneakership.listener.ItemClickListener
import com.example.sneakership.model.local.Sneaker


abstract class BaseAdapter<T>(diffUtil: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, BaseAdapter<T>.BaseViewHolder>(diffUtil) {

    open var itemClickListener: ItemClickListener<T>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    open fun setDataForItems(binding: ViewDataBinding, item: T, position: Int?=null ) {
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }

    open inner class BaseViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                itemClickListener?.onItemClick(getItem(adapterPosition), adapterPosition)

            }
        }

        fun bind(item: T) {
            setDataForItems(binding, item, adapterPosition)
        }
    }

}