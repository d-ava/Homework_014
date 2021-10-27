package com.example.homework_014

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.homework_014.model.User
import com.example.homework_014.network.NetworkClient
import kotlinx.coroutines.delay

class PeoplePagingSource (): PagingSource<Int, User.Data>() {


    override fun getRefreshKey(state: PagingState<Int, User.Data>): Int? {

     return state.anchorPosition?.let { anchorPosition ->
         val anchorPage = state.closestPageToPosition(anchorPosition)
         anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)

     }


   //     return null

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User.Data> {
        val page: Int = params.key ?: 1
       return  try {
            val response = NetworkClient.api.getUsers(page)

            val body = response.body()
           delay(2000)
            if (response.isSuccessful && body != null) {
                var previousPage: Int? = null
                var nextPage: Int? = null
                if (body.totalPages!!>page){
                    nextPage = page +1
                }
                if (page !=1)
                    previousPage = page -1
                    LoadResult.Page(
                        body.data!!, previousPage, nextPage
                    )
                }else {
                    LoadResult.Error(Throwable())
                }
            }catch (e:Exception){
                LoadResult.Error(e)
            }

        }

    }


