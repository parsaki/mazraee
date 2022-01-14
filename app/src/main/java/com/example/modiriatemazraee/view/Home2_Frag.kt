package com.example.modiriatemazraee.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modiriatemazraee.R
import com.example.modiriatemazraee.databinding.Home2Binding
import com.example.modiriatemazraee.model.State
import com.example.modiriatemazraee.model.iteamKonsntre
import com.example.modiriatemazraee.view.adapters.Recycle.Data.KonsnteAdapter
import com.example.modiriatemazraee.viewmodel.MainViewModel
import java.util.*

class Home2_Frag: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    val model:MainViewModel by activityViewModels()
    lateinit var bind:Home2Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var state:State? =null
        bind = Home2Binding.inflate(layoutInflater)

        model.kons1_clean()

        bind.home1TextTool.text = getText(R.string.consatre_sabt)

        bind.home2Back.setOnClickListener {
            requireActivity().onBackPressed()
            model.kons1_clean()
        }

        bind.home2Include.home2Recycleview.adapter =  KonsnteAdapter(model.konsant1.value!!.iteams,model,bind,requireActivity())
        bind.home2Include.home2Recycleview.layoutManager = LinearLayoutManager(requireContext())

        bind.home2Include.home2BtnNewsave.setOnClickListener {
            val import= android.app.Dialog(context!!,R.style.kharidarandialogs)
            import.requestWindowFeature(Window.FEATURE_NO_TITLE)
            import.setCancelable(false)
            import.setContentView(R.layout.home_dialog)
            import.show()
            val save = import.findViewById<AppCompatButton>(R.id.home_savabtn)
            save.setOnClickListener {
                import.dismiss()
            }
        }

        bind.home2Include.home2BtnApplysave.setOnClickListener {
            val date = Date()
            val dateformat = android.text.format.DateFormat.format("yyyy/MM/dd hh:mm",date).toString()
            model.onkilo_set(model.konsant1.value!!.iteams)
            model.konsant1.value!!.Date =dateformat
            model.konsant1.value!!.namekonsntre = bind.home2Include.home2NamekonsntreText.text.toString()
            state =  model.set_Konsantre(model.konsant1.value!!)
            if(state == State.sucsses){
                requireActivity().onBackPressed()
                model.kons1_clean()
            }
            else if (state == State.error_name) {Toast.makeText(requireContext(),"name is error",Toast.LENGTH_SHORT).show()
                model.kons1_clean()
            }
            else {
                model.kons1_clean()
                Toast.makeText(requireContext(),"faild",Toast.LENGTH_SHORT).show()
            }
        }

        return bind.root
    }
}