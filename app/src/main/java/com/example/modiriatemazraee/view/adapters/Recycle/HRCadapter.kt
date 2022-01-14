package com.example.modiriatemazraee.view.adapters.Recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.modiriatemazraee.model.MainOprtionIteamDuble
import com.example.modiriatemazraee.R
import kotlin.properties.Delegates

class HRCadapter(val list: Array<MainOprtionIteamDuble>,val viewa: View):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private inner class viewHolderTwo(view: View):RecyclerView.ViewHolder(view){
        lateinit var name1:TextView;lateinit var image1:ImageView;lateinit var btn1:AppCompatButton
        lateinit var name2:TextView;lateinit var image2:ImageView;lateinit var btn2:AppCompatButton
        init {
            name1 = view.findViewById(R.id.rc3_text1)
            image1 = view.findViewById(R.id.rc3_image1)
            btn1 = view.findViewById(R.id.rc3_btn1)
            name2 = view.findViewById(R.id.rc3_text2)
            image2 = view.findViewById(R.id.rc3_image2)
            btn2 = view.findViewById(R.id.rc3_btn2)
        }
    }
    private inner class viewHolder1(view: View):RecyclerView.ViewHolder(view){
        lateinit var name1:TextView;lateinit var image1:ImageView;lateinit var btn:AppCompatButton

        init {
            name1 = view.findViewById(R.id.rc1_text)
            image1 = view.findViewById(R.id.rc1_image)
            btn = view.findViewById(R.id.rc1_view)
        }
    }
    private inner class viewHolder2(view: View):RecyclerView.ViewHolder(view){
        lateinit var name1:TextView;lateinit var image1:ImageView;lateinit var btn:AppCompatButton
        init {
            name1 = view.findViewById(R.id.rc2_text)
            image1 = view.findViewById(R.id.rc2_image)
            btn = view.findViewById(R.id.rc2_view)
        }
    }
    companion object {
        const val THE_FIRST = 1
        const val THE_SECOND = 2
        const val THE_TWO_VIEW = 3
    }

    override fun getItemViewType(position: Int): Int {
        if(position == 1)return THE_SECOND
        if(list[position].name2.isNullOrEmpty())return  THE_FIRST
        return THE_TWO_VIEW
    }


    override fun getItemCount()=list.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position == 1) {
            (holder as viewHolder2).image1.setImageResource(list[position].image1)
            (holder as viewHolder2).name1.text = list[position].name1.toString()
            (holder as viewHolder2).btn.setOnClickListener {
            }
        }
        else if(list[position].name2.isNullOrEmpty()){
                (holder as viewHolder1).image1.setImageResource(list[position].image1)
            (holder as viewHolder1).name1.text = list[position].name1.toString()
            (holder as viewHolder1).btn.setOnClickListener {
                Navigation.findNavController(viewa).navigate(R.id.action_modiriat_Frag_to_home_Frag)
            }
        }
        else {
            (holder as viewHolderTwo).image1.setImageResource(list[position].image1)
            (holder as viewHolderTwo).name1.text = list[position].name1.toString()
            (holder as viewHolderTwo).image2.setImageResource(list[position].image2!!)
            (holder as viewHolderTwo).name2.text = list[position].name2!!.toString()
            (holder as viewHolderTwo).btn1.setOnClickListener { Navigation.findNavController(viewa).navigate(R.id.action_modiriat_Frag_to_poshtiban_Frag) }
            (holder as viewHolderTwo).btn2.setOnClickListener { Navigation.findNavController(viewa).navigate(R.id.action_modiriat_Frag_to_profile_Frag) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == THE_FIRST)return viewHolder1(LayoutInflater.from(parent.context).inflate(R.layout.rcvi1,parent,false))
        if(viewType == THE_SECOND)return viewHolder2(LayoutInflater.from(parent.context).inflate(R.layout.rcvi2,parent,false))
        if(viewType == THE_TWO_VIEW)return viewHolderTwo(LayoutInflater.from(parent.context).inflate(R.layout.rcvi3,parent,false))
        return viewHolder1(LayoutInflater.from(parent.context).inflate(R.layout.rcvi1,parent,false))
    }
}