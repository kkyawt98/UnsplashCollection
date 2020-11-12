package com.kyawt.mycollection.view.ui

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyawt.mycollection.R
import com.kyawt.mycollection.view.adapter.CollectionsAdapter
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.exts.logd
import com.kyawt.mycollection.view.utils.ShimmerUtils
import com.kyawt.mycollection.viewmodel.CollectionsViewModel
import kotlinx.android.synthetic.main.fragment_collections.*
import kotlinx.android.synthetic.main.fragment_likes.*

class CollectionsFragment : Fragment() {
    lateinit var collectionsAdapter: CollectionsAdapter
    lateinit var viewManager: LinearLayoutManager
    lateinit var collectionsViewModel: CollectionsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        collectionsViewModel = ViewModelProviders.of(this).get(CollectionsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_collections, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username = arguments?.getString(Constant.Bundle_Username)
        logd("collections", username.toString())

        username?.let { collectionsViewModel.loadData(it) }
        setupRecycler()

        collectionsViewModel.collectionsResult.observe(this, Observer { result ->
            recyclerCollections.visibility = View.VISIBLE
            collectionsAdapter.updateList(result)
        })

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        shimmerCollectionsLayout.shimmer = ShimmerUtils.getGrayShimmer(context!!)
        recyclerCollections.shimmer = ShimmerUtils.getGrayShimmer(context!!)
        // delay-auto-unveil
        Handler().postDelayed({
            shimmerCollectionsLayout.unVeil()
            recyclerCollections.unVeil()
        }, 800)
    }

    private fun setupRecycler(){
        collectionsAdapter = CollectionsAdapter()
        viewManager = LinearLayoutManager(context)
        recyclerCollections.apply {
            this.visibility = View.VISIBLE
            this.setAdapter(collectionsAdapter)
            this.setLayoutManager(viewManager)
        }
        collectionsAdapter.notifyDataSetChanged()
    }

}