package com.example.modiriatemazraee.view.adapters.Recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.compose.ui.window.Dialog
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modiriatemazraee.R
import com.example.modiriatemazraee.model.MainOptionIteam
import com.example.modiriatemazraee.model.pages
import com.example.modiriatemazraee.view.adapters.Recycle.Data.KonsnteAdapter
import com.example.modiriatemazraee.viewmodel.MainViewModel

class ORCadapter(val list: Array<MainOptionIteam>, val viewa:View,val model: MainViewModel? = null,val context:FragmentActivity?=null,): RecyclerView.Adapter<ORCadapter.viewHolder>() {
    class viewHolder(view: View): RecyclerView.ViewHolder(view){
        lateinit var name1: TextView;lateinit var image1: ImageView;lateinit var btn: AppCompatButton
        init {
            name1 = view.findViewById(R.id.rc4_text)
            image1 = view.findViewById(R.id.rc4_image)
            btn = view.findViewById(R.id.rc4_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rcvi4,parent,false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.image1.setImageResource(list[position].imageId)
        holder.name1.text = list[position].name.toString()
        holder.btn.setOnClickListener {
            when (list[position].work) {
                pages.konsatre_save -> {
                    Navigation.findNavController(viewa).navigate(R.id.action_home1_Frag_to_home2_Frag)
                }
                pages.konsatre_archive -> {
                    Navigation.findNavController(viewa).navigate(R.id.action_home1_Frag_to_home3_Frag)
                }
                pages.khorak_save -> {
                    Navigation.findNavController(viewa).navigate(R.id.action_home5_Frag_to_home6_Frag)
                }
                pages.khorak_archive -> {
                    Navigation.findNavController(viewa).navigate(R.id.action_home5_Frag_to_home7_Frag)
                }
                pages.info_save -> {
                    Navigation.findNavController(viewa).navigate(R.id.action_home9_Frag_to_home10_Frag)
                }
                pages.info_archive -> {
                    Navigation.findNavController(viewa).navigate(R.id.action_home9_Frag_to_home11_Frag)
                }
                pages.kharidaran1 -> {
                    val kharid = android.app.Dialog(context!!,R.style.kharidarandialogs)
                    kharid.setCancelable(false)
                    kharid.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    kharid.setContentView(R.layout.kharidaran)
                    kharid.show()
                    val btn = kharid.findViewById<AppCompatButton>(R.id.kharidaran_save)
                    val imp = kharid.findViewById<AppCompatButton>(R.id.kharidaran_imput)
                    val bin = kharid.findViewById<RecyclerView>(R.id.kharidaran_recycleview)
                    if(model != null)
                    bin.adapter =  com.example.modiriatemazraee.view.adapters.Recycle.Data.kharid(
                        model!!.kharid.value!!
                    )
                    bin.layoutManager = LinearLayoutManager(kharid.context)

                    btn.setOnClickListener {
                        kharid.dismiss()
                    }
                    imp.setOnClickListener {
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
                }
                pages.froosh -> {
                    val kharid = android.app.Dialog(context!!,R.style.kharidarandialogs)
                    kharid.setCancelable(false)
                    kharid.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    kharid.setContentView(R.layout.froosh)
                    kharid.show()
                    val btn = kharid.findViewById<AppCompatButton>(R.id.froosh_save)
                    val bin = kharid.findViewById<RecyclerView>(R.id.froosh_recycleview)
                    if(model != null)
                        bin.adapter =  com.example.modiriatemazraee.view.adapters.Recycle.Data.froosh(
                            model!!.froosh.value!!,
                            context
                        )
                    bin.layoutManager = LinearLayoutManager(kharid.context)

                    btn.setOnClickListener {
                        kharid.dismiss()
                    }
                }
            }
        }
    }

    override fun getItemCount()=list.size
}