package com.kyawt.mycollection.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyawt.mycollection.service.model.detail.Detail
import com.kyawt.mycollection.service.model.detail.Exif
import com.kyawt.mycollection.service.model.photo.Photo
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.service.repository.PhotoRepository
import kotlinx.coroutines.launch

class PhotoDetailViewModel(application: Application) : AndroidViewModel(application){
    var photoID : MutableLiveData<PhotoItem> = MutableLiveData()
    val detailData : LiveData<PhotoItem>
    get() = photoID

    fun setID(detail : PhotoItem){
        photoID.value = detail
    }

    var photoDetail = MutableLiveData<Detail>()
    private var photoRepository : PhotoRepository = PhotoRepository()
    fun loadData(movie_id :  String){
        viewModelScope.launch {
            val result = photoRepository.getPhotoDetail(movie_id)
            photoDetail.value = result
        }
    }


}