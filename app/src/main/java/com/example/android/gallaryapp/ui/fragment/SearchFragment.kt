package com.example.android.gallaryapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.gallaryapp.databinding.FragmentSearchBinding
import com.example.android.gallaryapp.paging.LoaderAdapter
import com.example.android.gallaryapp.paging.PhotoPagingAdapter
import com.example.android.gallaryapp.viewmodel.MainViewModel
import com.example.android.gallaryapp.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding
    lateinit var searchViewModel: SearchViewModel
    var TAG="SearchFragment_java"


    lateinit var adapter: PhotoPagingAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        adapter = PhotoPagingAdapter()

        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)


        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Update the search text in the view model when the user submits the query
                // Update the search text in the view model when the user submits the query
                searchViewModel.text = query ?: ""

                // Call the searchPhotos() function with the search query
                searchViewModel.searchPhotos(query ?: "")

                Log.d(TAG, "onQueryTextSubmit: $query")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Do nothing when the user types in the search bar
                return true
            }
        })
        binding.photoSearchRecycler.layoutManager= LinearLayoutManager(requireContext())
        binding.photoSearchRecycler.adapter=adapter.withLoadStateHeaderAndFooter(
            header = LoaderAdapter(),
            footer = LoaderAdapter()
        )

        searchViewModel.list.observe(viewLifecycleOwner) {
            adapter.submitData(lifecycle, it)
        }



        return binding.getRoot();
    }


}