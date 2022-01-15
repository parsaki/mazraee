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
import com.example.modiriatemazraee.databinding.Home10Binding
import com.example.modiriatemazraee.databinding.Home6Binding
import com.example.modiriatemazraee.model.State
import com.example.modiriatemazraee.model.cowType
import com.example.modiriatemazraee.model.iteamKonsntre
import com.example.modiriatemazraee.view.adapters.Recycle.archive.DKonsantAdapter
import com.example.modiriatemazraee.viewmodel.MainViewModel
import java.util.*

class Info_Creat_Frag: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    val model: MainViewModel by activityViewModels()
    lateinit var bind: Home10Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = Home10Binding.inflate(layoutInflater)
        bind.home10Tooltext.text = getText(R.string.info_sabt)

        model.info_clear()

        bind.home10Back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val araye = arrayListOf<String>("کنسانتره انتخاب کنید")
        model.Get_Khorak().forEach {
            araye.add(it.name)
        }
        val adapt = ArrayAdapter<String>(requireContext(),R.layout.spin2,araye )
        bind.home10Include.home10Spiner.adapter =adapt
        bind.home10Include.home10Spiner.setSelection(0)
        bind.home10Include.home10Spiner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(position > 0){
                    val pos = position - 1
                    model.info1.value!!.khorak = model.Get_Khorak()[pos]
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        bind.home10Include.home10Radiobtn1.setOnClickListener {
            model.slect1.value = true
            bind.home10Include.home10Radiobtn2.isSelected = false
            model.info1.value!!.cow_type = cowType.unshiri
            print("cow:${model.info1.value!!.cow_type}")
        }
        bind.home10Include.home10Radiobtn2.setOnClickListener {
            model.slect1.value = false
            bind.home10Include.home10Radiobtn2.isSelected = true
            model.info1.value!!.cow_type = cowType.shiri
            print("cow:${model.info1.value!!.cow_type}")
        }

        bind.home10Include.home10BtnNewsave.setOnClickListener {
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

        bind.home10Include.home10BtnApplysave.setOnClickListener {
            var state: State? =null
            val date = Date()
            val dateformat = android.text.format.DateFormat.format("yyyy/MM/dd hh:mm",date).toString()
            //model.onkilo_set(model.konsant1.value!!.iteams)
            model.info1.value!!.Date =dateformat
            model.info1.value!!.room_name = bind.home10Include.home10NamesalonText.text.toString()
            if(!bind.home10Include.home10CowsText.text.toString().isNullOrEmpty())model.info1.value!!.cow_number = bind.home10Include.home10CowsText.text.toString().toInt()
            model.info1.value!!.cow_group = bind.home10Include.home10CowtypeText.text.toString()
            if(!bind.home10Include.home10RoomnumText.text.toString().isNullOrEmpty())model.info1.value!!.roomnumber = bind.home10Include.home10RoomnumText.text.toString().toInt()
            state =  model.Set_Info(model.info1.value!!)
            if(state == State.sucsses){
                requireActivity().onBackPressed()
                model.info_clear()
            }
            else if (state == State.error_name) {
                Toast.makeText(requireContext(),"name is error", Toast.LENGTH_SHORT).show()
                model.info_clear()
            }
            else {
                model.info_clear()
                Toast.makeText(requireContext(),"faild", Toast.LENGTH_SHORT).show()
            }

        }

        return bind.root
    }
}