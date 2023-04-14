package com.example.android.gallaryapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android.gallaryapp.data.model.Photos
import com.example.android.gallaryapp.data.model.pics
import com.example.android.gallaryapp.data.repository.GalaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: GalaryRepository):ViewModel() {

    val galaryLiveData : LiveData<pics>
    get() = repository.photos

    init {
        GlobalScope.launch {
            repository.getPhotos()
        }
    }
}