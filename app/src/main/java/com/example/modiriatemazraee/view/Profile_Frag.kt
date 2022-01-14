package com.example.modiriatemazraee.view

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.modiriatemazraee.R
import com.example.modiriatemazraee.databinding.PoshtibanBinding
import com.example.modiriatemazraee.databinding.ProfileBinding
import com.example.modiriatemazraee.model.Profile
import com.example.modiriatemazraee.viewmodel.MainViewModel

class Profile_Frag: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    val model: MainViewModel by activityViewModels()

    lateinit var bind: ProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = ProfileBinding.inflate(layoutInflater)
        model.local.value = ""

        val adapt =ArrayAdapter<String>(requireContext(), R.layout.bluespiner, arrayOf("انتخاب کنید","iran","england"))
        bind.profileIncludeMain.profilBackInclude.profileSpiner.adapter = adapt
        bind.profileIncludeMain.profilBackInclude.profileSpiner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position){
                    1->{
                        model.local.value = "iran"}
                    2->{
                        model.local.value ="england"}
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        bind.profileIncludeMain.profileBackInclude.profileExitBtn.setOnClickListener {
            model.Set_Profile(Profile(
                bind.profileIncludeMain.pfofileNameText.text.toString(),
                bind.profileIncludeMain.pfofileEmailText.text.toString(),
                bind.profileIncludeMain.pfofilePhonenumberText.text.toString(),
                bind.profileIncludeMain.pfofilePasswordText.text.toString(),
                model.local.value.toString(),
                bind.profileIncludeMain.profileCowNumberText.text.toString(),
                bind.profileIncludeMain.pfofileAddresText.text.toString()
                ))
        }

        return bind.root
    }
}