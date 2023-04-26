package com.example.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.PostItemsBinding
import com.example.test.models.GetAllPostItem

class PostAdapter(private var getList: ArrayList<GetAllPostItem>) : RecyclerView.Adapter<PostAdapter.Holder>(){

    class Holder(val binding: PostItemsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder(PostItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: PostAdapter.Holder, position: Int) {
        val model = getList[position]
        holder.binding.model = model
    }

    override fun getItemCount() = getList.size

}