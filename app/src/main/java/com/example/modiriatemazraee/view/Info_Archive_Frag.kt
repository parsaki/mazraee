package com.example.modiriatemazraee.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modiriatemazraee.R
import com.example.modiriatemazraee.databinding.Home1Binding
import com.example.modiriatemazraee.model.*
import com.example.modiriatemazraee.view.adapters.Recycle.archive.DInfoAdapter
import com.example.modiriatemazraee.viewmodel.MainViewModel

class Info_Archive_Frag: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    val model: MainViewModel by activityViewModels()

    lateinit var bind: Home1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind= Home1Binding.inflate(layoutInflater)
        bind.home1TextTool.text = getText(R.string.info_archiv)
        bind.home1Back.setOnClickListener { requireActivity().onBackPressed() }

        bind.home1Recycle.adapter = DInfoAdapter(model.Get_Info(),bind.root,model)
        bind.home1Recycle.layoutManager =  LinearLayoutManager(requireContext())
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}