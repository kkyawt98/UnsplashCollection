package com.kyawt.mycollection.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.mycollection.R
import com.kyawt.mycollection.service.model.collection.CollectionItem
import com.kyawt.mycollection.view.exts.bindView
import com.kyawt.mycollection.view.viewholder.CategoryViewHolder

class CategoryAdapter( private var mClickListener: CategoryViewHolder.subClickListener
    ,var collectionList:List<CollectionItem> = emptyList()): RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(parent.context.bindView(R.layout.item_categories,parent),mClickListener)
    }

    override fun getItemCount(): Int = collectionList.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(collectionList[position])
    }

    fun updateList(collectionList: List<CollectionItem>){
        this.collectionList = collectionList
        notifyDataSetChanged()
    }
}