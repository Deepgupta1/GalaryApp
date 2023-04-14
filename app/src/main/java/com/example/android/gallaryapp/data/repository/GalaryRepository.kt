package com.example.android.gallaryapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.gallaryapp.data.api.NetworkService
import com.example.android.gallaryapp.data.model.Photos
import com.example.android.gallaryapp.data.model.pics
import com.example.android.gallaryapp.utils.AppConstant
import javax.inject.Inject

class GalaryRepository @Inject constructor(private val networkService: NetworkService) {

    private val _photos = MutableLiveData<pics>()

    val photos: LiveData<pics>
        get() = _photos

    suspend fun getPhotos() {
        val result = networkService.getPhotos(AppConstant.method,AppConstant.per_page,"1",AppConstant.api_key,AppConstant.format,AppConstant.nojsoncallback,AppConstant.extras)
        if(result.isSuccessful && result.body()!=null){
            _photos.postValue(result.body())
        }

    }
}