package com.kyawt.mycollection.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyawt.mycollection.service.model.usersCollections.UsersCollections
import com.kyawt.mycollection.service.repository.PhotoRepository
import com.kyawt.mycollection.view.exts.logd
import kotlinx.coroutines.launch

class CollectionsViewModel (application: Application) : AndroidViewModel(application){
    var collectionsResult = MutableLiveData<UsersCollections>()
    private var photoRepository : PhotoRepository = PhotoRepository()
    fun loadData(username : String){
        viewModelScope.launch {
            try {
                val result = photoRepository.getUserCollections(username)
                collectionsResult.value = result
                logd("Collections", result.toString())
            }catch (e:Exception){
                Log.d("List", e.toString())
            }

        }
    }
}