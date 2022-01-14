package com.example.modiriatemazraee.view.adapters.Recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.modiriatemazraee.R
import com.example.modiriatemazraee.model.MainOptionIteam
import com.example.modiriatemazraee.model.pages

class MRCadapter(val list: Array<MainOptionIteam>,val viewa:View): RecyclerView.Adapter<MRCadapter.viewHolder>() {
    class viewHolder(view: View):RecyclerView.ViewHolder(view){
        lateinit var name1: TextView;lateinit var image1: ImageView;lateinit var btn: AppCompatButton
        init {
            name1 = view.findViewById(R.id.rc_c_text)
            image1 = view.findViewById(R.id.rc_c_image)
            btn = view.findViewById(R.id.rc_c_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rcv3,parent,false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.image1.setImageResource(list[position].imageId)
        holder.name1.text = list[position].name.toString()
        holder.btn.setOnClickListener {
            when(list[position].work){
                pages.makekonsatre ->{
                    Navigation.findNavController(viewa).navigate(R.id.action_home_Frag_to_home1_Frag)
                }
                pages.makekhorak ->{
                    Navigation.findNavController(viewa).navigate(R.id.action_home_Frag_to_home5_Frag)
                }
                pages.kharidaran ->{
                    Navigation.findNavController(viewa).navigate(R.id.action_home_Frag_to_kharidaran_Frag)
                }
                pages.inputinformation ->{
                    Navigation.findNavController(viewa).navigate(R.id.action_home_Frag_to_home9_Frag)
                }
            }
        }
    }

    override fun getItemCount()=list.size
}