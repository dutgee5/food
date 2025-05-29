package com.example.food.data.repo

import com.example.food.data.datasource.YemeklerDataSource
import com.example.food.data.entity.Yemekler

class YemeklerRepository(var yemeklerDataSource: YemeklerDataSource) {

    suspend fun yemekleriGetirRe():List<Yemekler> = yemeklerDataSource.yemekleriGetir()

}