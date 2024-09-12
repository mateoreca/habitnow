package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de la interfaz
        val valorPropiedadEditText = findViewById<EditText>(R.id.valor_propiedad)
        val valorPrestamoEditText = findViewById<EditText>(R.id.valor_prestamo)
        val tasaInteresEditText = findViewById<EditText>(R.id.tasa_interes)
        val plazoEditText = findViewById<EditText>(R.id.plazo)
        val botonSimular = findViewById<Button>(R.id.boton_simular)
        val resultadoTextView = findViewById<TextView>(R.id.resultado)

        botonSimular.setOnClickListener {
            val valorPropiedad = valorPropiedadEditText.text.toString().toDoubleOrNull() ?: 0.0
            val vp = valorPrestamoEditText.text.toString().toDoubleOrNull() ?: 0.0
            val tae = tasaInteresEditText.text.toString().toDoubleOrNull() ?: 0.0
            val plazoAños = plazoEditText.text.toString().toIntOrNull() ?: 0


            if (valorPropiedad < 70000000) {
                resultadoTextView.text = "No se puede hacer el préstamo. El valor de la propiedad no puede ser inferior a $70,000,000."
            } else if (vp > 0 && tae > 0 && plazoAños > 0) {
                val i = (tae / 12) / 100
                val n = plazoAños * 12
                val cuota = vp * ((1 + i).pow(n) * i) / ((1 + i).pow(n) - 1)

                resultadoTextView.text = "Cuota mensual: $%,.2f".format(cuota)
            } else {
                resultadoTextView.text = "Por favor ingrese valores válidos"
            }
        }
    }
}