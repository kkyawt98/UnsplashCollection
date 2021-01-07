package com.kyawt.mycollection.view.ui

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.kyawt.mycollection.R
import com.kyawt.mycollection.databinding.FragmentLikedDetailBinding
import com.kyawt.mycollection.databinding.FragmentPhotoDetailBinding
import com.kyawt.mycollection.service.model.usersLiked.UsersLikedItem
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.utils.ShimmerUtils
import com.kyawt.mycollection.viewmodel.LikedDetailViewModel
import com.kyawt.mycollection.viewmodel.PhotoDetailViewModel
import kotlinx.android.synthetic.main.appbar_layout.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_liked_detail.*
import kotlinx.android.synthetic.main.fragment_photo_detail.*

class LikedDetailFragment : Fragment() {
    lateinit var likedDetailViewModel: LikedDetailViewModel
    lateinit var viewBinding: FragmentLikedDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        likedDetailViewModel = ViewModelProviders.of(this).get(LikedDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_liked_detail, container, false)
        // Inflate the layout for this fragment
        return viewBinding.root
        // Inflate the layout for this fragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        shimmerLikedDetailLayout.shimmer = ShimmerUtils.getGrayShimmer(context!!)
        // delay-auto-unveil
        Handler().postDelayed({
            shimmerLikedDetailLayout?.unVeil()
        }, 3000)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            lifecycleOwner = this@LikedDetailFragment
            detail = likedDetailViewModel
        }


        arguments?.getParcelable<UsersLikedItem>(Constant.Bundle_Likes)?.let {
            val photosID = it.id
            photosID.let { ID ->
                likedDetailViewModel.loadData(ID)
                val username = it.user.username
                actions(username)
            }

        }
        appBarAction()
    }

    private fun appBarAction() {
        txt_like_close.setOnClickListener {
            findNavController().navigate(R.id.action_likedDetailFragment_to_homeFragment)
//
        }
    }

    private fun actions(username: String) {
        val bundle = Bundle()
        bundle.putString(Constant.Bundle_Username, username)
        this.arguments = bundle
        viewBinding.userLayout.setOnClickListener {
            findNavController().navigate(
                R.id.action_likedDetailFragment_to_userFragment,
                bundle
            )
        }
    }

}