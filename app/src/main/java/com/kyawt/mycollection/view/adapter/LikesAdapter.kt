package com.kyawt.mycollection.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.mycollection.R
import com.kyawt.mycollection.service.model.usersLiked.UsersLikedItem
import com.kyawt.mycollection.view.exts.bindView
import com.kyawt.mycollection.view.viewholder.LikesViewHolder
import com.kyawt.mycollection.view.viewholder.PhotoListViewHolder

class LikesAdapter(
    private val mClickListener: LikesViewHolder.ClickListener,
    var likesList: List<UsersLikedItem> = emptyList()
) : RecyclerView.Adapter<LikesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikesViewHolder {
        return LikesViewHolder(parent.context.bindView(R.layout.item_home, parent),mClickListener)
    }

    override fun onBindViewHolder(holder: LikesViewHolder, position: Int) =
        holder.bind(likesList[position])

    override fun getItemCount(): Int = likesList.size

    fun updateList(likesList: List<UsersLikedItem>) {
        this.likesList = likesList
        notifyDataSetChanged()
    }
}