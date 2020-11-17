package com.kyawt.mycollection.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyawt.mycollection.service.model.detail.Detail
import com.kyawt.mycollection.service.model.usersLiked.UsersLikedItem
import com.kyawt.mycollection.service.model.usersPhotos.UsersPhotosItem
import com.kyawt.mycollection.service.repository.PhotoRepository
import kotlinx.coroutines.launch

class UserPhotosDetailViewModel (application: Application) : AndroidViewModel(application){
    var photoID : MutableLiveData<UsersPhotosItem> = MutableLiveData()

    val detailData : LiveData<UsersPhotosItem>
        get() = photoID

    fun setID(detail : UsersPhotosItem){
        photoID.value = detail
    }

    var photoDetail = MutableLiveData<Detail>()
    private var photoRepository : PhotoRepository = PhotoRepository()

    fun loadData(photoId :  String){
        viewModelScope.launch {
            try {
                val result = photoRepository.getPhotoDetail(photoId)
                photoDetail.value = result
            }catch (e:Exception){
                Log.d("Detail", e.toString())
            }
        }

    }
}