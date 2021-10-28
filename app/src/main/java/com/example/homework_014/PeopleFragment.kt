package com.example.homework_014

import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_014.databinding.PeopleFragmentBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PeopleFragment :
    BaseFragment<PeopleFragmentBinding, PeopleModel>(PeopleFragmentBinding::inflate) {
    override fun getViewModel() = PeopleModel::class.java

    override var useSharedViewModel = false
    private lateinit var adapter: PeopleAdapter

    override fun start() {
        peopleRecycler()

        adapter.addLoadStateListener { loadState ->
            binding.recycler.isVisible = loadState.source.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = loadState.source.refresh is LoadState.Loading
            binding.progressBarOut.isVisible = loadState.source.refresh is LoadState.Loading


        }

    }

    private fun peopleRecycler() {

        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        adapter = PeopleAdapter()
        binding.recycler.adapter = adapter.withLoadStateHeaderAndFooter(
            header = PeopleLoadStateAdapter { adapter.retry() },
            footer = PeopleLoadStateAdapter { adapter.retry() }
        )



        lifecycleScope.launchWhenCreated {
            viewModel.loadPeople().observe(viewLifecycleOwner, {
                adapter.submitData(lifecycle, it)
            })
        }

    }

}