package com.example.api_parsing_and_pagination.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.api_parsing_and_pagination.R

/**
 * Created by Ratna Srivastava on 02-12-2024.
 */
class APIResponseAdapter(private val results: List<APIResponse>): RecyclerView.Adapter<APIResponseAdapter.APIResponseViewHolder>() {

    class APIResponseViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val body: TextView = view.findViewById(R.id.body)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): APIResponseAdapter.APIResponseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return APIResponseViewHolder(view)
    }

    override fun onBindViewHolder(holder: APIResponseAdapter.APIResponseViewHolder, position: Int) {
        val result = results[position]
        holder.title.text = result.title
        holder.body.text = result.body
    }

    override fun getItemCount(): Int {
        return results.size
    }
}