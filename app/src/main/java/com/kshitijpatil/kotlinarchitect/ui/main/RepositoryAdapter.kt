package com.kshitijpatil.kotlinarchitect.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kshitijpatil.kotlinarchitect.data.model.Repository
import com.kshitijpatil.kotlinarchitect.databinding.RvItemRepositoryBinding

class RepositoryAdapter(
    private var items: ArrayList<Repository>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvItemRepositoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position], listener)

    fun replaceData(list: ArrayList<Repository>) {
        items = list
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(private val binding: RvItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: Repository, listener: OnItemClickListener?) {
            binding.apply {
                repository = repo
                root.setOnClickListener { listener?.onItemClick(layoutPosition) }
                executePendingBindings()
            }
        }
    }
}