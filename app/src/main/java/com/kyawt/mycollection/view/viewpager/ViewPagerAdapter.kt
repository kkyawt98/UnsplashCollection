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

class TabsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int, var bundleUsername: Bundle) : FragmentStateAdapter(
    fm,
    lifecycle
) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                val bundle = Bundle()
                bundle.putString("fragmentName", "Photos")
                val photosFragment = PhotosFragment()
                photosFragment.arguments = bundleUsername
//                photosFragment.arguments = bundle
                return photosFragment
            }
            1 -> {
                val bundle = Bundle()
                bundle.putString("fragmentName", "Likes")
                val likesFragment = LikesFragment()
                likesFragment.arguments = bundleUsername
//                likesFragment.arguments = bundle
                return likesFragment
            }
            2 -> {
                val bundle = Bundle()
                bundle.putString("fragmentName", "Collections")
                val collectionsFragment = CollectionsFragment()
                collectionsFragment.arguments = bundleUsername
//                collectionsFragment.arguments = bundle
                return collectionsFragment
            }
            else -> return PhotosFragment()
        }
    }

    override fun getItemCount(): Int {
        return numberOfTabs
    }
}