package com.kyawt.mycollection.view.ui

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyawt.mycollection.R
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.view.adapter.PhotoListAdapter
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.utils.ShimmerUtils
import com.kyawt.mycollection.view.viewholder.PhotoListViewHolder
import com.kyawt.mycollection.viewmodel.CollectionViewModel
import com.kyawt.mycollection.viewmodel.PhotoListViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_photo_detail.*

class HomeFragment : Fragment(), PhotoListViewHolder.ClickListener{
    lateinit var photoListViewModel: PhotoListViewModel
    private var collectionViewModel: CollectionViewModel = CollectionViewModel()
    lateinit var photoListAdapter: PhotoListAdapter
    lateinit var viewManager:LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photoListViewModel = ViewModelProviders.of(this).get(PhotoListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_photo.apply {
            photoListAdapter = PhotoListAdapter(this@HomeFragment)
            viewManager = LinearLayoutManager(context)
            this.visibility = View.VISIBLE
            this.adapter = photoListAdapter
            this.layoutManager = viewManager
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        photoListViewModel.loadData()
        collectionViewModel.loadData()
        observeViewModel()
    }

    fun observeViewModel(){
        photoListViewModel.photoResult.observe(this, Observer { isSuccess ->
            loadingBar.visibility = View.GONE
            recycler_photo.visibility = View.VISIBLE
            photoListAdapter.updateList(isSuccess)
        })

        photoListViewModel.getLoading().observe(this, Observer { isLoading ->
            loadingBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            if (isLoading){
                loadingBar.visibility = View.VISIBLE
                recycler_photo.visibility = View.INVISIBLE
            }
        })
        photoListViewModel.loadData()
    }

    override fun onResume() {
        super.onResume()
        photoListViewModel.loadData()
//        categoriesViewModel.loadData()
    }

    override fun Onclick(photo: PhotoItem) {
        var bundle = Bundle()
        bundle.putParcelable(Constant.Bundle_Key,photo)
        this.arguments = bundle
        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.nav_default_enter_anim)
            .setExitAnim(R.anim.nav_default_exit_anim)
            .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
            .build()
        findNavController().navigate(R.id.action_homeFragment_to_photoDetailFragment,bundle,navOptions)

    }

}