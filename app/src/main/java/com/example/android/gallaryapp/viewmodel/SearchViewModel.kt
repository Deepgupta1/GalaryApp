package com.example.android.gallaryapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.android.gallaryapp.data.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: SearchRepository): ViewModel() {


    var text:String="All"

    val list=repository.getSearchPhoto(text).cachedIn(viewModelScope)


    fun searchPhotos(query: String) {
        viewModelScope.launch {
            repository.getSearchPhoto(query)
        }
    }
}