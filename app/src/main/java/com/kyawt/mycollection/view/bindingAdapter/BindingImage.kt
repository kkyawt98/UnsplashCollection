package com.kyawt.mycollection.view.bindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("BindImage")
fun bindImage(imageView: ImageView, url: String?){
    if (url != null){
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }
}