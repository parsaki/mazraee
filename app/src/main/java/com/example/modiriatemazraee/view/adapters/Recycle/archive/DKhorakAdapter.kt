package com.example.modiriatemazraee.view.adapters.Recycle.archive

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.modiriatemazraee.R
import com.example.modiriatemazraee.model.iteamKhorak
import com.example.modiriatemazraee.model.iteamKonsntre
import com.example.modiriatemazraee.viewmodel.MainViewModel
import com.google.android.material.button.MaterialButton

class DKhorakAdapter (val list:ArrayList<iteamKhorak>,val viewa:View,val model: MainViewModel? = null): RecyclerView.Adapter<DKhorakAdapter.viewholer>() {
    class viewholer(view: View): RecyclerView.ViewHolder(view){
        lateinit var text1: TextView;lateinit var text2: TextView
        lateinit var text3: TextView;lateinit var text4: TextView;lateinit var show: AppCompatButton;lateinit var edit: MaterialButton
        init {
            text1 =view.findViewById(R.id.archivr2_text1)
            text2 =view.findViewById(R.id.archivr2_text2)
            text3 =view.findViewById(R.id.archivr2_text3)
            text4 =view.findViewById(R.id.archivr2_text4)
            show = view.findViewById(R.id.archive2_show)
            edit = view.findViewById(R.id.archive2_edit)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholer {
        return viewholer(LayoutInflater.from(parent.context).inflate(R.layout.iteam_archive2,parent,false))
    }

    override fun onBindViewHolder(holder: viewholer, position: Int) {
        holder.text1.setText("نام خوراک : "+list[position].name)
        holder.text2.setText("تاریخ آخرین ویرایش : "+list[position].Date)
        holder.text3.setText("حجم کل :"+list[position].totalweghit.toString())
        holder.text4.setText("قیمت کل :"+list[position].onkoli.toString())

        holder.edit.setOnClickListener {
            if(model!=null){
                model.khorak1.value = list[position]
                Navigation.findNavController(viewa).navigate(R.id.action_home7_Frag_to_home8_Frag)
            }
        }
        holder.show.setOnClickListener {

        }
    }

    override fun getItemCount() = list.size

}
