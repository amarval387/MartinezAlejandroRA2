package com.example.recupra2mv_a

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var butVolver:Button
    private lateinit var tvResultGenero: TextView
    private lateinit var tvResultNombre:TextView
    private lateinit var tvResultCuenta:TextView
    private lateinit var tvResult: TextView

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initComponent()
        butVolver.setOnClickListener {
            finish()
        }
        val genero = intent.getStringExtra("GENERO")
        val nombre = intent.getStringExtra("NOMBRE") +" "+ intent.getBundleExtra("APELLIDO")
        val cuenta = intent.getStringExtra("CUENTA")
        val venta = intent.getDoubleExtra("VENTA",0.0)
        val pagado = intent.getDoubleExtra("PAGADO",0.0)
        var color:Int
        var result:String
        if(genero.isNullOrEmpty() || genero != "H"|| genero != "h" || genero != "M"|| genero != "m"){
            val response = "El género introducido es incorrecto, dale a volver"
            tvResultGenero.text = response
        }
        if(nombre.isEmpty()){
            val response = "El nombre o el apellido introducido está vacío, dale a volver"
            tvResultNombre.text = response
        }
        if(cuenta.isNullOrEmpty()){
            val response = "El número de cuenta esta vacio, dale a volver"
            tvResultCuenta.text = response
        }
        if(genero=="H"||genero=="h"){
             if(pagado<venta){
                 result ="Estimado Sr. $nombre, le recuerdo que aún debe usted ${venta-pagado}€ de su última compra, " +
                        "para su ingreso puede usted hacerlo en la cuenta: $cuenta"
                 color = R.color.hombreNeg
            }else if(pagado>venta){
                 result ="Estimado Sr. $nombre, le recuerdo que usted aún tiene un importe ${pagado-venta}€, que puede" +
                        "usted gastar en cualquier de nuestras tiendas, o sacarlo de la cuenta $cuenta"
                 color = R.color.hombrePos
            }else{
                 result ="Estimado Sr. $nombre, ahora mismo su saldo es 0"
                 color = R.color.hombreNulo
            }
        }else{
           if(pagado<venta){
               result ="Estimado Sra. $nombre, le recuerdo que aún debe usted ${venta-pagado}€ de su última compra, " +
                        "para su ingreso puede usted hacerlo en la cuenta: $cuenta"
               color = R.color.mujerNeg

            }else if(pagado>venta){
               result ="Estimado Sra. $nombre, le recuerdo que usted aún tiene un importe ${pagado-venta}€, que puede" +
                        "usted gastar en cualquier de nuestras tiendas, o sacarlo de la cuenta $cuenta"
               color = R.color.mujerPos
            }else{
               result = "Estimado Sra. $nombre, ahora mismo su saldo es 0"
               color = R.color.mujerNulo
            }
        }
        tvResult.text = result
        tvResult.setTextColor(color)
    }

    private fun initComponent(){
        butVolver=findViewById(R.id.butVolver)
        tvResultGenero = findViewById(R.id.tvResultGenero)
        tvResultNombre = findViewById(R.id.tvResultNombre)
        tvResultCuenta = findViewById(R.id.tvResultCuenta)
        tvResult = findViewById(R.id.tvResult)
    }
}