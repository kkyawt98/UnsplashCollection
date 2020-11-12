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
import com.kyawt.mycollection.view.adapter.LikesAdapter
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.view.exts.logd
import com.kyawt.mycollection.view.utils.ShimmerUtils
import com.kyawt.mycollection.viewmodel.LikesViewModel
import kotlinx.android.synthetic.main.fragment_likes.*
import kotlinx.android.synthetic.main.fragment_photos.*

class LikesFragment : Fragment() {

    lateinit var likesAdapter: LikesAdapter
    lateinit var likesViewModel: LikesViewModel
    lateinit var viewManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        likesViewModel = ViewModelProviders.of(this).get(LikesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_likes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username = arguments?.getString(Constant.Bundle_Username)
        logd("likes", username.toString())
        if (username != null) {
            likesViewModel.loadData(username)
        }
        setupRecycler()

        likesViewModel.likesResult.observe(this, Observer { result ->
            recyclerLiked.visibility = View.VISIBLE
            likesAdapter.updateList(result)
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        shimmerLikedLayout.shimmer = ShimmerUtils.getGrayShimmer(context!!)
        recyclerLiked.shimmer = ShimmerUtils.getGrayShimmer(context!!)
        // delay-auto-unveil
        Handler().postDelayed({
            shimmerLikedLayout.unVeil()
            recyclerLiked.unVeil()
        }, 800)
    }

    private fun setupRecycler(){
        likesAdapter = LikesAdapter()
        viewManager = LinearLayoutManager(context)
        recyclerLiked.apply {
            this.visibility = View.VISIBLE
            this.setAdapter(likesAdapter)
            this.setLayoutManager(viewManager)
        }

        likesAdapter.notifyDataSetChanged()
    }
}