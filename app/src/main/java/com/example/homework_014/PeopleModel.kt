package com.example.homework_014

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData

class PeopleModel : ViewModel() {

    fun loadPeople() =
        Pager(config = PagingConfig(1), pagingSourceFactory = { PeoplePagingSource() }
        ).liveData.cachedIn(viewModelScope)


}