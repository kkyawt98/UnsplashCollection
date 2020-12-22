package com.kyawt.mycollection.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.kyawt.mycollection.service.model.collection.Collection
import com.kyawt.mycollection.service.model.photo.PhotoItem
import com.kyawt.mycollection.service.repository.PhotoRepository
import kotlinx.coroutines.launch

class CollectionViewModel() : ViewModel() {
    var collectionResult = MutableLiveData<Collection>()
    private var photoRepository = PhotoRepository()

    var loading : MutableLiveData<Boolean> = MutableLiveData()
    fun setLoading() : LiveData<Boolean> = loading

    var photoResult = MutableLiveData<PhotoItem>()

    fun loadData(page:Int,per_page:Int) {
        viewModelScope.launch {
            try {
                val result = photoRepository.getCategories(page,per_page)
                collectionResult.value = result
            }catch (e:Exception){
                Log.d("Collection", e.toString())
            }

        }
    }
}