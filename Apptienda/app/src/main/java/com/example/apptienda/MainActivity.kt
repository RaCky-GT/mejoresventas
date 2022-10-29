package com.example.apptienda


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    var tbproductos:TableLayout?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tbproductos = findViewById(R.id.tbproductos2)
        tbproductos?.removeAllViews()
        var queue = Volley.newRequestQueue(this)
        var url = "http://192.168.1.34:8080/android_mysql/registrop.php"
        var jsonObjectRequest=JsonObjectRequest(Request.Method.GET,url,null,
            Response.Listener { response ->
                try {
                    var jsonArray=response.getJSONArray("data")
                    for (i : Int in 0 until  jsonArray.length()){
                        var jsonObject=jsonArray.getJSONObject(i)
                        val registro=LayoutInflater.from(this).inflate(R.layout.table_row_np2,null,false)
                        val producto = registro.findViewById<View>(R.id.producto) as TextView
                        val precio= registro.findViewById<View>(R.id.precio) as TextView
                        val comprar=registro.findViewById<View>(R.id.comprar)
                        producto.text = jsonObject.getString("descripcion")
                        precio.text = jsonObject.getString("precio")
                        comprar.id = jsonObject.getString("codproducto").toInt()
                        tbproductos?.addView(registro)
                }

                }catch (e:JSONException){
                    e.printStackTrace()
                }

            }, Response.ErrorListener { error -> Toast.makeText(this,"Error ", Toast.LENGTH_LONG).show() }
        )
        queue.add(jsonObjectRequest)
    }
    fun clictablaComprar (view: View){
        Toast.makeText(this, view.id.toString(),Toast.LENGTH_LONG).show()
        var intent = Intent(this,MainLogin::class.java)
        startActivity(intent)
    }


    fun clicVer(view:View){
        //var id:EditText = findViewById<EditText>(R.id.id)
        var intent = Intent(this,MainActivity2::class.java)
        //intent.putExtra("id",id.text.toString())
        startActivity(intent)
    }
}