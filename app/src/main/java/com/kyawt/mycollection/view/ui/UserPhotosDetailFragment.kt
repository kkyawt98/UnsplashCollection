package com.kyawt.mycollection.view.ui

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.kyawt.mycollection.R
import com.kyawt.mycollection.databinding.FragmentPhotoDetailBinding
import com.kyawt.mycollection.databinding.FragmentUserPhotosDetailBinding
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.service.model.usersPhotos.UsersPhotosItem
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.utils.ShimmerUtils
import com.kyawt.mycollection.viewmodel.PhotoDetailViewModel
import com.kyawt.mycollection.viewmodel.PhotosViewModel
import com.kyawt.mycollection.viewmodel.UserPhotosDetailViewModel
import kotlinx.android.synthetic.main.appbar_layout.*
import kotlinx.android.synthetic.main.fragment_photo_detail.*
import kotlinx.android.synthetic.main.fragment_user_photos_detail.*

class UserPhotosDetailFragment : Fragment() {
    lateinit var userPhotosDetailViewModel: UserPhotosDetailViewModel
    lateinit var viewBinding: FragmentUserPhotosDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userPhotosDetailViewModel =
            ViewModelProviders.of(this).get(UserPhotosDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_user_photos_detail,
                container,
                false
            )
        // Inflate the layout for this fragment
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        shimmerPhotosLayout.shimmer = ShimmerUtils.getGrayShimmer(context!!)
        // delay-auto-unveil
        Handler().postDelayed({
            shimmerPhotosLayout.unVeil()
        }, 3000)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            lifecycleOwner = this@UserPhotosDetailFragment
            detail = userPhotosDetailViewModel
        }

        arguments?.getParcelable<UsersPhotosItem>(Constant.Bundle_Key)?.let {
            userPhotosDetailViewModel.setID(it)
            val photo_id = it.id
            userPhotosDetailViewModel.loadData(photo_id)
        }

        appBarAction()
    }

    private fun appBarAction() {
        txt_close.setOnClickListener {
            findNavController().navigate(R.id.action_userPhotosDetailFragment_to_homeFragment)
        }
    }

}