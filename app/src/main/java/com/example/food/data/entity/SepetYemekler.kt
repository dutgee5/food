package com.example.food.data.entity

import java.io.Serializable

data class SepetYemekler(
    val yemek_adi: String,
    val yemek_resim_adi: String,
    val yemek_fiyat: Int,
    val yemek_siparis_adet: Int,
    val kullanici_adi: String
):Serializable{}
