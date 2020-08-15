package com.kyawt.mycollection.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.mycollection.R
import com.kyawt.mycollection.service.model.collection.CollectionItem
import com.kyawt.mycollection.service.model.collectionDetail.CollectionDetailItem
import com.kyawt.mycollection.view.exts.bindView
import com.kyawt.mycollection.view.viewholder.SubCategoryViewHolder

class SubCategoryAdapter(var subList: List<CollectionDetailItem> = emptyList()) : RecyclerView.Adapter<SubCategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        return SubCategoryViewHolder(parent.context.bindView(R.layout.subitem_category,parent))
    }

    override fun getItemCount(): Int = subList.size

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        holder.bind(subList[position])
    }

    fun updateList(subList: List<CollectionDetailItem>){
        this.subList = subList
        notifyDataSetChanged()
    }
}