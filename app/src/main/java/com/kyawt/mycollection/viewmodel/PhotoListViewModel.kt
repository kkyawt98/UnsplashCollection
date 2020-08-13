package com.kyawt.mycollection.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyawt.mycollection.service.model.photo.Photo
import com.kyawt.mycollection.service.repository.PhotoRepository
import kotlinx.coroutines.launch

class PhotoListViewModel(application: Application) : AndroidViewModel(application) {

    var loading : MutableLiveData<Boolean> = MutableLiveData()
    fun getLoading() :LiveData<Boolean> = loading

    var photoResult = MutableLiveData<Photo>()
    private var photoRepository : PhotoRepository = PhotoRepository()
    fun loadData(){
        loading.value = true
        viewModelScope.launch {
            val result = photoRepository.getPhotoList()
            photoResult.value = result
        }
    }
}