package com.example.modiriatemazraee.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modiriatemazraee.databinding.MazraeMangeBinding
import com.example.modiriatemazraee.model.HomePagesOption
import com.example.modiriatemazraee.view.adapters.Recycle.HRCadapter
import com.example.modiriatemazraee.viewmodel.MainViewModel

class modiriat_Frag: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    val model: MainViewModel by activityViewModels()
    lateinit var bind :MazraeMangeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        model.get_all_data()
        bind = MazraeMangeBinding.inflate(layoutInflater)
        bind.mazaraeRecycle.adapter = HRCadapter(HomePagesOption.home,bind.root)
        bind.mazaraeRecycle.layoutManager = LinearLayoutManager(requireContext())
        return bind.root
    }
}