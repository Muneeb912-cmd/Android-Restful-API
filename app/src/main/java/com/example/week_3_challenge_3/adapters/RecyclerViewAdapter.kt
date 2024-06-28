package com.example.week_3_challenge_3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week_3_challenge_3.R
import com.example.week_3_challenge_3.data_classes.houseData

class RecyclerViewAdapter(
    private val dataList: ArrayList<houseData>,
    private val listener: OnItemClickListener
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderClass>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
        fun onButtonClick(position: Int)
    }

    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val rvImage: ImageView = itemView.findViewById(R.id.cardImage)
        val button2: ImageButton = itemView.findViewById(R.id.button2)
        val price: TextView = itemView.findViewById(R.id.price)
        val dataId: TextView = itemView.findViewById(R.id.dataId)
        val title: TextView = itemView.findViewById(R.id.title)
        val activeStatus: TextView = itemView.findViewById(R.id.activeStatus)

        init {
            itemView.setOnClickListener(this)
            button2.setOnClickListener(this)
        }


        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if (v == button2) {
                    listener.onButtonClick(position)
                } else {
                    listener.onItemClick(position)
                }
            }
        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolderClass, position: Int) {
        val currentItem = dataList[position]

//        positionholder.rvImage.setImageResource(currentItem.images[0])
        holder.price.text = currentItem.price.toString()
        holder.dataId.text = currentItem.id.toString()
        holder.title.text = currentItem.title
        holder.activeStatus.text = ""
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}