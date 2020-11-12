package com.kyawt.mycollection.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.mycollection.R
import com.kyawt.mycollection.service.usersPhotos.UsersPhotosItem
import com.kyawt.mycollection.view.exts.bindView
import com.kyawt.mycollection.view.exts.logd
import com.kyawt.mycollection.view.viewholder.PhotosViewHolder

class PhotosAdapter(var photosList: List<UsersPhotosItem> = emptyList()) :
    RecyclerView.Adapter<PhotosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(parent.context.bindView(R.layout.item_photos, parent))
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(photosList[position])
        logd("Photos", photosList[position].urls.full)
    }

    override fun getItemCount(): Int = photosList.size

    fun updateList(photosList: List<UsersPhotosItem>) {
        this.photosList = photosList
        notifyDataSetChanged()
    }
}