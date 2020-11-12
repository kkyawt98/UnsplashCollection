package com.kyawt.mycollection.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyawt.mycollection.service.model.usersLiked.UsersLikedItem
import kotlinx.android.synthetic.main.item_home.view.*
import kotlinx.android.synthetic.main.item_photos.view.*

class LikesViewHolder (var v: View) : RecyclerView.ViewHolder(v){
    fun bind(users: UsersLikedItem) {
        Glide.with(v).load(users.urls.full).placeholder(android.R.drawable.progress_indeterminate_horizontal).error(android.R.drawable.stat_notify_error).into(v.img_home)

        itemView.txt_user_name.text = users.user.name

        Glide.with(v).load(users.user.profileImage.medium).placeholder(android.R.drawable.progress_indeterminate_horizontal).error(android.R.drawable.stat_notify_error).into(v.img_user)
    }
}