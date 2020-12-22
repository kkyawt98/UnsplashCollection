package com.kyawt.mycollection.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyawt.mycollection.R
import com.kyawt.mycollection.service.model.collection.CollectionItem
import com.kyawt.mycollection.view.adapter.CollectionAdapter
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.viewholder.CollectionViewHolder
import com.kyawt.mycollection.viewmodel.CollectionViewModel
import kotlinx.android.synthetic.main.fragment_collection.*
import kotlinx.android.synthetic.main.fragment_collection.loadingBar
import kotlinx.android.synthetic.main.fragment_collection.swipeRefresh
import kotlinx.android.synthetic.main.fragment_home.*

class CollectionFragment : Fragment(), CollectionViewHolder.ClickListener {

    lateinit var categoryViewModel: CollectionViewModel
    lateinit var collectionAdapter: CollectionAdapter
    lateinit var viewManager: LinearLayoutManager
    var page = 1
    var per_page = 30
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryViewModel = ViewModelProviders.of(this).get(CollectionViewModel::class.java)
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
            collectionAdapter = CollectionAdapter(this@CollectionFragment)
            viewManager = LinearLayoutManager(context)
            this.adapter = collectionAdapter
            this.layoutManager = viewManager
        }

        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing = false
            page++
            categoryViewModel.loadData(page, per_page)
        }

        scrollView.setOnScrollChangeListener { v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            if (v != null) {
                if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight){
                    loadingBar.visibility = View.VISIBLE
                    page++
                    categoryViewModel.loadData(page,per_page)
                }
            }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        categoryViewModel.loadData(page,per_page)
        observeViewModel()
    }

    private fun observeViewModel(){

        categoryViewModel.setLoading().observe(this, Observer {isLoading ->
           if (isLoading) View.VISIBLE else View.INVISIBLE
            loadingBar.visibility = View.VISIBLE
            recycler_collection.visibility = View.GONE

        })
        categoryViewModel.collectionResult.observe(this, Observer { isSuccess ->
            loadingBar.visibility = View.GONE
            recycler_collection.visibility = View.VISIBLE
            collectionAdapter.updateList(isSuccess)
        })
    }

    override fun onResume() {
        super.onResume()
        categoryViewModel.loadData(page,per_page)
    }

    override fun OnClick(photo: CollectionItem) {
        var bundle = Bundle()
        bundle.putParcelable(Constant.Bundle_Key,photo)
        this.arguments = bundle
        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.nav_default_enter_anim)
            .setExitAnim(R.anim.nav_default_exit_anim)
            .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
            .build()
        findNavController().navigate(R.id.action_collectionFragment_to_collectionItemsFragment,bundle,navOptions)
    }

}