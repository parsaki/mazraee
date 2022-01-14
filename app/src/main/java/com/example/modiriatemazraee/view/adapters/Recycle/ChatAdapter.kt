package com.example.modiriatemazraee.view.adapters.Recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modiriatemazraee.R
import com.example.modiriatemazraee.model.chatData
import com.example.modiriatemazraee.model.chattype

class ChatAdapter(val list1:ArrayList<chatData>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private inner class viewholder(view: View):RecyclerView.ViewHolder(view){
        lateinit var str1:TextView
        init {
            str1 = view.findViewById(R.id.chattexts)
        }
    }
    private inner class viewholder2(view: View):RecyclerView.ViewHolder(view){
        lateinit var str2:TextView
        init {
            str2 = view.findViewById(R.id.chattextr)
        }
    }


    companion object{
        const val send = 0
        const val recive =1
    }
    override fun getItemViewType(position: Int): Int {
        when(list1[position].type){
            chattype.recive ->return recive
            chattype.send ->return send
        }
        return send
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            send -> return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.chatsend,parent,false))
            recive -> return viewholder2(LayoutInflater.from(parent.context).inflate(R.layout.chatrecive,parent,false))
            else -> return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.chatsend,parent,false))

        }
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.chatsend,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(list1[position].type){
            chattype.recive ->(holder as viewholder2).str2.text = list1[position].stt
            chattype.send ->(holder as viewholder).str1.text = list1[position].stt
        }
    }

    override fun getItemCount()=list1.size
}