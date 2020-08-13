package com.kyawt.mycollection.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyawt.mycollection.R
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.view.adapter.PhotoListAdapter
import com.kyawt.mycollection.view.viewholder.PhotoListViewHolder
import com.kyawt.mycollection.viewmodel.PhotoListViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), PhotoListViewHolder.ClickListener {
    lateinit var photoListViewModel: PhotoListViewModel
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
            this.adapter = photoListAdapter
            this.layoutManager = viewManager
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        photoListViewModel.loadData()
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
    }

    override fun Onclick(photo: PhotoItem) {
        val targetFragment = PhotoDetailFragment.newInstance(photo)
        activity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, targetFragment)
            .commit()
    }

}