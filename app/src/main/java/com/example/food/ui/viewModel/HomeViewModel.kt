package com.example.food.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.food.data.entity.Yemekler
import com.example.food.data.repo.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    var yemeklerRepository: YemeklerRepository,
): ViewModel() {

    var liste =MutableLiveData<List<Yemekler>>()   //live-data


    init {
        yemek()
    }


    fun yemek(){
        CoroutineScope(Dispatchers.Main).launch{
            liste.value = yemeklerRepository.yemekleriGetirRe()
        }
    }
}