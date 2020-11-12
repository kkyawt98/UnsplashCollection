package com.kyawt.mycollection.view.ui

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyawt.mycollection.R
import com.kyawt.mycollection.view.adapter.PhotosAdapter
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.exts.logd
import com.kyawt.mycollection.view.utils.ShimmerUtils
import com.kyawt.mycollection.viewmodel.PhotosViewModel
import kotlinx.android.synthetic.main.fragment_photos.*

class PhotosFragment : Fragment() {
    lateinit var photosViewModel: PhotosViewModel
    lateinit var photosAdapter: PhotosAdapter
    lateinit var viewManager :LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photosViewModel = ViewModelProviders.of(this).get(PhotosViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        shimmerPhotoLayout.shimmer = ShimmerUtils.getGrayShimmer(context!!)
        recyclerPhotos.shimmer = ShimmerUtils.getGrayShimmer(context!!)
        // delay-auto-unveil
        Handler().postDelayed({
            shimmerPhotoLayout.unVeil()
            recyclerPhotos.unVeil()
        }, 800)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username = arguments?.getString(Constant.Bundle_Username)

        logd("bundle", username.toString())

        if (username != null) {
            photosViewModel.loadData(username)
        }

        setupRecycler()

        photosViewModel.photoResult.observe(this, Observer { result ->
            recyclerPhotos.visibility = View.VISIBLE
            photosAdapter.updateList(result)
        })
    }

    private fun setupRecycler(){
        photosAdapter = PhotosAdapter()
        recyclerPhotos.apply {
            viewManager = GridLayoutManager( context, 2)
            this.visibility = View.VISIBLE
            this.setAdapter(photosAdapter)
            this.setLayoutManager(viewManager)
        }
        photosAdapter.notifyDataSetChanged()
    }
}