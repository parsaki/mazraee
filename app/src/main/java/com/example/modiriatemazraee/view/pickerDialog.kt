package com.example.modiriatemazraee.view

import android.app.Dialog

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.modiriatemazraee.model.Froosh
import java.util.*

class pickerDialog(val index:Froosh) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val clend = Calendar.getInstance()
        val year = clend.get(Calendar.YEAR);
        val month = clend.get(Calendar.MONTH);
        val dayOfMonth = clend.get(Calendar.DAY_OF_MONTH)
        val date = year.toString() + "/" + month.toString() + "/" +dayOfMonth.toString()
        return super.onCreateDialog(savedInstanceState)
    }
}