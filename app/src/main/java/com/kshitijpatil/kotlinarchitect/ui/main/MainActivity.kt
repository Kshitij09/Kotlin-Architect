package com.kshitijpatil.kotlinarchitect.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.kshitijpatil.kotlinarchitect.R
import com.kshitijpatil.kotlinarchitect.data.model.Repository
import com.kshitijpatil.kotlinarchitect.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), RepositoryAdapter.OnItemClickListener {
    private val adapter = RepositoryAdapter(arrayListOf(), this)
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)
        binding.apply {
            this.viewModel = viewModel
            executePendingBindings()
            rvRepository.layoutManager = LinearLayoutManager(this@MainActivity)
            rvRepository.adapter = adapter
        }
        viewModel.repositories.observe(this,
            Observer<ArrayList<Repository>> { list -> list?.let { adapter.replaceData(it) } })
    }

    override fun onItemClick(position: Int) {
        println("Item clicked!")
    }
}
