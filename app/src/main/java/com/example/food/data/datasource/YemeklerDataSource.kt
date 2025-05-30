package com.example.food.data.datasource

import com.example.food.data.entity.Yemekler
import com.example.food.retrofit.YemeklerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YemeklerDataSource(var yemeklerDao: YemeklerDao) {


    suspend fun yemekleriGetir():List<Yemekler> = withContext(Dispatchers.IO){

        return@withContext yemeklerDao.tumYemekler().yemekler
    }


    suspend fun sepeteEkle(yemek_adi:String,
                           yemek_resim_adi:String,
                           yemek_fiyat:Int,
                           yemek_siparis_adet:Int,
                           kullanici_adi:String
                           ){
        yemeklerDao.sepeteEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
    }
}