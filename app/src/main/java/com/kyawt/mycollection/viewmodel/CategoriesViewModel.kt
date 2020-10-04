package com.kyawt.mycollection.viewmodel

import android.util.Log
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

    fun loadData() {
        viewModelScope.launch {
            try {
                val result = photoRepository.getCategories()
                collectionResult.value = result
            }catch (e:Exception){
                Log.d("Category", e.toString())
            }

        }
    }
}