package com.kyawt.mycollection.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyawt.mycollection.R
import com.kyawt.mycollection.view.adapter.CollectionAdapter
import com.kyawt.mycollection.viewmodel.CategoriesViewModel
import com.kyawt.mycollection.viewmodel.SubCategoryViewModel
import kotlinx.android.synthetic.main.fragment_collection.*

class CollectionFragment : Fragment() {

    lateinit var categoryViewModel: CategoriesViewModel
    lateinit var collectionAdapter: CollectionAdapter
    lateinit var viewManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryViewModel = ViewModelProviders.of(this).get(CategoriesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_collection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_collection.apply {
            collectionAdapter = CollectionAdapter()
            viewManager = GridLayoutManager(context, 2)
            this.adapter = collectionAdapter
            this.layoutManager = viewManager
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        categoryViewModel.loadData()
        observeViewModel()
        buttons()
    }

    private fun buttons(){
        imgBack.setOnClickListener {
            findNavController().navigate(R.id.action_collectionFragment_to_homeFragment)
        }
    }

    private fun observeViewModel(){
        categoryViewModel.collectionResult.observe(this, Observer { isSuccess ->
            recycler_collection.visibility = View.VISIBLE
            collectionAdapter.updateList(isSuccess)
        })
    }

    override fun onResume() {
        super.onResume()
        categoryViewModel.loadData()
    }

}