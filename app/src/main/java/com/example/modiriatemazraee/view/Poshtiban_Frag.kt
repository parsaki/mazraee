package com.example.modiriatemazraee.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modiriatemazraee.databinding.PoshtibanBinding
import com.example.modiriatemazraee.model.chatData
import com.example.modiriatemazraee.model.chattype
import com.example.modiriatemazraee.view.adapters.Recycle.ChatAdapter
import com.example.modiriatemazraee.viewmodel.MainViewModel

class Poshtiban_Frag : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    val model: MainViewModel by activityViewModels()

    lateinit var bind:PoshtibanBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = PoshtibanBinding.inflate(layoutInflater)

        bind.poshtianRecycle.adapter = ChatAdapter(model.Get_Masseages())
        bind.poshtianRecycle.layoutManager = LinearLayoutManager(requireContext())

        bind.poshtibanSendbtn.setOnClickListener {
            model.Send_Message(chatData(bind.poshtibanEdittext.text.toString(),chattype.send))
            bind.poshtibanEdittext.setText("")
        }

        return bind.root
    }
}