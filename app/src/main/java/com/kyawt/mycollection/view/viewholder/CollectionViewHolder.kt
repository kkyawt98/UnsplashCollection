package com.kyawt.mycollection.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyawt.mycollection.service.model.collection.CollectionItem
import kotlinx.android.synthetic.main.item_collection.view.*

class CollectionViewHolder (var v:View) : RecyclerView.ViewHolder(v){
    fun bind(category: CollectionItem) {
        Glide.with(v)
            .load(category.coverPhoto?.urls?.regular)
            .into(v.img_collection)
    }
}