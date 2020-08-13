package com.kyawt.mycollection.view.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.mycollection.R
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.view.exts.bindView
import com.kyawt.mycollection.view.viewholder.PhotoListViewHolder

class PhotoListAdapter(private val mClickListener: PhotoListViewHolder.ClickListener,
                       var photoList:List<PhotoItem> = emptyList()): RecyclerView.Adapter<PhotoListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoListViewHolder {
        return PhotoListViewHolder(parent.context.bindView(R.layout.item_home,parent), mClickListener)
    }

    override fun getItemCount(): Int = photoList.size

    override fun onBindViewHolder(holder: PhotoListViewHolder, position: Int) {
        holder.bind(photoList[position])
        Log.d("Photo", photoList.get(position).user.username)
    }

    fun updateList(photoList: List<PhotoItem>){
        this.photoList = photoList
        notifyDataSetChanged()
    }
}