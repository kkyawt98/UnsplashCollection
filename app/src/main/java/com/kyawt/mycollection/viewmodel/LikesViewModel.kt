package com.kyawt.mycollection.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyawt.mycollection.service.model.usersLiked.UsersLiked
import com.kyawt.mycollection.service.model.usersPhotos.UsersPhotos
import com.kyawt.mycollection.service.repository.PhotoRepository
import kotlinx.coroutines.launch

class LikesViewModel (application: Application) : AndroidViewModel(application){
    var likesResult = MutableLiveData<UsersLiked>()
    private var photoRepository : PhotoRepository = PhotoRepository()
    fun loadData(username : String){
        viewModelScope.launch {
            try {
                val result = photoRepository.getUserLikes(username)
                likesResult.value = result
            }catch (e:Exception){
                Log.d("List", e.toString())
            }

        }
    }
}