package com.example.modiriatemazraee.view.adapters.Recycle.Data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.modiriatemazraee.R
import com.example.modiriatemazraee.model.Froosh
import com.example.modiriatemazraee.model.Khoracks
import com.example.modiriatemazraee.model.kharidaran
import com.example.modiriatemazraee.viewmodel.MainViewModel

class kharid (val arrayList: ArrayList<kharidaran>,val model: MainViewModel?=null):RecyclerView.Adapter<kharid.viewholer>() {
    class  viewholer(view: View): RecyclerView.ViewHolder(view){
        lateinit var text1:EditText;lateinit var text2:EditText;lateinit var text3:EditText
        lateinit var remove:ImageButton; lateinit var add:ImageButton
        init {
            text1=view.findViewById(R.id.kharidarani_text1)
            text2=view.findViewById(R.id.kharidarani_text2)
            text3=view.findViewById(R.id.kharidarani_text3)
            remove = view.findViewById(R.id.kharidarani_min)
            add = view.findViewById(R.id.kharidarani_pluse)
            add.visibility = View.GONE
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholer {
        return viewholer(LayoutInflater.from(parent.context).inflate(R.layout.kharidaran_data_iteam,parent,false))
    }

    override fun onBindViewHolder(holder: viewholer, position: Int) {
        if(position == arrayList.size-1)holder.add.visibility = View.VISIBLE

        holder.text1.setText(arrayList[position].gift_price.toString())
        holder.text2.setText(arrayList[position].base_precent.toString())
        holder.text3.setText(arrayList[position].name.toString())
        holder.text1.addTextChangedListener {
            if(!holder.text1.text.isNullOrEmpty())arrayList[position].gift_price = holder.text1.text.toString().toInt()

        }
        holder.text2.addTextChangedListener {
            if(!holder.text2.text.isNullOrEmpty())arrayList[position].base_precent = holder.text2.text.toString().toInt()

        }
        holder.text3.addTextChangedListener {
            arrayList[position].name = holder.text3.text.toString()

        }
        holder.add.setOnClickListener {
            arrayList.add(kharidaran("",0,0))
            holder.add.visibility = View.GONE
            this.notifyDataSetChanged()
        }
        holder.remove.setOnClickListener {
            arrayList.removeAt(position)
            this.notifyDataSetChanged()
        }
    }

    override fun getItemCount()= arrayList.size
}