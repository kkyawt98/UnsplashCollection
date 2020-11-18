package com.kyawt.mycollection.view.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.ui.CollectionsFragment
import com.kyawt.mycollection.view.ui.LikesFragment
import com.kyawt.mycollection.view.ui.PhotosFragment
import com.kyawt.mycollection.view.viewholder.LikesViewHolder
import com.kyawt.mycollection.view.viewholder.PhotosViewHolder

class TabsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int, var bundleUsername: Bundle, private val photoClickListener: PhotosFragment.FragmentClickListener, private val likeClickListener: LikesFragment.likeClickListener, private val collectionClickListener: CollectionsFragment.collectionsClickListener) : FragmentStateAdapter(
    fm,
    lifecycle
) {
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                val bundle = Bundle()
//                bundle.putString("fragmentName", "Photos")
                val photosFragment = PhotosFragment(photoClickListener)
                photosFragment.arguments = bundleUsername
//                photosFragment.arguments = bundle
                return photosFragment
            }
            1 -> {
                val bundle = Bundle()
//                bundle.putString(Constant.Bundle_Key, "Likes")
                val likesFragment = LikesFragment(likeClickListener)
                likesFragment.arguments = bundleUsername
//                likesFragment.arguments = bundle
                return likesFragment
            }
            2 -> {
                val bundle = Bundle()
//                bundle.putString("fragmentName", "Collections")
                val collectionsFragment = CollectionsFragment(collectionClickListener)
                collectionsFragment.arguments = bundleUsername
//                collectionsFragment.arguments = bundle
                return collectionsFragment
            }
            else -> return PhotosFragment(photoClickListener)
        }
    }

    override fun getItemCount(): Int {
        return numberOfTabs
    }
}