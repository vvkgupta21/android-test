package com.example.test.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.test.ViewModelFactory
import com.example.test.adapter.PostAdapter
import com.example.test.databinding.FragmentHomeBinding
import com.example.test.network.TestApi
import com.example.test.repository.Repository
import com.example.test.viewModels.MainViewModel

class FragmentHome : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var adapter: PostAdapter
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val repository = Repository(TestApi)
        viewModel = ViewModelProvider(this, ViewModelFactory(repository))[MainViewModel::class.java]

        viewModel.getAllPost.observe(viewLifecycleOwner) {
            adapter = PostAdapter(it)
            binding.recyclerView.adapter = adapter
        }

        viewModel.loading.observe(viewLifecycleOwner, Observer {
            if (it){
                binding.pb.visibility = View.VISIBLE
            }else{
                binding.pb.visibility = View.GONE
            }
        })

        viewModel.getAllPost()

        return binding.root
    }

}