package com.example.apptienda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class MainLogin : AppCompatActivity() {
    var dni:EditText? = null
    var id:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)
        dni = findViewById(R.id.txtdniC)
        id = findViewById(R.id.txtIdC)
        var btn: Button = findViewById( R.id.ingresar )
    }
    fun clickBtningresar(view:View)
    {
        val url=  "http://192.168.1.34:8080/android_mysql/log.php"
        val queue = Volley.newRequestQueue(this)
        var resultadoPost = object: StringRequest(
            Method.POST,url,
            Response.Listener<String> { response ->
                var intent = Intent(this,MainActivitycomprar::class.java)
                startActivity(intent)
            }, Response.ErrorListener { error ->
                Toast.makeText(this,"Error ", Toast.LENGTH_LONG).show()
            }
        ){
            override fun getParams(): MutableMap<String, String>? {
                val parametros = HashMap<String, String>()
                parametros.put("dni",dni?.text.toString())
                parametros.put("idcliente",id?.text.toString())
                return parametros
            }
        }
        queue.add(resultadoPost)
    }
    fun clicRegistrarse (view: View){
        var intent = Intent(this,newCliente::class.java)
        startActivity(intent)
    }
}