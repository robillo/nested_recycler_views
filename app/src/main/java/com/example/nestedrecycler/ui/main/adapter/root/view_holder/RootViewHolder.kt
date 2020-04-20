package com.example.nestedrecycler.ui.main.adapter.root.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecycler.model.RootNode
import kotlinx.android.synthetic.main.root_node_layout.view.*

class RootViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var rootItemClickListener: RootItemClickListener

    fun setItem(rootNode: RootNode) {
        itemView.titleTv.text = rootNode.title
        setClickListeners(rootNode.title)
    }

    private fun setClickListeners(title: String) {
        itemView.setOnClickListener {
            if(::rootItemClickListener.isInitialized)
                rootItemClickListener.onRootItemClicked(title)
        }
    }

    fun setRootItemClickListener(rootItemClickListener: RootItemClickListener) {
        this.rootItemClickListener = rootItemClickListener
    }

    interface RootItemClickListener {
        fun onRootItemClicked(title: String)
    }
}