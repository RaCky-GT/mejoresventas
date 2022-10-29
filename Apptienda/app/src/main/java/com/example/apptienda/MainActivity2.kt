package com.example.apptienda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class MainActivity2 : AppCompatActivity() {
    var nombre: EditText?=null
    var correo: EditText?=null
    var usuario: EditText?=null
    var clave: EditText?=null
    var rol: EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        nombre = findViewById(R.id.nombre)
        correo = findViewById(R.id.correo)
        usuario = findViewById(R.id.usuariop)
        rol = findViewById(R.id.rol)
        clave = findViewById(R.id.clave)

        //val id:String = intent.getStringExtra("id").toString()
        //val queue: RequestQueue = Volley.newRequestQueue(this)
        //val url="http://192.168.1.34:8080/android_mysql/registro.php?idusuario=$id"
       /* val jsonObjectRequest = JsonObjectRequest(
            //Request.Method.GET,url,null,
            Response.Listener { response ->
                nombre?.setText(response.getString("nombre"))
                correo?.setText(response.getString("correo"))
                usuario?.setText(response.getString("usuario"))
                clave?.setText(response.getString("clave"))
                rol?.setText(response.getString("rol"))

            }, Response.ErrorListener { error -> Toast.makeText(this,"Error ", Toast.LENGTH_LONG).show() }
        )
        queue.add(jsonObjectRequest)
    }*/
   // fun clcRegresar(view: View){
        //var intent = Intent(this, MainActivity::class.java)
      //  startActivity(intent)
    }
    }
