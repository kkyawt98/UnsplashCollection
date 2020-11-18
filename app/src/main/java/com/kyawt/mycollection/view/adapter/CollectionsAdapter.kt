package com.kyawt.mycollection.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.mycollection.R
import com.kyawt.mycollection.service.model.usersCollections.UsersCollectionsItem
import com.kyawt.mycollection.view.exts.bindView
import com.kyawt.mycollection.view.viewholder.CollectionsViewHolder
import com.kyawt.mycollection.view.viewholder.PhotosViewHolder

class CollectionsAdapter (private val mClickListener: CollectionsViewHolder.userCollectionsClickListener,var collectionsList: List<UsersCollectionsItem> = emptyList()) : RecyclerView.Adapter<CollectionsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionsViewHolder {
        return CollectionsViewHolder(parent.context.bindView(R.layout.item_collection, parent), mClickListener)
    }

    override fun onBindViewHolder(holder: CollectionsViewHolder, position: Int) = holder.bind(collectionsList[position])

    override fun getItemCount(): Int = collectionsList.size

    fun updateList(collectionsList: List<UsersCollectionsItem>){
        this.collectionsList = collectionsList
        notifyDataSetChanged()
    }
}