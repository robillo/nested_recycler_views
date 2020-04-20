package com.example.nestedrecycler.ui.main.adapter.root

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecycler.R
import com.example.nestedrecycler.model.RootNode
import com.example.nestedrecycler.ui.main.adapter.root.view_holder.RootViewHolder

class RootAdapter(private val rootItemList: List<RootNode>):
    RecyclerView.Adapter<RootViewHolder>(), RootViewHolder.RootItemClickListener {

    private lateinit var rootItemClickListener: RootItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RootViewHolder {
        return RootViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.root_node_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return rootItemList.size
    }

    override fun onBindViewHolder(holder: RootViewHolder, position: Int) {
        holder.setItem(rootItemList[position])
        holder.setRootItemClickListener(this)
    }

    fun setRootItemClickListener(rootItemClickListener: RootItemClickListener) {
        this.rootItemClickListener = rootItemClickListener
    }

    interface RootItemClickListener {
        fun onRootItemClicked(title: String)
    }

    override fun onRootItemClicked(title: String) {
        if(::rootItemClickListener.isInitialized)
            rootItemClickListener.onRootItemClicked(title)
    }
}