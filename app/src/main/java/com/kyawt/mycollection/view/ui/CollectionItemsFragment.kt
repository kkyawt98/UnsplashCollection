package com.kyawt.mycollection.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyawt.mycollection.R
import com.kyawt.mycollection.databinding.FragmentCollectionItemsBinding
import com.kyawt.mycollection.databinding.FragmentPhotoDetailBinding
import com.kyawt.mycollection.service.model.collection.Collection
import com.kyawt.mycollection.service.model.collection.CollectionItem
import com.kyawt.mycollection.service.model.collectionItem.CollectionItemItem
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.view.adapter.CollectionAdapter
import com.kyawt.mycollection.view.adapter.CollectionItemAdapter
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.viewholder.CollectionItemViewHolder
import com.kyawt.mycollection.viewmodel.CollectionItemViewModel
import kotlinx.android.synthetic.main.fragment_collection.*
import kotlinx.android.synthetic.main.fragment_collection_items.*
import kotlinx.android.synthetic.main.fragment_collection_items.loadingBar

class CollectionItemsFragment : Fragment(), CollectionItemViewHolder.ClickListener {
    lateinit var collectionItemViewModel: CollectionItemViewModel
    lateinit var collectionItemAdapter: CollectionItemAdapter
    lateinit var viewManager: LinearLayoutManager
    lateinit var viewBinding: FragmentCollectionItemsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        collectionItemViewModel = ViewModelProviders.of(this).get(CollectionItemViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_collection_items, container, false)
        // Inflate the layout for this fragment
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.apply {
            lifecycleOwner = this@CollectionItemsFragment
            collection = collectionItemViewModel
        }

        observeViewModel()
        val collectionItem = arguments?.getParcelable<CollectionItem>(Constant.Bundle_Key)
        collectionItemViewModel.setID(collectionItem!!)
        var colletionId = collectionItem.id
        collectionItemViewModel.loadData(colletionId)
        setupRecycler()
        onBackPressed()
    }

    private fun setupRecycler(){
        recyclerCollectionItem.apply {
            collectionItemAdapter = CollectionItemAdapter(this@CollectionItemsFragment)
            viewManager = LinearLayoutManager(context)
            this.adapter = collectionItemAdapter
            this.layoutManager = viewManager
        }
    }

    private fun onBackPressed(){
        icBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun observeViewModel(){

        collectionItemViewModel.setLoading().observe(this, Observer {isLoading ->
            if (isLoading) View.VISIBLE else View.INVISIBLE
            loadingBar.visibility = View.VISIBLE
            recyclerCollectionItem.visibility = View.GONE

        })
        collectionItemViewModel.collectionItemResult.observe(this, Observer { isSuccess ->
            loadingBar.visibility = View.GONE
            recyclerCollectionItem.visibility = View.VISIBLE
            collectionItemAdapter.updateList(isSuccess)
        })
    }

    override fun OnClick(collectionItem: CollectionItemItem) {
        val bundle = Bundle()
        bundle.putParcelable(Constant.Bundle_Collection_Key,collectionItem)
        this.arguments = bundle
        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.nav_default_enter_anim)
            .setExitAnim(R.anim.nav_default_exit_anim)
            .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
            .build()
        findNavController().navigate(R.id.action_collectionItemsFragment_to_collectionDetailFragment,bundle,navOptions)
    }

}