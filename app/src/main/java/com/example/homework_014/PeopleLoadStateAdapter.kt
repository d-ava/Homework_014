package com.example.homework_014

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class PeopleLoadStateAdapter(
    private val retry : ()-> Unit
):LoadStateAdapter<PeopleLoadStateViewHolder>() {


    override fun onBindViewHolder(holder: PeopleLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup,
        loadState: LoadState
    ): PeopleLoadStateViewHolder {

        return PeopleLoadStateViewHolder.create(parent, retry)
    }
}