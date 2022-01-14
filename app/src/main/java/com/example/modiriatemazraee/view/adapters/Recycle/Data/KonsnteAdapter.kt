package com.example.modiriatemazraee.view.adapters.Recycle.Data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.modiriatemazraee.R
import com.example.modiriatemazraee.databinding.Home2Binding
import com.example.modiriatemazraee.model.Konsantres
import com.example.modiriatemazraee.model.Konstre
import com.example.modiriatemazraee.model.iteamKonsntre
import com.example.modiriatemazraee.viewmodel.MainViewModel

class KonsnteAdapter(val list:ArrayList<Konsantres>,val model:MainViewModel? = null,val bind:Home2Binding? = null,val context:FragmentActivity? =null):RecyclerView.Adapter<KonsnteAdapter.viewholer>() {
    class viewholer(view: View):RecyclerView.ViewHolder(view){
        lateinit var text1:EditText;lateinit var text2:TextView
        lateinit var text3:EditText;lateinit var text4:EditText;lateinit var add:ImageButton
        init {
            text1 =view.findViewById(R.id.rcdata1_text1)
            text2 =view.findViewById(R.id.rcdata1_text2)
            text3 =view.findViewById(R.id.rcdata1_text3)
            text4 =view.findViewById(R.id.rcdata1_text4)
            add = view.findViewById(R.id.rcdata1_pluse)
            add.visibility = View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholer {
        return viewholer(LayoutInflater.from(parent.context).inflate(R.layout.rcvdata1,parent,false))
    }

    override fun onBindViewHolder(holder: viewholer, position: Int) {
        if(position == list.size-1) holder.add.visibility = View.VISIBLE

        if(bind != null&&model != null){
            model!!.onkilo_set(list)
            bind!!.home2Include.home2Onk.text = model!!.onkilo_konsntre(list).toString()
        }

        if (list[position].price != 0) holder.text1.setText(list[position].price.toString())
        if (list[position].percent != 0F) holder.text2.setText(list[position].percent.toInt().toString())
        if (list[position].weight != 0F) holder.text3.setText(list[position].weight.toString())
        holder.text4.setText(list[position].nameKhoraki)

        holder.text1.addTextChangedListener {
            if(holder.text1.text.toString() != "")
            list[position].price = holder.text1.text.toString().toInt()
            if(model != null){
                model!!.onkilo_set(list)
                model.konsant1.value!!.onkilo = model.onkilo_konsntre(list)
            }
            if(bind != null&&model != null){
                model!!.onkilo_set(list)
                bind!!.home2Include.home2Onk.text = model!!.onkilo_konsntre(list).toString()
            }

        }
        holder.text3.addTextChangedListener {
            if(holder.text3.text.toString() != "") list[position].weight = holder.text3.text.toString().toFloat()
            if(model != null)   model!!.onkilo_konsntre(list)
            if(model != null)  model!!.percent_iteam_konsantre(list)
            if (!list[position].percent.isNaN()) holder.text2.setText(list[position].percent.toInt().toString())
            if(model != null){
                model!!.onkilo_set(list)
            }
            if(bind != null&&model != null){
                model!!.onkilo_set(list)
                bind!!.home2Include.home2Onk.text =  model!!.onkilo_konsntre(list).toString()
            }
        }
        holder.text4.addTextChangedListener {
            if(holder.text4.text.toString() != "")
            list[position].nameKhoraki = holder.text4.text.toString()

        }
        holder.add.setOnClickListener {
            list.add(Konsantres(0,0F,"",0F))
            holder.add.visibility = View.GONE
            if(model != null)   model!!.onkilo_konsntre(list)
            if(bind != null){
                model!!.onkilo_set(list)
            }
            this.notifyDataSetChanged()
        }
    }

    override fun getItemCount() = list.size
}