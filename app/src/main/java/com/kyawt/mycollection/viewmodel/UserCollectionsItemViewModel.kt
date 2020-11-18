package com.kyawt.mycollection.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyawt.mycollection.service.model.collectionItem.CollectionItem
import com.kyawt.mycollection.service.model.usersCollections.UsersCollectionsItem
import com.kyawt.mycollection.service.repository.PhotoRepository
import kotlinx.coroutines.launch

class UserCollectionsItemViewModel (application: Application): AndroidViewModel(application){
    var collectionItemResult = MutableLiveData<CollectionItem>()
    private var photoRepository = PhotoRepository()
    var loading : MutableLiveData<Boolean> = MutableLiveData()
    fun setLoading() : LiveData<Boolean> = loading

    var collectionID : MutableLiveData<UsersCollectionsItem> = MutableLiveData()

    val detailData : LiveData<UsersCollectionsItem>
        get() = collectionID

    fun setID(collection : UsersCollectionsItem){
        collectionID.value = collection
    }

    fun loadData(collectionId:String) {
        viewModelScope.launch {
            try {
                val result = photoRepository.getCollectionItem(collectionId)
                collectionItemResult.value = result
            }catch (e:Exception){
                Log.d("Collection's Items", e.toString())
            }

        }
    }
}