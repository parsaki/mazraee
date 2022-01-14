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
import com.example.modiriatemazraee.model.HomePagesOption
import com.example.modiriatemazraee.model.iteamKonsntre
import com.example.modiriatemazraee.view.adapters.Recycle.ORCadapter
import com.example.modiriatemazraee.view.adapters.Recycle.archive.DKonsantAdapter
import com.example.modiriatemazraee.viewmodel.MainViewModel

class Home3_Frag: Fragment() {
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
        bind.home1TextTool.text = getText(R.string.consatre_archiv)

        bind.home1Back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val item = model.Get_Konsantre()

        bind.home1Recycle.adapter = DKonsantAdapter(item,bind.root,model)
        bind.home1Recycle.layoutManager =  LinearLayoutManager(requireContext())

        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}