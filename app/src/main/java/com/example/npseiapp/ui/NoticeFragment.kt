package com.example.npseiapp.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.npseiapp.R
import com.google.firebase.database.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class NoticeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    lateinit var deleteNoticeRecycler: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var list: ArrayList<NoticeData>
//    lateinit var myadapter: NoticeAdapter

    lateinit var reference: DatabaseReference

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_notice, container, false)
        deleteNoticeRecycler = view.findViewById(R.id.deleteNoticeRecycler)
        progressBar = view.findViewById(R.id.progressBar)

        reference = FirebaseDatabase.getInstance().reference.child("Notice")

        deleteNoticeRecycler.layoutManager = LinearLayoutManager(context)
        deleteNoticeRecycler.setHasFixedSize(true)
        list = arrayListOf<NoticeData>()

        getNotice()

        return view
    }

    private fun getNotice() {
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                if(dataSnapshot.exists()){
                    for (snapshot in dataSnapshot.children) {
                        val data = snapshot.getValue(NoticeData::class.java)
                        Log.d(TAG, "Value is: " + data)
                        list.add(data!!)
                }}
//                adapter = context?.let { NoticeAdapter(it, list) }!!
                progressBar.visibility = View.GONE
                deleteNoticeRecycler.adapter = NoticeAdapter(context!!,list)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                progressBar.visibility = View.GONE
                Toast.makeText(context, databaseError.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

}