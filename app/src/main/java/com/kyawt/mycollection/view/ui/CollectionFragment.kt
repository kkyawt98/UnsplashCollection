package com.kyawt.mycollection.view.ui

import android.os.Bundle
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
import com.kyawt.mycollection.service.model.collection.CollectionItem
import com.kyawt.mycollection.view.adapter.CollectionAdapter
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.viewholder.CollectionViewHolder
import com.kyawt.mycollection.viewmodel.CollectionViewModel
import kotlinx.android.synthetic.main.fragment_collection.*

class CollectionFragment : Fragment(), CollectionViewHolder.ClickListener {

    lateinit var categoryViewModel: CollectionViewModel
    lateinit var collectionAdapter: CollectionAdapter
    lateinit var viewManager: LinearLayoutManager
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
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        categoryViewModel.loadData()
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
        categoryViewModel.loadData()
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