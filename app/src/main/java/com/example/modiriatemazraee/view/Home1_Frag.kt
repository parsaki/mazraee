package com.example.modiriatemazraee.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modiriatemazraee.R
import com.example.modiriatemazraee.databinding.Home1Binding
import com.example.modiriatemazraee.databinding.HomeBinding
import com.example.modiriatemazraee.model.HomePagesOption
import com.example.modiriatemazraee.view.adapters.Recycle.MRCadapter
import com.example.modiriatemazraee.view.adapters.Recycle.ORCadapter

class Home1_Frag :Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    lateinit var bind:Home1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind= Home1Binding.inflate(layoutInflater)
        bind.home1TextTool.text = getText(R.string.frag_consatre)
        bind.home1Recycle.adapter = ORCadapter(HomePagesOption.optionpages[HomePagesOption.map["home1"]!!],bind.root)
        bind.home1Recycle.layoutManager = LinearLayoutManager(requireContext())
        bind.home1Back.setOnClickListener { requireActivity().onBackPressed() }
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}