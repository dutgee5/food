package com.example.food.data.repo

import com.example.food.data.datasource.YemeklerDataSource
import com.example.food.data.entity.Yemekler

class YemeklerRepository(var yemeklerDataSource: YemeklerDataSource) {

    suspend fun yemekleriGetirRe():List<Yemekler> = yemeklerDataSource.yemekleriGetir()

    suspend fun sepeteEkle(yemekAdi:String,resim:String,fiyat:Int,adet:Int,user:String){
        yemeklerDataSource.sepeteEkle(yemekAdi,resim,fiyat,adet,user)
    }

}