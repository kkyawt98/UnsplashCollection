package com.kyawt.mycollection.view.ui

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kyawt.mycollection.R
import com.kyawt.mycollection.databinding.FragmentPhotoDetailBinding
import com.kyawt.mycollection.databinding.FragmentUserBinding
import com.kyawt.mycollection.service.model.users.Users
import com.kyawt.mycollection.service.model.usersLiked.UsersLikedItem
import com.kyawt.mycollection.service.model.usersPhotos.UsersPhotosItem
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.utils.ShimmerUtils
import com.kyawt.mycollection.view.viewholder.LikesViewHolder
import com.kyawt.mycollection.view.viewholder.PhotosViewHolder
import com.kyawt.mycollection.view.viewpager.TabsPagerAdapter
import com.kyawt.mycollection.viewmodel.PhotoDetailViewModel
import com.kyawt.mycollection.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_photo_detail.*
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : Fragment(), PhotosViewHolder.ClickListener,
    PhotosFragment.FragmentClickListener,
    LikesFragment.likeClickListener {
    lateinit var userViewModel: UserViewModel
    lateinit var viewBinding: FragmentUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)
        // Inflate the layout for this fragment
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        shimmerUserLayout.shimmer = ShimmerUtils.getGrayShimmer(context!!)
        // delay-auto-unveil
        Handler().postDelayed({
            shimmerUserLayout.unVeil()
        }, 3000)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            lifecycleOwner = this@UserFragment
            users = userViewModel
        }

        val username = arguments?.getString(Constant.Bundle_Username)
        username?.let { userViewModel.loadData(it) }

        username?.let { setupTabs(it) }
        onBackPressed()
    }

    private fun setupTabs(username: String) {
        val bundle = Bundle()
        bundle.putString(Constant.Bundle_Username, username)
        this.arguments = bundle

        // Tabs Customization
        tab_layout.setSelectedTabIndicatorColor(Color.WHITE)
//        tab_layout.tabTextColors = ContextCompat.getColorStateList(requireContext(), R.color.colorPrimary)
        tab_layout.setTabTextColors(Color.LTGRAY, Color.WHITE)
        val numberOfTabs = 3
        tab_layout.tabMode = TabLayout.MODE_SCROLLABLE
        // Set the ViewPager Adapter
        val adapter =
            TabsPagerAdapter(requireFragmentManager(), lifecycle, numberOfTabs, bundle, this, this)
        tabs_viewpager.adapter = adapter

        // Enable Swipe
        tabs_viewpager.isUserInputEnabled = true

        TabLayoutMediator(tab_layout, tabs_viewpager) { tab, position ->
            val photos = "Photos"
            val likes = "Likes"
            val collections = "Collections"
            when (position) {
                0 -> {
                    tab.text = photos
                }
                1 -> {
                    tab.text = likes
                }
                2 -> {
                    tab.text = collections
                }
            }
        }.attach()
    }

    private fun onBackPressed() {
        imgBack.setOnClickListener {
            findNavController().navigate(R.id.action_userFragment_to_homeFragment)
        }
    }

    override fun Onclick(photo: UsersPhotosItem) {
        var bundle = Bundle()
        bundle.putParcelable(Constant.Bundle_Key, photo)
        this.arguments = bundle

        findNavController().navigate(R.id.action_userFragment_to_userPhotosDetailFragment, bundle)
    }

    override fun fragmentClick(photo: UsersPhotosItem) {
        var bundle = Bundle()
        bundle.putParcelable(Constant.Bundle_Key, photo)
        this.arguments = bundle

        findNavController().navigate(R.id.action_userFragment_to_userPhotosDetailFragment, bundle)
    }

//    override fun Onclick(photo: UsersLikedItem) {
//        val bundle = Bundle()
//        bundle.putParcelable(Constant.Bundle_Likes, photo)
//        this.arguments = bundle
//        findNavController().navigate(R.id.action_userFragment_to_likedDetailFragment, bundle)
//    }

    override fun fragmentClick(photo: UsersLikedItem) {
        val bundle = Bundle()
        bundle.putParcelable(Constant.Bundle_Likes, photo)
        this.arguments = bundle
        findNavController().navigate(R.id.action_userFragment_to_likedDetailFragment, bundle)
    }

}