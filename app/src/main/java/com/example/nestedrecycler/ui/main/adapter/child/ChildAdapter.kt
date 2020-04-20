package com.example.nestedrecycler.ui.main.adapter.child

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecycler.R
import com.example.nestedrecycler.model.ChildNode
import com.example.nestedrecycler.ui.main.adapter.child.view_holder.ChildViewHolder
import com.squareup.picasso.Picasso

class ChildAdapter(
    private val context: Context,
    private val childItemList: List<ChildNode>,
    private val picasso: Picasso
): RecyclerView.Adapter<ChildViewHolder>(), ChildViewHolder.RootItemClickListener {

    private lateinit var rootItemClickListener: RootItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        return ChildViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.child_node_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return childItemList.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.setItem(context, childItemList[position], picasso)
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
            this.rootItemClickListener.onRootItemClicked(title)
    }
}