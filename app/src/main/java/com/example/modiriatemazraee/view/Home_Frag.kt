package com.example.modiriatemazraee.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modiriatemazraee.databinding.HomeBinding
import com.example.modiriatemazraee.model.HomePagesOption
import com.example.modiriatemazraee.view.adapters.Recycle.MRCadapter
import com.example.modiriatemazraee.viewmodel.MainViewModel

class Home_Frag:Fragment (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    val viewmodel:MainViewModel by activityViewModels()
    lateinit var bind:HomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = HomeBinding.inflate(layoutInflater)
        bind.homeRecycle.adapter = MRCadapter(HomePagesOption.pagemain,bind.root)
        bind.homeRecycle.layoutManager = LinearLayoutManager(requireContext())
        bind.homeBack.setOnClickListener { requireActivity().onBackPressed() }
        return bind.root
    }
}