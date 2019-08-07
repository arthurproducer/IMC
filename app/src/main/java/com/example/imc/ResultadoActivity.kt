package com.example.imc

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        calcular()
    }

    private fun calcular() {

        val peso = intent.getDoubleExtra("PESO", 0.0)
        val altura = intent.getDoubleExtra("ALTURA", 0.0)
        val sexo = intent.getStringExtra("SEXO")
        val imc = peso / (altura * altura)

        when (sexo) {
            getString(R.string.label_masc) -> calcularMasculino(imc)
            getString(R.string.label_fem) -> calcularFeminino(imc)
            else -> {
            }
        }

    }

    private fun calcularFeminino(imc: Double) {

    }

    private fun calcularMasculino(imc: Double) {

        tvIMC.text = imc.toFixed(2)

        if (imc < 20) {
            tvStatus.text = "Abaixo do peso"
            configuraImagem(R.drawable.masc_abaixo)
        } else if (imc < 25) {
            tvStatus.text = "Peso ideal"
            configuraImagem(R.drawable.masc_ideal)
        } else if (imc < 30) {
            tvStatus.text = "Sobre peso"
            configuraImagem(R.drawable.masc_sobre)
        } else if (imc < 43) {
            tvStatus.text = "Obeso"
            configuraImagem(R.drawable.masc_obeso)
        } else {
            tvStatus.text = "Obesidade Extrema"
            configuraImagem(R.drawable.masc_extremo_obeso)

        }
    }

    private fun configuraImagem(resourceId: Int) {
        ivIMC.setImageDrawable(ContextCompat.getDrawable(this, resourceId))
    }
}
