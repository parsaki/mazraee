package com.example.modiriatemazraee.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.modiriatemazraee.model.*
import com.example.modiriatemazraee.view.adapters.Recycle.Data.froosh

class MainViewModel : ViewModel(){
    val slect1 = MutableLiveData<Boolean>(true)
    private val  konsantres:MutableLiveData<ArrayList<iteamKonsntre>> = MutableLiveData()
    private val  khoracks:MutableLiveData<ArrayList<iteamKhorak>> = MutableLiveData()
    private val  infos:MutableLiveData<ArrayList<InfoIteam>> = MutableLiveData()
    private val  massages:MutableLiveData<ArrayList<chatData>> = MutableLiveData()
    val  kharid:MutableLiveData<ArrayList<kharidaran>> = MutableLiveData()
    val  froosh:MutableLiveData<ArrayList<Froosh>> = MutableLiveData()
    private val  profile:MutableLiveData<Profile> = MutableLiveData()
    val  konsant1:MutableLiveData<iteamKonsntre> = MutableLiveData(iteamKonsntre("", arrayListOf(
        Konsantres(0,0F,"",0F)
    ),"",0))
    val  khorak1:MutableLiveData<iteamKhorak> = MutableLiveData(iteamKhorak("",
    iteamKonsntre("", arrayListOf(),"",0),
            0F,
            arrayListOf(Khoracks("",0F,0))
        ,"",
            0,0
        )
    )
    val info1:MutableLiveData<InfoIteam> = MutableLiveData(
        InfoIteam(
        "","",cowType.unshiri,0,0, iteamKhorak(
                "", iteamKonsntre("", arrayListOf(),"",0),0F,
                arrayListOf(),"",0,0),""
        )
    )
    val local = MutableLiveData<String>("")

    fun get_all_data(){
        konsantres.value = arrayListOf()
        khoracks.value = arrayListOf()
        infos.value = arrayListOf()
        massages.value = arrayListOf()
        kharid.value = arrayListOf(kharidaran("",0,0))
        froosh.value = arrayListOf(Froosh("",0F,0F,""))
        profile.value = Profile("","","","","","","")
    }
    fun kons1_clean(){
        konsant1.value=(iteamKonsntre("", arrayListOf(Konsantres(0,0F,"",0F)
        ),"",0))

    }
    fun info_clear(){
        info1.value= InfoIteam("","",cowType.unshiri,0,0,
            iteamKhorak("", iteamKonsntre("", arrayListOf(),"",0),0F,
                    arrayListOf(),"",0,0),""
            )
    }
    fun khorak1_clean(){
         khorak1.value = (iteamKhorak("",
            iteamKonsntre("", arrayListOf(),"",0),
            0F,
            arrayListOf(Khoracks("",0F,0))
            ,"",
            0,0))
    }
    fun set_Konsantre(index:iteamKonsntre):State{
        if(index.namekonsntre.isNullOrEmpty())return State.error_name
        konsantres.value!!.forEach {
            percent_iteam_konsantre(it.iteams)
            if(index.namekonsntre == it.namekonsntre) return State.error_name
        }
        konsantres.value!!.add(index)
        return State.sucsses
    }
    fun Set_Khorak(index:iteamKhorak):State{
        khoracks.value!!.forEach {
            println("vdf : ${index.name}")
            println(it)
            println(khoracks.value!!)
            if( it.name == index.name) return State.error_name
        }
        khoracks.value!!.add(index)
        return State.sucsses
    }
    fun Set_Info(index:InfoIteam):State{
        infos.value!!.forEach {
            if(index.room_name == it.room_name) return State.error_name
        }
        infos.value!!.add(index)
        return State.sucsses
    }
    fun Get_Konsantre():ArrayList<iteamKonsntre>{
        return konsantres.value!!
    }
    fun Get_Khorak():ArrayList<iteamKhorak>{
        return khoracks.value!!
    }
    fun Get_Info():ArrayList<InfoIteam>{
        return infos.value!!
    }
    fun Get_Kharid(){

    }
    fun Get_Forioosh(){

    }
    fun Set_Profile(index: Profile){
        profile.value = index
    }
    fun Get_Prifile():Profile{
        return profile.value!!
    }
    fun Get_Masseages():ArrayList<chatData>{
        return massages.value!!
    }
    fun Send_Message(index: chatData):State{
        massages.value!!.add(index)
        return State.sucsses
    }
    fun Update_Konsantre(index: iteamKonsntre):State{
        konsantres.value!!.forEach {
            if(it.namekonsntre == index.namekonsntre){
                it.Date = index.Date
                it.iteams = index.iteams
                percent_iteam_konsantre(it.iteams)
                return State.sucsses
            }
        }
        return State.faild
    }
    fun Update_Khorak(index: iteamKhorak):State{
        khoracks.value!!.forEach {
            if(it.name == index.name){
                it.Date = index.Date
                it.khonsnre = index.khonsnre
                it.khorack = index.khorack
                it.konst_wieght = index.konst_wieght
                return State.sucsses
            }
        }
        return State.faild
    }
    fun Update_Info(index: InfoIteam):State{
        infos.value!!.forEach {
            if(it.room_name == index.room_name){
                it.Date = index.Date
                it.cow_group = index.cow_group
                it.cow_number = index.cow_number
                it.cow_type = index.cow_type
                it.khorak = index.khorak
                return State.sucsses
            }
        }
        return State.faild

    }
    fun percent_iteam_konsantre(index:ArrayList<Konsantres>){
        var total = 0F
        index.forEach {
            total += it.weight
        }
        index.forEach {
            it.percent = (it.weight*100) / total
        }
    }
    fun onkilo_konsntre(index:ArrayList<Konsantres>):Int{
        var total = 0F
        index.forEach {
            total += it.weight * it.price
        }
            return (total/index.size).toInt()

    }
    fun onkilo_set(index:ArrayList<Konsantres>){
        konsant1.value!!.onkilo = onkilo_konsntre(index)
    }
    fun total_khorak1(){
        var total = 0F
        khorak1.value!!.khorack.forEach {
           total += it.witgh
        }
        khorak1.value!!.konst_wieght = total
    }
    fun total_khorak1_list(index:ArrayList<Khoracks>):Float{
        var total = 0F
        index.forEach {
            total += it.witgh
        }
        khorak1.value!!.konst_wieght = total
        return total
    }
    fun onkilo_khorak1_set(){
        var total = 0F
        khorak1.value!!.khorack.forEach {
            total += it.witgh * it.price
        }
        khorak1.value!!.onkoli = (total/khorak1.value!!.khorack.size).toInt()

    }
    fun onkilo_khorak1(index:ArrayList<Khoracks>):Int{
        var total = 0F
        index.forEach {
            total += it.witgh * it.price
        }
        khorak1.value!!.onkoli = (total/index.size).toInt()
        return (total/index.size).toInt()
    }
}