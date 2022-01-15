package com.example.modiriatemazraee.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modiriatemazraee.R
import com.example.modiriatemazraee.databinding.Home6Binding
import com.example.modiriatemazraee.model.Khoracks
import com.example.modiriatemazraee.model.State
import com.example.modiriatemazraee.view.adapters.Recycle.Data.KhorakAdapter
import com.example.modiriatemazraee.viewmodel.MainViewModel
import java.util.*

class Khorack_Edit_Frag: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    val model: MainViewModel by activityViewModels()
    lateinit var bind: Home6Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = Home6Binding.inflate(layoutInflater)

        bind.home6Tooltext.text = getText(R.string.khorak_sabt)

        bind.home6Back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        bind.home6Include.home6HagmText.setText(model.khorak1.value!!.konst_wieght.toString())
        bind.home6Include.home6NamekhorakText.setText(model.khorak1.value!!.name)
        bind.home6Include.home6NamekhorakText.isEnabled = false
        bind.home6Include.home6Edittext1.setText(model.khorak1.value!!.totalweghit.toString())
        bind.home6Include.home6Edittext2.setText(model.khorak1.value!!.onkoli.toString())

        bind.home6Include.home6Recycleview.adapter =  KhorakAdapter(model.khorak1.value!!.khorack)
        bind.home6Include.home6Recycleview.layoutManager = LinearLayoutManager(requireContext())


        val araye = arrayListOf<String>("کنسانتره انتخاب کنید")
        model.Get_Konsantre().forEach {
            araye.add(it.namekonsntre)
        }
        val adapt = ArrayAdapter<String>(requireContext(),R.layout.spin2,araye )
        bind.home6Include.hom6Spiner.adapter =adapt
        bind.home6Include.hom6Spiner.setSelection(get_spiner())
        bind.home6Include.hom6Spiner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(position > 0){
                    val pos = position - 1
                    model.khorak1.value!!.khonsnre = model.Get_Konsantre()[pos]
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        bind.home6Include.home6BtnNewsave.setOnClickListener {
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

        bind.home6Include.home6BtnApplysave.setOnClickListener {
            var state: State? =null
            val date = Date()
            val dateformat = android.text.format.DateFormat.format("yyyy/MM/dd hh:mm",date).toString()
            //model.onkilo_set(model.konsant1.value!!.iteams)
            model.khorak1.value!!.Date =dateformat
            model.khorak1.value!!.name = bind.home6Include.home6NamekhorakText.text.toString()
            if(!bind.home6Include.home6HagmText.text.isNullOrEmpty())model.khorak1.value!!.konst_wieght = bind.home6Include.home6HagmText.text.toString().toFloat()
            state =  model.Update_Khorak(model.khorak1.value!!)
            if(state == State.sucsses){
                requireActivity().onBackPressed()
                model.khorak1_clean()
            }
            else if (state == State.error_name) {
                Toast.makeText(requireContext(),"name is error", Toast.LENGTH_SHORT).show()
                model.khorak1_clean()
            }
            else {
                model.khorak1_clean()
                Toast.makeText(requireContext(),"faild", Toast.LENGTH_SHORT).show()
            }
        }

        return bind.root
    }

    private fun get_spiner():Int{
        var posit = 0
        model.Get_Konsantre().forEach {
            if(it.namekonsntre == model.khorak1.value!!.khonsnre.namekonsntre) {return posit}
            posit ++
        }
        return 0
    }
}