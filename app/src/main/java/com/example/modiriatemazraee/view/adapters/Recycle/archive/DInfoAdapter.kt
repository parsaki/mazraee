package com.example.modiriatemazraee.view.adapters.Recycle.archive

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.modiriatemazraee.R
import com.example.modiriatemazraee.model.InfoIteam
import com.example.modiriatemazraee.model.iteamKhorak
import com.example.modiriatemazraee.viewmodel.MainViewModel
import com.google.android.material.button.MaterialButton

class DInfoAdapter (val list:ArrayList<InfoIteam>,val viewa:View,val model: MainViewModel? = null): RecyclerView.Adapter<DInfoAdapter.viewholer>() {
    class viewholer(view: View): RecyclerView.ViewHolder(view){
        lateinit var text1: TextView;lateinit var text2: TextView
        lateinit var text3: TextView;lateinit var show: AppCompatButton;lateinit var edit: MaterialButton
        init {
            text1 =view.findViewById(R.id.archivr3_text1)
            text2 =view.findViewById(R.id.archivr3_text2)
            text3 =view.findViewById(R.id.archivr3_text3)

            show = view.findViewById(R.id.archive3_show)
            edit = view.findViewById(R.id.archive3_edit)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholer {
        return viewholer(LayoutInflater.from(parent.context).inflate(R.layout.iteam_archive3,parent,false))
    }

    override fun onBindViewHolder(holder: viewholer, position: Int) {
        holder.text1.setText("نام سالن : "+list[position].room_name)
        holder.text2.setText("دسته گاو : "+list[position].cow_group)
        holder.text3.setText("شماره سالن :"+list[position].roomnumber.toString())

        holder.edit.setOnClickListener {
            if(model!=null){
                model.info1.value = list[position]
                Navigation.findNavController(viewa).navigate(R.id.action_home11_Frag_to_home12_Frag)
            }
        }
        holder.show.setOnClickListener {

        }
    }

    override fun getItemCount() = list.size

}
