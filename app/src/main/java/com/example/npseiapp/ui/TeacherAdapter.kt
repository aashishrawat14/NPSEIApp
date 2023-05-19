package com.example.npseiapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.npseiapp.R
import com.squareup.picasso.Picasso

class TeacherAdapter(var list: ArrayList<TeacherData>) :RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewAdapter {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.faculty_item_layout, parent, false)
        return TeacherViewAdapter(view)
    }

    override fun onBindViewHolder(holder: TeacherViewAdapter, position: Int) {
        val currentItem = list!![position]
        holder.name.text = currentItem.name
        holder.email.text = currentItem.email
        holder.post.text = currentItem.post
        try {
            if (currentItem.image != null) Picasso.get().load(currentItem.image)
                .into(holder.imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }


    class TeacherViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val email: TextView
        val post: TextView
        val imageView: ImageView

        init {
            name = itemView.findViewById(R.id.teacherName)
            imageView = itemView.findViewById(R.id.teacherImage)
            email = itemView.findViewById(R.id.teacherEmail)
            post = itemView.findViewById(R.id.teacherPost)
        }
    }
}