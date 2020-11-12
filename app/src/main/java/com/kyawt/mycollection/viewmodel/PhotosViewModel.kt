package com.kyawt.mycollection.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyawt.mycollection.service.repository.PhotoRepository
import com.kyawt.mycollection.service.usersPhotos.UsersPhotos
import kotlinx.coroutines.launch

class PhotosViewModel (application: Application) : AndroidViewModel(application){
    var photoResult = MutableLiveData<UsersPhotos>()
    private var photoRepository : PhotoRepository = PhotoRepository()
    fun loadData(username : String){
        viewModelScope.launch {
            try {
                val result = photoRepository.getUserPhotos(username)
                photoResult.value = result
            }catch (e:Exception){
                Log.d("List", e.toString())
            }

        }
    }
}