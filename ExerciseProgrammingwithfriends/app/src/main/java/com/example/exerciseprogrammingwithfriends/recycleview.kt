package com.example.exerciseprogrammingwithfriends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycleview.*

class recycleview : AppCompatActivity() {
    val viewModel:MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)
        viewModel.mydata()


        val adapter = nameadapter(viewModel.data, LayoutInflater.from(this))
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)

}
class nameadapter(
    val itemlist: ArrayList<items>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<nameadapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val title =view.findViewById<TextView>(R.id.text_hyundo)
        val description =view.findViewById<TextView>(R.id.text_Cmong)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): nameadapter.ViewHolder {
            return ViewHolder(inflater.inflate(R.layout.recycleview2, parent, false))
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: nameadapter.ViewHolder, position: Int) {
        holder.title.setText(itemlist[position].title)
        holder.description.setText(itemlist[position].description)
    }
}