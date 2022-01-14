package com.example.modiriatemazraee.view.adapters.Recycle.Data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.modiriatemazraee.R
import com.example.modiriatemazraee.databinding.Home2Binding
import com.example.modiriatemazraee.databinding.Home6Binding
import com.example.modiriatemazraee.model.Khoracks
import com.example.modiriatemazraee.model.Konsantres
import com.example.modiriatemazraee.model.Konstre
import com.example.modiriatemazraee.viewmodel.MainViewModel

class KhorakAdapter(val list:ArrayList<Khoracks>,val model: MainViewModel? = null, val bind: Home6Binding? = null):RecyclerView.Adapter<KhorakAdapter.viewholer>() {
    class viewholer(view: View): RecyclerView.ViewHolder(view){
        lateinit var text1: EditText;lateinit var text2: TextView
        lateinit var text3: EditText;lateinit var add: ImageButton
        init {
            text1 =view.findViewById(R.id.rcdata2_text1)
            text2 =view.findViewById(R.id.rcdata2_text2)
            text3 =view.findViewById(R.id.rcdata2_text3)
            add = view.findViewById(R.id.rcdata2_pluse)
            add.visibility = View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholer {
        return viewholer(LayoutInflater.from(parent.context).inflate(R.layout.rcvdata2,parent,false))
    }

    override fun onBindViewHolder(holder: viewholer, position: Int) {
        if(position == list.size-1)holder.add.visibility = View.VISIBLE

        if(bind != null&&model != null){
            model.total_khorak1()
            bind.home6Include.home6Edittext1.setText(model.total_khorak1_list(list).toString())

        }
        if(bind != null&&model != null){
            model.onkilo_khorak1_set()
            bind.home6Include.home6Edittext2.setText(model.onkilo_khorak1(list).toString())
        }

        if (list[position].price != 0)
            holder.text1.setText(list[position].price.toString())
        if (list[position].witgh !=0F) holder.text2.setText(list[position].witgh.toString())
        holder.text3.setText(list[position].nameKhorack)

        holder.text1.addTextChangedListener {
            if(holder.text1.text.toString() != "")
               list[position].price = holder.text1.text.toString().toInt()
            if(bind != null&&model != null){
                model.onkilo_khorak1_set()
                bind.home6Include.home6Edittext2.setText(model.onkilo_khorak1(list).toString())
            }
        }

        holder.text3.addTextChangedListener {
        if(holder.text3.text.toString() != "")
                list[position].nameKhorack = holder.text3.text.toString()
        }

        holder.text2.addTextChangedListener {
        if(holder.text2.text.toString() != "")
                list[position].witgh = holder.text2.text.toString().toFloat()
            if(bind != null&&model != null){
                model.total_khorak1()
                bind.home6Include.home6Edittext1.setText(model.total_khorak1_list(list).toString())
            }
            if(bind != null&&model != null){
                model.onkilo_khorak1_set()
                bind.home6Include.home6Edittext2.setText(model.onkilo_khorak1(list).toString())
            }
        }

        holder.add.setOnClickListener {
            list.add(Khoracks("",0F,0))
            holder.add.visibility = View.GONE
            this.notifyDataSetChanged()
        }
    }

    override fun getItemCount() = list.size
}
