package com.example.android.gallaryapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.gallaryapp.databinding.ActivityMainBinding
import com.example.android.gallaryapp.paging.LoaderAdapter
import com.example.android.gallaryapp.paging.PhotoPagingAdapter
import com.example.android.gallaryapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity_java"

     private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



     /*   //live data work
        mainViewModel.galaryLiveData.observe(this) {
            it.toString()
            binding.text.text = it.stat
            Log.d(TAG, "onCreate: $it")
        }*/

    }
}