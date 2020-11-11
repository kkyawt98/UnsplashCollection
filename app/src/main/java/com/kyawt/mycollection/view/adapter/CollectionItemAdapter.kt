package com.kyawt.mycollection.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.mycollection.R
import com.kyawt.mycollection.service.model.collection.CollectionItem
import com.kyawt.mycollection.service.model.collectionItem.CollectionItemItem
import com.kyawt.mycollection.view.exts.bindView
import com.kyawt.mycollection.view.viewholder.CollectionItemViewHolder
import com.kyawt.mycollection.view.viewholder.CollectionViewHolder

class CollectionItemAdapter (private val  mClickListener : CollectionItemViewHolder.ClickListener,var collectionItemList: List<CollectionItemItem> = emptyList()) : RecyclerView.Adapter<CollectionItemViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionItemViewHolder {
        return CollectionItemViewHolder(parent.context.bindView(R.layout.item_home,parent),mClickListener)
    }

    override fun onBindViewHolder(holder: CollectionItemViewHolder, position: Int) = holder.bind(collectionItemList[position])

    override fun getItemCount(): Int = collectionItemList.size


    fun updateList(collectionItemList: List<CollectionItemItem>){
        this.collectionItemList = collectionItemList
        notifyDataSetChanged()
    }

}