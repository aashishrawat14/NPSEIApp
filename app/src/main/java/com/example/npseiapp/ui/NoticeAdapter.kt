package com.example.npseiapp.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.npseiapp.FullImageView
import com.example.npseiapp.R
import com.squareup.picasso.Picasso

class NoticeAdapter(var context: Context,var list: ArrayList<NoticeData>) :RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewAdapter {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout, parent, false)
        return NoticeViewAdapter(view)
    }

    override fun onBindViewHolder(holder: NoticeViewAdapter, position: Int) {
        val currentItem = list!![position]
        holder.deleteNoticeTitle.text = currentItem.title
        holder.date.text = currentItem.date
        holder.time.text = currentItem.time
        try {
            if (currentItem.image != null) Picasso.get().load(currentItem.image)
                .into(holder.deleteNoticeImage)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        holder.deleteNoticeImage.setOnClickListener {
            val intent = Intent(context, FullImageView::class.java)
            intent.putExtra("image", currentItem.image)
            context!!.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }


    class NoticeViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val deleteNoticeTitle: TextView
        val date: TextView
        val time: TextView
        val deleteNoticeImage: ImageView

        init {
            deleteNoticeTitle = itemView.findViewById<TextView>(R.id.deleteNoticeTitle)
            deleteNoticeImage = itemView.findViewById<ImageView>(R.id.deleteNoticeImage)
            date = itemView.findViewById<TextView>(R.id.date)
            time = itemView.findViewById<TextView>(R.id.time)
        }
    }
}