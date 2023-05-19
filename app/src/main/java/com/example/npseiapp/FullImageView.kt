package com.example.npseiapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.chrisbanes.photoview.PhotoView
import com.squareup.picasso.Picasso

class FullImageView : AppCompatActivity() {
    private var imageView: PhotoView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image_view)
        imageView = findViewById(R.id.imageView)
        val image = intent.getStringExtra("image")
        Picasso.get().load(image).into(imageView)
    }
}