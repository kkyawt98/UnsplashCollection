package com.kyawt.mycollection.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyawt.mycollection.service.model.collection.Collection
import com.kyawt.mycollection.service.model.collection.CollectionItem
import com.kyawt.mycollection.service.model.collectionDetail.CollectionDetail
import com.kyawt.mycollection.service.repository.PhotoRepository
import kotlinx.coroutines.launch

class SubCategoryViewModel(application: Application) : AndroidViewModel(application) {
    var loading: MutableLiveData<Boolean> = MutableLiveData()
    fun getLoading(): LiveData<Boolean> = loading

    var collectionItemLiveData: MutableLiveData<CollectionItem> = MutableLiveData()
    val categoryID: LiveData<CollectionItem>
        get() = collectionItemLiveData

    fun setCategoryID(collection: CollectionItem) {
        collectionItemLiveData.value = collection
    }

    var subCategoryResult = MutableLiveData<CollectionDetail>()

    private val service: PhotoRepository = PhotoRepository()

    fun loadData(category_id: String) {
        loading.value = true
        viewModelScope.launch {
            try {
                val result = service.getCategory(category_id)
                subCategoryResult.value = result
            } catch (e: Exception) {
                Log.d("Sub", e.toString())
            }
        }

    }
}