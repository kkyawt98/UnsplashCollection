package com.kyawt.mycollection.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyawt.mycollection.service.model.collection.CollectionItem
import kotlinx.android.synthetic.main.item_categories.view.*

class CategoryViewHolder(var v:View) : RecyclerView.ViewHolder(v) {

    fun bind(collection: CollectionItem){
        Glide.with(v)
            .load(collection.coverPhoto.urls.regular)
            .into(v.img_category)

        v.txt_categories.text = collection.title
    }
}