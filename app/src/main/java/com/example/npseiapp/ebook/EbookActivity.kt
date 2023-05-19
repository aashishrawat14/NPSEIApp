package com.example.npseiapp.ebook

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.npseiapp.R
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.firebase.database.*

class EbookActivity : AppCompatActivity() {
    lateinit var ebookRecycler: RecyclerView
    lateinit var reference: DatabaseReference
    lateinit var list: MutableList<EbookData?>
    lateinit var adapter: EbookAdapter

    lateinit var shimmerLayout: LinearLayout
    lateinit var shimmerFrameLayout: ShimmerFrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ebook)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Ebooks"
        ebookRecycler = findViewById(R.id.ebookRecycler)
        reference = FirebaseDatabase.getInstance().reference.child("pdf")
        shimmerFrameLayout = findViewById(R.id.shimmer_view_container)
        shimmerLayout = findViewById(R.id.shimmer_layout)
        getData()
    }

    private fun getData() {
        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list = ArrayList<EbookData?>()
                for (snapshot in dataSnapshot.children) {
                    val data: EbookData? = snapshot.getValue(EbookData::class.java)
                    list!!.add(data)
                }
                adapter = EbookAdapter(this@EbookActivity, list)
                ebookRecycler!!.layoutManager = LinearLayoutManager(this@EbookActivity)
                ebookRecycler!!.adapter = adapter
                shimmerFrameLayout!!.stopShimmer()
                shimmerLayout!!.visibility = View.GONE
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@EbookActivity, databaseError.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onPause() {
        shimmerFrameLayout!!.stopShimmer()
        super.onPause()
    }

    override fun onResume() {
        shimmerFrameLayout!!.startShimmer()
        super.onResume()
    }
}