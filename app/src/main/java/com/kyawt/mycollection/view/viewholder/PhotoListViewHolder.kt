package com.kyawt.mycollection.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyawt.mycollection.service.model.photo.PhotoItem
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_home.view.*

class PhotoListViewHolder(itemView:View,
private val mClickListener: ClickListener) : RecyclerView.ViewHolder(itemView) {

    fun bind(photo:PhotoItem){
        Glide.with(itemView)
            .load(photo.urls.regular)
            .into(itemView.img_home)

        itemView.txt_user_name.text = photo.user.instagramUsername

        Glide.with(itemView)
            .load(photo.user.profileImage.small)
            .into(itemView.img_user)
        itemView.txt_like_no.text = photo.likes.toString()

        itemView.rootView.setOnClickListener {
            mClickListener.Onclick(photo)
        }

    }

    interface ClickListener{
        fun Onclick(photo: PhotoItem)
    }
}

