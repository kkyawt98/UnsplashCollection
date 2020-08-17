package com.kyawt.mycollection.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyawt.mycollection.R
import com.kyawt.mycollection.databinding.FragmentCategoryBinding
import com.kyawt.mycollection.service.model.collection.CollectionItem
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.view.adapter.SubCategoryAdapter
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.exts.logd
import com.kyawt.mycollection.view.viewholder.CategoryViewHolder
import com.kyawt.mycollection.viewmodel.SubCategoryViewModel
import kotlinx.android.synthetic.main.fragment_category.*
import java.util.zip.Inflater

class CategoryFragment : Fragment(){

    lateinit var subCategoriesViewModel: SubCategoryViewModel
    lateinit var subCategoryAdapter: SubCategoryAdapter
    lateinit var viewManager: LinearLayoutManager
    private lateinit var viewBinding :FragmentCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subCategoriesViewModel = ViewModelProviders.of(this).get(SubCategoryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_category, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.apply {
            lifecycleOwner = this@CategoryFragment
            category = subCategoriesViewModel
        }
        recycler_sub_category.apply {
            subCategoryAdapter = SubCategoryAdapter()
            viewManager = GridLayoutManager(context,2)
            this.adapter = subCategoryAdapter
            this.layoutManager = viewManager
        }

        val detail = arguments?.getParcelable<CollectionItem>(Constant.Bundle_Category_Key)
        subCategoriesViewModel.setCategoryID(detail!!)

        subCategoriesViewModel.loadData(detail.id)
        observeViewModel()
        buttons()

    }

    private fun buttons(){
        imgBack.setOnClickListener {
            findNavController().navigate(R.id.action_categoryFragment_to_homeFragment)
        }
    }

    fun observeViewModel(){
        subCategoriesViewModel.getLoading().observe(this, Observer { isLoading ->
            loadingBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            if (isLoading){
                loadingBar.visibility = View.VISIBLE
                recycler_sub_category.visibility = View.GONE
            }
        })

        subCategoriesViewModel.subCategoryResult.observe(this, Observer { isSuccess ->
            loadingBar.visibility = View.GONE
            recycler_sub_category.visibility = View.VISIBLE
            subCategoryAdapter.updateList(isSuccess)
        })
    }

}