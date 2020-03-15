package com.example.clinicalucreciapain.dataBinding

import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class GestanteBinding(
    var nome:String,
    var bi:String,
    var nacionalidade:String,
    var peso:String,
    var altura:String,
    var sexo:String,
    var grupo_sanguineo:String,
    var raca:String,
    var provincia:String,
    var bairro:String,
    var rua:String,
    var municipio:String,
    var telefone:String,
    var email:String,
    var data_nac:String,
    var senha:String,
    var foto:String
) : BaseObservable() {


    companion object {
        @JvmStatic
        @BindingAdapter("profileImage")
        fun loadImage(view: ImageView, imageUrl: String) {
            Glide.with(view.context)
                .load(imageUrl)
                .into(view)
        }
    }

}