package com.kyawt.mycollection.view.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.service.model.usersPhotos.UsersPhotosItem
import kotlinx.android.synthetic.main.item_photos.view.*

class PhotosViewHolder(
    var v: View,
    private val mClickListener: PhotosViewHolder.ClickListener
) : RecyclerView.ViewHolder(v) {

    fun bind(users: UsersPhotosItem) {
        Glide.with(v).load(users.urls.full)
            .placeholder(android.R.drawable.progress_indeterminate_horizontal)
            .error(android.R.drawable.stat_notify_error).into(v.imgPhotos)
        itemView.rootView.setOnClickListener {
            mClickListener.Onclick(users)
        }
    }

    interface ClickListener {
        fun Onclick(photo: UsersPhotosItem)
    }

}

//@GlideModule
//class AppNameGlideModule : AppGlideModule() {
//
//    override fun applyOptions(context: Context, builder: GlideBuilder) {
//        super.applyOptions(context, builder)
//        builder.apply {
//            RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).signature(
//                ObjectKey(System.currentTimeMillis().toShort())
//            )
//        }
//    }
//}
