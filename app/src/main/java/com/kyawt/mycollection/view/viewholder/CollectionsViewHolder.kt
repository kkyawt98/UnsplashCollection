package com.kyawt.mycollection.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyawt.mycollection.service.model.usersCollections.UsersCollectionsItem
import kotlinx.android.synthetic.main.item_collection.view.*
import kotlinx.android.synthetic.main.item_home.view.*

class CollectionsViewHolder (var v:View, private val mClickListener: CollectionsViewHolder.userCollectionsClickListener): RecyclerView.ViewHolder(v){
    fun bind(users: UsersCollectionsItem) {
        Glide.with(v).load(users.coverPhoto.urls.full)
            .placeholder(android.R.drawable.progress_indeterminate_horizontal)
            .error(android.R.drawable.stat_notify_error).into(v.img_collection)

        itemView.txtTitle.text = users.title
        itemView.rootView.setOnClickListener {
            mClickListener.collectionClick(users)
        }
    }

    interface userCollectionsClickListener{
        fun collectionClick(users: UsersCollectionsItem)
    }
}