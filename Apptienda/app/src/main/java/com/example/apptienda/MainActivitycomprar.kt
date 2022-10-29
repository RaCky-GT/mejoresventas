package com.example.apptienda

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import org.json.JSONException

class MainActivitycomprar : AppCompatActivity(){
    var tbproducto: TableLayout?=null
    var cantidad: EditText?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activitycomprar)
        cantidad = findViewById(R.id.cantidad)
        tbproducto = findViewById(R.id.tbproductos)
        tbproducto?.removeAllViews()
        var queue = Volley.newRequestQueue(this)
        var url = "http://192.168.1.34:8080/android_mysql/registrop.php"
        var jsonObjectRequest= JsonObjectRequest(Request.Method.GET,url,null,
            Response.Listener { response ->
                try {
                    var jsonArray=response.getJSONArray("data")
                    for (i : Int in 0 until  jsonArray.length()){
                        var jsonObject=jsonArray.getJSONObject(i)
                        val registro=
                            LayoutInflater.from(this).inflate(R.layout.table_row_np3,null,false)
                        val producto = registro.findViewById<View>(R.id.produc) as TextView
                        val precio= registro.findViewById<View>(R.id.precio1) as TextView
                        val comprar=registro.findViewById<View>(R.id.carrito)
                        producto.text = jsonObject.getString("descripcion")
                        precio.text = jsonObject.getString("precio")
                        comprar.id = jsonObject.getString("codproducto").toInt()
                        tbproducto?.addView(registro)
                    }

                }catch (e: JSONException){
                    e.printStackTrace()
                }

            }, Response.ErrorListener { error -> Toast.makeText(this,"Error ", Toast.LENGTH_LONG).show() }
        )
        queue.add(jsonObjectRequest)
    }
    

}