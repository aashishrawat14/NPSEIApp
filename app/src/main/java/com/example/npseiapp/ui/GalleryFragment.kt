package com.example.npseiapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.npseiapp.R
import com.google.firebase.database.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GalleryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GalleryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var festRecycler: RecyclerView
    lateinit var campusRecycler: RecyclerView
    lateinit var sportsRecycler: RecyclerView
    lateinit var adapter:GalleryAdapter
    lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        festRecycler = view.findViewById(R.id.festRecycler)
        campusRecycler = view.findViewById(R.id.campusRecycler)
        sportsRecycler = view.findViewById(R.id.sportsRecycler)
        reference = FirebaseDatabase.getInstance().reference.child("Gallery")
        getFestImage()
        getCampusImage()
        getSportsImage()
        return view
    }

    private fun getCampusImage() {
        reference.child("Other Events").addValueEventListener(object : ValueEventListener {
            var imageList: MutableList<String?> = ArrayList()
            override fun onDataChange(datasnapshot: DataSnapshot) {
                for (snapshot in datasnapshot.children) {
                    val data = snapshot.value as String?
                    imageList.add(data)
                }
                adapter = context?.let { GalleryAdapter(it, imageList) }!!
                campusRecycler.layoutManager = GridLayoutManager(context, 3)
                campusRecycler.setAdapter(adapter)
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    private fun getSportsImage() {
        reference.child("Independence Day").addValueEventListener(object : ValueEventListener {
            var imageList: MutableList<String?> = ArrayList()
            override fun onDataChange(datasnapshot: DataSnapshot) {
                for (snapshot in datasnapshot.children) {
                    val data = snapshot.value as String?
                    imageList.add(data)
                }
                adapter = context?.let { GalleryAdapter(it, imageList) }!!
                sportsRecycler.layoutManager = GridLayoutManager(context, 3)
                sportsRecycler.setAdapter(adapter)
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    private fun getFestImage() {
        reference.child("Convocation").addValueEventListener(object : ValueEventListener {
            var imageList: MutableList<String?> = ArrayList()
            override fun onDataChange(datasnapshot: DataSnapshot) {
                for (snapshot in datasnapshot.children) {
                    val data = snapshot.value as String?
                    imageList.add(data)
                }
                adapter = context?.let { GalleryAdapter(it, imageList) }!!
                festRecycler.setLayoutManager(GridLayoutManager(context, 3))
                festRecycler.setAdapter(adapter)
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GalleryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GalleryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}