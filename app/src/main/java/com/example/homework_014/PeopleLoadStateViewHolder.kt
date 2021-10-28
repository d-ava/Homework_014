package com.example.homework_014

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_014.databinding.ItemLoadStateBinding

class PeopleLoadStateViewHolder (
    private val binding: ItemLoadStateBinding,
    retry:() -> Unit
        ): RecyclerView.ViewHolder(binding.root){


            init{
                binding.retryButton.setOnClickListener { retry.invoke() }

            }

    fun bind(loadState: LoadState){
        if (loadState is LoadState.Error){
            binding.errorMsg.text = loadState.error.localizedMessage
        }
        binding.progressBarPaging.isVisible = loadState is LoadState.Loading
        binding.retryButton.isVisible=loadState is LoadState.Error
        binding.errorMsg.isVisible = loadState is LoadState.Error
    }




    companion object{
        fun create(parent: ViewGroup, retry: () -> Unit): PeopleLoadStateViewHolder{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_load_state, parent, false)
            val binding = ItemLoadStateBinding.bind(view)
            return PeopleLoadStateViewHolder(binding, retry)
        }
    }



}