package com.example.food.retrofit

class ApiUtils {


    companion object{
        // BASE URL ->  http://kasimadalan.pe.hu/
        // geri kalanı API URL
        val BASE_URL ="http://kasimadalan.pe.hu/"

        fun getYemeklerDao():YemeklerDao{
            return RetrofitClient.getClient(BASE_URL).create(YemeklerDao::class.java)
        }

    }

}