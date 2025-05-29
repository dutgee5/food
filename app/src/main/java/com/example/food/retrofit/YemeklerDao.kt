package com.example.food.retrofit

import com.example.food.data.entity.YemeklerCevap
import retrofit2.http.GET

interface YemeklerDao {

    // wep servisleri calistirma yeri

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun tumYemekler():YemeklerCevap

}