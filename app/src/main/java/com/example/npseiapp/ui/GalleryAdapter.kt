package com.example.npseiapp.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.npseiapp.FullImageView
import com.example.npseiapp.R
import com.squareup.picasso.Picasso

class GalleryAdapter(var context: Context, var images: MutableList<String?>) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.gallery_image, parent, false)
        return GalleryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        Picasso.get().load(images[position]).into(holder.imageView)
        holder.imageView.setOnClickListener {
            val intent = Intent(context, FullImageView::class.java)
            intent.putExtra("image", images[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return images!!.size
    }


    class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView

        init {

            imageView = itemView.findViewById(R.id.image)

        }
    }
}