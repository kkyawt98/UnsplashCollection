package com.kyawt.mycollection.viewmodel

import android.app.Application
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
    var loading : MutableLiveData<Boolean> = MutableLiveData()
    fun getLoading() : LiveData<Boolean> = loading

    var category_id : MutableLiveData<CollectionItem> = MutableLiveData()
    val categoryID : LiveData<CollectionItem>
    get() = category_id

    fun setCategoryID(collection: CollectionItem){
        category_id.value = collection
    }
    var subCategoryResult = MutableLiveData<CollectionDetail>()

    private val service : PhotoRepository = PhotoRepository()

    fun loadData(category_id : String){
        loading.value = true
        viewModelScope.launch {
            val result =service.getCategory(category_id)
            subCategoryResult.value = result
        }
    }
}