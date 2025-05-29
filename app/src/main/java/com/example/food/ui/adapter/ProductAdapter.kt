package com.example.food.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.food.data.entity.Yemekler
import com.example.food.databinding.ProductsBinding
import com.example.food.ui.viewModel.HomeViewModel

class ProductAdapter(
    var mContext: Context,
    var yemeklerListesi:List<Yemekler>,
    var viewModel:HomeViewModel):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(var tasarim:ProductsBinding):RecyclerView.ViewHolder(tasarim.root)

    // tasarim olustur
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val tasarim=ProductsBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return ProductViewHolder(tasarim)
    }

    //kac kere calisagi
    override fun getItemCount(): Int {
         return yemeklerListesi.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val yemekler = yemeklerListesi.get(position)

        val t = holder.tasarim

        val imageUrl="http://kasimadalan.pe.hu/yemekler/resimler/${yemekler.yemek_resim_adi}"

        t.textFoodName.text = yemekler.yemek_adi
        t.textFoodPrice.text = yemekler.yemek_fiyat.toString()


        Glide.with(t.imageFood)
            .load(imageUrl)
            .into(t.imageFood)


    }


}