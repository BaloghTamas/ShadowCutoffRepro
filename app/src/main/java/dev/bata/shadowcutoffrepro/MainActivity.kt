package dev.bata.shadowcutoffrepro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RemoteCallbackList

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.listWithRecyclerView)
        recyclerView.adapter = Adapter()
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val viewPager = findViewById<ViewPager2>(R.id.listWithViewPager2)
        viewPager.adapter = Adapter()

        (viewPager.getChildAt(0) as RecyclerView).clipToPadding = false
        (viewPager.getChildAt(0) as RecyclerView).clipChildren = false
    }

    class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(
                itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card, parent, false)
            )

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = "$position"
        }

        override fun getItemCount() = 5

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textView: TextView = itemView.findViewById(R.id.tv_card)
        }
    }
}