package com.example.homework_014

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_013.extensions.glideExtension
import com.example.homework_014.databinding.PeopleCardBinding
import com.example.homework_014.model.User

class PeopleAdapter : PagingDataAdapter<User.Data, PeopleAdapter.ViewHolder>(DiffCallback()) {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        PeopleCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    inner class ViewHolder(private val binding: PeopleCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: User.Data) {
            binding.tvFirstName.text = model.firstName
            binding.tvLastName.text = model.lastName
            binding.tvEmail.text = model.email

        binding.image.glideExtension(model.avatar)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<User.Data>() {

        override fun areItemsTheSame(oldItem: User.Data, newItem: User.Data) =
            oldItem.id == newItem.id


        override fun areContentsTheSame(oldItem: User.Data, newItem: User.Data) =
            oldItem == newItem

    }




}