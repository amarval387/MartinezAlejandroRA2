package com.example.recupra2mv_a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

private lateinit var butAceptar:Button
private lateinit var butCancelar:Button
private lateinit var etGenero:EditText
private lateinit var etNombre:EditText
private lateinit var etApellido:EditText
private lateinit var etVenta:EditText
private lateinit var etPagado:EditText
private lateinit var etCuenta:EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
        butAceptar.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("GENERO", etGenero.text.toString())
            intent.putExtra("APELLIDO", etApellido.text.toString())
            intent.putExtra("NOMBRE", etNombre.text.toString())
            intent.putExtra("CUENTA", etCuenta.text.toString())
            intent.putExtra("VENTA", etVenta.text.toString().toDouble())
            intent.putExtra("PAGADO", etPagado.text.toString().toDouble())
            startActivity(intent)
        }
    }

    private fun initComponent(){
        butAceptar = findViewById(R.id.butAceptar)
        butCancelar = findViewById(R.id.butCancelar)
        etGenero = findViewById(R.id.etGenero)
        etNombre = findViewById(R.id.etNombre)
        etApellido = findViewById(R.id.etApellido)
        etVenta = findViewById(R.id.etVenta)
        etPagado = findViewById(R.id.etPagado)
        etCuenta = findViewById(R.id.etCuenta)
    }
}