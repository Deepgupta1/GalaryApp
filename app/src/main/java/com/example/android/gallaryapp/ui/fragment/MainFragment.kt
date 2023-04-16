package com.example.android.gallaryapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.gallaryapp.R
import com.example.android.gallaryapp.databinding.ActivityMainBinding
import com.example.android.gallaryapp.databinding.FragmentHomeBinding
import com.example.android.gallaryapp.paging.LoaderAdapter
import com.example.android.gallaryapp.paging.PhotoPagingAdapter
import com.example.android.gallaryapp.viewmodel.MainViewModel


class MainFragment : Fragment() {

    val TAG = "MainActivity_java"

    lateinit var mainViewModel: MainViewModel
    lateinit var adapter:PhotoPagingAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val binding: FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)


        adapter= PhotoPagingAdapter()

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.photoRecycler.layoutManager= LinearLayoutManager(view?.context)
        // binding.photoRecycler.setHasFixedSize(true)
        binding.photoRecycler.adapter=adapter.withLoadStateHeaderAndFooter(
            header = LoaderAdapter(),
            footer = LoaderAdapter()
        )

        Log.d(TAG, "onCreate: running")

        mainViewModel.list.observe(viewLifecycleOwner) {
            adapter.submitData(lifecycle, it)
        }

        return binding.getRoot();
    }


}