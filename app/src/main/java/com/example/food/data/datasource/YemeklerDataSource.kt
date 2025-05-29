package com.example.food.data.datasource

import com.example.food.data.entity.Yemekler
import com.example.food.retrofit.YemeklerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YemeklerDataSource(var yemeklerDao: YemeklerDao) {


    suspend fun yemekleriGetir():List<Yemekler> = withContext(Dispatchers.IO){

        return@withContext yemeklerDao.tumYemekler().yemekler
    }
}