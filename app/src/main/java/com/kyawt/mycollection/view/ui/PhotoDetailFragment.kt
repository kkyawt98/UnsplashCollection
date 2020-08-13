package com.kyawt.mycollection.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import com.kyawt.mycollection.R
import com.kyawt.mycollection.databinding.FragmentPhotoDetailBinding
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.view.constance.Constant
import com.kyawt.mycollection.viewmodel.PhotoDetailViewModel
import kotlinx.android.synthetic.main.appbar_layout.*
import java.util.zip.Inflater

class PhotoDetailFragment : Fragment() {
    lateinit var photoDetailViewModel: PhotoDetailViewModel
    lateinit var viewBinding : FragmentPhotoDetailBinding
    lateinit var homeFragment:HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        photoDetailViewModel = ViewModelProviders.of(this).get(PhotoDetailViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo_detail,container,false)
        // Inflate the layout for this fragment
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            lifecycleOwner = this@PhotoDetailFragment
            detail = photoDetailViewModel
        }

        val detail = arguments?.getParcelable<PhotoItem>(Constant.Bundle_Key)
        photoDetailViewModel.setID(detail!!)

        val photo_id = detail.id

        photoDetailViewModel.loadData(photo_id)

        appBarAction()
    }


    fun appBarAction(){

        txt_close.setOnClickListener {

            homeFragment = HomeFragment()
            activity!!.supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }
    }

    companion object{
        fun newInstance(photo: PhotoItem) = PhotoDetailFragment().also {
            val bundle = Bundle()
            bundle.putParcelable(Constant.Bundle_Key,photo)
            it.arguments = bundle
        }
    }

}