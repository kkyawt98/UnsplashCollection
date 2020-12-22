package com.kyawt.mycollection.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyawt.mycollection.service.model.photo.Photo
import com.kyawt.mycollection.service.repository.PhotoRepository
import kotlinx.coroutines.launch
import java.util.*

class PhotoListViewModel(application: Application) : AndroidViewModel(application) {

    var loading : MutableLiveData<Boolean> = MutableLiveData()
    fun getLoading() :LiveData<Boolean> = loading


    var photoResult = MutableLiveData<Photo>()
    private var photoRepository : PhotoRepository = PhotoRepository()

    fun loadData(page :Int, per_page :Int){

        loading.value = true
            viewModelScope.launch {

                try {
                    val result = photoRepository.getPhotoList(page, per_page)
                    photoResult.value = result
                }catch (e:Exception){
                    Log.d("List", e.toString())
                }
            }


    }
}