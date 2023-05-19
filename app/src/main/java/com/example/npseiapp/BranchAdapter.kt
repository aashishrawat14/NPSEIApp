package com.example.npseiapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.npseiapp.ui.BranchModel

class BranchAdapter(var context: Context,var list: List<BranchModel>?): PagerAdapter() {



    override fun getCount(): Int {
        return list!!.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.branch_item_layout, container, false)
        val branch_icon: ImageView = view.findViewById(R.id.branch_icon)
        val branch_title: TextView = view.findViewById(R.id.branch_title)
        val branch_desc: TextView = view.findViewById(R.id.branch_desc)
        branch_icon.setImageResource(list!![position].img)
        branch_title.setText(list!![position].title)
        branch_desc.setText(list!![position].description)
        container.addView(view, 0)
        return view
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}