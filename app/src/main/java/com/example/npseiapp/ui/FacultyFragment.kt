package com.example.npseiapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.npseiapp.R
import com.google.firebase.database.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var csDepartment : RecyclerView
lateinit var  mechDepartment  : RecyclerView
lateinit var  itDepartment  : RecyclerView
lateinit var  eceDepartment: RecyclerView


@SuppressLint("StaticFieldLeak")
lateinit var  csNoData: LinearLayout
@SuppressLint("StaticFieldLeak")
lateinit var mechNoData: LinearLayout
@SuppressLint("StaticFieldLeak")
lateinit var  itNoData: LinearLayout
@SuppressLint("StaticFieldLeak")
lateinit var  eceNoData: LinearLayout

lateinit var list1:List<TeacherData>
lateinit var list2:List<TeacherData>
lateinit var list3:List<TeacherData>
lateinit var list4:List<TeacherData>

lateinit var adapter: TeacherAdapter

lateinit var reference: DatabaseReference
lateinit  var dbRef:DatabaseReference

/**
 * A simple [Fragment] subclass.
 * Use the [FacultyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FacultyFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val view = inflater.inflate(R.layout.fragment_faculty, container, false)
        csDepartment = view.findViewById(R.id.csDepartment)
        itDepartment = view.findViewById(R.id.itDepartment)
        mechDepartment = view.findViewById(R.id.mechDepartment)
        eceDepartment = view.findViewById(R.id.eceDepartment)
        csNoData = view.findViewById(R.id.csNoData)
        itNoData = view.findViewById(R.id.itNoData)
        mechNoData = view.findViewById(R.id.mechNoData)
        eceNoData = view.findViewById(R.id.eceNoData)
        reference = FirebaseDatabase.getInstance().reference.child("Faculty")
        csDepartment()
        mechDepartment()
        itDepartment()
        eceDepartment()
        return view
    }

    private fun csDepartment() {
        dbRef = reference.child("Computer Science")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list1 = ArrayList<TeacherData>()
                if (!dataSnapshot.exists()) {
                    csNoData.visibility = View.VISIBLE
                    csDepartment.visibility = View.GONE
                } else {
                    csNoData.visibility = View.GONE
                    csDepartment.visibility = View.VISIBLE
                    for (snapshot in dataSnapshot.children) {
                        val data: TeacherData? = snapshot.getValue(TeacherData::class.java)
                        if (data != null) {
                            (list1 as ArrayList<TeacherData>).add(data)
                        }
                    }
                    csDepartment.setHasFixedSize(true)
                    csDepartment.layoutManager = LinearLayoutManager(context)
                    adapter = TeacherAdapter(list1 as ArrayList<TeacherData>)
                    csDepartment.adapter = adapter
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(context, databaseError.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun itDepartment() {
        dbRef = reference.child("Civil")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list2 = ArrayList<TeacherData>()
                if (!dataSnapshot.exists()) {
                    itNoData.visibility = View.VISIBLE
                    itDepartment.visibility = View.GONE
                } else {
                    itNoData.visibility = View.GONE
                    itDepartment.visibility = View.VISIBLE
                    for (snapshot in dataSnapshot.children) {
                        val data: TeacherData? = snapshot.getValue(TeacherData::class.java)
                        if (data != null) {
                            (list2 as ArrayList<TeacherData>).add(data)
                        }
                    }
                    itDepartment.setHasFixedSize(true)
                    itDepartment.layoutManager = LinearLayoutManager(context)
                    adapter = TeacherAdapter(list2 as ArrayList<TeacherData>)
                    itDepartment.adapter = adapter
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(context, databaseError.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun eceDepartment() {
        dbRef = reference.child("Electronics and Communications")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list3 = ArrayList<TeacherData>()
                if (!dataSnapshot.exists()) {
                    eceNoData.visibility = View.VISIBLE
                    eceDepartment.visibility = View.GONE
                } else {
                    eceNoData.visibility = View.GONE
                    eceDepartment.visibility = View.VISIBLE
                    for (snapshot in dataSnapshot.children) {
                        val data: TeacherData? = snapshot.getValue(TeacherData::class.java)
                        if (data != null) {
                            (list3 as ArrayList<TeacherData>).add(data)
                        }
                    }
                    eceDepartment.setHasFixedSize(true)
                    eceDepartment.layoutManager = LinearLayoutManager(context)
                    adapter = TeacherAdapter(list3 as ArrayList<TeacherData>)
                    eceDepartment.adapter = adapter
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(context, databaseError.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun mechDepartment() {
        dbRef = reference.child("Mechanical Engineering")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list4 = ArrayList<TeacherData>()
                if (!dataSnapshot.exists()) {
                    mechNoData.visibility = View.VISIBLE
                    mechDepartment.visibility = View.GONE
                } else {
                    mechNoData.visibility = View.GONE
                    mechDepartment.visibility = View.VISIBLE
                    for (snapshot in dataSnapshot.children) {
                        val data: TeacherData? = snapshot.getValue(TeacherData::class.java)
                        if (data != null) {
                            (list4 as ArrayList<TeacherData>).add(data)
                        }
                    }
                    mechDepartment.setHasFixedSize(true)
                    mechDepartment.layoutManager = LinearLayoutManager(context)
                    adapter = TeacherAdapter(list4 as ArrayList<TeacherData>)
                    mechDepartment.adapter = adapter
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(context, databaseError.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FacultyFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FacultyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}