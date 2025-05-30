package com.example.food.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.food.data.repo.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UrunDetayViewModel @Inject constructor(var yemeklerRepository: YemeklerRepository):ViewModel() {

    private val _sepetMesaji = MutableLiveData<String>()
    val sepetMesaji: LiveData<String> get() = _sepetMesaji


    fun ekle(yemekad:String,resim:String,fiyat:Int,adet:Int,user:String){
        CoroutineScope(Dispatchers.Main).launch{
            val sonuc=yemeklerRepository.sepeteEkle(yemekad,resim,fiyat,adet,user)
            _sepetMesaji.value = sonuc.toString()
            Log.e(
                "urun",yemekad
            )
        }
    }
}