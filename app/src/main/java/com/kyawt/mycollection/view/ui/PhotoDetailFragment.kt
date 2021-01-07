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
import com.kyawt.mycollection.databinding.FragmentPhotoDetailBinding
import com.kyawt.mycollection.service.model.collection.CollectionItem
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.service.model.usersLiked.UsersLikedItem
import com.kyawt.mycollection.service.model.usersPhotos.UsersPhotosItem
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.exts.logd
import com.kyawt.mycollection.view.utils.ShimmerUtils
import com.kyawt.mycollection.viewmodel.PhotoDetailViewModel
import kotlinx.android.synthetic.main.appbar_layout.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_photo_detail.*
import java.util.zip.Inflater

class PhotoDetailFragment : Fragment() {
    lateinit var photoDetailViewModel: PhotoDetailViewModel
    lateinit var viewBinding: FragmentPhotoDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        photoDetailViewModel = ViewModelProviders.of(this).get(PhotoDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_photo_detail, container, false)
        // Inflate the layout for this fragment
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        shimmerLayout.shimmer = ShimmerUtils.getGrayShimmer(context!!)
        // delay-auto-unveil
        Handler().postDelayed({
            shimmerLayout.unVeil()
        }, 3000)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            lifecycleOwner = this@PhotoDetailFragment
            detail = photoDetailViewModel
        }
//
            arguments?.getParcelable<PhotoItem>(Constant.Bundle_Key)?.let {
                photoDetailViewModel.setID(it)
                val photo_id = it.id
                photoDetailViewModel.loadData(photo_id)

                val username = it.user.username
                actions(username)
            }

        appBarAction()
    }


    private fun appBarAction() {
        txt_detail_close.setOnClickListener {
            findNavController().navigate(R.id.action_photoDetailFragment_to_homeFragment)
        }
    }

    private fun actions(username: String) {
        var bundle = Bundle()
        bundle.putString(Constant.Bundle_Username, username)
        this.arguments = bundle
        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.nav_default_enter_anim)
            .setExitAnim(R.anim.nav_default_exit_anim)
            .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
            .build()
        viewBinding.userLayout.setOnClickListener {
            findNavController().navigate(
                R.id.action_photoDetailFragment_to_userFragment,
                bundle,
                navOptions
            )
        }
    }

//    private fun observeViewModel() {
//        photoDetailViewModel.photoDetail.observe(this, Observer { isSuccess ->
//            loadingBar.visibility = View.GONE
//        })
//
//        photoDetailViewModel.getLoading().observe(this, Observer { isLoading ->
//            loadingBar.visibility = if (isLoading) View.VISIBLE else View.GONE
//            if (isLoading) {
//                loadingBar.visibility = View.VISIBLE
//            }
//        })
//    }

}