package com.example.android.gallaryapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android.gallaryapp.data.api.NetworkService
import com.example.android.gallaryapp.data.model.Photo
import com.example.android.gallaryapp.utils.AppConstant

class PhotoSearchPagingSource(private val networkService: NetworkService, val text: String) :
    PagingSource<Int, Photo>() {
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val position = params.key ?: 1
            val response = networkService.getPhotosSearch(
                AppConstant.method,
                AppConstant.per_page,
                position,
                AppConstant.api_key,
                AppConstant.format,
                AppConstant.nojsoncallback,
                AppConstant.extras,
                text
            )


            return LoadResult.Page(

                data = response.body()?.photos!!.photo,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == response.body()?.photos?.total) null else position + 1
            )


        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}