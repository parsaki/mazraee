package com.example.modiriatemazraee.view.adapters.Recycle.Data

import android.app.ActivityManager
import android.app.DatePickerDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.modiriatemazraee.R
import com.example.modiriatemazraee.model.Froosh
import com.example.modiriatemazraee.model.kharidaran
import com.example.modiriatemazraee.view.pickerDialog
import com.example.modiriatemazraee.viewmodel.MainViewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class froosh(val arrayList: ArrayList<Froosh>,val activy:FragmentActivity,val model:MainViewModel?=null):RecyclerView.Adapter<froosh.viewholer>() {
    class viewholer(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var text1: EditText;
        lateinit var text2: EditText;
        lateinit var text3: EditText;
        lateinit var text4: EditText
        lateinit var remove: ImageButton;
        lateinit var add: ImageButton

        init {
            text1 = view.findViewById(R.id.frooshi_text1)
            text2 = view.findViewById(R.id.frooshi_text2)
            text3 = view.findViewById(R.id.frooshi_text3)
            text4 = view.findViewById(R.id.frooshi_text4)
            add = view.findViewById(R.id.frooshi_pluse)
            remove = view.findViewById(R.id.frooshi_min)
            add.visibility = View.GONE
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholer {
        return viewholer(
            LayoutInflater.from(parent.context).inflate(R.layout.frooshiteam, parent, false)
        )
    }

    override fun onBindViewHolder(holder: viewholer, position: Int) {
        if (position == arrayList.size - 1) holder.add.visibility = View.VISIBLE

        holder.text1.setText(arrayList[position].date.toString())
        holder.text2.setText(arrayList[position].fat.toString())
        holder.text3.setText(arrayList[position].weight.toString())
        holder.text4.setText(arrayList[position].name.toString())

        holder.text1.setOnClickListener {
            var cal = Calendar.getInstance()

            val dateSetListener =
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, monthOfYear)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    val myFormat = "dd/MM/yyyy" // mention the format you need
                    val sdf = SimpleDateFormat(myFormat, Locale.US)
                    holder.text1.setText(sdf.format(cal.time))

                }
            DatePickerDialog(
                activy, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        holder.text1.addTextChangedListener {
            if (!holder.text1.text.isNullOrEmpty()) arrayList[position].date =
                holder.text1.text.toString()

        }
        holder.text2.addTextChangedListener {
            if (!holder.text2.text.isNullOrEmpty()) arrayList[position].fat =
                holder.text2.text.toString().toFloat()

        }
        holder.text3.addTextChangedListener {
            if (!holder.text3.text.isNullOrEmpty()) arrayList[position].weight =
                holder.text3.text.toString().toFloat()

        }
        holder.text4.addTextChangedListener {
            if (!holder.text4.text.isNullOrEmpty()) arrayList[position].name =
                holder.text4.text.toString()

        }
        holder.add.setOnClickListener {
            arrayList.add(Froosh("", 0F, 0F, ""))
            holder.add.visibility = View.GONE
            this.notifyDataSetChanged()
        }
        holder.remove.setOnClickListener {
            arrayList.removeAt(position)
            this.notifyDataSetChanged()
        }


    }
    override fun getItemCount() = arrayList.size

}