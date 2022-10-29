package com.example.apptienda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class newCliente : AppCompatActivity() {
    var dni: EditText?=null
    var nombre: EditText?=null
    var telefono: EditText?=null
    var direccion: EditText?=null
    var usuario_id: EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_cliente)
        dni=findViewById(R.id.dniCliente)
        nombre=findViewById(R.id.nombreC)
        telefono=findViewById(R.id.telefonoC)
        direccion=findViewById(R.id.direccionC)
        usuario_id=findViewById(R.id.usuario_id_c)
    }

    fun clickBtnInsertar(view:View)
    {
        val url=  "http://192.168.1.34:8080/android_mysql/insertar.php"
        val queue = Volley.newRequestQueue(this)
        var resultadoPost = object: StringRequest(Method.POST,url,
            Response.Listener<String> { response ->
                Toast.makeText(this,"usuario insertado exitosamente ", Toast.LENGTH_LONG).show()
            }, Response.ErrorListener { error ->
                Toast.makeText(this,"Error ", Toast.LENGTH_LONG).show()
            }
        ){
            override fun getParams(): MutableMap<String, String>? {
                val parametros = HashMap<String, String>()
                parametros.put("dni",dni?.text.toString())
                parametros.put("nombre",nombre?.text.toString())
                parametros.put("telefono",telefono?.text.toString())
                parametros.put("direccion",direccion?.text.toString())
                parametros.put("usuario_id",usuario_id?.text.toString())
                return parametros
            }
        }
        queue.add(resultadoPost)
    }
    fun clicRegresar (view: View){
        var intent = Intent(this,MainLogin::class.java)
        startActivity(intent)
    }
}
