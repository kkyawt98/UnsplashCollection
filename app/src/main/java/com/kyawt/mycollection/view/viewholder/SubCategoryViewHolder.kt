package com.kyawt.mycollection.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyawt.mycollection.service.model.collection.CollectionItem
import com.kyawt.mycollection.service.model.collectionDetail.CollectionDetailItem
import com.kyawt.mycollection.view.exts.logd
import kotlinx.android.synthetic.main.fragment_category.view.*
import kotlinx.android.synthetic.main.subitem_category.view.*

class SubCategoryViewHolder(var v: View) : RecyclerView.ViewHolder(v) {

    fun bind(category: CollectionDetailItem) {
        Glide.with(v)
            .load(category.urls.regular)
            .into(v.img_sub_category)
    }
}