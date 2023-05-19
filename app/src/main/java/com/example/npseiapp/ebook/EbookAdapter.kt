package com.example.npseiapp.ebook

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.npseiapp.R
import com.example.npseiapp.ui.NoticeData

class EbookAdapter(var context:Context, var list: MutableList<EbookData?>) : RecyclerView.Adapter<EbookAdapter.EbookViewAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EbookViewAdapter {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.ebook_item_layout, parent, false)
        return EbookViewAdapter(view)
    }

    override fun onBindViewHolder(holder: EbookViewAdapter, position: Int) {
        holder.ebookName.text = list[position]!!.pdfTitle
        holder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                list[position]!!.pdfTitle,
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.ebookDownload.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(list[position]!!.pdfUrl)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class EbookViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ebookName: TextView
        val ebookDownload: ImageView

        init {
            ebookDownload = itemView.findViewById<ImageView>(R.id.ebookDownload)
            ebookName = itemView.findViewById<TextView>(R.id.ebookName)
        }
    }
}