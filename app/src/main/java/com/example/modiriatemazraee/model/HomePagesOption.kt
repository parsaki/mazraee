package com.example.modiriatemazraee.model

import com.example.modiriatemazraee.R

object HomePagesOption {
    val home = arrayOf<MainOprtionIteamDuble>(
        MainOprtionIteamDuble("مدیریت مزرعه",null,R.drawable.cow,null,pages.modiriat,null),
        MainOprtionIteamDuble("گزارش",null,R.drawable.statistics,null,pages.state,null),
        MainOprtionIteamDuble("پشتیبان","پروفایل",R.drawable.support,R.drawable.man,pages.poshtiban,pages.profile)
    )

    val pagemain= arrayOf<MainOptionIteam>(
        MainOptionIteam("ساخت کنسانتره",R.drawable.im3,pages.makekonsatre),
        MainOptionIteam("ساخت خوراک",R.drawable.im2,pages.makekhorak),
        MainOptionIteam("خریداران",R.drawable.im4,pages.kharidaran),
        MainOptionIteam("ورود اطلاعات بهاربند",R.drawable.labtop,pages.inputinformation))
    val optionpages:Array<Array<MainOptionIteam>> = arrayOf(
        arrayOf<MainOptionIteam>(
            MainOptionIteam("ساخت کنسانتره",R.drawable.im3,pages.konsatre_save),
            MainOptionIteam("آرشیو کنسانتره",R.drawable.im1,pages.konsatre_archive)),
        arrayOf<MainOptionIteam>(
            MainOptionIteam("ساخت خوراک",R.drawable.im2,pages.khorak_save),
            MainOptionIteam("آرشیو خوراک",R.drawable.im1,pages.khorak_archive)),
        arrayOf<MainOptionIteam>(
            MainOptionIteam("ثبت اطلاعات",R.drawable.labtop,pages.info_save),
            MainOptionIteam("آرشیو اطلاعات",R.drawable.im1,pages.info_archive)),
        arrayOf<MainOptionIteam>(
            MainOptionIteam("خریداران",R.drawable.groupby,pages.kharidaran1),
            MainOptionIteam("فروش",R.drawable.groupfo,pages.froosh))
    )
    val map = mapOf<String,Int>("home1" to 0,"home5" to 1,"home9" to 2,"kharid" to 3)
}