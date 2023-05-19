package com.example.npseiapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.npseiapp.BranchAdapter
import com.example.npseiapp.R
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    lateinit var viewPager: ViewPager
    lateinit var adapter: BranchAdapter
    lateinit var list: List<BranchModel>

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
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        list = ArrayList<BranchModel>()
        (list as ArrayList<BranchModel>).add(
            BranchModel(
                R.drawable.ic_computer,
                "Computer Science",
                "Computer Science & Engineering department aims at producing technically competent professionals who can excel in today's age of technology and fulfill demands of trained IT professionals in the industry. The curriculum is designed in such a manner that the students are able to sail through the intense competition smoothly."
            )
        )
        (list as ArrayList<BranchModel>).add(
            BranchModel(
                R.drawable.ic_mech,
                "Mechanical Engineering",
                "This discipline of engineering in NPSEI has the most lively and highly energized group of engineers. Students have left their mark in several premier institutes all over India including ITTs. Main difference lies in the approach of both the students and the faculty which knows exactly WHAT to achieve and HOW to achieve."
            )
        )
        (list as ArrayList<BranchModel>).add(
            BranchModel(
                R.drawable.ic_it,
                "Civil Engineering",
                "Civil Engineering is the study, design, development, application, implementation, support or management of raw materail like cement, soil, clap, stone, etc. In the era where there is demand for trained Civil engineers this department provides the students with a good infrastructure and highly qualified faculty to produce skilled professionals."
            )
        )
        (list as ArrayList<BranchModel>).add(
            BranchModel(
                R.drawable.ic_ece,
                "Electronics & Communications",
                "Department of Electronics & Communication is one of the most sought after department of NPSEI and boasts of excellent infrastructure. The students are motivated to take up challenging projects and enhance their practical skills in electronics. The department is well equipped in all aspects and has the following labs."
            )
        )
        adapter = context?.let { BranchAdapter(it, list) }!!
        viewPager = view.findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = adapter
        val imageView = view.findViewById<ImageView>(R.id.college_image)
        Picasso.get()
            .load("https://firebasestorage.googleapis.com/v0/b/npseiapp.appspot.com/o/Gallery%2FConvocation%2FIMG_0796.JPG?alt=media&token=33fbceff-263b-44de-b589-0b3a841db33f")
            .into(imageView)
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AboutFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AboutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}