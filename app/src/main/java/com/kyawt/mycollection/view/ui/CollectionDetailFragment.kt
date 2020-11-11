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
import com.kyawt.mycollection.databinding.FragmentCollectionDetailBinding
import com.kyawt.mycollection.databinding.FragmentPhotoDetailBinding
import com.kyawt.mycollection.service.model.collectionItem.CollectionItemItem
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.utils.ShimmerUtils
import com.kyawt.mycollection.viewmodel.CollectionDetailViewModel
import com.kyawt.mycollection.viewmodel.PhotoDetailViewModel
import kotlinx.android.synthetic.main.fragment_collection_detail.*
import kotlinx.android.synthetic.main.fragment_collection_detail.shimmerLayout
import kotlinx.android.synthetic.main.fragment_collection_items.*
import kotlinx.android.synthetic.main.fragment_photo_detail.*

class CollectionDetailFragment : Fragment() {
    lateinit var collectionDetailViewModel: CollectionDetailViewModel
    lateinit var viewBinding: FragmentCollectionDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        collectionDetailViewModel = ViewModelProviders.of(this).get(CollectionDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_collection_detail, container, false)
        // Inflate the layout for this fragment
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        shimmerLayout.shimmer = ShimmerUtils.getGrayShimmer(context!!)
        // delay-auto-unveil
        Handler().postDelayed({
            shimmerLayout.unVeil()
        }, 800)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            lifecycleOwner = this@CollectionDetailFragment
            detail = collectionDetailViewModel
        }

        val collectionItem = arguments?.getParcelable<CollectionItemItem>(Constant.Bundle_Collection_Key)
        collectionDetailViewModel.setID(collectionItem!!)

        val photo_id = collectionItem.id
        collectionDetailViewModel.loadData(photo_id)
        onBackPressed()
    }

    private fun onBackPressed(){
        imgBack.setOnClickListener {
            findNavController().navigate(R.id.action_collectionDetailFragment_to_collectionFragment)
        }
    }
}