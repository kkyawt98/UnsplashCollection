package com.kyawt.mycollection.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyawt.mycollection.service.model.collectionItem.CollectionItem
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.service.repository.PhotoRepository
import kotlinx.coroutines.launch

class CollectionItemViewModel:ViewModel(){
    var collectionItemResult = MutableLiveData<CollectionItem>()
    private var photoRepository = PhotoRepository()
    var loading : MutableLiveData<Boolean> = MutableLiveData()
    fun setLoading() : LiveData<Boolean> = loading

    var collectionID : MutableLiveData<com.kyawt.mycollection.service.model.collection.CollectionItem> = MutableLiveData()

    val detailData : LiveData<com.kyawt.mycollection.service.model.collection.CollectionItem>
        get() = collectionID

    fun setID(collection : com.kyawt.mycollection.service.model.collection.CollectionItem){
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