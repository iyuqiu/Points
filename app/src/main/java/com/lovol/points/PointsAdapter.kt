package com.lovol.points

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.lovol.points.databinding.ItemPointsBinding

class PointsAdapter(private val points: Array<String>) :
    RecyclerView.Adapter<PointsAdapter.ViewHolder>() {
    private lateinit var mOnItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPointsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }

    override fun getItemCount(): Int {
        return points.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.points.text = points[position]
        holder.points.setOnClickListener {
            mOnItemClickListener.onItemClick(position)
        }
    }

    inner class ViewHolder(binding: ItemPointsBinding) : RecyclerView.ViewHolder(binding.root) {
        var points: Button = binding.acbPoints
    }
}