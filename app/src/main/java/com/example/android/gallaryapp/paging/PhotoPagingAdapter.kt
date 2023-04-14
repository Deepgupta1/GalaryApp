package com.example.android.gallaryapp.paging

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.gallaryapp.R
import com.example.android.gallaryapp.data.model.Photo

class PhotoPagingAdapter: PagingDataAdapter<Photo, PhotoPagingAdapter.PhotoViewHolder>(COMPARATOR) {

    class PhotoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val photoUrl=itemView.findViewById<ImageView>(R.id.photoImg)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
      val item=getItem(position)
        if(item!=null){
            var url=item.url_s
            Glide.with(holder.itemView.context)
                .load(url)
                .fitCenter()
                .centerCrop()
                .into(holder.photoUrl)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
      val view =LayoutInflater.from(parent.context).inflate(R.layout.adapter_photo_layout,parent,false)
        return PhotoViewHolder(view)
    }

    companion object{
        private val  COMPARATOR=object : DiffUtil.ItemCallback<Photo>(){
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {

                return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem==newItem
            }

        }
    }
}