package com.example.android.gallaryapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.android.gallaryapp.data.api.NetworkService
import com.example.android.gallaryapp.paging.PhotoSearchPagingSource
import javax.inject.Inject

class SearchRepository @Inject constructor(private val networkService: NetworkService) {



    fun getSearchPhoto(text: String)= Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = {
            PhotoSearchPagingSource(networkService,text)
        }

    ).liveData
}