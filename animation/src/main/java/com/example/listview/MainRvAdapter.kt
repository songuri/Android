package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.animation.R


class MainRvAdapter(val context: Context, val mlist: ArrayList<Int> , val itemClick: (Int, View) -> Unit) :
	RecyclerView.Adapter<MainRvAdapter.Holder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
		val view = LayoutInflater.from(context).inflate(R.layout.layout_recyclerview_item, parent, false)
		return Holder(view, itemClick)
	}

	override fun getItemCount(): Int {
		return mlist.size
	}

	override fun onBindViewHolder(holder: Holder, position: Int) {
		holder.bind(mlist[position], context)
	}

	inner class Holder(itemView: View?, itemClick: (Int, View) -> Unit) : RecyclerView.ViewHolder(itemView!!) {
		val tvText = itemView?.findViewById<TextView>(R.id.tv_text)

		fun bind(pos: Int, context: Context) {
			tvText?.setText(pos.toString())
			itemView.setOnClickListener { itemClick(pos, itemView) }
		}
	}
}