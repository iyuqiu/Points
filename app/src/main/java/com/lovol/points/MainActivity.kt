package com.lovol.points

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lovol.points.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val pointsTitles = arrayOf("泛型", "架构")
    private val pointsGenerics = 0
    private val pointsArchitecture = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvListview.layoutManager = LinearLayoutManager(this)
        val pointsAdapter = PointsAdapter(pointsTitles)
        pointsAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                jumpPoints(position)
            }
        })
        binding.rvListview.adapter = pointsAdapter
    }

    private fun jumpPoints(position: Int) {
        when (position) {
            pointsGenerics -> {
                Toast.makeText(this@MainActivity, "泛型", Toast.LENGTH_LONG).show()
            }

            pointsArchitecture -> {
                Toast.makeText(this@MainActivity, "架构", Toast.LENGTH_LONG).show()
            }
        }
    }
}