package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Data.
        val myDataset = Datasource().loadAffirmations()

        val recyclerview = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerview.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView.
        recyclerview.setHasFixedSize(true)

        // Using Layout manager

        // GridLayoutManager
        // val gridLayoutManager = GridLayoutManager(this, 3)
        // recyclerView.layoutManager = gridLayoutManager

        // StaggeredGridLayoutManager
        // val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        // recyclerview.layoutManager = staggeredGridLayoutManager
    }
}