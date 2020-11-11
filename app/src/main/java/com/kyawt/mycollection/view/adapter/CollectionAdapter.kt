package com.kyawt.mycollection.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.mycollection.R
import com.kyawt.mycollection.service.model.collection.CollectionItem
import com.kyawt.mycollection.view.exts.bindView
import com.kyawt.mycollection.view.viewholder.CollectionViewHolder

class CollectionAdapter(private val  mClickListener : CollectionViewHolder.ClickListener, var collectionList: List<CollectionItem> = emptyList()): RecyclerView.Adapter<CollectionViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        return CollectionViewHolder(parent.context.bindView(R.layout.item_collection,parent), mClickListener)
    }

    override fun getItemCount(): Int = collectionList.size

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.bind(collectionList[position])
    }

    fun updateList(collectionList: List<CollectionItem>){
        this.collectionList = collectionList
        notifyDataSetChanged()
    }

}