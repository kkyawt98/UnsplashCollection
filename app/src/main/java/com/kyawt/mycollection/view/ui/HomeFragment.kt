package com.kyawt.mycollection.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyawt.mycollection.R
import com.kyawt.mycollection.service.model.collection.CollectionItem
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.view.adapter.CategoryAdapter
import com.kyawt.mycollection.view.adapter.PhotoListAdapter
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.viewholder.CategoryViewHolder
import com.kyawt.mycollection.view.viewholder.PhotoListViewHolder
import com.kyawt.mycollection.viewmodel.CategoriesViewModel
import com.kyawt.mycollection.viewmodel.PhotoListViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), PhotoListViewHolder.ClickListener, CategoryViewHolder.subClickListener {
    lateinit var photoListViewModel: PhotoListViewModel
    private var categoriesViewModel: CategoriesViewModel = CategoriesViewModel()
    lateinit var categoryAdapter: CategoryAdapter
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

        recycler_category.apply {
            categoryAdapter =  CategoryAdapter(this@HomeFragment)
            viewManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            this.adapter = categoryAdapter
            this.layoutManager = viewManager
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        photoListViewModel.loadData()
        categoriesViewModel.loadData()
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

        categoriesViewModel.collectionResult.observe(this, Observer { isSuccess ->
            recycler_category.visibility = View.VISIBLE
            categoryAdapter.updateList(isSuccess)
        })

        photoListViewModel.loadData()
        categoriesViewModel.loadData()
    }

    override fun onResume() {
        super.onResume()
        photoListViewModel.loadData()
        categoriesViewModel.loadData()
    }

    override fun Onclick(photo: PhotoItem) {
        var bundle = Bundle()
        bundle.putParcelable(Constant.Bundle_Key,photo)
        this.arguments = bundle
        findNavController().navigate(R.id.action_homeFragment_to_photoDetailFragment,bundle)

    }

    override fun onItemClick(category: CollectionItem) {

        var bundle = Bundle()
        bundle.putParcelable(Constant.Bundle_Category_Key, category)
        this.arguments = bundle
        findNavController().navigate(R.id.action_homeFragment_to_categoryFragment,bundle)
    }

}