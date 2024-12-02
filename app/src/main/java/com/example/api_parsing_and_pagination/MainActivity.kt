package com.example.api_parsing_and_pagination

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api_parsing_and_pagination.model.APIResponseAdapter
import com.example.api_parsing_and_pagination.viewModel.APIResponseViewModel

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private val apiResponseViewModel: APIResponseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, (recyclerView.layoutManager as LinearLayoutManager).orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)
        // Observe the Live Data from the view model
        apiResponseViewModel.apiResponse.observe(this, { apiResponse ->
            val adapter = APIResponseAdapter(apiResponse)
            recyclerView.adapter = adapter
        })

        apiResponseViewModel.fetchResponse()
    }
    }

