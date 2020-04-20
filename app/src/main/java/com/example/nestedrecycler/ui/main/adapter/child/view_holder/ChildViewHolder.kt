package com.example.nestedrecycler.ui.main.adapter.child.view_holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecycler.model.ChildNode
import com.example.nestedrecycler.ui.main.adapter.root.RootAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.child_node_layout.view.*

class ChildViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), RootAdapter.RootItemClickListener {

    private lateinit var rootItemClickListener: RootItemClickListener

    fun setItem(
        context: Context,
        childNode: ChildNode,
        picasso: Picasso
    ) {
        itemView.headerTv.text = childNode.header
        setRootRecyclerView(context, childNode, picasso)
    }

    private fun setRootRecyclerView(
        context: Context,
        childNode: ChildNode,
        picasso: Picasso
    ) {
        itemView.rootRecyclerView.setHasFixedSize(true)
        itemView.rootRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val adapter = RootAdapter(childNode.rootNodeList, picasso)
        adapter.setRootItemClickListener(this)
        itemView.rootRecyclerView.adapter = adapter
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