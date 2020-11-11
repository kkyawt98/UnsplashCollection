package com.kyawt.mycollection.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyawt.mycollection.service.model.detail.Detail
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.service.model.users.User
import com.kyawt.mycollection.service.model.users.Users
import com.kyawt.mycollection.service.repository.PhotoRepository
import kotlinx.coroutines.launch

class UserViewModel (application: Application) : AndroidViewModel(application){
    var username : MutableLiveData<User> = MutableLiveData()

    val detailData : LiveData<User>
        get() = username

    fun setID(detail : User){
        username.value = detail
    }

    var userDetail = MutableLiveData<Users>()
    private var photoRepository : PhotoRepository = PhotoRepository()

    fun loadData(username :  String){
        viewModelScope.launch {
            try {
                val result = photoRepository.getUser(username)
                userDetail.value = result
            }catch (e:Exception){
                Log.d("Detail", e.toString())
            }
        }

    }
}