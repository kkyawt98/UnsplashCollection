package com.kyawt.mycollection.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyawt.mycollection.service.model.collection.CollectionItem
import com.kyawt.mycollection.service.model.detail.Detail
import com.kyawt.mycollection.service.model.detail.Exif
import com.kyawt.mycollection.service.model.photo.Photo
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.service.model.usersPhotos.UsersPhotosItem
import com.kyawt.mycollection.service.repository.PhotoRepository
import kotlinx.coroutines.launch
import java.io.IOException

class PhotoDetailViewModel(application: Application) : AndroidViewModel(application){
    var loading : MutableLiveData<Boolean> = MutableLiveData()
    fun getLoading() :LiveData<Boolean> = loading
    var photoID : MutableLiveData<PhotoItem> = MutableLiveData()
    val detailData : LiveData<PhotoItem>
    get() = photoID
    fun setID(detail : PhotoItem){
        photoID.value = detail
    }

    var photoDetail = MutableLiveData<Detail>()
    private var photoRepository : PhotoRepository = PhotoRepository()

    fun loadData(photoId :  String){
        loading.value = true
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