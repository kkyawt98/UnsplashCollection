package com.kyawt.mycollection.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyawt.mycollection.service.model.collection.CollectionItem
import com.kyawt.mycollection.service.model.collectionItem.CollectionItemItem
import kotlinx.android.synthetic.main.fragment_collection_items.view.*
import kotlinx.android.synthetic.main.item_collection.view.*
import kotlinx.android.synthetic.main.item_home.view.*

class CollectionItemViewHolder(
    var v: View,
    private val mClickListener: CollectionItemViewHolder.ClickListener
) : RecyclerView.ViewHolder(v) {
    fun bind(collectionItem: CollectionItemItem) {
        Glide.with(v)
            .load(collectionItem.urls.regular)
            .into(v.img_home)

        itemView.txt_user_name.text = collectionItem.user.name

        Glide.with(itemView)
            .load(collectionItem.user.profileImage.medium)
            .into(itemView.img_user)

        itemView.rootView.setOnClickListener {
            mClickListener.OnClick(collectionItem)
        }
    }

    interface ClickListener {
        fun OnClick(collectionItem: CollectionItemItem)
    }

}