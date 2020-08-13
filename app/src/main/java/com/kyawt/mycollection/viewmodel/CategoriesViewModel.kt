package com.kyawt.mycollection.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyawt.mycollection.service.model.collection.Collection
import com.kyawt.mycollection.service.repository.PhotoRepository
import kotlinx.coroutines.launch

class CategoriesViewModel() : ViewModel() {
    var collectionResult = MutableLiveData<Collection>()
    private var photoRepository = PhotoRepository()

    fun loadData(){
        viewModelScope.launch {
            val result = photoRepository.getCategories()
            collectionResult.value = result
        }
    }
}