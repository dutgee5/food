package com.example.food.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.food.databinding.FragmentUrunDetayBinding
import com.example.food.ui.viewModel.UrunDetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UrunDetayFragment : Fragment() {

    private lateinit var binding:FragmentUrunDetayBinding

    private lateinit var viewModel: UrunDetayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUrunDetayBinding.inflate(inflater,container,false)

        val bundle:UrunDetayFragmentArgs by navArgs()


        val veriler =bundle.yemekler
        val textFiyat = veriler.yemek_fiyat.toString()

        var adet = 1

        binding.buttonArttir.setOnClickListener {
            adet++
            binding.textViewAdet.text = adet.toString()
        }

        binding.buttonAzalt.setOnClickListener {
            if (adet >= 1) {
                adet--
                binding.textViewAdet.text = adet.toString()
            }

            if (adet <=0){
                val detay =UrunDetayFragmentDirections.geri()
                Navigation.findNavController(it).navigate(detay)
            }
        }

        binding.buttonSepeteEkle.setOnClickListener {
            // sepete ekle logic burada
        }


        binding.textViewYemekAdi.setText(veriler.yemek_adi)
        binding.textViewYemekFiyat.setText(textFiyat)


        val imageUrl="http://kasimadalan.pe.hu/yemekler/resimler/${veriler.yemek_resim_adi}"

        Glide.with(this)
            .load(imageUrl)
            .into(binding.imageViewYemek)


        binding.buttonSepeteEkle.setOnClickListener {

            viewModel.sepetMesaji.observe(viewLifecycleOwner){mesaj->
                Toast.makeText(requireContext(),mesaj,Toast.LENGTH_SHORT).show()
            }
        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:UrunDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

}